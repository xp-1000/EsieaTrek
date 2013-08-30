package org.esiea.utils;

import org.esiea.config.MovementConfig;
import org.newdawn.slick.*;

public class MovementSprite {
	
	private StateAnimation leftAnimation;
	private StateAnimation rightAnimation;
	private StateAnimation forwardAnimation;
	private StateAnimation backwardAnimation;
	private StateAnimation currentAnimation;
	private MovementConfig config;
	
	
	
	public MovementSprite(String settingsFileName) throws SlickException {
		config = MovementConfig.FromXmlFile("res/settings/characters/" + settingsFileName);
		this.init();
	}
	
	public final void init() throws SlickException {
		
		SpriteSheet sheet = new SpriteSheet(config.getSheetPath(), config.getSpriteWidth(), config.getSpriteHeight());
		leftAnimation = StateAnimation.CreateFromConfig(config.getLeftAnimationConfig(), sheet);
		rightAnimation = StateAnimation.CreateFromConfig(config.getRightAnimationConfig(), sheet);
		forwardAnimation = StateAnimation.CreateFromConfig(config.getForwardAnimationConfig(), sheet);
		backwardAnimation = StateAnimation.CreateFromConfig(config.getBackwardAnimationConfig(), sheet);
		
		currentAnimation = backwardAnimation;
		currentAnimation.stop();
	}
	
	public void start(){ currentAnimation.start(); }
	public void stop(){ currentAnimation.stop(); }
	
	public int height() {
		return this.currentAnimation.getCurrentFrame().getHeight();
	}
	
	public int width() {
		return this.currentAnimation.getCurrentFrame().getWidth();
	}
	
	
	
	public void update(int delta) {
		this.currentAnimation.update(delta);
	}
	
	public void moveLeft(){
		if(currentAnimation != leftAnimation){
			currentAnimation.stop();
			currentAnimation = leftAnimation;
			currentAnimation.start();
		}
	}
	
	public void moveRight(){
		if(currentAnimation != rightAnimation){
			currentAnimation.stop();
			currentAnimation = rightAnimation;
			currentAnimation.start();
		}
	}
	
	public void moveForward(){
		if(currentAnimation != forwardAnimation){
			currentAnimation.stop();
			currentAnimation = forwardAnimation;
			currentAnimation.start();
		}
	}
	
	public void moveBackward(){
		if(currentAnimation != backwardAnimation){
			currentAnimation.stop();
			currentAnimation = backwardAnimation;
			currentAnimation.start();
		}
	}
	
	public Image getCurrentFrame(){ return currentAnimation.getCurrentFrame(); }
}
