package mc437.bean;

import java.util.List;

public class TestSetResults {

	private String id;
	private Integer idSeq;
	private String cod;
	private String path;
	private int idItestResult;
	private List<TestCaseResults> listTestCaseResults;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getIdSeq() {
		return idSeq;
	}
	public void setIdSeq(Integer idSeq) {
		this.idSeq = idSeq;
	}
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getIdItestResult() {
		return idItestResult;
	}
	public void setIdItestResult(int idItestResult) {
		this.idItestResult = idItestResult;
	}
	public List<TestCaseResults> getListTestCaseResults() {
		return listTestCaseResults;
	}
	public void setListTestCaseResults(List<TestCaseResults> listTestCaseResults) {
		this.listTestCaseResults = listTestCaseResults;
	}
	
	
	
}
