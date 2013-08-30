package org.esiea.mechanics;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Menu extends BasicGameState{

	private int id;
	
	public Menu(int id){
		this.id = id;
	}
	
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		
	}

	@Override
	public int getID() {
		return this.id;
	}
}
