package org.esiea.config;

import org.w3c.dom.Element;

public class SheetConfig {
	
	private String sourceName;
	private int width;
	private int height;
	
	public SheetConfig(String name, int spriteWidth, int spriteHeight){
		this.sourceName = name;
		this.width = spriteWidth;
		this.height = spriteHeight;
	}
	
	public int getSpriteWidth(){
		return this.width;
	}
	
	public int getSpriteHeight(){
		return this.height;
	}

	public String getSourcePath(){
		return this.sourceName;
	}
	
	public static SheetConfig CreateFromXml(Element element){
		String source = element.getAttribute("src");
		int width = Integer.parseInt(element.getAttribute("x"));
		int height  = Integer.parseInt(element.getAttribute("y"));
		
		return new SheetConfig(source, width, height);
	}
}
