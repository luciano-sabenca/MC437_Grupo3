package mc437.service;

import java.util.ArrayList;
import java.util.List;

import mc437.bean.TestCaseExecutingOutputMutantlist;
import mc437.dao.TestCaseExecutingOutputMutantlistDAO;
import mc437.service.Interface.TestCaseExecutingOutputMutantlistInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Service
public class TestCaseExecutingOutputMutantlistService implements
		TestCaseExecutingOutputMutantlistInterface {

	@Autowired
	TestCaseExecutingOutputMutantlistDAO testCaseExecutingOutputMutantlistDAO;

	public List<TestCaseExecutingOutputMutantlist> parserXml(NodeList listNodes) {
		List<TestCaseExecutingOutputMutantlist> listTestCaseExecutingOutputMutantlists = new ArrayList<TestCaseExecutingOutputMutantlist>();

		for (int i = 0; i < listNodes.getLength(); i++) {

			if (listNodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
				TestCaseExecutingOutputMutantlist testCaseExecutingOutputMutantlist = new TestCaseExecutingOutputMutantlist();
				Element eElement = (Element) listNodes.item(i);

				testCaseExecutingOutputMutantlist.setMutantKey(eElement
						.getElementsByTagName("mutantKey").item(0)
						.getTextContent());
				testCaseExecutingOutputMutantlist.setDead(eElement
						.getElementsByTagName("dead").item(0).getTextContent()
						.equals("true"));
				testCaseExecutingOutputMutantlist.setDeathIndex(Integer
						.parseInt(eElement.getElementsByTagName("deathIndex")
								.item(0).getTextContent()));
				testCaseExecutingOutputMutantlist.setEvalFailed(eElement
						.getElementsByTagName("evalFailed").item(0)
						.getTextContent().equals("true"));

				listTestCaseExecutingOutputMutantlists
						.add(testCaseExecutingOutputMutantlist);
			}
		}

		return listTestCaseExecutingOutputMutantlists;
	}

	@Override
	public void save(
			final List<TestCaseExecutingOutputMutantlist> listTestCaseExecutingOutputMutantlists,
			final Integer idITestResults, final Integer idTestSetResults,
			final Integer idTestCaseResults) {
		for (final TestCaseExecutingOutputMutantlist item : listTestCaseExecutingOutputMutantlists) {

			item.setIdITestResults(idITestResults);
			item.setIdTestCaseResults(idTestCaseResults);
			item.setIdTestSetResults(idTestSetResults);
			item.setId_seq(testCaseExecutingOutputMutantlistDAO.save(item));

		}

	}
}
