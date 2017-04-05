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

    @Autowired
    TypeRepository typeRepo;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String initTypes(Model model) {
        ArrayList<String> reqFields = new ArrayList<>();
        ArrayList<String> optFields = new ArrayList<>();
        reqFields.add("author");
        reqFields.add("title");
        reqFields.add("journal");
        optFields.add("number");
        optFields.add("pages");
        typeRepo.save(new Type("article", reqFields, optFields));
        
        reqFields = new ArrayList<>();
        optFields = new ArrayList<>();
        reqFields.add("author");
        reqFields.add("title");
        reqFields.add("publisher");
        optFields.add("volume");
        optFields.add("series");
        typeRepo.save(new Type("book", reqFields, optFields));
        
        return "redirect:/references";
    }
    
    @RequestMapping(value = "/references", method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute("references", refRepo.findAll());
        model.addAttribute("types", typeRepo.findAll());
        return "list";
    }

    @RequestMapping(value = "/references/create/{type}", method = RequestMethod.GET)
    public String showForm(Model model, @PathVariable String type) {
        Type refType = typeRepo.findOne(type);
        model.addAttribute("reference", initializeRef(refType));
        return "add";
    }
    
    // inits new empty reference for dynamically generating a form
    private Reference initializeRef(Type type) {
        List<RefField> refs = new ArrayList<>();
        for (String fieldname : type.getReqFields()) {
            refs.add(new RefField(fieldname, "", true));
        }
        for (String fieldname : type.getOptFields()) {
            refs.add(new RefField(fieldname, "", false));
        }
        return new Reference(type.getName(), refs);
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
}
