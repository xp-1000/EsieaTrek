package org.esiea.characters;


import org.newdawn.slick.geom.Shape;

public interface CollisionChecker {
	boolean isColliding(Shape shape, Shape ignoredShape);
}
