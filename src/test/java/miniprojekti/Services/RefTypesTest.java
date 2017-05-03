package miniprojekti.Services;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by markovai on 3.5.2017.
 */
public class RefTypesTest {

    @Test
    public void optionalFieldsForArticleAreCorrect() {
        RefTypes refTypes = new RefTypes();
        assertFalse(refTypes.getTypeMap("article").get("number")[1]);
        assertFalse(refTypes.getTypeMap("article").get("pages")[1]);
        assertFalse(refTypes.getTypeMap("article").get("month")[1]);
        assertFalse(refTypes.getTypeMap("article").get("note")[1]);
        assertFalse(refTypes.getTypeMap("article").get("key")[1]);
        assertTrue(refTypes.getTypeMap("article").get("number")[0]);
        assertTrue(refTypes.getTypeMap("article").get("pages")[0]);
        assertTrue(refTypes.getTypeMap("article").get("month")[0]);
        assertTrue(refTypes.getTypeMap("article").get("note")[0]);
        assertTrue(refTypes.getTypeMap("article").get("key")[0]);
    }

    @Test
    public void requiredFieldsForArticleAreCorrect() {
        RefTypes refTypes = new RefTypes();
        assertTrue(refTypes.getTypeMap("article").get("author")[1]);
        assertTrue(refTypes.getTypeMap("article").get("title")[1]);
        assertTrue(refTypes.getTypeMap("article").get("journal")[1]);
        assertTrue(refTypes.getTypeMap("article").get("year")[1]);
        assertTrue(refTypes.getTypeMap("article").get("volume")[1]);
    }

    @Test
    public void optionalFieldsForBookAreCorrect() {
        RefTypes refTypes = new RefTypes();
        assertFalse(refTypes.getTypeMap("book").get("volume")[1]);
        assertFalse(refTypes.getTypeMap("book").get("series")[1]);
        assertFalse(refTypes.getTypeMap("book").get("address")[1]);
        assertFalse(refTypes.getTypeMap("book").get("edition")[1]);
        assertFalse(refTypes.getTypeMap("book").get("month")[1]);
        assertFalse(refTypes.getTypeMap("book").get("note")[1]);
        assertFalse(refTypes.getTypeMap("book").get("key")[1]);
        assertTrue(refTypes.getTypeMap("book").get("volume")[0]);
        assertTrue(refTypes.getTypeMap("book").get("series")[0]);
        assertTrue(refTypes.getTypeMap("book").get("address")[0]);
        assertTrue(refTypes.getTypeMap("book").get("edition")[0]);
        assertTrue(refTypes.getTypeMap("book").get("month")[0]);
        assertTrue(refTypes.getTypeMap("book").get("note")[0]);
        assertTrue(refTypes.getTypeMap("book").get("key")[0]);
    }

    @Test
    public void requiredFieldsForBookAreCorrect() {
        RefTypes refTypes = new RefTypes();
        assertTrue(refTypes.getTypeMap("book").get("author")[1]);
        assertTrue(refTypes.getTypeMap("book").get("title")[1]);
        assertTrue(refTypes.getTypeMap("book").get("publisher")[1]);
        assertTrue(refTypes.getTypeMap("book").get("year")[1]);
    }

    @Test
    public void optionalFieldsForInproceedingsAreCorrect() {
        RefTypes refTypes = new RefTypes();
        assertFalse(refTypes.getTypeMap("inproceedings").get("editor")[1]);
        assertFalse(refTypes.getTypeMap("inproceedings").get("volume")[1]);
        assertFalse(refTypes.getTypeMap("inproceedings").get("number")[1]);
        assertFalse(refTypes.getTypeMap("inproceedings").get("series")[1]);
        assertFalse(refTypes.getTypeMap("inproceedings").get("pages")[1]);
        assertFalse(refTypes.getTypeMap("inproceedings").get("address")[1]);
        assertFalse(refTypes.getTypeMap("inproceedings").get("month")[1]);
        assertFalse(refTypes.getTypeMap("inproceedings").get("organization")[1]);
        assertFalse(refTypes.getTypeMap("inproceedings").get("publisher")[1]);
        assertFalse(refTypes.getTypeMap("inproceedings").get("note")[1]);
        assertFalse(refTypes.getTypeMap("inproceedings").get("key")[1]);
        assertTrue(refTypes.getTypeMap("inproceedings").get("editor")[0]);
        assertTrue(refTypes.getTypeMap("inproceedings").get("volume")[0]);
        assertTrue(refTypes.getTypeMap("inproceedings").get("number")[0]);
        assertTrue(refTypes.getTypeMap("inproceedings").get("series")[0]);
        assertTrue(refTypes.getTypeMap("inproceedings").get("pages")[0]);
        assertTrue(refTypes.getTypeMap("inproceedings").get("address")[0]);
        assertTrue(refTypes.getTypeMap("inproceedings").get("month")[0]);
        assertTrue(refTypes.getTypeMap("inproceedings").get("organization")[0]);
        assertTrue(refTypes.getTypeMap("inproceedings").get("publisher")[0]);
        assertTrue(refTypes.getTypeMap("inproceedings").get("note")[0]);
        assertTrue(refTypes.getTypeMap("inproceedings").get("key")[0]);
    }

    @Test
    public void requiredFieldsForInproceedingsAreCorrect() {
        RefTypes refTypes = new RefTypes();
        assertTrue(refTypes.getTypeMap("inproceedings").get("author")[1]);
        assertTrue(refTypes.getTypeMap("inproceedings").get("title")[1]);
        assertTrue(refTypes.getTypeMap("inproceedings").get("booktitle")[1]);
        assertTrue(refTypes.getTypeMap("inproceedings").get("year")[1]);
    }
}
