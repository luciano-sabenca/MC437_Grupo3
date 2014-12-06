package mc437.service;

import java.util.ArrayList;
import java.util.List;

import mc437.bean.IMutants;
import mc437.bean.Implementation;
import mc437.dao.ImplementationDAO;
import mc437.service.Interface.ImplementationInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;


@Service
public class ImplementationService implements ImplementationInterface{

	
	@Autowired
	ImplementationDAO implementationDAO;
	
	public List<Implementation> parserXml(NodeList nList) {
		List<Implementation> listTestSetResults = new ArrayList<Implementation>();
			
		for(int i = 0; i < nList.getLength(); i++){
			Implementation testSetResults = new Implementation();
			Node nNode = nList.item(i);
			
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				testSetResults.setId(eElement.getAttribute("id"));
				testSetResults.setType(eElement.getAttribute("type"));
				testSetResults.setIsMutant(eElement.getAttribute("isMutant").contentEquals("true"));
				testSetResults.setContent(eElement.getElementsByTagName("content").item(0).getTextContent());
				
				//testSetResults.setIdSeq(eElement.getElementsByTagName("id_seq").item(0).getTextContent());
				//testSetResults.setIdItestResult(eElement.getElementsByTagName("id_i_test_result").item(0).getTextContent());
				//....idIMutant
				
				listTestSetResults.add(testSetResults);
			}
		}
		
		return listTestSetResults;
	}
	
	public void save(IMutants iMutantsBean, Integer idITestResult){
		for (Implementation item : iMutantsBean.getListImplementation()) {
			item.setIdSeq(implementationDAO.save(item, iMutantsBean.getIdSeq(), idITestResult));
		}
	}

}
