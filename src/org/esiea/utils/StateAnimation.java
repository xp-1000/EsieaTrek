package org.esiea.utils;

import org.esiea.config.AnimationConfig;
import org.newdawn.slick.*;

public class StateAnimation {

	private Animation animation;
	private Image inactive;
	
	public StateAnimation(SpriteSheet animationFrames, int xStart, int yStart, int xEnd, int yEnd, 
			boolean horizontalScan, int duration, boolean autoUpdate, Image inactiveImage){
		animation = new Animation(animationFrames, xStart, yStart, xEnd, yEnd, horizontalScan, duration, autoUpdate);
		inactive = inactiveImage;
	}
	
	public static StateAnimation CreateFromConfig(AnimationConfig config, SpriteSheet sheet){
		
		return new StateAnimation(sheet, config.getStartPosition().x, config.getStartPosition().y, 
				config.getEndPosition().x, config.getEndPosition().y, false, config.getFrameDuration(),
				true, sheet.getSprite(config.getInactivePosition().x, config.getInactivePosition().y));
	}
	
	public void start(){ this.animation.start(); }
	public void stop(){ this.animation.stop(); }
	public void update(int delta){ this.animation.update(delta); }
	
	
	public Image getCurrentFrame(){
		if(animation.isStopped()){
			return inactive;
		}
		return animation.getCurrentFrame();
	}
	
}
