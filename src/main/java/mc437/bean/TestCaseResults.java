package mc437.bean;

import java.util.List;

public class TestCaseResults {
	private String testCaseKey;
	private String path;
	private int idTestSetResults;
	private int idITestResults;
	private int idSeq;
	private List<TestCaseExecutingOutputMutantlist> listtestCaseExecutingOutputMutantlists;
	
	public int getIdSeq() {
		return idSeq;
	}
	public void setIdSeq(int idSeq) {
		this.idSeq = idSeq;
	}
	public String getTestCaseKey() {
		return testCaseKey;
	}
	public void setTestCaseKey(String testCaseKey) {
		this.testCaseKey = testCaseKey;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getIdTestSetResults() {
		return idTestSetResults;
	}
	public void setIdTestSetResults(int idTestSetResults) {
		this.idTestSetResults = idTestSetResults;
	}
	public int getIdITestResults() {
		return idITestResults;
	}
	public void setIdITestResults(int idITestResults) {
		this.idITestResults = idITestResults;
	}
	public List<TestCaseExecutingOutputMutantlist> getListtestCaseExecutingOutputMutantlists() {
		return listtestCaseExecutingOutputMutantlists;
	}
	public void setListtestCaseExecutingOutputMutantlists(
			List<TestCaseExecutingOutputMutantlist> listtestCaseExecutingOutputMutantlists) {
		this.listtestCaseExecutingOutputMutantlists = listtestCaseExecutingOutputMutantlists;
	}
	
	
}
