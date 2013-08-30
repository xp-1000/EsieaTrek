package org.esiea.mechanics;

import org.esiea.config.TransitionConfiguration;
import org.esiea.minigames.ExternalGame;
import org.esiea.minigames.GameFactory;
import org.newdawn.slick.geom.Point;

public class Transition {

	private final TransitionConfiguration configuration;
	private Timer timer;
	
	public Transition(TransitionConfiguration configuration) {
		this.configuration = configuration;
		timer = new Timer();
		timer.start();
	}
	
	public boolean isTriggered (int x, int y) {
		if(!isActivated()) return false;
		Point origin = this.configuration.getOrigin();
		
		return ((int)origin.getX()) == x 
				&& ((int)origin.getY() == y);		
	}
	
	private boolean isActivated() {
		return timer.getElapsedTimeInMilliseconds() >= 
			configuration.getTimeInMillisecondBeforeActivation();
	}
	
	public boolean hasEvent() {
		return configuration.hasEvent();
	}
	
	public ExternalGame getEvent() {
		if(!hasEvent()) return null;
		return GameFactory.Create(configuration.getExternalGameName());
	}
	
	public Point getOrigin() {
		return configuration.getOrigin();
	}
	
	public Point getDestination() {
		return configuration.getDestination();
	}
	
	public String destinatioName() {
		return configuration.destinatioName();
	}
	
	public String getPlayerDirection() {
		return configuration.getPlayerDirection();
	}
	
}
