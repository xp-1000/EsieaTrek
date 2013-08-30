package org.esiea.minigames;

import org.esiea.mechanics.EsieaTrek;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class CubeMiniGame extends ExternalGame{

	 
    private Image Fond [] = new Image [5];
    private Image Barre [] = new Image [2];
    private Image Cube = null;
    private Image Porte = null;

    private long counterSaut =0;
        
    private int xD = 400;
    private int xG = 525;
    private int Saut = 0;
    private int secondTour =0;
    private int win = 0;
    private int modif = 0;
    private boolean youWin = false;
    private Music ambiance = null;
    
    // emplacement initial des barres
    private int pL[][][]={{{150,250,350,450,550,640},{150,0,250,450,640,640},{0,0,0,250,500,640},{640,640,220,250,500,640},{300,300,300,300,500,640}},{{150,250,640,450,0,640},{300,100,250,450,640,640},{0,500,0,250,100,640},{640,0,220,250,200,640},{200,400,200,400,500,640}}};
    private int pH[][][]={{{500,400,300,200,150,100},{500,400,300,310,200,100},{500,400,300,200,150,100},{450,350,400,300,200,100},{450,350,400,300,200,100}},{{400,300,300,200,150,100},{500,400,300,400,200,100},{500,400,200,300,100,100},{550,450,500,300,200,100},{450,350,400,300,450,100}}};
    
	@Override
	public void init(GameContainer gc) throws SlickException {
		
		EsieaTrek.GetContainer().setDisplayMode(800, 600, false);
		
		ambiance = new Music("/res/sounds/music1.ogg");
    	ambiance.play();
    	Fond [0]= new Image("res/images/games/Fond1.png");
    	Fond [1]= new Image("res/images/games/Fond2.png");
    	Fond [2]= new Image("res/images/games/Fond3.png");
    	Fond [3]= new Image("res/images/games/Fond4.png");
    	Fond [4]= new Image("res/images/games/Fond5.png");
    	Cube = new Image("res/images/games/Cube1.png");
    	Porte = new Image("res/images/games/Porte1.png");
    	Barre [0] = new Image("res/images/games/Barre1.png");
    	Barre [1] = new Image("res/images/games/Barre2.png");
	}
    
    
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
    	Fond[win].draw(0,0);
    	Barre[0].draw(0,550);
		Porte.draw(700,50);
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
    	
    	if(input.isKeyDown(Input.KEY_LEFT)&&xD>0)
    	{
    		xD=xD-10;
    	}
    	
    	if(input.isKeyDown(Input.KEY_RIGHT)&&xD<775)
    	{
    		xD=xD+10;
    	}
    	
    	if(input.isKeyDown(Input.KEY_SPACE)&&Saut==0)
    	{
    		if(secondTour==1){
    			if(modif==0)modif = 1;
    			else modif = 0;
    		}
    		Saut=1;
    	}
    	
    	if (Saut==0)
        {      	
        	if(xG<525)
        	{
        		for(int i=0;i<6;i++)
        		{
        			if(xG>=pH[modif][win][i]-25&&xG<=pH[modif][win][i]-20)
        			{
        				if(xD<=pL[modif][win][i]-25||xD>=pL[modif][win][i]+100)
        				{
            				Saut=2;
        				}else{
        					Saut=0;
        					break;
        				}
        			}
        		}
        	}
        }
    	
        
        if (Saut==1)
        {
        	counterSaut+=delta;
        	if (counterSaut<=250)
        	{
        		xG -= 10;
        	}
        	if (counterSaut>=250)
        	{
        		xG -= 5;
        	}
        	if (counterSaut>=300)
        	{
        		counterSaut=0;
        		Saut=2;
        	}      	
        }
        
        if (Saut==2)
        {
        	xG += 10;
        	
        	if(xG<525)
        	{       	
        		for(int i=0;i<6;i++)
        		{
        			if(xD>=pL[modif][win][i]-25&&xD<=pL[modif][win][i]+100)
        			{
        				if(xG>=pH[modif][win][i]-25&&xG<=pH[modif][win][i]-20)
        				{
        					Saut=0;
        					break;
        				}
        			}
        		}
        	}else{
        		Saut=0;
        	}
        }

        	
        	        
        if(xD>=700&&xD<=720)
		{
			if(xG>=50&&xG<=80)
    		{
				if(win==4 && secondTour==1){
					youWin=true;
				}else{
					win++;
					xD = 400;
				    xG = 525;
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
    		this.isOver = true;
        }
    	
	}



}
