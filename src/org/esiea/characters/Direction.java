package org.esiea.characters;

public enum Direction {
	East, West, North, South;
	
	public static Direction parse(String raw) {
		if(raw == null || raw.isEmpty()) return South;
		if(raw.equals("down")) {
			return South;
		} else if(raw.equals("up")) {
			return North;
		} else if(raw.equals("left")) {
			return West;
		}  else if(raw.equals("right")) {
			return East;
		} return South;
	}
}
