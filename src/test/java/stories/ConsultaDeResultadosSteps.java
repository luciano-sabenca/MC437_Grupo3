package stories;

import java.util.List;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ConsultaDeResultadosSteps {

	private WebDriver webDriver;

	@Given("a lista de arquivos enviados pelo usuario.")
	public void givenAListaDeArquivosEnviadosPeloUsuario() {
		webDriver = new FirefoxDriver();
		webDriver.get("http://localhost:8080");
	}

	@When("o usuario clica para exibir o resultado.")
	public void whenOUsuarioSelecionaUmArquivoDessaLista() {
		List<WebElement> elements = webDriver.findElements(new By.ByName(
				"testResult"));
		Assert.assertTrue(elements.size() > 0);
		WebElement element = elements.get(0);
		element.click();
	}

	@Then("a página com os resultados é exibida.")
	public void thenAPáginaComOsResultadosÉExibida() {
		Assert.assertEquals("http://localhost:8080/testResults/1",
				webDriver.getCurrentUrl());
		
	}
}