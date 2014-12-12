package mc437.service;

import java.util.ArrayList;
import java.util.List;

import mc437.bean.Guard;
import mc437.bean.Transition;
import mc437.dao.GuardDAO;
import mc437.dao.TransitionDAO;
import mc437.service.Interface.GuardInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;


@Service
public class GuardService implements GuardInterface{

	
	@Autowired
	TransitionDAO transitionDAO;
	@Autowired
	GuardDAO guardDAO;
	
	//@Autowired
	//GuardService guardService;
	
	public List<Guard> parserXml(NodeList nList) {
		List<Guard> listTestSetResults = new ArrayList<Guard>();
			
		for(int i = 0; i < nList.getLength(); i++){
			Guard testSetResults = new Guard();
			Node nNode = nList.item(i);
			
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				testSetResults.setId(eElement.getAttribute("id"));
				testSetResults.setIsMutant(eElement.getAttribute("isMutant").contentEquals("true"));
				
				testSetResults.setCloneGlobalIndexTransitionIndex(eElement.getElementsByTagName("cloneGlobalIndexAsTransitionIndex").item(0).getTextContent().contentEquals("true"));
				testSetResults.setGuardCondition(eElement.getElementsByTagName("condition").item(0).getTextContent());
				testSetResults.setGlobalIndex(eElement.getElementsByTagName("globalIndex").item(0).getTextContent());
				testSetResults.setPopArgs(eElement.getElementsByTagName("popArgs").item(0).getTextContent());
				testSetResults.setPushState(eElement.getElementsByTagName("pushState").item(0).getTextContent());
				testSetResults.setTargetState(eElement.getElementsByTagName("targetState").item(0).getTextContent());
				testSetResults.setTransitionType(eElement.getElementsByTagName("transitionType").item(0).getTextContent());
				testSetResults.settIndex(eElement.getElementsByTagName("tIndex").item(0).getTextContent());
				
				listTestSetResults.add(testSetResults);
			}
		}
		
		return listTestSetResults;
	}
	
	public void save(Transition transBean, Integer idState, Integer idMap, Integer idMutants, Integer idITestResult){
		for (Guard item : transBean.getListGuard()) {
			Integer idTransition = guardDAO.save(item, transBean.getIdSeq(), idState, idMap, idMutants, idITestResult);
			item.setIdSeq(idTransition);
		}
	}

}
