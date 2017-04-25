package miniprojekti;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.constraints.AssertFalse;
import miniprojekti.repositories.ReferenceRepository;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
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
        //DriverFactory.getInstance().removeDriver();

    }

    @Given("references is visited$")
    public void references_is_visited() throws Throwable {
        DriverFactory.getInstance().getDriver().get(referencesPath);
    }

    @Given("^getbibtex is visited$")
    public void getbibtex_is_visited() throws Throwable {
        DriverFactory.getInstance().getDriver().get(getbibtexPath);
    }

    @Given("^book is added with name: \"([^\"]*)\", author: \"([^\"]*)\", title: \"([^\"]*)\", year: \"([^\"]*)\" and publisher: \"([^\"]*)\"$")
    @When("^book with name: \"([^\"]*)\", author: \"([^\"]*)\", title: \"([^\"]*)\", year: \"([^\"]*)\" and publisher: \"([^\"]*)\" is added$")
    public void book_is_added(String name, String author, String title, String year, String publisher) throws Throwable {
        selectType("Book");
        submitButtonWithId("submit");
        fillInputWithValue(name, "name");
        fillInputWithValue(author, "author");
        fillInputWithValue(title, "title");
        fillInputWithValue(publisher, "publisher");
        fillInputWithValue(year, "year");
        submitButtonWithId("submit");
    }

    @When("^book with author: \"([^\"]*)\" is added$")
    public void book_is_added_with_author(String author) {
        selectType("Book");
        submitButtonWithId("submit");
        fillInputWithValue(author, "author");
        submitButtonWithId("submit");
    }

    @Given("^book with name \"([^\"]*)\" is edited with name: \"([^\"]*)\", author: \"([^\"]*)\", title: \"([^\"]*)\", year: \"([^\"]*)\" and publisher: \"([^\"]*)\"$")
    @When("^book named \"([^\"]*)\" is edited with name: \"([^\"]*)\", author: \"([^\"]*)\", title: \"([^\"]*)\", year: \"([^\"]*)\" and publisher: \"([^\"]*)\"$")
    public void book_is_edited(String oldName, String newName, String author, String title, String year, String publisher) {
        submitButtonWithId("edit" + oldName);
        fillInputWithValue(newName, "name");
        fillInputWithValue(author, "author");
        fillInputWithValue(title, "title");
        fillInputWithValue(year, "year");
        fillInputWithValue(publisher, "publisher");
        submitButtonWithId("submit");
    }

    @Given("^book with name: \"([^\"]*)\" is deleted$")
    @When("^book named \"([^\"]*)\" is deleted$")
    public void book_is_deleted(String name) {
        submitButtonWithId("delete" + name);
    }

    @Given("^article is added with name: \"([^\"]*)\", author: \"([^\"]*)\", title: \"([^\"]*)\", journal: \"([^\"]*)\", year: \"([^\"]*)\" and volume: \"([^\"]*)\"$")
    @When("^article with name: \"([^\"]*)\", author: \"([^\"]*)\", title: \"([^\"]*)\", journal: \"([^\"]*)\", year: \"([^\"]*)\" and volume: \"([^\"]*)\" is added$")
    public void article_is_added(String name, String author, String title, String journal, String year, String volume) throws Throwable {
        selectType("Article");
        submitButtonWithId("submit");
        fillInputWithValue(name, "name");
        fillInputWithValue(author, "author");
        fillInputWithValue(title, "title");
        fillInputWithValue(journal, "journal");
        fillInputWithValue(year, "year");
        fillInputWithValue(volume, "volume");
        submitButtonWithId("submit");
    }

    @When("^article with author: \"([^\"]*)\" is added$")
    public void article_is_added_with_author(String author) {
        selectType("Article");
        submitButtonWithId("submit");
        fillInputWithValue(author, "author");
        submitButtonWithId("submit");
    }

    @When("^article named \"([^\"]*)\" is edited with name: \"([^\"]*)\", author: \"([^\"]*)\", title: \"([^\"]*)\", year: \"([^\"]*)\" and publisher: \"([^\"]*)\"$")
    public void article_is_edited(String oldName, String newName, String author, String title, String year, String publisher) {
        submitButtonWithId("edit" + oldName);
        fillInputWithValue(newName, "name");
        fillInputWithValue(author, "author");
        fillInputWithValue(title, "title");
        fillInputWithValue(year, "year");
        fillInputWithValue(publisher, "publisher");
        submitButtonWithId("submit");
    }

    @When("^article named \"([^\"]*)\" is deleted$")
    public void article_is_deleted(String name) {
        submitButtonWithId("delete" + name);
    }

    @Given("^inproceedings is added with name: \"([^\"]*)\", author: \"([^\"]*)\", title: \"([^\"]*)\", book title: \"([^\"]*)\" and year: \"([^\"]*)\"$")
    @When("^inproceedings with name: \"([^\"]*)\", author: \"([^\"]*)\", title: \"([^\"]*)\", book title: \"([^\"]*)\" and year: \"([^\"]*)\" is added$")
    public void inproceedings_is_added(String name, String author, String title, String bookTitle, String year) throws Throwable {
        selectType("Inproceedings");
        submitButtonWithId("submit");
        fillInputWithValue(name, "name");
        fillInputWithValue(author, "author");
        fillInputWithValue(title, "title");
        fillInputWithValue(bookTitle, "booktitle");
        fillInputWithValue(year, "year");
        submitButtonWithId("submit");
    }

    @When("^inproceedings with author: \"([^\"]*)\" is added$")
    public void inproceedings_is_added_with_author(String author) {
        selectType("Inproceedings");
        submitButtonWithId("submit");
        fillInputWithValue(author, "author");
        submitButtonWithId("submit");
    }

    @When("^inproceedings named \"([^\"]*)\" is edited with name: \"([^\"]*)\", author: \"([^\"]*)\", title: \"([^\"]*)\", book title: \"([^\"]*)\" and year: \"([^\"]*)\"$")
    public void inproceedings_is_edited(String oldName, String newName, String author, String title, String bookTitle, String year) {
        submitButtonWithId("edit" + oldName);
        fillInputWithValue(newName, "name");
        fillInputWithValue(author, "author");
        fillInputWithValue(title, "title");
        fillInputWithValue(bookTitle, "booktitle");
        fillInputWithValue(year, "year");
        submitButtonWithId("submit");
    }

    @When("^inproceedings named \"([^\"]*)\" is deleted$")
    public void inproceedings_is_deleted(String name) {
        submitButtonWithId("delete" + name);
    }

    @When("^type: \"([^\"]*)\" is selected$")
    public void type_is_selected(String type) throws Throwable {
        selectType(type);
        submitButtonWithId("submit");
    }

    private void selectType(String type) {
        WebElement selectElement = DriverFactory.getInstance().getDriver().findElement(By.name("type"));
        Select select = new Select(selectElement);
        select.selectByVisibleText(type);

    }

    @When("^form is filled with value: \"([^\"]*)\" for \"([^\"]*)\"$")
    public void form_is_filled_with_value(String value, String field) throws Throwable {
        fillInputWithValue(value, field);
    }

    private void fillInputWithValue(String value, String input) {
        WebElement fieldElement = DriverFactory.getInstance().getDriver().findElement(By.id(input));
        fieldElement.sendKeys(value);
    }

    @When("^form is submitted$")
    public void form_is_submitted() throws Throwable {
        submitButtonWithId("submit");
    }

    private void submitButtonWithId(String id) {
        WebElement submit = DriverFactory.getInstance().getDriver().findElement(By.id(id));
        submit.submit();
    }

    @When("^getbibtex file named \"([^\"]*)\" is downloaded$")
    public void getbibtex_file_is_downloaded(String file) throws Throwable {
        WebElement fileNameInput = DriverFactory.getInstance().getDriver().findElement(By.name("filename"));
        fileNameInput.sendKeys(file);
        WebElement getBibtexButton = DriverFactory.getInstance().getDriver().findElement(By.id("submitBibtex"));
        getBibtexButton.submit();
        URL url = new URL(getbibtexPath + "/" + file);
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

    @Then("^file does not contain content: \"([^\"]*)\"$")
    public void file_does_not_contain_content(String content) throws Throwable {
        assertFalse(downloadedFile.contains(content));
    }

    @Then("^page displays add a book reference content$")
    public void page_displays_add_a_book_reference_content() throws Throwable {
        assertTrue(DriverFactory.getInstance().getDriver().getPageSource().contains("Add a book reference"));
        assertTrue(DriverFactory.getInstance().getDriver().getPageSource().contains("Reference name"));
        assertTrue(DriverFactory.getInstance().getDriver().getPageSource().contains("Author"));
        assertTrue(DriverFactory.getInstance().getDriver().getPageSource().contains("Title"));
        assertTrue(DriverFactory.getInstance().getDriver().getPageSource().contains("Publisher"));
        assertTrue(DriverFactory.getInstance().getDriver().getPageSource().contains("Year"));
        assertTrue(DriverFactory.getInstance().getDriver().getPageSource().contains("Volume"));
        assertTrue(DriverFactory.getInstance().getDriver().getPageSource().contains("Number"));
        assertTrue(DriverFactory.getInstance().getDriver().getPageSource().contains("Series"));
        assertTrue(DriverFactory.getInstance().getDriver().getPageSource().contains("Address"));
        assertTrue(DriverFactory.getInstance().getDriver().getPageSource().contains("Edition"));
        assertTrue(DriverFactory.getInstance().getDriver().getPageSource().contains("Month"));
        assertTrue(DriverFactory.getInstance().getDriver().getPageSource().contains("Note"));
        assertTrue(DriverFactory.getInstance().getDriver().getPageSource().contains("Key"));
    }

    @Then("^page displays add an article reference content$")
    public void page_displays_add_an_article_reference_content() throws Throwable {
        assertTrue(DriverFactory.getInstance().getDriver().getPageSource().contains("Add an article reference"));
        assertTrue(DriverFactory.getInstance().getDriver().getPageSource().contains("Reference name"));
        assertTrue(DriverFactory.getInstance().getDriver().getPageSource().contains("Author"));
        assertTrue(DriverFactory.getInstance().getDriver().getPageSource().contains("Title"));
        assertTrue(DriverFactory.getInstance().getDriver().getPageSource().contains("Journal"));
        assertTrue(DriverFactory.getInstance().getDriver().getPageSource().contains("Year"));
        assertTrue(DriverFactory.getInstance().getDriver().getPageSource().contains("Volume"));
        assertTrue(DriverFactory.getInstance().getDriver().getPageSource().contains("Number"));
        assertTrue(DriverFactory.getInstance().getDriver().getPageSource().contains("Pages"));
        assertTrue(DriverFactory.getInstance().getDriver().getPageSource().contains("Month"));
        assertTrue(DriverFactory.getInstance().getDriver().getPageSource().contains("Note"));
        assertTrue(DriverFactory.getInstance().getDriver().getPageSource().contains("Key"));
    }

    @Then("^page displays add an inproceedings reference content$")
    public void page_displays_add_an_inproceedings_reference_content() throws Throwable {
        assertTrue(DriverFactory.getInstance().getDriver().getPageSource().contains("Add an inproceedings reference"));
        assertTrue(DriverFactory.getInstance().getDriver().getPageSource().contains("Reference name"));
        assertTrue(DriverFactory.getInstance().getDriver().getPageSource().contains("Author"));
        assertTrue(DriverFactory.getInstance().getDriver().getPageSource().contains("Title"));
        assertTrue(DriverFactory.getInstance().getDriver().getPageSource().contains("Book Title"));
        assertTrue(DriverFactory.getInstance().getDriver().getPageSource().contains("Editor"));
        assertTrue(DriverFactory.getInstance().getDriver().getPageSource().contains("Volume"));
        assertTrue(DriverFactory.getInstance().getDriver().getPageSource().contains("Number"));
        assertTrue(DriverFactory.getInstance().getDriver().getPageSource().contains("Series"));
        assertTrue(DriverFactory.getInstance().getDriver().getPageSource().contains("Pages"));
        assertTrue(DriverFactory.getInstance().getDriver().getPageSource().contains("Address"));
        assertTrue(DriverFactory.getInstance().getDriver().getPageSource().contains("Month"));
        assertTrue(DriverFactory.getInstance().getDriver().getPageSource().contains("Organization"));
        assertTrue(DriverFactory.getInstance().getDriver().getPageSource().contains("Publisher"));
        assertTrue(DriverFactory.getInstance().getDriver().getPageSource().contains("Note"));
        assertTrue(DriverFactory.getInstance().getDriver().getPageSource().contains("Key"));
    }
}
