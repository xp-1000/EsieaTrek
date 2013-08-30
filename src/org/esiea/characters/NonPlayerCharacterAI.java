package org.esiea.characters;

import org.newdawn.slick.geom.Shape;

public class NonPlayerCharacterAI {
	
	protected Shape playerShape;
	protected Shape itsShape;
	protected CollisionChecker collisionChecker;
	
	public NonPlayerCharacterAI(Shape itsShape, Shape playerShape) {
		this.itsShape = itsShape;
		this.playerShape = playerShape;
	}
	
	// TODO : Add obstacle in sight handling
	public final boolean hasPlayerInSight(Direction direction) {
		
		if(Direction.North == direction) {
			return (floatEqual(itsShape.getCenterX(), playerShape.getCenterX()))
					&& (itsShape.getCenterY() >= playerShape.getCenterY());
		} else if(Direction.South == direction) {
			return (floatEqual(itsShape.getCenterX(),playerShape.getCenterX()))
					&& (itsShape.getCenterY() <= playerShape.getCenterY());
		} else if(Direction.East == direction) {
			return (itsShape.getCenterX() <= playerShape.getCenterX())
					&& floatEqual(itsShape.getCenterY(), playerShape.getCenterY());
		} else if(Direction.West == direction) {
			return (itsShape.getCenterX() >= playerShape.getCenterX())
					&& floatEqual(itsShape.getCenterY(), playerShape.getCenterY());
		}
		return false;
	}
	
	
	public boolean floatEqual(float f1, float f2) {
		float tolerance = 10.f;
		return Math.abs(f1 - f2) <= tolerance;
	}
	
	
}