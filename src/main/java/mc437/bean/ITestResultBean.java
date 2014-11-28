package mc437.bean;

import java.util.Date;
import java.util.List;
import java.io.File;

public class ITestResultBean {
	private Integer id;
	private String nome;
	private Long tamanho;
	private Date dataEnvio;
	private File xmlFile;
	private List<TestSetResults> listTestSetResults;

	public List<TestSetResults> getListTestSetResults() {
		return listTestSetResults;
	}

	public void setListTestSetResults(List<TestSetResults> listTestSetResults) {
		this.listTestSetResults = listTestSetResults;
	}

	public ITestResultBean() {

	}

	public ITestResultBean(String nome, Long tamanho, Date dataEnvio, File xmlFile) {
		this.nome = nome;
		this.tamanho = tamanho;
		this.dataEnvio = dataEnvio;
		this.xmlFile = xmlFile;
	}
	
	public ITestResultBean(String nome, Long tamanho, Date dataEnvio) {
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public File getXmlFile() {
		return this.xmlFile;
	}
	
	public void setXmlFile(File xmlFile) {
		this.xmlFile = xmlFile;
	}

}
