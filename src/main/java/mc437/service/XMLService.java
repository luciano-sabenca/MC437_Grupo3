package mc437.service;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import mc437.bean.ITestResultBean;
import mc437.service.Interface.XMLInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
@Service
public class XMLService implements XMLInterface{
	
	@Autowired
	TestSetResultsService testSetResults;
		
	@Autowired
	ITestResultService iTestResultService;
		
	public void parserXml(ITestResultBean xmlFile){
		
		try{
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile.getXmlFile());
			doc.getDocumentElement().normalize();
		
			xmlFile.setListTestSetResults(testSetResults.parserXml(doc));
			
			this.save(xmlFile);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void save(ITestResultBean xmlFile){
		iTestResultService.save(xmlFile);
		testSetResults.save(xmlFile);
	}
}
