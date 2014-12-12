package mc437.service.Interface;

import java.util.List;

import org.w3c.dom.NodeList;

import mc437.bean.State;
import mc437.bean.Transition;

public interface TransitionInterface {

	public List<Transition> parserXml(NodeList nList);
	
	public void save(State stateBean, Integer idMap, Integer idMutants, Integer idITestResult);
}
