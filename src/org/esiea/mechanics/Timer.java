package org.esiea.mechanics;

import org.lwjgl.Sys;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Timer {

	private long startTick = 0;
	private long stopTick = 0;
	private boolean running = false;
	
	public void start() {
		startTick = Sys.getTime();
		running = true;
	}
	
	public void stop() {
		stopTick = Sys.getTime();
		running = false;
	}
	
	public void reset() {
		running = false;
		startTick = 0;
		stopTick = 0;
	}
	
	public void render(GameContainer container, Graphics g, float x, float y) {
		g.setColor(Color.white);
		g.drawString("Temps : " + getElapsedTimeInSeconds(), x,y);
	}
	
	public long getElapsedTimeInSeconds() {
		return getElapsedTimeInMilliseconds() / 1000;
	}
	
	public long getElapsedTimeInMilliseconds() {
		return (running) ? (Sys.getTime() - startTick):
			(stopTick - startTick);
	}
	
}
