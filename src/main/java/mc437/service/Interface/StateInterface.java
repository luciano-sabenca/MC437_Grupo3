package mc437.service.Interface;

import java.util.List;

import org.w3c.dom.NodeList;

import mc437.bean.Map;
import mc437.bean.State;

public interface StateInterface {

	public List<State> parserXml(NodeList nList);
	
	public void save(Map iMutantsBean, Integer idMutants, Integer idITestResult);
}
