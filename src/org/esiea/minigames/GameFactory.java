package org.esiea.minigames;


public class GameFactory {
	public static ExternalGame Create(String name) {
		if(name == null || name.isEmpty()) return null;
		if(name.equals("cube")) return new CubeMiniGame();
		if(name.equals("hypercube")) return new HyperCubeMiniGame();
		if(name.equals("train")) return new TrainMiniGame();
		return null;
	}
}
