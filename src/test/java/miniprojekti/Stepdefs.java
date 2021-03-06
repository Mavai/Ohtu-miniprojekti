package miniprojekti;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.net.URL;
import java.util.Scanner;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
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
    String downloadedFileString;
    private static boolean init = false;
    public static WebDriver driver;

    public Stepdefs() {
    }

    @Before
    public void setup() {
        if (!init) {
            ChromeDriverManager.getInstance().setup();
            driver = new ChromeDriver();
            init = true;
        }
    }

    @Given("references is visited$")
    public void references_is_visited() throws Throwable {
        driver.get(referencesPath);
    }

    @Given("^book is added with name: \"([^\"]*)\", author: \"([^\"]*)\", editor: \"([^\"]*)\", title: \"([^\"]*)\", year: \"([^\"]*)\" and publisher: \"([^\"]*)\"$")
    @When("^book with name: \"([^\"]*)\", author: \"([^\"]*)\", editor: \"([^\"]*)\", title: \"([^\"]*)\", year: \"([^\"]*)\" and publisher: \"([^\"]*)\" is added$")
    public void book_is_added(String name, String author, String editor, String title, String year, String publisher) throws Throwable {
        selectType("Book");
        submitButtonWithId("submit");
        fillInputWithValue(name, "name");
        fillInputWithValue(author, "author");
        fillInputWithValue(editor, "editor");
        fillInputWithValue(title, "title");
        fillInputWithValue(publisher, "publisher");
        fillInputWithValue(year, "year");
        submitButtonWithId("submit");
    }

    @Given("^book with name \"([^\"]*)\" is edited with name: \"([^\"]*)\", author: \"([^\"]*)\", editor: \"([^\"]*)\", title: \"([^\"]*)\", year: \"([^\"]*)\" and publisher: \"([^\"]*)\"$")
    @When("^book named \"([^\"]*)\" is edited with name: \"([^\"]*)\", author: \"([^\"]*)\", editor: \"([^\"]*)\", title: \"([^\"]*)\", year: \"([^\"]*)\" and publisher: \"([^\"]*)\"$")
    public void book_is_edited(String oldName, String newName, String author, String editor, String title, String year, String publisher) {
        clickLinkWithId("edit" + oldName);
        fillInputWithValue(newName, "name");
        fillInputWithValue(author, "author");
        fillInputWithValue(editor, "editor");
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

    @When("^book with author: \"([^\"]*)\" is added$")
    public void book_is_added_with_author(String author) {
        selectType("Book");
        submitButtonWithId("submit");
        fillInputWithValue(author, "author");
        submitButtonWithId("submit");
    }

    @When("^article with author: \"([^\"]*)\" is added$")
    public void article_is_added_with_author(String author) {
        selectType("Article");
        submitButtonWithId("submit");
        fillInputWithValue(author, "author");
        submitButtonWithId("submit");
    }

    @When("^article named \"([^\"]*)\" is edited with name: \"([^\"]*)\", author: \"([^\"]*)\", title: \"([^\"]*)\", journal: \"([^\"]*)\", year: \"([^\"]*)\" and volume: \"([^\"]*)\"$")
    public void article_is_edited(String oldName, String newName, String author, String title, String journal, String year, String volume) {
        clickLinkWithId("edit" + oldName);
        fillInputWithValue(newName, "name");
        fillInputWithValue(author, "author");
        fillInputWithValue(title, "title");
        fillInputWithValue(journal, "journal");
        fillInputWithValue(year, "year");
        fillInputWithValue(volume, "volume");
        submitButtonWithId("submit");
    }

    @When("^article named \"([^\"]*)\" is deleted$")
    public void article_is_deleted(String name) {
        submitButtonWithId("delete" + name);
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
        clickLinkWithId("edit" + oldName);
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

    @When("^getbibtex file named \"([^\"]*)\" is downloaded$")
    public void getbibtex_file_is_downloaded(String fileName) throws Throwable {
        WebElement fileNameInput = driver.findElement(By.name("filename"));
        fileNameInput.sendKeys(fileName);
        submitButtonWithId("submitBibtex");
        URL url = new URL(getbibtexPath + "/" + fileName);
        downloadedFileString = new Scanner(url.openStream()).useDelimiter("\\A").next();
    }

    @When("^type: \"([^\"]*)\" is selected$")
    public void type_is_selected(String type) throws Throwable {
        selectType(type);
        submitButtonWithId("submit");
    }

    @Then("^page displays content: \"([^\"]*)\"$")
    public void page_displays_content(String content) throws Throwable {
        assertTrue(driver.getPageSource().contains(content));
    }

    @Then("^page does not display content: \"([^\"]*)\"$")
    public void page_does_not_display_content(String content) throws Throwable {
        assertFalse(driver.getPageSource().contains(content));
    }

    @Then("^file contains content: \"([^\"]*)\"$")
    public void file_contains_content(String content) throws Throwable {
        assertTrue(downloadedFileString.contains(content));
    }

    @Then("^file does not contain content: \"([^\"]*)\"$")
    public void file_does_not_contain_content(String content) throws Throwable {
        assertFalse(downloadedFileString.contains(content));
    }

    @Then("^page displays add a book reference content$")
    public void page_displays_add_a_book_reference_content() throws Throwable {
        assertTrue(driver.getPageSource().contains("Add reference: book"));
        assertTrue(driver.getPageSource().contains("name"));
        assertTrue(driver.getPageSource().contains("author"));
        assertTrue(driver.getPageSource().contains("title"));
        assertTrue(driver.getPageSource().contains("publisher"));
        assertTrue(driver.getPageSource().contains("year"));
        assertTrue(driver.getPageSource().contains("volume"));
        assertTrue(driver.getPageSource().contains("number"));
        assertTrue(driver.getPageSource().contains("series"));
        assertTrue(driver.getPageSource().contains("address"));
        assertTrue(driver.getPageSource().contains("edition"));
        assertTrue(driver.getPageSource().contains("month"));
        assertTrue(driver.getPageSource().contains("note"));
        assertTrue(driver.getPageSource().contains("key"));
    }

    @Then("^page displays add an article reference content$")
    public void page_displays_add_an_article_reference_content() throws Throwable {
        assertTrue(driver.getPageSource().contains("Add reference: article"));
        assertTrue(driver.getPageSource().contains("name"));
        assertTrue(driver.getPageSource().contains("author"));
        assertTrue(driver.getPageSource().contains("title"));
        assertTrue(driver.getPageSource().contains("journal"));
        assertTrue(driver.getPageSource().contains("year"));
        assertTrue(driver.getPageSource().contains("volume"));
        assertTrue(driver.getPageSource().contains("number"));
        assertTrue(driver.getPageSource().contains("pages"));
        assertTrue(driver.getPageSource().contains("month"));
        assertTrue(driver.getPageSource().contains("note"));
        assertTrue(driver.getPageSource().contains("key"));
    }

    @Then("^page displays add an inproceedings reference content$")
    public void page_displays_add_an_inproceedings_reference_content() throws Throwable {
        assertTrue(driver.getPageSource().contains("Add reference: inproceedings"));
        assertTrue(driver.getPageSource().contains("name"));
        assertTrue(driver.getPageSource().contains("author"));
        assertTrue(driver.getPageSource().contains("title"));
        assertTrue(driver.getPageSource().contains("booktitle"));
        assertTrue(driver.getPageSource().contains("editor"));
        assertTrue(driver.getPageSource().contains("volume"));
        assertTrue(driver.getPageSource().contains("number"));
        assertTrue(driver.getPageSource().contains("series"));
        assertTrue(driver.getPageSource().contains("pages"));
        assertTrue(driver.getPageSource().contains("address"));
        assertTrue(driver.getPageSource().contains("month"));
        assertTrue(driver.getPageSource().contains("organization"));
        assertTrue(driver.getPageSource().contains("publisher"));
        assertTrue(driver.getPageSource().contains("note"));
        assertTrue(driver.getPageSource().contains("key"));
    }

    private void selectType(String type) {
        WebElement selectElement = driver.findElement(By.name("type"));
        Select select = new Select(selectElement);
        select.selectByVisibleText(type);
    }

    private void fillInputWithValue(String value, String input) {
        WebElement fieldElement = driver.findElement(By.id(input));
        fieldElement.clear();
        fieldElement.sendKeys(value);
    }

    private void submitButtonWithId(String id) {
        WebElement submit = driver.findElement(By.id(id));
        submit.submit();
    }

    private void clickLinkWithId(String id) {
        WebElement link = driver.findElement(By.id(id));
        link.click();
    }
}
