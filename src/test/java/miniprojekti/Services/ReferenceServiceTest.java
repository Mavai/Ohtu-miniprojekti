package miniprojekti.Services;

import miniprojekti.entities.Reference;
import miniprojekti.repositories.ReferenceRepository;
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


    @Test
    public void nameIsGeneratedCorrectlyWhenItsEmpty() {
        Reference ref = new Reference("author:authorForMisc", "title:title", "refType:misc");
        System.out.println(ref.getBibtex());
        refService.save(ref);
        String tex = ref.getBibtex();
        String bibtex = "@misc{title" + ref.getId() + ",\n author    = \"authorForMisc\",\n title     = \"title\"\n}\n\n";
        assertEquals(bibtex, ref.getBibtex());
    }

}