package org.esiea.characters;


import java.awt.Point;

import org.esiea.mechanics.GraphicElement;
import org.esiea.utils.MovementSprite;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public abstract class Character implements GraphicElement {

	protected MovementSprite sprite;
	protected Shape shape;
	protected CollisionChecker collisionChecker;
	
	private final static int speed = 2;
	private Direction direction;
	
	public Character(float x, float y, MovementSprite sprite) {
		this.sprite = sprite;
		this.shape = new Rectangle(x, y, sprite.width(), sprite.height());
		this.direction = Direction.South; 
	}
	
	public void setCollisionListener(CollisionChecker listener) {
		collisionChecker = listener;
	}

	public Direction getDirection() {
		return this.direction;
	}
	
	public void setDirection(Direction direction) {
		setDirection(direction, true);
	}
	
	public void setDirection(Direction direction, boolean moving) {
		this.direction = direction;
		if(Direction.North == direction) sprite.moveForward();
		else if(Direction.South == direction) sprite.moveBackward();
		else if(Direction.East == direction) sprite.moveRight();
		else if(Direction.West == direction) sprite.moveLeft();
		
		if(!moving) sprite.stop();
	}
	
	@Override
	public void render(GameContainer container, Graphics g) {
		sprite.getCurrentFrame().draw(shape.getX(), shape.getY());
	}

	@Override
	public void update(GameContainer container, int delta) {
		sprite.update(delta);
		handleUserInput(container, delta);
	}
	
	public Point center() {
		return new Point((int)shape.getCenterX(), (int)shape.getCenterY());
	}
	
	public Shape shape() {
		return this.shape;
	}
	
	protected abstract void handleUserInput(GameContainer container, int delta);

	protected void moveForward(int delta) {
		setDirection(Direction.North);
		float y = shape.getY();
		shape.setY(shape.getY() - getPositionIncrement(delta));
		Shape collisionBox = new Rectangle(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
		if(collisionChecker.isColliding(collisionBox, shape)) shape.setY(y);
	}
	
	protected void moveBackward(int delta) {
		setDirection(Direction.South);
		float y = shape.getY();
		shape.setY(shape.getY() + getPositionIncrement(delta));
		Shape collisionBox = new Rectangle(shape.getX(), shape.getY(), shape.getWidth() * 2, shape.getHeight() * 2);
		if(collisionChecker.isColliding(collisionBox, shape)) shape.setY(y);
	}

	protected void moveLeft(int delta) {
		setDirection(Direction.West);
		float x = shape.getX(); 
		shape.setX(shape.getX() - getPositionIncrement(delta));
		Shape collisionBox = new Rectangle(shape.getX(), shape.getY(), shape.getWidth() * 0, shape.getHeight()*2);
		if(collisionChecker.isColliding(collisionBox, shape)) shape.setX(x);
	}

	protected void moveRight(int delta) {
		setDirection(Direction.East);
		float x = shape.getX();
		shape.setX(shape.getX() + getPositionIncrement(delta));
		Shape collisionBox = new Rectangle(shape.getX(), shape.getY(), shape.getWidth() * 2, shape.getHeight());
		if(collisionChecker.isColliding(collisionBox, shape)) 
			shape.setX(x);
	}
	
	private float getPositionIncrement(int delta) {
		return delta * speed *  0.1f;
	}
	
	
}
