package mc437.service;

import java.util.ArrayList;
import java.util.List;

import mc437.bean.State;
import mc437.bean.Transition;
import mc437.dao.GuardDAO;
import mc437.dao.TransitionDAO;
import mc437.service.Interface.TransitionInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;


@Service
public class TransitionService implements TransitionInterface{

	
	@Autowired
	TransitionDAO transitionDAO;
	@Autowired
	GuardDAO guardDAO;
	
	@Autowired
	GuardService guardService;
	
	public List<Transition> parserXml(NodeList nList) {
		List<Transition> listTestSetResults = new ArrayList<Transition>();
			
		for(int i = 0; i < nList.getLength(); i++){
			Transition testSetResults = new Transition();
			Node nNode = nList.item(i);
			
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				testSetResults.setId(eElement.getAttribute("id"));
				testSetResults.setIsMutant(eElement.getAttribute("isMutant").contentEquals("true"));
				testSetResults.setEvent(eElement.getElementsByTagName("event").item(0).getTextContent());
				
				//testSetResults.setIdSeq(eElement.getElementsByTagName("id_seq").item(0).getTextContent());
				//testSetResults.setIdItestResult(eElement.getElementsByTagName("id_i_test_result").item(0).getTextContent());
				//....idIMutant
				
				testSetResults.setListGuard(guardService.parserXml(eElement.getElementsByTagName("guard")));
				
				listTestSetResults.add(testSetResults);
			}
		}
		
		return listTestSetResults;
	}
	
	public void save(State stateBean, Integer idMap, Integer idMutants, Integer idITestResult){
		for (Transition item : stateBean.getListTransition()) {
			Integer idTransition = transitionDAO.save(item, stateBean.getIdSeq(), idMap, idMutants, idITestResult);
			item.setIdSeq(idTransition);
			guardService.save(item, stateBean.getIdSeq(), idMap, idMutants, idITestResult);
		}
	}

}
