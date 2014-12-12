package mc437.bean;

import java.util.List;

public class IMutants {

	private Integer idSeq;
	private int idItestResult;
	private String id;
	private Boolean buildFlag;
	private String contextId;
	private Boolean convFlag;
	private Boolean ignoreErros;
	private Boolean isMutant;
	private String initialState;
	private String name;
	private String path;
	private List<Implementation> listImplementation;
	private List<Map> listMap;
	

	public Boolean getBuildFlag() {
		return buildFlag;
	}
	public void setBuildFlag(Boolean buildFlag){
		this.buildFlag = buildFlag;
	}
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
	public String getContextId() {
		return contextId;
	}
	public void setContextId(String contextId) {
		this.contextId = contextId;
	}
	public Boolean getConvFlag() {
		return convFlag;
	}
	public void setConvFlag(Boolean convFlag) {
		this.convFlag = convFlag;
	}
	public Boolean getIgnoreErros() {
		return ignoreErros;
	}
	public void setIgnoreErros(Boolean ignoreErros) {
		this.ignoreErros = ignoreErros;
	}
	public Boolean getIsMutant() {
		return isMutant;
	}
	public void setIsMutant(Boolean isMutant) {
		this.isMutant = isMutant;
	}
	public String getInitialState() {
		return initialState;
	}
	public void setInitialState(String initialState) {
		this.initialState = initialState;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Implementation> getListImplementation() {
		return listImplementation;
	}
	public void setListImplementation(List<Implementation> listImplementation) {
		this.listImplementation = listImplementation;
	}
	public List<Map> getListMap() {
		return listMap;
	}
	public void setListMap(List<Map> listMap) {
		this.listMap = listMap;
	}
	
	
	
}
