package mc437.service.Interface;

import java.util.List;

import org.w3c.dom.NodeList;

import mc437.bean.IMutants;
import mc437.bean.Implementation;

public interface ImplementationInterface {

	public List<Implementation> parserXml(NodeList nList);
	
	public void save(IMutants iMutantsBean, Integer idITestResult);
}
