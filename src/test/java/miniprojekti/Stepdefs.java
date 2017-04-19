package miniprojekti;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.constraints.AssertFalse;
import miniprojekti.repositories.ReferenceRepository;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author hanranti
 */
@Ignore
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Miniprojekti.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class Stepdefs {

    String referencesPath = "http://localhost:8080/references";
    String getbibtexPath = "http://localhost:8080/getbibtex";
    String downloadedFile;

    @After
    public void shutdown_server() {
        DriverFactory.getInstance().removeDriver();

    }

    @Given("references is visited$")
    public void references_is_visited() throws Throwable {
        DriverFactory.getInstance().getDriver().get(referencesPath);
    }

    @Given("^getbibtex is visited$")
    public void getbibtex_is_visited() throws Throwable {
        DriverFactory.getInstance().getDriver().get(getbibtexPath);
    }

    @Given("^book is added$")
    public void book_is_added() throws Throwable {
        type_is_selected("book");
        form_is_submitted();
        form_is_filled_with_value("referenceName", "name");
        form_is_filled_with_value("authorName", "author");
        form_is_filled_with_value("titleOfTheBook", "title");
        form_is_filled_with_value("1994", "year");
        form_is_filled_with_value("publisherName", "publisher");
        form_is_submitted();
    }

    @When("^type: \"([^\"]*)\" is selected$")
    public void type_is_selected(String type) throws Throwable {
        WebElement selectElement = DriverFactory.getInstance().getDriver().findElement(By.name("type"));
        Select select = new Select(selectElement);
        select.selectByVisibleText(type);
    }

    @When("^form is filled with value: \"([^\"]*)\" for \"([^\"]*)\"$")
    public void form_is_filled_with_value(String value, String field) throws Throwable {
        WebElement fieldElement = DriverFactory.getInstance().getDriver().findElement(By.id(field));
        fieldElement.sendKeys(value);
    }

    @When("^form is submitted$")
    public void form_is_submitted() throws Throwable {
        WebElement submit = DriverFactory.getInstance().getDriver().findElement(By.id("submit"));
        submit.submit();
    }

    @When("^getbibtex file is downloaded$")
    public void getbibtex_file_is_downloaded() throws Throwable {
        URL url = new URL(getbibtexPath);
        downloadedFile = new Scanner(url.openStream()).useDelimiter("\\A").next();
    }

    @Then("^page displays create a new reference$")
    public void page_displays_create_a_new_reference() throws Throwable {
        assertTrue(DriverFactory.getInstance().getDriver().getPageSource().contains("Create a new reference"));
    }

    @Then("^page displays content: \"([^\"]*)\"$")
    public void page_displays_content(String content) throws Throwable {
        assertTrue(DriverFactory.getInstance().getDriver().getPageSource().contains(content));
    }
    
    @Then("^page does not display content: \"([^\"]*)\"$")
    public void page_does_not_display_content(String content) throws Throwable {
        assertFalse(DriverFactory.getInstance().getDriver().getPageSource().contains(content));
    }

    @Then("^file contains content: \"([^\"]*)\"$")
    public void file_contains_content(String content) throws Throwable {
        assertTrue(downloadedFile.contains(content));
    }

    @Then("^page displays add a book reference content$")
    public void page_displays_add_a_book_reference_content() throws Throwable {
        assertTrue(DriverFactory.getInstance().getDriver().getPageSource().contains("author"));
        assertTrue(DriverFactory.getInstance().getDriver().getPageSource().contains("title"));
        assertTrue(DriverFactory.getInstance().getDriver().getPageSource().contains("year"));
        assertTrue(DriverFactory.getInstance().getDriver().getPageSource().contains("publisher"));
    }

}
