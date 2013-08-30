package org.esiea.characters;

import org.esiea.config.NPCConfiguration;
import org.esiea.utils.MovementSprite;
import org.newdawn.slick.GameContainer;

public class NPC extends Character {
	NonPlayerCharacterAI ai;

	public NPC(float x, float y, MovementSprite sprite, Player p) {
		super(x, y, sprite);
	}

	public NPC(NPCConfiguration configuration, Player p) {
		this(configuration.getX(), configuration.getY(), configuration
				.getMovementConfiguration(), p);
		
		if(configuration.getDirection().equals("left")) {
			setDirection(Direction.West, false);
		} else if(configuration.getDirection().equals("right")) {
			setDirection(Direction.East, false);
		} else if(configuration.getDirection().equals("up")) {
			setDirection(Direction.North, false);
		} else if(configuration.getDirection().equals("down")) {
			setDirection(Direction.South, false);
		}
	}

	@Override
	protected void handleUserInput(GameContainer container, int delta) {
		
	}
}
