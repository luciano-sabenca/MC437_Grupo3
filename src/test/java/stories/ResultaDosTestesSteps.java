package stories;

import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ResultaDosTestesSteps {

	private WebDriver driver = new FirefoxDriver();

	private String url;

	@Given("um test result valido $id")
	public void givenUmTestResultValido(String id) {
		url = "http://localhost:8081/testResult/" + id;
	}

	@When("eu acesso a pagina que exibe informacoes do test result")
	public void whenEuAcessoAPaginaQueExibeInformacoesDoTestResult() {
		driver.get(url);
	}

	@Then("desejo obter os dados do result $id")
	public void thenDesejoObterOsDadosDoResult(String id) {
		Assert.assertEquals("Test Result " + id, driver.getTitle());
	}

	@Then("desejo obter o score $score")
	public void thenObterOScore(Double score) {
		WebElement element = driver.findElement(new By.ById("score"));
		Assert.assertNotNull(element);
		Assert.assertNotNull(element.getText());
		Double scoreNaPagina = Double.parseDouble(element.getText());
		Assert.assertEquals(score, scoreNaPagina);

	}

	@Then("desejo obter a quantidade de mutantes mortos $qtdMutantes")
	public void thenObterAQuantidadeDeMutantesMortos(Long qtdMutantes) {
		WebElement element = driver.findElement(new By.ById("mutantesMortos"));
		Assert.assertNotNull(element);
		Assert.assertNotNull(element.getText());
		Long deadMutantes = Long.parseLong(element.getText());
		Assert.assertEquals(qtdMutantes, deadMutantes);
	}
	
	@Then("desejo carregar um grafico")
	public void thenDesejoCarregarUmGrafico () {
		WebElement element = driver.findElement(new By.ById("chart_div"));
		Assert.assertNotNull(element);
		Assert.assertNotNull(element.getText());
	}

	@Given("um test result nao existente $naoExistenteId")
	public void givenUmTestResultNaoExistente(String naoExistenteId) {
		url = "http://localhost:8080/testResult/" + naoExistenteId;
	}

	@When("desejo obter informacoes sobre esse test result")
	public void whenDesejoObterInformacoesSobreEsseTestResult() {

		driver.get(url);
	}

	@Then("uma pagina de erro eh renderizada")
	public void thenUmaPaginaDeErroEhRenderizada() {
		Assert.assertEquals("Não Encontrado", driver.getTitle());
		WebElement element = driver.findElement(new By.ById("mensagemDeErro"));

		Assert.assertTrue(element.getText().contains("Não Encontrado"));

	}

	@AfterStories
	public void tearDown() {
		driver.close();
	}

}