package miniprojekti.Services;

import miniprojekti.entities.Reference;
import miniprojekti.repositories.ReferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by markovai on 2.5.2017.
 */
@Component
public class ReferenceService {

    @Autowired
    private ReferenceRepository refRepo;

    public String generateBibtex() {
        String bibtex = "";
        for (Reference r : refRepo.findAll()) {
            bibtex += r.getBibtex();
        }
        return bibtex;
    }

    public String save(Reference reference) {
        if (reference.validate()) {
            try {
                refRepo.save(reference);
            } catch (Exception e) {
                reference.setName(reference.getName()+"2");
                refRepo.save(reference);
            }
            if (reference.getName().equals("")) {
                reference.generateKey();
                refRepo.save(reference);
            }
            return "redirect:/references";
        } else {
            return "redirect:/references/create/" + reference.getRefType();
        }
    }

}
