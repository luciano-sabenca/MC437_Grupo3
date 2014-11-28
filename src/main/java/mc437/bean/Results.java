package mc437.bean;

public class Results {
	private String operador_mutante;
	private String mutante;
	private Integer dead;

	public Results() {

	}

	public Results(String operador_mutante, String mutante, Integer dead) {
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
}
