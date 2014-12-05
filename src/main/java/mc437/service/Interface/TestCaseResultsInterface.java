package mc437.service.Interface;

import java.util.List;

import mc437.bean.TestCaseResults;

import org.w3c.dom.NodeList;

public interface TestCaseResultsInterface {
	
	public List<TestCaseResults> parserXml(NodeList nNode);
	
	public void save(List<TestCaseResults> listTestCaseResults, Integer idITestResults, Integer idTestSetResults);

}
