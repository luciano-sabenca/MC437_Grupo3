package mc437.service;

import java.util.ArrayList;
import java.util.List;

import mc437.bean.IMutants;
import mc437.bean.ITestResultBean;
import mc437.bean.Implementation;
import mc437.bean.Map;
import mc437.dao.IMutantsDAO;
import mc437.dao.ImplementationDAO;
import mc437.dao.MapDAO;
import mc437.service.Interface.IMutantsInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;


@Service
public class IMutantsService implements IMutantsInterface{

	@Autowired
	ImplementationService implementationService;
	@Autowired
	MapService mapService;
	
	@Autowired
	IMutantsDAO iMutantsDAO;
	@Autowired
	ImplementationDAO implementationDAO;
	@Autowired
	MapDAO mapDAO;
	
	public List<IMutants> parserXml(Document doc) {
		List<IMutants> listTestSetResults = new ArrayList<IMutants>();
		
		NodeList nList = doc.getElementsByTagName("_imutants");
			
		for(int i = 0; i < nList.getLength(); i++){
			IMutants testSetResults = new IMutants();
			Node nNode = nList.item(i);
			
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				testSetResults.setId(eElement.getAttribute("id"));
				testSetResults.setBuildFlag(eElement.getElementsByTagName("buildFlag").item(0).getTextContent().contentEquals("true"));
				testSetResults.setPath(eElement.getElementsByTagName("path").item(0).getTextContent());
				//testSetResults.setIdSeq(eElement.getElementsByTagName("id_seq").item(0).getTextContent());
				//testSetResults.setIdItestResult(eElement.getElementsByTagName("id_i_test_result").item(0).getTextContent());
				testSetResults.setContextId(eElement.getElementsByTagName("contextId").item(0).getTextContent());
				testSetResults.setConvFlag(eElement.getElementsByTagName("convFlag").item(0).getTextContent().contentEquals("true"));
				testSetResults.setIgnoreErros(eElement.getElementsByTagName("ignoreErrors").item(0).getTextContent().contentEquals("true"));
				testSetResults.setIsMutant(eElement.getAttribute("isMutant").contentEquals("true"));
				testSetResults.setInitialState(eElement.getAttribute("initialState"));
				testSetResults.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
				
				testSetResults.setListImplementation(implementationService.parserXml(eElement.getElementsByTagName("implementation")));
				testSetResults.setListMap(mapService.parserXml(eElement.getElementsByTagName("map")));
				
				listTestSetResults.add(testSetResults);
			}
		}
		
		return listTestSetResults;
	}
	
	public void save(ITestResultBean iTestResultBean){
		for (IMutants item : iTestResultBean.getListIMutants()) {
			Integer mutantIdSeq = iMutantsDAO.save(item, iTestResultBean.getId());
			item.setIdSeq(mutantIdSeq);
		    
			implementationService.save(item, iTestResultBean.getId());
			mapService.save(item, iTestResultBean.getId());
		}
	}

}
