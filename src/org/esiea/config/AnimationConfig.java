package org.esiea.config;

import java.awt.Point;
import org.w3c.dom.Element;

public class AnimationConfig {

	private Point start;
	private Point end;
	private Point inactive;
	private int duration;
	
	public AnimationConfig(Point start, Point end, Point inactive, int duration){
		this.start = start;
		this.end = end;
		this.inactive = inactive;
		this.duration = duration;
	}
	
	public int getFrameDuration(){
		return this.duration;
	}
	
	public Point getStartPosition(){
		return this.start;
	}
	
	public Point getEndPosition(){
		return this.end;
	}
	
	public Point getInactivePosition(){
		return this.inactive;
	}
	
	public static AnimationConfig CreateFromXml(Element element){
		
		int duration = Integer.parseInt(element.getAttribute("duration"));
		
		Element startElement = (Element) element.getElementsByTagName("start").item(0);
		Element endElement = (Element) element.getElementsByTagName("end").item(0);
		Element inactiveElement = (Element) element.getElementsByTagName("inactive").item(0);
		
		int xStart = Integer.parseInt(startElement.getAttribute("x"));
		int yStart = Integer.parseInt(startElement.getAttribute("y"));
		int xEnd = Integer.parseInt(endElement.getAttribute("x"));
		int yEnd = Integer.parseInt(endElement.getAttribute("y"));
		int xInactive = Integer.parseInt(inactiveElement.getAttribute("x"));
		int yInactive = Integer.parseInt(inactiveElement.getAttribute("y"));
		
		return new AnimationConfig(new Point(xStart, yStart), new Point(xEnd, yEnd), 
				new Point(xInactive, yInactive), duration);
	}
}
