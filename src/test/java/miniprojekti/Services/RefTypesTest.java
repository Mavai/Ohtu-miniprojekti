package miniprojekti.Services;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by markovai on 3.5.2017.
 */
public class RefTypesTest {

    @Test
    public void optionalFieldsAreCorrect() {
        RefTypes refTypes = new RefTypes();
        assertFalse(refTypes.getTypeMap("book").get("volume")[1]);
        assertFalse(refTypes.getTypeMap("book").get("series")[1]);
        assertFalse(refTypes.getTypeMap("book").get("address")[1]);
        assertFalse(refTypes.getTypeMap("book").get("edition")[1]);
        assertFalse(refTypes.getTypeMap("book").get("month")[1]);
        assertFalse(refTypes.getTypeMap("book").get("note")[1]);
        assertTrue(refTypes.getTypeMap("book").get("volume")[0]);
        assertTrue(refTypes.getTypeMap("book").get("series")[0]);
        assertTrue(refTypes.getTypeMap("book").get("address")[0]);
        assertTrue(refTypes.getTypeMap("book").get("edition")[0]);
        assertTrue(refTypes.getTypeMap("book").get("month")[0]);
        assertTrue(refTypes.getTypeMap("book").get("note")[0]);
    }

    @Test
    public void requiredFieldsAreCorrect() {
        RefTypes refTypes = new RefTypes();
        assertTrue(refTypes.getTypeMap("book").get("author")[1]);
        assertTrue(refTypes.getTypeMap("book").get("title")[1]);
        assertTrue(refTypes.getTypeMap("book").get("publisher")[1]);
        assertTrue(refTypes.getTypeMap("book").get("year")[1]);
    }

}