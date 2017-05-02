package miniprojekti.Services;

import miniprojekti.entities.Reference;
import miniprojekti.repositories.ReferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

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
                reference.setName(reference.getName() + "2");
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

    public void delete(Long id) {
        Reference deleted = refRepo.findOne(id);
        refRepo.delete(deleted);
    }

    public HttpEntity<byte[]> makeFile(String filename) {
        byte[] data = generateBibtex().getBytes();
        HttpHeaders header = makeHeader(filename, data);
        return new HttpEntity<byte[]>(data, header  );

    }

    private HttpHeaders makeHeader(@PathVariable String filename, byte[] data) {
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.TEXT_PLAIN);
        header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+filename+".bib");
        header.setContentLength(data.length);
        return header;
    }

}
