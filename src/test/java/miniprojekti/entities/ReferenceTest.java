/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojekti.entities;

import miniprojekti.Services.ReferenceService;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author markovai
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ReferenceTest {

    @Autowired
    ReferenceService refService;

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

}
