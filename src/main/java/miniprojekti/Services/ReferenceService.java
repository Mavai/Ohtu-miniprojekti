package miniprojekti.Services;

import miniprojekti.entities.Reference;
import miniprojekti.repositories.ReferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;

/**
 * Created by markovai on 2.5.2017.
 */
@Component
public class ReferenceService {
    private int uniqueNum = 2;

    @Autowired
    private ReferenceRepository refRepo;

    public String generateBibtex() {
        String bibtex = "";
        for (Reference r : refRepo.findAll()) {
            bibtex += r.getBibtex();
        }
        return bibtex;
    }

    public boolean save(Reference reference) {
        if (reference.validate()) {
            try {
                refRepo.save(reference);
            } catch (Exception e) {
                reference.setName(reference.getName() + uniqueNum++);
                save(reference);
            }
            if (reference.getName().equals("")) {
                reference.generateKey();
                refRepo.save(reference);
            }
            return true;
        }
        return false;
    }

    public void delete(Long id) {
        Reference deleted = refRepo.findOne(id);
        refRepo.delete(deleted);
    }

    public HttpEntity<byte[]> makeFile(String filename) {
        byte[] data = generateBibtex().getBytes();
        HttpHeaders header = makeHeader(filename, data);
        return new HttpEntity<byte[]>(data, header);

    }

    private HttpHeaders makeHeader(@PathVariable String filename, byte[] data) {
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.TEXT_PLAIN);
        header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename + ".bib");
        header.setContentLength(data.length);
        return header;
    }

    public HashMap<String, List<Reference>> findAllByRefType() {
        HashMap<String, List<Reference>> map = new HashMap<>();
        RefTypes refTypes = new RefTypes();
        for (String type : refTypes.getTypes().keySet()) {
            map.put(type + "References", refRepo.findByRefType(type));
        }
        return map;
    }

    public void deleteAll() {
        for (Reference ref: refRepo.findAll()) {
            refRepo.delete(ref);
        }
    }
}
