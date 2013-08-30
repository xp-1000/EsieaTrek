package org.esiea.mechanics;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class EndState extends BasicGameState{

	private int id = EsieaTrek.END_STATE;
	private long timeInSeconds;
	
	public EndState(int id){
		this.id = id;
	}
	
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		g.setColor(Color.lightGray);
		g.drawString("Vous avez gagné en " + timeInSeconds + " secondes !", 
				60 , 180);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		
	}

	public void setTimeInSecondes(long timeInSeconds) {
		this.timeInSeconds = timeInSeconds;
	}
	
	@Override
	public int getID() {
		return this.id;
	}
}
