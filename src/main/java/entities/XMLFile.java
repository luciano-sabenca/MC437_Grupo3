package entities;

import java.sql.Date;

public class XMLFile {
	private String nome;
	private Integer tamanho;
	private Date dataEnvio;
	
	public XMLFile (String nome, Integer tamanho, Date dataEnvio){
		this.nome = nome;
		this.tamanho = tamanho;
		this.dataEnvio = dataEnvio;
	}
	
	public String getNome(){
		return nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public Integer getTamanho(){
		return tamanho;
	}
	
	public void setTamanho(Integer tamanho){
		this.tamanho = tamanho;
	}
	
	public Date getDataEnvio(){
		return dataEnvio;
	}
	
	public void setDataEnvio(Date dataEnvio){
		this.dataEnvio = dataEnvio;
	}

}
