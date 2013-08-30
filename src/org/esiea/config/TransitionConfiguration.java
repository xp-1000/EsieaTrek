package org.esiea.config;

import org.newdawn.slick.geom.Point;
import org.w3c.dom.Element;

public class TransitionConfiguration {

	private final Point origin;
	private final Point destination;
	private final String direction;
	private final String destinationMapName;
	private final String externalGameName;
	private final long millisecondsBeforeActivation;
	
	public TransitionConfiguration(Point origin, Point remote, 
			String destinationMapName, String playerDirection, 
			String externalGameName, long tickCountBeforeActivation){
		
		this.origin = origin;
		this.destination = remote;
		this.destinationMapName = destinationMapName;
		this.direction = playerDirection;
		this.millisecondsBeforeActivation = tickCountBeforeActivation;
		this.externalGameName = externalGameName;
		
	}
	
	public static TransitionConfiguration CreateFromXml(Element element) {
		
		float originX = Float.parseFloat(element.getAttribute("originx"));
		float originY = Float.parseFloat(element.getAttribute("originY"));
		
		float destinationX = Float.parseFloat(element.getAttribute("remotex"));
		float destinationY = Float.parseFloat(element.getAttribute("remotey"));
		
		String direction = element.getAttribute("direction");
		String destinationMapName = element.getAttribute("to");
		String externalGameName = element.getAttribute("event");
		long millisecondesBeforeActivation = Long.parseLong(element.getAttribute("timing"));
		
		return new TransitionConfiguration(new Point(originX, originY), new Point(destinationX, destinationY),
				destinationMapName, direction, externalGameName, millisecondesBeforeActivation);
	}
	
	public Point getOrigin() {
		return origin;
	}
	
	public Point getDestination() {
		return destination;
	}
	
	public String destinatioName() {
		return destinationMapName;
	}
	
	public String getPlayerDirection() {
		return direction;
	}
	
	public String getExternalGameName() {
		return externalGameName;
	}
	
	public long getTimeInMillisecondBeforeActivation() {
		return millisecondsBeforeActivation;
	}
	
	public boolean hasEvent(){
		return externalGameName != null 
				&& !externalGameName.isEmpty();	
	}
}
