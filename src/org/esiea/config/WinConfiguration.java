package org.esiea.config;
import org.w3c.dom.Element;

public class WinConfiguration {
	private final int x;
	private final int y;
	
	public WinConfiguration(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public static WinConfiguration CreateFromXml(Element element) {
		
		int x = Integer.parseInt(element.getAttribute("x"));
		int y = Integer.parseInt(element.getAttribute("y"));
		
		return new WinConfiguration(x, y);
	}
}
