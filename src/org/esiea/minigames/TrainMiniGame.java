package org.esiea.minigames;

import org.esiea.mechanics.EsieaTrek;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class TrainMiniGame extends ExternalGame {

	
	Image irer = null;
    Image iPorteD = null;
    Image iPorteG = null;
    Image [] iLettre = new Image [26]; //tableau contenant les images des lettres
    
    Image itemp = null; //image lettre affichee
    
    Music ambiance = null;
    
    private long counter =0;
    
    private double al = 0; 	//random
    private int d = 0;		//random
    private int randint =0;	//random
    
    private int xD = 292;
    private int xG = 286;
    
    private boolean youWin= false;
    
    private float scale =1f;
    private boolean bonnetouche = false; //true lorsque la bonne touche est appuyee
	
	@Override
	public void init(GameContainer gc) throws SlickException {
		
		EsieaTrek.GetContainer().setDisplayMode(800, 600, false);
		
		//Initialisation Sons
    	ambiance = new Music("res/sounds/ambiance.ogg");
    	ambiance.play();
    	//Initialisation Images
    	irer = new Image("res/images/games/RER.png");
    	iPorteD = new Image("res/images/games/RER_porteDF.png");
    	iPorteG = new Image("res/images/games/RER_porteGF.png");
    	iLettre [0]= new Image("res/images/games/RER_toucheA.png");
    	iLettre [1]= new Image("res/images/games/RER_toucheB.png");
    	iLettre [2]= new Image("res/images/games/RER_toucheC.png");
    	iLettre [3]= new Image("res/images/games/RER_toucheD.png");
    	iLettre [4]= new Image("res/images/games/RER_toucheE.png");
    	iLettre [5]= new Image("res/images/games/RER_toucheF.png");
    	iLettre [6]= new Image("res/images/games/RER_toucheG.png");
    	iLettre [7]= new Image("res/images/games/RER_toucheH.png");
    	iLettre [8]= new Image("res/images/games/RER_toucheI.png");
    	iLettre [9]= new Image("res/images/games/RER_toucheJ.png");
    	iLettre [10]= new Image("res/images/games/RER_toucheK.png");
    	iLettre [11]= new Image("res/images/games/RER_toucheL.png");
    	iLettre [12]= new Image("res/images/games/RER_toucheM.png");
    	iLettre [13]= new Image("res/images/games/RER_toucheN.png");
    	iLettre [14]= new Image("res/images/games/RER_toucheO.png");
    	iLettre [15]= new Image("res/images/games/RER_toucheP.png");
    	iLettre [16]= new Image("res/images/games/RER_toucheQ.png");
    	iLettre [17]= new Image("res/images/games/RER_toucheR.png");
    	iLettre [18]= new Image("res/images/games/RER_toucheS.png");
    	iLettre [19]= new Image("res/images/games/RER_toucheT.png");
    	iLettre [20]= new Image("res/images/games/RER_toucheU.png");
    	iLettre [21]= new Image("res/images/games/RER_toucheV.png");
    	iLettre [22]= new Image("res/images/games/RER_toucheW.png");
    	iLettre [23]= new Image("res/images/games/RER_toucheX.png");
    	iLettre [24]= new Image("res/images/games/RER_toucheY.png");
    	iLettre [25]= new Image("res/images/games/RER_toucheZ.png");
    	//Initialisation de randint (random integer)
    	al = Math.random();
        d = (int) (al * 26);
        randint = (int)d;
        
        itemp = iLettre [randint];
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		iPorteG.draw(xG,116);
    	iPorteD.draw(xD,116);
    	irer.draw(0,0);
    	if(youWin==false)
    	{
    		itemp.draw(110,450,scale);
    	}
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		
		counter += delta;
    	if(counter >=500)
    	{
    		counter=0;
    		if(scale==1f)
    		{
    			scale=0.9f;
    		}
    		else
    		{
    			scale=1f;
    		}
    	}
    	
    	Input input = container.getInput();
    	if(input.isKeyDown(Input.KEY_A))
    	{
    		if(randint==0)
    		{
    			bonnetouche=true;
    		}
    	}
    	
    	if(input.isKeyDown(Input.KEY_B))
    	{
    		if(randint==1)
    		{
    			bonnetouche=true;
    		}
    	}
    	
    	if(input.isKeyDown(Input.KEY_C))
    	{
    		if(randint==2)
    		{
    			bonnetouche=true;
    		}
    	}
    	
    	if(input.isKeyDown(Input.KEY_D))
    	{
    		if(randint==3)
    		{
    			bonnetouche=true;
    		}
    	}
    	
    	if(input.isKeyDown(Input.KEY_E))
    	{
    		if(randint==4)
    		{
    			bonnetouche=true;
    		}
    	}
    	
    	if(input.isKeyDown(Input.KEY_F))
    	{
    		if(randint==5)
    		{
    			bonnetouche=true;
    		}
    	}
    	
    	if(input.isKeyDown(Input.KEY_G))
    	{
    		if(randint==6)
    		{
    			bonnetouche=true;
    		}
    	}
    	
    	if(input.isKeyDown(Input.KEY_H))
    	{
    		if(randint==7)
    		{
    			bonnetouche=true;
    		}
    	}
    	
    	if(input.isKeyDown(Input.KEY_I))
    	{
    		if(randint==8)
    		{
    			bonnetouche=true;
    		}
    	}
    	
    	if(input.isKeyDown(Input.KEY_J))
    	{
    		if(randint==9)
    		{
    			bonnetouche=true;
    		}
    	}
    	
    	if(input.isKeyDown(Input.KEY_K))
    	{
    		if(randint==10)
    		{
    			bonnetouche=true;
    		}
    	}
    	
    	if(input.isKeyDown(Input.KEY_L))
    	{
    		if(randint==11)
    		{
    			bonnetouche=true;
    		}
    	}
    	
    	if(input.isKeyDown(Input.KEY_M))
    	{
    		if(randint==12)
    		{
    			bonnetouche=true;
    		}
    	}
    	
    	if(input.isKeyDown(Input.KEY_N))
    	{
    		if(randint==13)
    		{
    			bonnetouche=true;
    		}
    	}
    	
    	if(input.isKeyDown(Input.KEY_O))
    	{
    		if(randint==14)
    		{
    			bonnetouche=true;
    		}
    	}
    	
    	if(input.isKeyDown(Input.KEY_P))
    	{
    		if(randint==15)
    		{
    			bonnetouche=true;
    		}
    	}
    	
    	if(input.isKeyDown(Input.KEY_Q))
    	{
    		if(randint==16)
    		{
    			bonnetouche=true;
    		}
    	}
    	
    	if(input.isKeyDown(Input.KEY_R))
    	{
    		if(randint==17)
    		{
    			bonnetouche=true;
    		}
    	}
    	
    	if(input.isKeyDown(Input.KEY_S))
    	{
    		if(randint==18)
    		{
    			bonnetouche=true;
    		}
    	}
    	
    	if(input.isKeyDown(Input.KEY_T))
    	{
    		if(randint==19)
    		{
    			bonnetouche=true;
    		}
    	}
    	
    	if(input.isKeyDown(Input.KEY_U))
    	{
    		if(randint==20)
    		{
    			bonnetouche=true;
    		}
    	}
    	
    	if(input.isKeyDown(Input.KEY_V))
    	{
    		if(randint==21)
    		{
    			bonnetouche=true;
    		}
    	}
    	
    	if(input.isKeyDown(Input.KEY_W))
    	{
    		if(randint==22)
    		{
    			bonnetouche=true;
    		}
    	}
    	
    	if(input.isKeyDown(Input.KEY_X))
    	{
    		if(randint==23)
    		{
    			bonnetouche=true;
    		}
    	}
    	
    	if(input.isKeyDown(Input.KEY_Y))
    	{
    		if(randint==24)
    		{
    			bonnetouche=true;
    		}
    	}
    	
    	if(input.isKeyDown(Input.KEY_Z))
    	{
    		if(randint==25)
    		{
    			bonnetouche=true;
    		}
    	}
    	
    	
        
        if (bonnetouche==true)
        {
        	bonnetouche=false;
        	al = Math.random();
            d = (int) (al * 26);
            randint = (int)d;
            itemp = iLettre [randint];
            xD += 5;
            xG -= 5;
            if(xG<=155)
            {
            	youWin=true;
            }
        }
        
        if (youWin==true)
        {
        	ambiance.stop();
        	isOver = true;
        }
		
	}

}
