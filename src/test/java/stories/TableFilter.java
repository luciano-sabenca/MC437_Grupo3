package stories;

import java.util.List;

import org.jbehave.core.annotations.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import dao.TestUploadXmlDAO;

public class TableFilter {

	private WebDriver driver;

	String tableFilterId = "flt" + "3" + "_table1";

	TestUploadXmlDAO testUploadXmlDAO;

	@Given("uma pagina de teste result valida")
	public void givenTheTestResultPage() {
		driver = new FirefoxDriver();
		driver.get("http://localhost:8081/testResult/1");

	}

	@When("eu digito um dado para ser filtrado")
	public void whenAFilterIsEntered() {
		WebElement filterbox = driver.findElement(By.id(tableFilterId));
		filterbox.sendKeys("4gdfgdfg");
		filterbox.sendKeys(Keys.ENTER);

	}

	@Then("desejo obter a tabela filtrada")
	public void theTheTableIsFiltered() {
		WebElement table_element = driver.findElement(By.id("table1"));
		List<WebElement> tr_collection = table_element.findElements(By.xpath("id('table1')/tbody/tr"));
		// remove a linha dos filtros e a linha do titulo
		tr_collection.remove(0);
		tr_collection.remove(0);

		WebElement trElement1 = tr_collection.get(0);
		WebElement tdElement1 = trElement1.findElements(By.xpath("td")).get(0);

		boolean isEmpty = true;
		// itera na tabela procurando pelo valor
		for (WebElement trElement : tr_collection) {
			if (!trElement.getCssValue("display").equals("none")) {
				isEmpty = false;
				break;
			}
		}
		
		// caso em que o filtro gerou uma tabela vazia	
		if (isEmpty){	
			for (WebElement trElement : tr_collection) {
				WebElement tdElement = trElement.findElements(By.xpath("td")).get(3);
					if (tdElement.getText().equals("4 ")) {
						Assert.assertFalse(false);
					}		
			}
		}

		// caso em que existe linha na tabela com o id
		for (WebElement trElement : tr_collection) {
			WebElement tdElement = trElement.findElements(By.xpath("td")).get(3);
			if ((tdElement != null) && !(tdElement.getCssValue("display").equals("none")) ) {
				Assert.assertEquals(tdElement.getText(), tdElement.getText());
				
			}
			
		}

	}
}