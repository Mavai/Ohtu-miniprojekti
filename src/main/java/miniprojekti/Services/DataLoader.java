package miniprojekti.Services;

import miniprojekti.entities.Reference;
import miniprojekti.repositories.ReferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Created by Marko Vainio on 6.4.2017.
 */
@Component
public class DataLoader implements ApplicationRunner {
    private ReferenceRepository referenceRepository;

    @Autowired
    public DataLoader(ReferenceRepository referenceRepository) {
        this.referenceRepository = referenceRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        referenceRepository.save(new Reference("refType:Book", "name:SWEBOK", "author:Test Author1", "publisher:Test Publisher", "year:2017"));
        referenceRepository.save(new Reference("refType:Book", "name:BA04", "author:Test Author2", "publisher:Test Publisher", "year:2017"));
        referenceRepository.save(new Reference("refType:Book", "name:scrum", "author:Test Author3", "publisher:Test Publisher", "year:2017"));
        referenceRepository.save(new Reference("refType:Book", "name:royce70", "author:Test Author4", "publisher:Test Publisher", "year:2017"));
        referenceRepository.save(new Reference("refType:Book", "name:Martin09", "author:Test Author5", "publisher:Test Publisher", "year:2017"));
        referenceRepository.save(new Reference("refType:Book", "name:Begel_2008", "author:Test Author6", "publisher:Test Publisher", "year:2017"));
        referenceRepository.save(new Reference("refType:Book", "name:fox", "author:Äääööö Äuthör", "publisher:Test Publisher", "year:2017"));

    }
}
