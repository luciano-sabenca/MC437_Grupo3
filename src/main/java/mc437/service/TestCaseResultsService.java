package mc437.service;

import java.util.ArrayList;
import java.util.List;

import mc437.bean.TestCaseResults;
import mc437.dao.TestCaseResultsDAO;
import mc437.service.Interface.TestCaseResultsInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Service
public class TestCaseResultsService implements TestCaseResultsInterface {

	@Autowired
	TestCaseExecutingOutputMutantlistService testCaseExecutingOutputMutantlist;

	@Autowired
	TestCaseResultsDAO testCaseResultsDAO;

	public List<TestCaseResults> parserXml(NodeList listNodes) {
		List<TestCaseResults> listTestCaseResults = new ArrayList<TestCaseResults>();

		for (int i = 0; i < listNodes.getLength(); i++) {

			if (listNodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
				TestCaseResults testCaseResults = new TestCaseResults();
				Element eElement = (Element) listNodes.item(i);
				testCaseResults.setPath(eElement.getElementsByTagName("path")
						.item(0).getTextContent());
				testCaseResults.setTestCaseKey(eElement
						.getElementsByTagName("_testCaseKey").item(0)
						.getTextContent());
				testCaseResults
						.setListtestCaseExecutingOutputMutantlists(testCaseExecutingOutputMutantlist.parserXml(eElement
								.getElementsByTagName("testCaseExecutingOutput_MutantList")));
				listTestCaseResults.add(testCaseResults);
			}
		}

		return listTestCaseResults;
	}

	@Override
	public void save(final List<TestCaseResults> listTestCaseResults,
			final Integer idITestResults, final Integer idTestSetResults) {
		for (final TestCaseResults item : listTestCaseResults) {

			item.setIdITestResults(idITestResults);
			item.setIdTestSetResults(idTestSetResults);
			item.setIdSeq(testCaseResultsDAO.save(item));

			testCaseExecutingOutputMutantlist.save(
					item.getListtestCaseExecutingOutputMutantlists(),
					idITestResults, idTestSetResults, item.getIdSeq());

		}
	}
}
