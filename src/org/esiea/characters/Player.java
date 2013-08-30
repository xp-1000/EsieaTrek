package org.esiea.characters;


import org.esiea.utils.MovementSprite;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

public class Player extends Character {
	
	public Player(float x, float y, MovementSprite sprite) {
		super(x, y, sprite);
	}
	
	@Override
	protected void handleUserInput(GameContainer container, int delta) {
		
		Input input = container.getInput();
		
		if(input.isKeyDown(Input.KEY_Z)){
			moveForward(delta);
		}
		else if(input.isKeyDown(Input.KEY_S)){
			moveBackward(delta);
		}
		else if(input.isKeyDown(Input.KEY_Q)) {
			moveLeft(delta);
			
		}
		else if(input.isKeyDown(Input.KEY_D)) {
			moveRight(delta);
			
		}
		else sprite.stop();
	}
}
