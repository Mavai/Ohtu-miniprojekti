/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojekti.entities;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import miniprojekti.repositories.ReferenceRepository;

import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author markovai
 */
@SpringBootTest()
public class ReferenceTest {
    
    @Autowired
    ReferenceRepository referenceRepository;

    public ReferenceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void controllerWithVariableAmountParameters() {
        Reference ref = new Reference("name:nimi", "author:kirjoittaja", "type:book");
        assertEquals("nimi", ref.getName());
        assertEquals("kirjoittaja", ref.getAuthor());
        assertEquals("book", ref.getType());
    }

    @Test
    public void titleValidationWOrks() {
        Reference ref = new Reference("name:nimi", "author:kirjoittaja", "type:book");
        assertFalse(ref.validate());
    }

    @Test
    public void getBibTextWorksWithScandinavian() {
        Reference ref = new Reference("name:name", "author:äuthör", "refType:böök");
        String tex = ref.getBibtex();
        String bibtex = "@b{\\\"o}{\\\"o}k{name,\n author    = \"{\\\"a}uth{\\\"o}r\"\n}\n\n";
        assertEquals(bibtex, ref.getBibtex());
    }

//    @Test
//    public void nameIsGeneratedCorrectlyWhenItsEmpty() {
//        Reference ref = new Reference("author:authorForMisc", "title:title", "refType:misc");
//        System.out.println(ref.getBibtex());
//        referenceRepository.save(ref);
//        String tex = ref.getBibtex();
//        String bibtex = "@misc{title" + ref.getId() + ",\n author    = \"authorForMisc\",\n title    = \"title\"}\n\n";
//        assertEquals(bibtex, ref.getBibtex());
//    }
}
