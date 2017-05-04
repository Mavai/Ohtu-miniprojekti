/*
 */
package miniprojekti.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.HashMap;
import java.util.LinkedHashMap;

import miniprojekti.Services.RefTypes;
import miniprojekti.Services.ReferenceService;
import miniprojekti.entities.RefField;
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
    ReferenceService refService;

    @Autowired
    ReferenceRepository refRepo;
    
    @Autowired
    RefTypes refTypes;

    @RequestMapping(value = "/")
    public String index(Model model) {
        return "redirect:/references";
    }

    @RequestMapping(value = "/references", method = RequestMethod.GET)
    public String get(Model model) {
        model.addAllAttributes(refService.findAllByRefType());
        return "list";
    }

    @RequestMapping(value = "/references/create/{type}", method = RequestMethod.GET)
    public String showForm(Model model, @PathVariable String type) {
        LinkedHashMap<String, Boolean[]> map = refTypes.getTypeMap(type);
        model.addAttribute("header", "Add reference: " + type);
        model.addAttribute("map", map);
        model.addAttribute("reference", new Reference(type));
        return "form";
    }
    
    @RequestMapping(value = "/references/edit/{id}", method = RequestMethod.GET)
    public String showEditForm(Model model, @PathVariable Long id) {
        Reference ref = refRepo.findOne(id);
        model.addAttribute("reference", ref);
        return "add_" + ref.getRefType();
    }

//    @RequestMapping(value = "/references/edit/{id}", method = RequestMethod.GET)
//    public String showEditForm(Model model, @PathVariable Long id) {
//        Reference ref = refRepo.findOne(id);
//        LinkedHashMap<String, Boolean[]> map = refTypes.getTypeMap(ref.getRefType());
//        model.addAttribute("header", "Edit reference: " + ref.getRefType());
//        model.addAttribute("map", map);
//        model.addAttribute("reference", ref);
//        return "form";
//    }

    @RequestMapping(value = "/save")
    public String addNew(Reference reference) {
        System.out.println(reference.getBibtex());
        if (refService.save(reference)) {
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
        return refService.makeFile(filename);
    }

    @RequestMapping(value = "/requestbibtex", method = RequestMethod.POST)
    public String requestBibtex(Model model, @RequestParam String filename) {
        return "redirect:/getbibtex/" + filename;
    }

    @RequestMapping(value = "/destroy/{id}", method = RequestMethod.POST)
    public String destroy(@PathVariable Long id) {
        refService.delete(id);
        return "redirect:/references";
    }

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String testHashMap(Model model) {
        Reference ref = new Reference();
        model.addAttribute("reference", ref);
        LinkedHashMap<String, Boolean[]> map = new LinkedHashMap<String, Boolean[]>();
        map.put("testi", new Boolean[]{true, true});
        map.put("testi2", new Boolean[]{true, true});
        map.put("testi3", new Boolean[]{false, false});
        map.put("testi4", new Boolean[]{true, true});
        model.addAttribute("testmap", map);
        return "test";
    }

    @RequestMapping(value = "test2", method = RequestMethod.GET)
    public String testTypeMaps(Model model) {
        Reference ref = new Reference("book");
        RefTypes rt = new RefTypes();
        LinkedHashMap<String, Boolean[]> map = rt.getTypeMap("book");
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" + map);
        model.addAttribute("testmap", map);
        model.addAttribute("reference", ref);
        return "test2";
    }

}
