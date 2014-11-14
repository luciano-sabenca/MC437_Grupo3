package mc437.bean;

import java.io.Serializable;

public class TestcaseExecutingOutput implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String mutantKey;
	private Boolean dead;
	private Integer deathIndex;
	private Boolean evalFailed;
	private Integer idTestCaseRest;
	private Integer codSetResultsCaseResults;
	private Integer idItrTestSetResultsCaseResults;

	public String getMutantKey() {
		return mutantKey;
	}

	public void setMutantKey(String mutantKey) {
		this.mutantKey = mutantKey;
	}

	public Boolean getDead() {
		return dead;
	}

	public void setDead(Boolean dead) {
		this.dead = dead;
	}

	public Integer getDeathIndex() {
		return deathIndex;
	}

	public void setDeathIndex(Integer deathIndex) {
		this.deathIndex = deathIndex;
	}

	public Boolean getEvalFailed() {
		return evalFailed;
	}

	public void setEvalFailed(Boolean evalFailed) {
		this.evalFailed = evalFailed;
	}

	public Integer getIdTestCaseRest() {
		return idTestCaseRest;
	}

	public void setIdTestCaseRest(Integer idTestCaseRest) {
		this.idTestCaseRest = idTestCaseRest;
	}

	public Integer getCodSetResultsCaseResults() {
		return codSetResultsCaseResults;
	}

	public void setCodSetResultsCaseResults(Integer codSetResultsCaseResults) {
		this.codSetResultsCaseResults = codSetResultsCaseResults;
	}

	public Integer getIdItrTestSetResultsCaseResults() {
		return idItrTestSetResultsCaseResults;
	}

	public void setIdItrTestSetResultsCaseResults(
			Integer idItrTestSetResultsCaseResults) {
		this.idItrTestSetResultsCaseResults = idItrTestSetResultsCaseResults;
	}

	@Override
	public String toString() {
		return "TestcaseExecutingOutput ["
				+ (mutantKey != null ? "mutantKey=" + mutantKey + ", " : "")
				+ (dead != null ? "dead=" + dead + ", " : "")
				+ (deathIndex != null ? "deathIndex=" + deathIndex + ", " : "")
				+ (evalFailed != null ? "evalFailed=" + evalFailed + ", " : "")
				+ (idTestCaseRest != null ? "idTestCaseRest=" + idTestCaseRest
						+ ", " : "")
				+ (codSetResultsCaseResults != null ? "codSetResultsCaseResults="
						+ codSetResultsCaseResults + ", "
						: "")
				+ (idItrTestSetResultsCaseResults != null ? "idItrTestSetResultsCaseResults="
						+ idItrTestSetResultsCaseResults
						: "") + "]";
	}

}
