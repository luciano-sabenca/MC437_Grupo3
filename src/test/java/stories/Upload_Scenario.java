package stories;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Upload_Scenario {

	WebDriver driver = new FirefoxDriver();

	@Then("o arquivo e processado e armazenado no banco de dados")
	public void thenOArquivoEProcessadoEArmazenadoNoBancoDeDados() {
		// TODO
		driver.get("http://localhost:8080");
		System.out.println("bla");
	}

	@Then("aparece a mensagem Upload realizado com sucesso")
	public void thenApareceAMensagemUploadRealizadoComSucesso() {
		// TODO
	}

	@Given("o caminho de um arquivo xml <caminho_xml>")
	public void givenOCaminhoDeUmArquivoXmlcaminho_xml() {
		// TODO
	}

	@Then("o arquivo passa a ser listado na lista de arquivos")
	public void thenOArquivoPassaASerListadoNaListaDeArquivos() {
		// TODO
	}

	@When("ha memoria disponivel no banco de dados")
	public void whenHaMemoriaDisponivelNoBancoDeDados() {
		// TODO
	}

	@When("o usuario clica no botao de upload")
	public void whenOUsuarioClicaNoBotaoDeUpload() {
		// TODO
	}

	@When("o xml e valido")
	public void whenOXmlEValido() {
		// TODO
	}
}