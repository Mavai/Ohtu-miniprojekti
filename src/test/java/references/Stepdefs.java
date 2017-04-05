package references;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 *
 * @author hanranti
 */
public class Stepdefs {
    
    WebDriver driver = new ChromeDriver();
    String baseUrl = "http://localhost:8080/";
    
    @Given("^index is selected$")
    public void index_is_selected() throws Throwable {
        driver.get(baseUrl);
    }
    
    @Then("^page displays create a new reference$")
    public void page_displays_create_a_new_reference() throws Throwable {
        assertTrue(driver.getPageSource().contains("Create a new reference"));
    }
}
