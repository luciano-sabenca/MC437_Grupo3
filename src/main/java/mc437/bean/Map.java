package mc437.bean;

import java.util.List;

public class Map {
	
	private Integer idSeq;
	private Integer idIMutant;
	private Integer idITestResult;
	private String id;
	private Boolean isMutant;
	private String name;
	private List<State> listState;
	
	public Integer getIdSeq() {
		return idSeq;
	}
	public void setIdSeq(Integer idSeq) {
		this.idSeq = idSeq;
	}
	public Integer getIdIMutant() {
		return idIMutant;
	}
	public void setIdIMutant(Integer idIMutant) {
		this.idIMutant = idIMutant;
	}
	public Integer getIdITestResult() {
		return idITestResult;
	}
	public void setIdITestResult(Integer idITestResult) {
		this.idITestResult = idITestResult;
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
	public List<State> getListState() {
		return listState;
	}
	public void setListState(List<State> listState) {
		this.listState = listState;
	}

}
