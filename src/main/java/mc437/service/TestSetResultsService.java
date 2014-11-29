package mc437.service;

import java.util.ArrayList;
import java.util.List;

import mc437.bean.ITestResultBean;
import mc437.bean.TestSetResults;
import mc437.dao.TestSetResultsDAO;
import mc437.service.Interface.TestSetResultsInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;


@Service
public class TestSetResultsService implements TestSetResultsInterface{

	
	@Autowired
	TestSetResultsDAO testSetResultsDAO;
	
	public List<TestSetResults> parserXml(Document doc) {
		List<TestSetResults> listTestSetResults = new ArrayList<TestSetResults>();
		
		NodeList nList = doc.getElementsByTagName("testSetResults");
			
		for(int i = 0; i < nList.getLength(); i++){
			TestSetResults testSetResults = new TestSetResults();
			Node nNode = nList.item(i);
			
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				testSetResults.setId(eElement.getElementsByTagName("id").item(0).getTextContent());
				testSetResults.setCod(eElement.getElementsByTagName("cod").item(0).getTextContent());
				testSetResults.setPath(eElement.getElementsByTagName("path").item(0).getTextContent());
				
				listTestSetResults.add(testSetResults);
			}
		}
		
		return listTestSetResults;
	}
	
	public void save(ITestResultBean iTestResultBean){
		for (TestSetResults item : iTestResultBean.getListTestSetResults()) {
			item.setIdSeq(testSetResultsDAO.save(item, iTestResultBean.getId()));
		}
	}

}
