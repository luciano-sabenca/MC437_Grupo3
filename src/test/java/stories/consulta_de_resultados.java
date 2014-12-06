package stories;

import org.jbehave.core.annotations.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;	
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class consulta_de_resultados{
	
	private WebDriver driver = new FirefoxDriver();

	private String url;	
	
	@Given("um testResult cadastrado valido <id>")
	public void givenUmTestResultCadastradoValidoid(String id){
		url = "http://localhost:8081/testResult/" + id; 
	}
	
	@When("eu entro na pagina que exibe informacoes do testResult    ")
	public void whenEuEntroNaPaginaQueExibeInformacoesDoTestResult(){
		driver.get(url);	
	}
	
	@Then("quero visualizar os dados acessados do result <id>")
	public void thenQueroVisualizarOsDadosAcessadosDoResultid(String id){
		Assert.assertEquals("Test Result " + id, driver.getTitle());
	}
	
	@Then("quero visualizar o conjunto de testes <conjunto>")
	public void thenQueroVisualizarOConjuntoDeTestesconjunto(String conjunto){
		WebElement element = driver.findElement(new By.ById("conjunto"));
		Assert.assertNotNull(element);
		Assert.assertNotNull(element.getText());
		String infoNaPagina = element.getText();
		Assert.assertEquals(conjunto, infoNaPagina);
	}
	
	@Then("quero visualizar o caso de testes <caso>")
	public void thenQueroVisualizarOCasoDeTestescaso(String caso){
		WebElement element = driver.findElement(new By.ById("caso"));
		Assert.assertNotNull(element);
		Assert.assertNotNull(element.getText());
		String infoNaPagina = element.getText();
		Assert.assertEquals(caso, infoNaPagina);
	}
	
	@Then("quero visualizar o operador de mutação <operador>")
	public void thenQueroVisualizarOOperadorDeMutaçãooperador(String operador){
		WebElement element = driver.findElement(new By.ById("operador"));
		Assert.assertNotNull(element);
		Assert.assertNotNull(element.getText());
		String infoNaPagina = element.getText();
		Assert.assertEquals(operador, infoNaPagina);
	}
	
	@Then("quero visualizar o mutante <mutante>")
	public void thenQueroVisualizarOMutantemutante(String mutante){
		WebElement element = driver.findElement(new By.ById("mutante"));
		Assert.assertNotNull(element);
		Assert.assertNotNull(element.getText());
		String infoNaPagina = element.getText();
		Assert.assertEquals(mutante, infoNaPagina);
	}
	@Then("quero visualizar Vivo? <vivo>")
	public void thenQueroVisualizarVivovivo(String vivo){
		WebElement element = driver.findElement(new By.ById("vivo"));
		Assert.assertNotNull(element);
		Assert.assertNotNull(element.getText());
		String infoNaPagina = element.getText();
		Assert.assertEquals(vivo, infoNaPagina);
	}
	
	@AfterStories
	public void tearDown() {
		driver.close();
	}
}