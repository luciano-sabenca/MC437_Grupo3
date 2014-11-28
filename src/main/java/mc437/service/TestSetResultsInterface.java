package mc437.service;

import java.util.List;

import org.w3c.dom.Document;

import mc437.bean.TestSetResults;
import mc437.bean.ITestResultBean;

public interface TestSetResultsInterface {

	public List<TestSetResults> parserXml(Document doc);
	
	public void save(ITestResultBean iTestResultBean);
}
