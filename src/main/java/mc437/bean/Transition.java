package mc437.bean;

import java.util.List;

public class Transition {

	private Integer idSeq;
	private Integer idITestResult;
	private Integer idIMutant;
	private Integer idMap;
	private Integer idState;
	private String id;
	private Boolean isMutant;
	private String event;
	private List<Guard> listGuard;
	
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
	public Integer getIdState() {
		return idState;
	}
	public void setIdState(Integer idState) {
		this.idState = idState;
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
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public List<Guard> getListGuard() {
		return listGuard;
	}
	public void setListGuard(List<Guard> listGuard) {
		this.listGuard = listGuard;
	}
	
}
