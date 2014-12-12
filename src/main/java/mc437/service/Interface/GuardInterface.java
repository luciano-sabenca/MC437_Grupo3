package mc437.service.Interface;

import java.util.List;

import org.w3c.dom.NodeList;

import mc437.bean.Guard;
import mc437.bean.Transition;

public interface GuardInterface {

	public List<Guard> parserXml(NodeList nList);
	
	public void save(Transition transBean, Integer idState, Integer idMap, Integer idMutants, Integer idITestResult);
}
