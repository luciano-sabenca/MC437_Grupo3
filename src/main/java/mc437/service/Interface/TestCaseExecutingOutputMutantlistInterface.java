package mc437.service.Interface;

import java.util.List;
import mc437.bean.TestCaseExecutingOutputMutantlist;
import org.w3c.dom.NodeList;

public interface TestCaseExecutingOutputMutantlistInterface {
	
public List<TestCaseExecutingOutputMutantlist> parserXml(NodeList listNodes);
	
	public void save(List<TestCaseExecutingOutputMutantlist> listTestCaseExecutingOutputMutantlists);
}
