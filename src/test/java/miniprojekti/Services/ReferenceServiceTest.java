package miniprojekti.Services;

import miniprojekti.entities.Reference;
import miniprojekti.repositories.ReferenceRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by markovai on 2.5.2017.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ReferenceServiceTest {
    @Autowired
    ReferenceService refService;

    @Autowired
    ReferenceRepository referenceRepository;

    @After
    public void tearDown() {
        refService.deleteAll();
    }

    @Test
    public void nameIsGeneratedCorrectlyWhenItsEmpty() {
        Reference ref = new Reference("author:authorForMisc", "title:title", "refType:misc");
        System.out.println(ref.getBibtex());
        refService.save(ref);
        String tex = ref.getBibtex();
        String bibtex = "@misc{title" + ref.getId() + ",\n author    = \"authorForMisc\",\n title     = \"title\"\n}\n\n";
        assertEquals(bibtex, ref.getBibtex());
    }

    @Test
    public void saveWorks() {
        Reference ref = new Reference("name:foo", "refType:bar", "title:foobar");
        refService.save(ref);
        Reference retrieved = referenceRepository.findByName("foo");
        assertNotNull(retrieved);
        assertEquals("foobar" ,retrieved.getTitle());
    }

    @Test
    public void saveWorksWithDuplicateNames() {
        Reference ref1 = new Reference("name:foo", "refType:unpublished", "title:foobar");
        Reference ref2 = new Reference("name:foo", "refType:unpublished", "title:foobar");
        refService.save(ref1);
        refService.save(ref2);
        assertNotNull(referenceRepository.findByName("foo"));
        assertNotNull(referenceRepository.findByName("foo2"));
    }

    public void saveWorksMultipleWithDuplicateNames() {
        Reference ref1 = new Reference("name:foo2", "refType:unpublished", "title:foobar");
        Reference ref2 = new Reference("name:foo2", "refType:unpublished", "title:foobar");
        Reference ref3 = new Reference("name:foo2", "refType:unpublished", "title:foobar");
        refService.save(ref1);
        refService.save(ref2);
        refService.save(ref3);
        assertNotNull(referenceRepository.findByName("foo"));
        assertNotNull(referenceRepository.findByName("foo2"));
    }

    @Test
    public void deleteWorks() {
        Reference ref = new Reference("name:foo", "refType:bar", "title:foobar");
        refService.save(ref);
        refService.delete(ref.getId());
        Reference retrieved = referenceRepository.findByName("foo");
        assertNull(retrieved);
    }

    @Test
    public void findAllByRefTypeReturnsCorrectAmount() {
        Reference ref1 = new Reference("name:foo", "refType:unpublished", "title:foobar");
        Reference ref2 = new Reference("name:foo", "refType:unpublished", "title:foobar");
        Reference ref3 = new Reference("name:foo", "refType:unpublished", "title:barfoo");
        Reference ref4 = new Reference("name:foo", "refType:unpublished", "title:barfoo");
        refService.save(ref1);
        refService.save(ref2);
        refService.save(ref3);
        refService.save(ref4);
        assertEquals(4, refService.findAllByRefType().get("unpublishedReferences").size());
    }
    
    @Test
    public void generatedBibtexContainsSavedBook() {
        refService.save(new Reference("name:referenceNameForGetBibtexTest", "author:authorNameForGetBibtexTest",
                "editor:editorNameForGetBibtexTest", "title:bookTitleForGetBibtexTest", "year:4321", "publisher:publisherNameForGetBibtexTest"));

        String bibtex = refService.generateBibtex();
        assertTrue(bibtex.contains("referenceNameForGetBibtexTest"));
        assertTrue(bibtex.contains("authorNameForGetBibtexTest"));
        assertTrue(bibtex.contains("editorNameForGetBibtexTest"));
        assertTrue(bibtex.contains("bookTitleForGetBibtexTest"));
        assertTrue(bibtex.contains("4321"));
        assertTrue(bibtex.contains("publisherNameForGetBibtexTest"));
    }

    @Test
    public void generatedBibtexDoesNotContainUnAddedFields() {
        refService.save(new Reference("name:referenceNameForGetBibtexTest", "author:authorNameForGetBibtexTest",
                "editor:editorNameForGetBibtexTest", "title:bookTitleForGetBibtexTest", "year:4321", "publisher:publisherNameForGetBibtexTest"));

        String bibtex = refService.generateBibtex();
        assertFalse(bibtex.contains("number"));
        assertFalse(bibtex.contains("series"));
        assertFalse(bibtex.contains("address"));
        assertFalse(bibtex.contains("edition"));
        assertFalse(bibtex.contains("month"));
        assertFalse(bibtex.contains("key"));
    }

    @Test
    public void generatedBibtexDoesNotContainScandinavianLetters() {
        refService.save(new Reference("name:äö", "author:äuthör", "editor:editor", "title:title", "journal:jöurnäl", "year:1999", "volume:5"));

        String fileString = refService.generateBibtex();
        assertFalse(fileString.contains("ä"));
        assertFalse(fileString.contains("Ä"));
        assertFalse(fileString.contains("ö"));
        assertFalse(fileString.contains("Ö"));
    }
    
    @Test
    public void titleWithInvalidValueDoesNotValidate() {
        Reference ref = new Reference();
        ref.setRefType("booklet");
        ref.setTitle("  \t");
        assertFalse(refService.validate(ref));
    }
    
    @Test
    public void titleWithValidValueValidates() {
        Reference ref = new Reference();
        ref.setRefType("booklet");
        ref.setTitle("testTitle");
        assertTrue(refService.validate(ref));
    }
    
    @Test
    public void authorWithInvalidValueDoesNotValidate() {
        Reference ref = new Reference();
        ref.setRefType("booklet");
        ref.setTitle("testTitle");
        ref.setAuthor("  \t");
        assertFalse(refService.validate(ref));
    }
    
    @Test
    public void journalWithInvalidValueDoesNotValidate() {
        Reference ref = new Reference();
        ref.setRefType("booklet");
        ref.setTitle("testTitle");
        ref.setJournal("  \t");
        assertFalse(refService.validate(ref));
    }
}