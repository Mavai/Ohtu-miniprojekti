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

    String getbibtexPath = "http://localhost:8080/getbibtex";

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        Reference book = new Reference("book");
        book.setName("referenceName");
        book.setAuthor("authorName");
        book.setTitle("bookTitle");
        book.setYear("1234");
        book.setPublisher("publisherName");
        referenceRepository.save(book);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getBibtexFileContainsSavedBook() {
        String file = downloadFile(getbibtexPath);
        file.contains("referenceName");
    }

    private String downloadFile(String path) {
        try {
            URL url = new URL(path);
            return new Scanner(url.openStream()).useDelimiter("\\A").next();
        } catch (IOException ex) {
            Logger.getLogger(GetBibtexTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
