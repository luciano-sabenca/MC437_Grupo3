package mc437.bean;

import java.util.List;

public class State {

	private Integer idSeq;
	private Integer idITestResult;
	private Integer idIMutant;
	private Integer idMap;
	private String id;
	private Boolean isMutant;
	private String name;
	private List<Transition> listTransition;
	
	public Integer getIdSeq() {
		return idSeq;
	}
	public void setIdSeq(Integer idSeq) {
		this.idSeq = idSeq;
	}
	public Integer getIdITestResult() {
		return idITestResult;
	}
	public void setIdITestResult(Integer idITestResult) {
		this.idITestResult = idITestResult;
	}
	public Integer getIdIMutant() {
		return idIMutant;
	}
	public void setIdIMutant(Integer idIMutant) {
		this.idIMutant = idIMutant;
	}
	public Integer getIdMap() {
		return idMap;
	}
	public void setIdMap(Integer idMap) {
		this.idMap = idMap;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Boolean getIsMutant() {
		return isMutant;
	}
	public void setIsMutant(Boolean isMutant) {
		this.isMutant = isMutant;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Transition> getListTransition() {
		return listTransition;
	}
	public void setListTransition(List<Transition> listTransition) {
		this.listTransition = listTransition;
	}
	
}
