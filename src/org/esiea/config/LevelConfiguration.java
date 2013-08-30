package org.esiea.config;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.SlickException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class LevelConfiguration {

	private final static String RESOURCE_PATH = "res/settings/levels/";
	private final static String SOUND_PATH = "res/sounds/";
	private final List<NPCConfiguration> npcs;
	private final List<TransitionConfiguration> transitions;
	private final WinConfiguration winTriggerConfiguration;
	private final String path;
	private final String soundPath;
	
	public LevelConfiguration(String path, String soundPath, List<NPCConfiguration> npcs, 
			List<TransitionConfiguration> transitions, WinConfiguration winTriggerConfiguration) {
		this.path = path;
		this.npcs = npcs;
		this.soundPath = soundPath;
		this.transitions = transitions;
		this.winTriggerConfiguration = winTriggerConfiguration;
	}

	public String path() {
		return this.path;
	}
	
	public String soundPath() {
		return SOUND_PATH + soundPath;
	}

	public boolean hasSound() {
		return soundPath != null 
				&& !soundPath.isEmpty();
	}
	
	public boolean hasWinTrigger() {
		return winTriggerConfiguration != null;
	}
	
	public WinConfiguration getWinTrigger() {
		return winTriggerConfiguration;
	}
	
	public final List<NPCConfiguration> getNPCs() {
		return this.npcs;
	}

	public final List<TransitionConfiguration> getTransitions() {
		return this.transitions;
	}
	
	public static LevelConfiguration FromXmlFile(String fileName) throws SlickException {

		Document document = XmlParser.Parse(RESOURCE_PATH + fileName + ".xml");

		Element levelNode = (Element) document.getFirstChild();
		String path = levelNode.getAttribute("map");
		String soundPath = levelNode.getAttribute("sound");

		Element charactersNode = (Element) document.getElementsByTagName(
				"characters").item(0);
		List<NPCConfiguration> configurations = new ArrayList<NPCConfiguration>();
		
		if (charactersNode != null) {
			NodeList characterNodes = charactersNode.getElementsByTagName("character");

			for (int i = 0; i < characterNodes.getLength(); i++) {
				Element characterElement = (Element) characterNodes.item(i);
				configurations.add(NPCConfiguration.CreateFromXml(characterElement));
			}
		}

		
		Element transitionsNode = (Element) document.getElementsByTagName("transitions").item(0);
		List<TransitionConfiguration> transitions = new ArrayList<TransitionConfiguration>();
		
		if (transitionsNode != null) {
			NodeList transitionNodes = transitionsNode.getElementsByTagName("transition");

			for (int i = 0; i < transitionNodes.getLength(); i++) {
				Element transitionElement = (Element) transitionNodes.item(i);
				transitions.add(TransitionConfiguration.CreateFromXml(transitionElement));
			}
		}
		
		
		WinConfiguration winConfiguration = null;
		if(document.getElementsByTagName("win").item(0) != null) {
			Element winNode = (Element) document.getElementsByTagName("win").item(0);
			winConfiguration = WinConfiguration.CreateFromXml(winNode);
		}
		
		return new LevelConfiguration(path, soundPath, configurations, transitions, winConfiguration);
	}

}
