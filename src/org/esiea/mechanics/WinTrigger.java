package org.esiea.mechanics;

import org.esiea.config.WinConfiguration;

public class WinTrigger {
	
	private int x;
	private int y;
	
	public WinTrigger(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public WinTrigger(WinConfiguration configuration) {
		this(configuration.getX(), configuration.getY());
	}
	
	public boolean isTriggered(int x, int y) {
		return this.x == x && this.y == y;
	}
}
