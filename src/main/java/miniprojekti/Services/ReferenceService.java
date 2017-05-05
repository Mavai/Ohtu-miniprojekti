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
        if (validate(reference)) {
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
    
    public boolean validate(Reference reference) {
        if (!containsWhitespace(reference.getName())) {
            return false;
        }
        if (!containsWhitespace(reference.getAuthor())) {
            return false;
        }
        if (!containsWhitespace(reference.getTitle()) ||(!reference.getRefType().equals("misc") && reference.getTitle().isEmpty())) {
            return false;
        }
        if (!containsWhitespace(reference.getJournal())) {
            return false;
        }
        if (!containsWhitespace(reference.getYear())) {
            return false;
        }
        if (!containsWhitespace(reference.getVolume())) {
            return false;
        }
        if (!containsWhitespace(reference.getNumber())) {
            return false;
        }
        if (!containsWhitespace(reference.getPages())) {
            return false;
        }
        if (!containsWhitespace(reference.getMonth())) {
            return false;
        }
        if (!containsWhitespace(reference.getNote())) {
            return false;
        }
        if (!containsWhitespace(reference.getKey())) {
            return false;
        }
        if (!containsWhitespace(reference.getPublisher())) {
            return false;
        }
        if (!containsWhitespace(reference.getSeries())) {
            return false;
        }
        if (!containsWhitespace(reference.getAddress())) {
            return false;
        }
        if (!containsWhitespace(reference.getEdition())) {
            return false;
        }
        if (!containsWhitespace(reference.getAnnote())) {
            return false;
        }
        if (!containsWhitespace(reference.getChapter())) {
            return false;
        }
        if (!containsWhitespace(reference.getCrossref())) {
            return false;
        }
        if (!containsWhitespace(reference.getEditor())) {
            return false;
        }
        if (!containsWhitespace(reference.getHowpublished())) {
            return false;
        }
        if (!containsWhitespace(reference.getInstitution())) {
            return false;
        }
        if (!containsWhitespace(reference.getOrganization())) {
            return false;
        }
        if (!containsWhitespace(reference.getSchool())) {
            return false;
        }
        if (!containsWhitespace(reference.getBooktitle())) {
            return false;
        }
        return true;
    }

    private boolean containsWhitespace(String string) {
        if (string != null && string.matches("\\s+")) {
            return false;
        }
        return true;
    }
}
