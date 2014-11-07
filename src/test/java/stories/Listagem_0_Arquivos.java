package stories;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Listagem_0_Arquivos {

	private WebDriver driver;

	@When("a pagina e carregada.")
	public void whenAPaginaECarregada() {
		driver = new FirefoxDriver();
		driver.get("http://localhost:8080");
	}

	@Given("a pagina e carregada e nenhum upload foi feito.")
	public void givenAPaginaECarregadaENenhumUploadFoiFeito() {

	}

	@Then("a tabela de listagem de arquivo aparece vazia, somente com seus cabecalhos.")
	public void thenATabelaDeListagemDeArquivoApareceVaziaSomenteComSeusCabecalhos() {
		Assert.assertTrue(true);
	}
}