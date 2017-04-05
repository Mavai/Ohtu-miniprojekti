/*
 */

package miniprojekti.controllers;

import java.util.ArrayList;
import java.util.List;
import miniprojekti.entities.RefField;
import miniprojekti.entities.Reference;
import miniprojekti.entities.Type;
import miniprojekti.repositories.ReferenceRepository;
import miniprojekti.repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

//    @RequestMapping(value = "/getbibtex", method=RequestMethod.GET)
//    public String getBibtex(Model model) {
//        Iterable result = refRepo.findAll();
//        String bibtex = "";
//        for (Reference r : result) {
//            bibtex += "@book{"+=r.getName()+"\n";
//            bibtex += " author    = \""+r.getAuthor()+"\",\n";
//            bibtex += " title     = "+r.getTitle()+"\",\n";
//            bibtex += " publisher = "+r.getPublisher()+"\",\n";
//            bibtex += " year      = "+r.getYear()+"\"\n";
//            bibtex += " address   = "+r.getAddress()+"\",\n";
//            bibtex += " edition   = "+r.getEdition()+"\",\n";
//            bibtex += "}\n\n";
//        }
//        model.addAttribute("bibtexString", bibtex);
//        return("bibtex");
//    }
}
