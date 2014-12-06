package mc437.service.Interface;

import java.util.List;

import org.w3c.dom.NodeList;

import mc437.bean.IMutants;
import mc437.bean.Map;

public interface MapInterface {

	public List<Map> parserXml(NodeList nList);
	
	public void save(IMutants iMutantsBean, Integer idITestResult);
}
