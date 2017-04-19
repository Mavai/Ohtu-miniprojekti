/*
 */
package miniprojekti.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import miniprojekti.entities.RefField;
import miniprojekti.entities.Reference;
import miniprojekti.entities.Type;
import miniprojekti.repositories.ReferenceRepository;
import miniprojekti.repositories.TypeRepository;
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

    @RequestMapping(value = "/references", method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute("references", refRepo.findAll());
        return "list";
    }

    @RequestMapping(value = "/references/create/{type}", method = RequestMethod.GET)
    public String showForm(Model model, @PathVariable String type) {
        model.addAttribute("reference", new Reference(type));
        return "add_" + type;
    }

    @RequestMapping(value = "/save")
    public String addNew(Reference reference) {
        refRepo.save(reference);
        return "redirect:/references";
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

    @RequestMapping(value= "/requestbibtex", method = RequestMethod.POST)
    public String requestBibtex(Model model, @RequestParam String filename) {
        return "redirect:/getbibtex/" + filename;
    }

    public String generateBibtex() {
        String bibtex = "";
        for (Reference r : refRepo.findAll()) {
            bibtex += r.getBibtex();
        }
        bibtex = bibtex.replaceAll("ä", "\\\\"+"\"a");
        bibtex = bibtex.replaceAll("ö", "\\\\"+"\"o");
        return bibtex;
    }

}
