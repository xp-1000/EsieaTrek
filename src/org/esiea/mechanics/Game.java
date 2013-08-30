package org.esiea.mechanics;

import org.esiea.characters.Player;
import org.esiea.config.LevelConfiguration;
import org.esiea.utils.MovementSprite;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends BasicGameState {

	private int id;
	private Level currentLevel;
	private Player player;
	private Timer timer;
	
	public Game(int id) {
		this.id = id;
	}

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		container.setShowFPS(false);
		
		timer = new Timer();
		timer.start();
		player = new Player(30, 50, new MovementSprite("salameche.xml"));
		currentLevel = new Level(container,this, player,
				LevelConfiguration.FromXmlFile("room"));
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		currentLevel.render(container, game, g, timer);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		currentLevel.update(container, game, delta);
	}

	public void setLevel(Level level) {
		this.currentLevel = level;
	}
	
	
	public void isOver(){
		EsieaTrek.getInstance().getEndState().setTimeInSecondes(timer.getElapsedTimeInSeconds());
		EsieaTrek.getInstance().enterState(EsieaTrek.END_STATE);
	}
	

	@Override
	public int getID() {
		return this.id;
	}

}
