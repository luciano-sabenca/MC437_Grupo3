package mc437.bean;

public class Results {
	private String operador_mutante;
	private String mutante;
	private Integer dead;
	private String conjunto;
	private String caso;
	private String vivo;

	public Results() {

	}

	public Results(String operador_mutante, String mutante, Integer dead, String conjunto, String caso) {
		this.conjunto = conjunto;
		this.caso = caso;
		this.operador_mutante = operador_mutante;
		this.mutante = mutante;		
		this.dead = dead;
	}	

	public String getOperador_Mutante() {
		return operador_mutante;
	}

	public void setOperador_Mutante(String operador_mutante) {
		this.operador_mutante = operador_mutante;
	}
	
	public String getMutante() {
		return mutante;
	}

	public void setMutante(String mutante) {
		this.mutante = mutante;
	}

	public Integer getDead() {
		return dead;
	}

	public void setDead(Integer dead) {
		this.dead = dead;
	}
	
	public String getConjunto() {
		return conjunto;
	}

	public void setConjunto(String conjunto) {
		this.conjunto = conjunto;
	}
	
	public String getCaso() {
		return caso;
	}

	public void setCaso(String caso) {
		this.caso = caso;
	}
	
	public String getVivo() {
		return vivo;
	}

	public void setVivo(String vivo) {
		this.vivo = vivo;
	}	
}
