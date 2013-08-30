package org.esiea.mechanics;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Highscore extends BasicGameState{

	
	private int id;
	
	public Highscore(int id){
		this.id = id;
	}
	
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getID() {
		return this.id;
	}
}
