package org.esiea.minigames;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public abstract class ExternalGame {

	
	protected boolean isOver = false;
	
	
	public boolean isOver() {
		return this.isOver;
	}
	
	public abstract void init(GameContainer gc) throws SlickException;
	
	public abstract void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException;

	
	public abstract void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException;
	
}
