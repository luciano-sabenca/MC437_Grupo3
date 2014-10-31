package mc437.bean;

import java.util.Date;

public class XMLFile {
	private String nome;
	private Long tamanho;
	private Date dataEnvio;

	public XMLFile() {

	}

	public XMLFile(String nome, Long tamanho, Date dataEnvio) {
		this.nome = nome;
		this.tamanho = tamanho;
		this.dataEnvio = dataEnvio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getTamanho() {
		return tamanho;
	}

	public void setTamanho(Long tamanho) {
		this.tamanho = tamanho;
	}

	public Date getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(Date dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

}
