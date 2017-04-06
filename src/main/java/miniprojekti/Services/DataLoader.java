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
        referenceRepository.save(new Reference("type:Book", "name:Test Book1", "author:Test Author1", "publisher:Test Publisher", "year:2017"));
        referenceRepository.save(new Reference("type:Book", "name:Test Book2", "author:Test Author2", "publisher:Test Publisher", "year:2017"));
        referenceRepository.save(new Reference("type:Book", "name:Test Book3", "author:Test Author3", "publisher:Test Publisher", "year:2017"));
        referenceRepository.save(new Reference("type:Book", "name:Test Book4", "author:Test Author4", "publisher:Test Publisher", "year:2017"));
        referenceRepository.save(new Reference("type:Book", "name:Test Book5", "author:Test Author5", "publisher:Test Publisher", "year:2017"));
    }
}
