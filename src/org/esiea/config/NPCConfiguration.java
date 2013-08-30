package org.esiea.config;

import org.esiea.utils.MovementSprite;
import org.newdawn.slick.SlickException;
import org.w3c.dom.Element;

public class NPCConfiguration {

	private final int x;
	private final int y;
	private final String direction;
	private final MovementSprite movementSprite;
	
	public NPCConfiguration(int x, int y, String direction, MovementSprite movementSprite) {
		this.x = x;
		this.y = y;
		this.movementSprite = movementSprite;
		this.direction = direction;
	}
	
	public static NPCConfiguration CreateFromXml(Element element) throws SlickException {
		
		Element positionElement = (Element) element
				.getElementsByTagName("position").item(0);
		int x = Integer.parseInt(positionElement.getAttribute("x"));
		int y = Integer.parseInt(positionElement.getAttribute("y"));
		Element movementElement = (Element) element
				.getElementsByTagName("movement").item(0);
		MovementSprite movementSprite = new MovementSprite(movementElement.getAttribute("src"));
		String direction = movementElement.getAttribute("dir");
		
		return new NPCConfiguration(x, y, direction, movementSprite);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public String getDirection() {
		return direction;
	}
	
	public MovementSprite getMovementConfiguration() {
		return movementSprite;
	}
}
