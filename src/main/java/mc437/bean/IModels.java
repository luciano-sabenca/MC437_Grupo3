package mc437.bean;

import java.io.Serializable;

public class IModels implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String initialState;
	private Integer id;
	private Integer idSeq;
	private Boolean isMutante;
	private Boolean buildFlag;
	private String contextId;
	private Boolean convFlag;
	private Boolean ignoreErrors;
	private String name;
	private String path;
	private Integer idITestResult;

	public String getInitialState() {
		return initialState;
	}

	public void setInitialState(String initialState) {
		this.initialState = initialState;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdSeq() {
		return idSeq;
	}

	public void setIdSeq(Integer idSeq) {
		this.idSeq = idSeq;
	}

	public Boolean getIsMutante() {
		return isMutante;
	}

	public void setIsMutante(Boolean isMutante) {
		this.isMutante = isMutante;
	}

	public Boolean getBuildFlag() {
		return buildFlag;
	}

	public void setBuildFlag(Boolean buildFlag) {
		this.buildFlag = buildFlag;
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

	public Boolean getIgnoreErrors() {
		return ignoreErrors;
	}

	public void setIgnoreErrors(Boolean ignoreErrors) {
		this.ignoreErrors = ignoreErrors;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getIdITestResult() {
		return idITestResult;
	}

	public void setIdITestResult(Integer idITestResult) {
		this.idITestResult = idITestResult;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "IModels ["
				+ (initialState != null ? "initialState=" + initialState + ", "
						: "")
				+ (id != null ? "id=" + id + ", " : "")
				+ (idSeq != null ? "idSeq=" + idSeq + ", " : "")
				+ (isMutante != null ? "isMutante=" + isMutante + ", " : "")
				+ (buildFlag != null ? "buildFlag=" + buildFlag + ", " : "")
				+ (contextId != null ? "contextId=" + contextId + ", " : "")
				+ (convFlag != null ? "convFlag=" + convFlag + ", " : "")
				+ (ignoreErrors != null ? "ignoreErrors=" + ignoreErrors + ", "
						: "")
				+ (name != null ? "name=" + name + ", " : "")
				+ (path != null ? "path=" + path + ", " : "")
				+ (idITestResult != null ? "idITestResult=" + idITestResult
						: "") + "]";
	}

}
