package org.esiea.mechanics;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public interface GraphicElement {
	public void render(GameContainer container, Graphics g);
	public void update(GameContainer container, int delta);
}
