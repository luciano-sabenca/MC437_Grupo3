package mc437.service;

import java.util.ArrayList;
import java.util.List;

import mc437.bean.IMutants;
import mc437.bean.Map;
import mc437.bean.State;
import mc437.dao.MapDAO;
import mc437.dao.StateDAO;
import mc437.service.Interface.MapInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;


@Service
public class MapService implements MapInterface{

	
	@Autowired
	MapDAO mapDAO;
	@Autowired
	StateDAO stateDAO;
	
	@Autowired
	StateService stateService;
	
	public List<Map> parserXml(NodeList nList) {
		List<Map> listTestSetResults = new ArrayList<Map>();
			
		for(int i = 0; i < nList.getLength(); i++){
			Map testSetResults = new Map();
			Node nNode = nList.item(i);
			
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				testSetResults.setId(eElement.getAttribute("id"));
				testSetResults.setIsMutant(eElement.getAttribute("isMutant").contentEquals("true"));
				testSetResults.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
				
				//testSetResults.setIdSeq(eElement.getElementsByTagName("id_seq").item(0).getTextContent());
				//testSetResults.setIdItestResult(eElement.getElementsByTagName("id_i_test_result").item(0).getTextContent());
				//....idIMutant
				
				testSetResults.setListState(stateService.parserXml(eElement.getElementsByTagName("state")));
				
				listTestSetResults.add(testSetResults);
			}
		}
		
		return listTestSetResults;
	}
	
	public void save(IMutants iMutantsBean, Integer idITestResult){
		for (Map item : iMutantsBean.getListMap()) {
			Integer idMap = mapDAO.save(item, iMutantsBean.getIdSeq(), idITestResult);
			item.setIdSeq(idMap);
			stateService.save(item, iMutantsBean.getIdSeq(), idITestResult);
		}
	}

}
