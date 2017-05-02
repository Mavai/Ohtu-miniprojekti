/*
 */
package miniprojekti.controllers;

import java.io.IOException;
import miniprojekti.entities.Reference;
import miniprojekti.repositories.ReferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    ReferenceRepository refRepo;
    
    @RequestMapping(value = "/")
    public String index(Model model) {
        return "redirect:/references";
    }
    
    @RequestMapping(value = "/references", method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute("articleReferences", refRepo.findByRefType("article"));
        model.addAttribute("bookReferences", refRepo.findByRefType("book"));
        model.addAttribute("bookletReferences", refRepo.findByRefType("booklet"));
        model.addAttribute("conferenceReferences", refRepo.findByRefType("conference"));
        model.addAttribute("inbookReferences", refRepo.findByRefType("inbook"));
        model.addAttribute("incollectionReferences", refRepo.findByRefType("incollection"));
        model.addAttribute("inproceedingsReferences", refRepo.findByRefType("inproceedings"));
        model.addAttribute("manualReferences", refRepo.findByRefType("manual"));
        model.addAttribute("mastersthesisReferences", refRepo.findByRefType("mastersthesis"));
        model.addAttribute("miscReferences", refRepo.findByRefType("misc"));
        model.addAttribute("phdthesisReferences", refRepo.findByRefType("phdthesis"));
        model.addAttribute("proceedingsReferences", refRepo.findByRefType("proceedings"));
        model.addAttribute("techreportReferences", refRepo.findByRefType("techreport"));
        model.addAttribute("unpublishedReferences", refRepo.findByRefType("unpublished"));
        return "list";
    }

    @RequestMapping(value = "/references/create/{type}", method = RequestMethod.GET)
    public String showForm(Model model, @PathVariable String type) {
        model.addAttribute("reference", new Reference(type));
        return "add_" + type;
    }
    
    @RequestMapping(value = "/references/edit/{id}", method = RequestMethod.GET)
    public String showEditForm(Model model, @PathVariable Long id) {
        Reference ref = refRepo.findOne(id);
        model.addAttribute("reference", ref);
        System.out.println("KIISSSSSSSSSSSSSSSSSSSSSSSSSSSAAAAAAAAAAAAAAAAAAAAAAAAA " + id.getClass());
        return "add_" + ref.getRefType();
    }

    @RequestMapping(value = "/save")
    public String addNew(Reference reference) {
        if (reference.validate()) {
            try {
                refRepo.save(reference);
            } catch (Exception e) {
                reference.setName(reference.getName()+"2");
                refRepo.save(reference);
            }        
            if (reference.getName().equals("")) {
                generateKey(reference);
                refRepo.save(reference);
            }
            return "redirect:/references";
        } else {
            return "redirect:/references/create/" + reference.getRefType();
        }
    }

    @RequestMapping(value = "/references", method = RequestMethod.POST)
    public String createReference(Model model, @RequestParam String type) {
        return "redirect:/references/create/" + type;
    }

    @RequestMapping(value = "/getbibtex/{filename}", method = RequestMethod.GET)
    public HttpEntity<byte[]> getBibtex(Model model, @PathVariable String filename) throws IOException {
       String bibtex = generateBibtex();
/*        for (Reference r : refRepo.findAll()) {
            bibtex += "@" + r.getType() + "{" + r.getName() + ",\n";
            bibtex += r.getAuthor() != null && !r.getAuthor().equals("") ? " author    = \"" + r.getAuthor() + "\",\n" : "";
            bibtex += r.getTitle() != null && !r.getTitle().equals("") ? " title     = \"" + r.getTitle() + "\",\n" : "";
            bibtex += r.getPublisher() != null && !r.getPublisher().equals("") ? " publisher = \"" + r.getPublisher() + "\",\n" : "";
            bibtex += r.getYear() != null && !r.getYear().equals("") ? " year      = \"" + r.getYear() + "\",\n" : "";
            bibtex += r.getMonth() != null && !r.getMonth().equals("") ? " month     = \"" + r.getMonth() + "\",\n" : "";
            bibtex += r.getAddress() != null && !r.getAddress().equals("") ? " address   = \"" + r.getAddress() + "\",\n" : "";
            bibtex += r.getEdition() != null && !r.getEdition().equals("") ? " edition   = \"" + r.getEdition() + "\",\n" : "";
            bibtex += r.getJournal() != null && !r.getJournal().equals("") ? " journal   = \"" + r.getJournal() + "\",\n" : "";
            bibtex += r.getVolume() != null && !r.getVolume().equals("") ? " volume    = \"" + r.getVolume() + "\",\n" : "";
            bibtex += r.getNumber() != null && !r.getNumber().equals("") ? " number    = \"" + r.getNumber() + "\",\n" : "";
            bibtex += r.getPages() != null && !r.getPages().equals("") ? " pages     = \"" + r.getPages() + "\",\n" : "";
            bibtex += r.getNote() != null && !r.getNote().equals("") ? " note       = \"" + r.getNote() + "\",\n" : "";
            bibtex += r.getKey() != null && !r.getKey().equals("") ? " key          = \"" + r.getKey() + "\",\n" : "";
            bibtex += r.getPublisher() != null && !r.getPublisher().equals("") ? " publisher = \"" + r.getPublisher() + "\",\n" : "";
            bibtex += r.getSeries() != null && !r.getSeries().equals("") ? " series   = \"" + r.getSeries() + "\",\n" : "";
            bibtex = bibtex.substring(0, bibtex.length() - 2);
            bibtex += "\n}\n\n";
            bibtex += r.getBibtex();
        }*/

        byte[] data = bibtex.getBytes();
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.TEXT_PLAIN);
        header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+filename+".bib");
        header.setContentLength(data.length);
        return new HttpEntity<byte[]>(data, header  );
    }

    @RequestMapping(value= "/requestbibtex", method = RequestMethod.POST )
    public String requestBibtex(Model model, @RequestParam String filename) {
        return "redirect:/getbibtex/" + filename;
    }

    @RequestMapping(value = "/destroy/{id}", method = RequestMethod.GET)
    public String destroy(@PathVariable Long id) {
        Reference deleted = refRepo.findOne(id);
        refRepo.delete(deleted);
        return "redirect:/references";
    }

    public String generateBibtex() {
        String bibtex = "";
        for (Reference r : refRepo.findAll()) {
            bibtex += r.getBibtex();
        }
        return bibtex;
    }

    public void generateKey(Reference reference) {
        String title = reference.getTitle();
        String key;
        int length = title.length();

        if (length < 5) {
            key = title;
        } else {
            key = title.substring(0,5);
        }
        key += reference.getId();
        reference.setName(key);
    }


}
