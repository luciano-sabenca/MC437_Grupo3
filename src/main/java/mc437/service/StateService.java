package mc437.service;

import java.util.ArrayList;
import java.util.List;

import mc437.bean.Map;
import mc437.bean.State;
import mc437.bean.Transition;
import mc437.dao.StateDAO;
import mc437.dao.TransitionDAO;
import mc437.service.Interface.StateInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;


@Service
public class StateService implements StateInterface{

	
	@Autowired
	StateDAO stateDAO;
	@Autowired
	TransitionDAO transitionDAO;
	
	@Autowired
	TransitionService transitionService;
	
	public List<State> parserXml(NodeList nList) {
		List<State> listTestSetResults = new ArrayList<State>();
			
		for(int i = 0; i < nList.getLength(); i++){
			State testSetResults = new State();
			Node nNode = nList.item(i);
			
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				testSetResults.setId(eElement.getAttribute("id"));
				testSetResults.setIsMutant(eElement.getAttribute("isMutant").contentEquals("true"));
				testSetResults.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
				
				//testSetResults.setIdSeq(eElement.getElementsByTagName("id_seq").item(0).getTextContent());
				//testSetResults.setIdItestResult(eElement.getElementsByTagName("id_i_test_result").item(0).getTextContent());
				//....idIMutant
				
				testSetResults.setListTransition(transitionService.parserXml(eElement.getElementsByTagName("transition")));
				
				listTestSetResults.add(testSetResults);
			}
		}
		
		return listTestSetResults;
	}
	
	public void save(Map mapBean, Integer idMutants, Integer idITestResult){
		for (State item : mapBean.getListState()) {
			item.setIdMap(mapBean.getIdSeq());
			item.setIdIMutant(idMutants);
			item.setIdITestResult(idITestResult);
			item.setIdSeq(stateDAO.save(item));
			transitionService.save(item, mapBean.getIdSeq(), idMutants, idITestResult);
		}
	}

}
