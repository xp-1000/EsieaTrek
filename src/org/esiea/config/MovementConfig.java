package org.esiea.config;


import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class MovementConfig {
	
	private final AnimationConfig leftAnimationConfig;
	private final AnimationConfig rightAnimationConfig;
	private final AnimationConfig forwardAnimationConfig;
	private final AnimationConfig backwardAnimationConfig;
	private final SheetConfig sheetConfig;
	
	private MovementConfig(SheetConfig sheetConfig, AnimationConfig leftAnimationConfig,
			AnimationConfig rightAnimationConfig, AnimationConfig forwardAnimationConfig, 
			AnimationConfig backwardAnimationConfig){
		
		this.sheetConfig = sheetConfig;
		this.leftAnimationConfig = leftAnimationConfig;
		this.forwardAnimationConfig = forwardAnimationConfig;
		this.rightAnimationConfig = rightAnimationConfig;
		this.backwardAnimationConfig = backwardAnimationConfig;
	}
	
	public AnimationConfig getLeftAnimationConfig(){
		return this.leftAnimationConfig;
	}
	
	public AnimationConfig getRightAnimationConfig(){
		return this.rightAnimationConfig;
	}

	public AnimationConfig getForwardAnimationConfig(){
		return this.forwardAnimationConfig;
	}

	public AnimationConfig getBackwardAnimationConfig(){
		return this.backwardAnimationConfig;
	}
	
	public String getSheetPath(){
		return this.sheetConfig.getSourcePath();
	}

	public int getSpriteWidth(){
		return this.sheetConfig.getSpriteWidth();
	}
	
	public int getSpriteHeight(){
		return this.sheetConfig.getSpriteHeight();
	}
	
	
	
	public static MovementConfig FromXmlFile(String fileName){
		Document document = XmlParser.Parse(fileName);
		
		SheetConfig sheetConfig = SheetConfig.CreateFromXml((Element) document.getElementsByTagName("sheet").item(0));
		Element animationElement = (Element) document.getElementsByTagName("animations").item(0);
		
		AnimationConfig leftAnimationConfig = AnimationConfig.CreateFromXml((Element) 
				animationElement.getElementsByTagName("left").item(0));
		AnimationConfig rightAnimationConfig = AnimationConfig.CreateFromXml((Element) 
				animationElement.getElementsByTagName("right").item(0));
		AnimationConfig forwardAnimationConfig = AnimationConfig.CreateFromXml((Element) 
				animationElement.getElementsByTagName("forward").item(0));
		AnimationConfig backwardAnimationConfig = AnimationConfig.CreateFromXml((Element) 
				animationElement.getElementsByTagName("backward").item(0));
		
		return new MovementConfig(sheetConfig, leftAnimationConfig, rightAnimationConfig, 
				forwardAnimationConfig, backwardAnimationConfig);
	}
}
