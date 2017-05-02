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
                reference.setName(reference.getName() + "2");
                refRepo.save(reference);
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
        map.put("articleReferences", refRepo.findByRefType("article"));
        map.put("articleReferences", refRepo.findByRefType("article"));
        map.put("bookReferences", refRepo.findByRefType("book"));
        map.put("bookletReferences", refRepo.findByRefType("booklet"));
        map.put("conferenceReferences", refRepo.findByRefType("conference"));
        map.put("inbookReferences", refRepo.findByRefType("inbook"));
        map.put("incollectionReferences", refRepo.findByRefType("incollection"));
        map.put("inproceedingsReferences", refRepo.findByRefType("inproceedings"));
        map.put("manualReferences", refRepo.findByRefType("manual"));
        map.put("mastersthesisReferences", refRepo.findByRefType("mastersthesis"));
        map.put("miscReferences", refRepo.findByRefType("misc"));
        map.put("phdthesisReferences", refRepo.findByRefType("phdthesis"));
        map.put("proceedingsReferences", refRepo.findByRefType("proceedings"));
        map.put("techreportReferences", refRepo.findByRefType("techreport"));
        map.put("unpublishedReferences", refRepo.findByRefType("unpublished"));
        return map;
    }

}
