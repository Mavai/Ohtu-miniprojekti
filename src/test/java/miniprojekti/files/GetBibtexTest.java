package miniprojekti.files;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import miniprojekti.entities.Reference;
import miniprojekti.repositories.ReferenceRepository;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author hanranti
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class GetBibtexTest {

    @Autowired
    ReferenceRepository referenceRepository;

    String getbibtexPath = "http://localhost:8080/getbibtex/";
    String bibtexFileName = "bibtex";
    private static Boolean initialized = false;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        if (!initialized) {
            referenceRepository.save(new Reference("name:referenceNameForGetBibtexTest", "author:authorNameForGetBibtexTest",
                    "editor:editorNameForGetBibtexTest", "title:bookTitleForGetBibtexTest", "year:4321", "publisher:publisherNameForGetBibtexTest"));

            referenceRepository.save(new Reference("name:äö", "author:äuthör", "editor:editor", "title:title", "journal:jöurnäl", "year:1999", "volume:5"));

            initialized = true;
        }
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getBibtexFileContainsSavedBook() {
        String fileString = downloadFileAsString(getbibtexPath + bibtexFileName);

        System.out.println(fileString);
        assertTrue(fileString.contains("referenceNameForGetBibtexTest"));
        assertTrue(fileString.contains("authorNameForGetBibtexTest"));
        assertTrue(fileString.contains("editorNameForGetBibtexTest"));
        assertTrue(fileString.contains("bookTitleForGetBibtexTest"));
        assertTrue(fileString.contains("4321"));
        assertTrue(fileString.contains("publisherNameForGetBibtexTest"));
    }

    @Test
    public void getBibtexFileDoesNotContainUnAddedFields() {
        String fileString = downloadFileAsString(getbibtexPath + bibtexFileName);
        System.out.println(fileString);
        assertFalse(fileString.contains("number"));
        assertFalse(fileString.contains("series"));
        assertFalse(fileString.contains("address"));
        assertFalse(fileString.contains("edition"));
        assertFalse(fileString.contains("month"));
        assertFalse(fileString.contains("key"));
    }

    @Test
    public void getBibtexFileDoesNotContainScandinavianLetters() {
        String fileString = downloadFileAsString(getbibtexPath + bibtexFileName);
        assertFalse(fileString.contains("ä"));
        assertFalse(fileString.contains("Ä"));
        assertFalse(fileString.contains("ö"));
        assertFalse(fileString.contains("Ö"));
    }

    private String downloadFileAsString(String path) {
        try {
            URL url = new URL(path);
            return new Scanner(url.openStream()).useDelimiter("\\A").next();
        } catch (IOException ex) {
            Logger.getLogger(GetBibtexTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
