package org.esiea.mechanics;


import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class EsieaTrek extends StateBasedGame {

	public static final int MENUSTATEID = 0;
	public static final int GAMESTATEID = 1;
	public static final int HIGHSCORESTATEID = 2;
	public static final int END_STATE = 3;
	private static final String name = "Esiea Trek";
	private static AppGameContainer container;
	private static EsieaTrek instance;
	private EndState endstate;
	
	public static int GAME_WIDTH = 400;
	public static int GAME_HEIGHT = 400;
	
	public EsieaTrek() {
		super(name);
		this.addState(new Menu(MENUSTATEID));
		this.addState(new Game(GAMESTATEID));
		this.addState(new Highscore(HIGHSCORESTATEID));
		endstate = new EndState(END_STATE);
		this.addState(endstate);
		
		instance = this;
	}
	
	public static void main(String args[]){
		try{
			AppGameContainer container = new AppGameContainer(new EsieaTrek());
			EsieaTrek.container = container;
			container.setDisplayMode(400, 400, false);
			container.setTargetFrameRate(50);
			container.setIcon("/res/images/icon_32_32.png");
			container.start();
			
		}catch(SlickException e){
			e.printStackTrace();
		}
	}

	public static AppGameContainer GetContainer() {
		return EsieaTrek.container;
	}
	
	public static EsieaTrek getInstance(){
		return instance;
	}
	
	public EndState getEndState() {
		return endstate;
	}
	
	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		this.enterState(GAMESTATEID);
	}
}
