package org.esiea.config;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;


public class XmlParser {
	public static Document Parse(String fileName){
		File xmlFile = new File(fileName);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document document = dBuilder.parse(xmlFile);
			document.getDocumentElement().normalize();
			return document;
		} catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}
}
