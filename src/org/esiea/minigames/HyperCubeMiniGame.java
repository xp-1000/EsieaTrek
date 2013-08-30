package org.esiea.minigames;

import org.esiea.mechanics.EsieaTrek;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class HyperCubeMiniGame extends ExternalGame{

	 
    Image Fond [] = new Image [5];
    Image Barre [] = new Image [2];
    Image Cube = null;
    Image Porte = null;

        
    private int xD = 285;
    private int xG = 575;
    private int secondTour =0;
    private int win = 0;
    private int modif = 0;
    private int avance = 1;
    
    private boolean youWin= false;
    Music ambiance = null;
	
  //emplacements barres initiaux.....................................................................................................................|emplacements barres modifiés..................................................................................................
    private int pL[][][]={{{225,25,25,375,375,375},{25,100,175,375,275,175},{200,25,375,200,25,375},{25,250,150,375,25,250},{30,270,370,25,225,465}},{{150,250,640,450,0,640},{300,100,250,450,640,640},{0,500,0,250,100,640},{640,0,220,250,200,640},{65,270,370,25,225,465}}};
    private int pH[][][]={{{400,300,200,400,300,200},{400,375,350,250,225,200},{200,300,300,400,500,500},{500,500,300,300,200,200},{400,400,400,200,200,200}},{{400,300,300,200,150,100},{500,400,300,400,200,100},{500,400,200,300,100,100},{550,450,500,300,200,100},{400,400,400,200,50,200}}};
    
    
    
	@Override
	public void init(GameContainer gc) throws SlickException {
		
		EsieaTrek.GetContainer().setDisplayMode(600, 600, false);
		
		ambiance = new Music("/res/sounds/music1.ogg");
    	ambiance.play();
    	Fond [0]= new Image("res/images/games/Fond1.png");
    	Fond [1]= new Image("res/images/games/Fond2.png");
    	Fond [2]= new Image("res/images/games/Fond3.png");
    	Fond [3]= new Image("res/images/games/Fond4.png");
    	Fond [4]= new Image("res/images/games/Fond5.png");
    	Cube = new Image("res/images/games/Cube1.png");
    	Porte = new Image("res/images/games/Porte1.png");
    	Barre [0] = new Image("res/images/games/Barre1_slim.png");
    	Barre [1] = new Image("res/images/games/Barre2_slim.png");
	}
    
    
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
    	Fond[win].draw(0,0);
    	Barre[0].draw(0,0);
    	Barre[0].draw(575,0);
		Porte.draw(285,550);
		Porte.draw(285,0);
    	for(int i=0;i<6;i++)
    	{
    		Barre[1].draw(pL[modif][win][i],pH[modif][win][i]);
    	}

    	if(youWin==false)
    	{
        	Cube.draw(xD,xG);
    	}
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		
		Input input = container.getInput();
    	
    	avance=1;

    	if(input.isKeyPressed(Input.KEY_LEFT))
    	{
    		if(secondTour==1)
    		{
    			if(modif==0)modif=1;
    			else modif=0;
    		}
    	}
    	
    	if(input.isKeyDown(Input.KEY_LEFT))
    	{
    		xD=xD-10;
    		avance=0;
    	}
    	
    	if(input.isKeyPressed(Input.KEY_RIGHT))
    	{
    		if(secondTour==1)
    		{
    			if(modif==0)modif=1;
    			else modif=0;
    		}
    	}
    	
    	if(input.isKeyDown(Input.KEY_RIGHT))
    	{
    		xD=xD+10;
    		avance=0;
    	}
    	 
    	if(xD<=25||xD>=550||xG<0)
    	{
    		xD = 285;
    	    xG = 575;
    	}
    	
    	for(int i=0;i<6;i++)
		{
			if(xG>=pH[modif][win][i]-25&&xG<=pH[modif][win][i]-5)
			{
				if(xD>=pL[modif][win][i]-25&&xD<=pL[modif][win][i]+200)
				{
					xD = 285;
		    	    xG = 575;
					break;
				}
			}
		}
    	
    	if(avance==1){
    		xG=xG-5;
    	}
        	        
        if(xD>=260&&xD<=310)
		{
			if(xG<50)
    		{
				if(win==4 && secondTour==1){
					youWin=true;
				}else{
					win++;
					xD = 285;
				    xG = 575;
				    if(win>4){
				    	modif=0;
				    	win=0;
				    	secondTour=1;
				    }
				}
    		}
		}
        
        if (youWin==true)
        {
        	ambiance.stop();
    		this.isOver=true;
        }
    	
	}



}
