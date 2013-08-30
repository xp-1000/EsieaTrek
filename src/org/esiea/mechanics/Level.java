package org.esiea.mechanics;

import java.util.ArrayList;
import java.util.List;

import org.esiea.characters.CollisionChecker;
import org.esiea.characters.Direction;
import org.esiea.characters.NPC;
import org.esiea.characters.Player;
import org.esiea.config.LevelConfiguration;
import org.esiea.config.NPCConfiguration;
import org.esiea.config.TransitionConfiguration;
import org.esiea.minigames.ExternalGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

public class Level implements CollisionChecker {

	private final static String RESOURCE_PATH = "res/maps/";
	private final static int COLLISION_LAYER_INDEX = 0;

	private final Camera camera;

	private final Player player;
	private final List<NPC> npcs;
	private final List<Transition> transitions;
	private final TiledMap map;
	private final int Width;
	private final int Height;
	private final Game game;
	private ExternalGame externalGame;
	private Music music;
	private Transition pendingTransition;
	private WinTrigger winTrigger;

	public Level(GameContainer container, Game game, Player player, String levelName)
			throws SlickException {
		map = new TiledMap(RESOURCE_PATH + levelName);
		Width = map.getWidth() * map.getTileWidth();
		Height = map.getHeight() * map.getTileHeight();

		this.game = game;
		this.player = player;
		this.npcs = new ArrayList<NPC>();
		this.transitions = new ArrayList<Transition>();
		this.camera = new Camera(container, this);
		player.setCollisionListener(this);
	}

	public Level(GameContainer container, Game game, Player player,
			LevelConfiguration configuration) throws SlickException {
		this(container, game, player, configuration.path());

		for (NPCConfiguration npcConfiguration : configuration.getNPCs()) {
			NPC npc = new NPC(npcConfiguration, player);
			npc.setCollisionListener(this);
			npcs.add(npc);
		}
		
		for (TransitionConfiguration t: configuration.getTransitions()) {
			transitions.add(new Transition(t));
		}

		if (configuration.hasSound()) {
			music = new Music(configuration.soundPath());
			music.play(1.f, 0.5f);
			music.loop();
		}
		
		if(configuration.hasWinTrigger()) {
			winTrigger = new WinTrigger(configuration.getWinTrigger());
		}
	}

	public void render(GameContainer container, StateBasedGame game,
			Graphics g, Timer t) throws SlickException {

		
		if(externalGame == null) {
			
			camera.drawMap();
			camera.translateGraphics();

			for (NPC npc : npcs) {
				npc.render(container, g);
			}

			player.render(container, g);
			t.render(container, g, camera.getX(), camera.getY());

		} else {
			externalGame.render(container, game, g);
		}
		
		
	}

	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {

		if(externalGame == null) {
			
			for (NPC npc : npcs) {
				npc.update(container, delta);
			}

			player.update(container, delta);
			camera.centerOn(player.shape());
			
			if(winTrigger != null && winTrigger.isTriggered(
					(int) (player.shape().getCenterX() / map.getTileWidth()),
					(int) (player.shape().getCenterY() / map.getTileHeight()))){
				this.game.isOver();
			}
			
			pendingTransition = hasTrigger(player.shape());
			if(pendingTransition != null) {
				if(pendingTransition.hasEvent()) {
					externalGame = pendingTransition.getEvent();
					externalGame.init(container);
				} else {
					executeTransitionIfAny(container, pendingTransition);
				}
			}
			
		} else if(externalGame.isOver()){
			setGameSize();
			externalGame = null;
			executeTransitionIfAny(container, pendingTransition);
		}
		else {
			externalGame.update(container, game, delta);
		}
	}

	public TiledMap map() {
		return map;
	}

	public Transition hasTrigger(Shape shape) {
		for(Transition t : transitions) {
			int x = (int) (shape.getCenterX() / map.getTileWidth());
			int y = (int) (shape.getCenterY() / map.getTileHeight());
			
			if(t.isTriggered(x, y)) {
				return t;
			}
		}
		
		return null;
	}
	
	public void executeTransitionIfAny(GameContainer container, Transition t) throws SlickException {
		if(t == null) return;
		
		Level destination = new Level(container, this.game, 
					this.player, LevelConfiguration.FromXmlFile(t.destinatioName()));
			
			this.game.setLevel(destination);
			player.setDirection(Direction.parse(t.getPlayerDirection()), false);
			player.shape().setX(t.getDestination().getX() * map.getTileWidth() + 1f);
			player.shape().setY(t.getDestination().getY() * map.getTileHeight() - 1f);
			if(music != null) 
				music.stop();
	}
	
	public boolean isColliding(Shape collisionBox, Shape shape) {

		if (isPlayerOnMap(collisionBox))
			return true;

		int x = (int) (collisionBox.getCenterX() / map.getTileWidth());
		int y = (int) (collisionBox.getCenterY() / map.getTileHeight());

		if (map.getTileId(x, y, COLLISION_LAYER_INDEX) != 0)
			return true;

		return false;
	}

	private boolean isPlayerOnMap(Shape playerShape) {

		return playerShape.getCenterX() <= 0.0
				|| playerShape.getCenterX() >= Width
				|| playerShape.getCenterY() <= 0.0
				|| playerShape.getCenterY() >= Height;
	}

	
	private void setGameSize() throws SlickException {
	
		EsieaTrek.GetContainer().setDisplayMode(EsieaTrek.GAME_WIDTH, 
				EsieaTrek.GAME_HEIGHT, false);

	}
	
}
