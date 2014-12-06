package stories;

import org.jbehave.core.annotations.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import dao.TestUploadXmlDAO;
public class UploadXml{
	
	private WebDriver driver;
	private String fileName = "resultados_9.xml";
	private int maxIdTestResult;
	
	TestUploadXmlDAO testUploadXmlDAO;
	
	@Given("the chosen XML file")
	public void givenTheChosenXMLFile(){
		driver = new FirefoxDriver();
		driver.get("http://localhost:8081");
		
		WebElement element = driver.findElement(By.id("btnUpload"));
		element.sendKeys("/home/cc2012/ra138466/Downloads/" + fileName);
	}
	
	@When("a click on the sumit bottom")
	public void whenAClickOnTheSumitBottom(){
		testUploadXmlDAO = new TestUploadXmlDAO();
		maxIdTestResult = testUploadXmlDAO.getMaxIdTestResult();
		
		driver.findElement(By.id("btnSubmit")).click();
	}
	
	@Then("the file is parsed in the data base")
	public void thenTheFileIsParsedInTheDataBase(){
		Assert.assertTrue(testUploadXmlDAO.checkFileParsed(maxIdTestResult + 1));
		Assert.assertTrue(testUploadXmlDAO.checkFileParsedTestSetResults(maxIdTestResult + 1));
		Assert.assertTrue(testUploadXmlDAO.checkFileParsedTestCaseResults(maxIdTestResult + 1));
		Assert.assertTrue(testUploadXmlDAO.checkFileParsedTestCaseExecutingOutputMutantList(maxIdTestResult + 1));
	}
}