package mc437.service;

import java.util.List;

import org.w3c.dom.Document;

import mc437.bean.TestSetResults;
import mc437.bean.XMLFile;

public interface TestSetResultsInterface {

	public List<TestSetResults> parserXml(Document doc, int idItestResult);
	
	public void save(List<TestSetResults> listTestSetResults);
}
