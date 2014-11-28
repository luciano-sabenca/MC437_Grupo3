package mc437.service;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
@Service
public class XMLService implements XMLInterface{
	
	@Autowired
	TestSetResultsService testSetResults;
	
	public void parserXml(String pathXmlFile, int idItestResult){
		
		try{
			File xmlFile = new File(pathXmlFile);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();
		
			testSetResults.parserXml(doc, idItestResult);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
