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
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author hanranti
 */
public class Stepdefs {

    WebDriver driver = new ChromeDriver();
    String referencesPath = "http://localhost:8080/references";

    @Given("^index is visited$")
    public void index_is_visited() throws Throwable {
        driver.get(referencesPath);
    }

    @When("^type: \"([^\"]*)\" is selected$")
    public void type_is_selected(String type) throws Throwable {
        WebElement selectElement = driver.findElement(By.name("type"));
        Select select = new Select(selectElement);
        select.selectByVisibleText(type);
    }

    @When("^form is filled with value: \"([^\"]*)\" for \"([^\"]*)\"$")
    public void form_is_filled_with_value(String value, String field) throws Throwable {
        WebElement fieldElement = driver.findElement(By.id(field));
        fieldElement.sendKeys(value);
    }

    @When("^form is submitted$")
    public void form_is_submitted() {
        WebElement submit = driver.findElement(By.id("submit"));
        submit.submit();
    }

//    @Then("^page displays create a new reference$")
//    public void page_displays_create_a_new_reference() throws Throwable {
//        assertTrue(driver.getPageSource().contains("Create a new reference"));
//    }

    @Then("^page displays content: \"([^\"]*)\"$")
    public void page_displays_content(String content) throws Throwable {
        assertTrue(driver.getPageSource().contains(content));
    }

//    @Then("^page displays add a book reference content$")
//    public void page_displays_add_a_book_reference_content() throws Throwable {
//        assertTrue(driver.getPageSource().contains("author"));
//        assertTrue(driver.getPageSource().contains("title"));
//        assertTrue(driver.getPageSource().contains("year"));
//        assertTrue(driver.getPageSource().contains("publisher"));
//    }
}
