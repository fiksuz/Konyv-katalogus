package hu.nye.progkor.bookcatalog.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hu.nye.progkor.bookcatalog.data.model.Konyvek;
import hu.nye.progkor.bookcatalog.service.KonyvekService;

/**
 * Controller for the music catalog.
 */
@Controller
@RequestMapping("/konyvkatalogus")
public class KonyvekkatalogusController {

    private final KonyvekService konyvekService;

    @Autowired
    public KonyvekkatalogusController(KonyvekService konyvekService) {
        this.konyvekService = konyvekService;
    }


    @GetMapping("/{id}")
    public String getKonyvekById(Model model, @PathVariable Long id) {
        Konyvek konyvek = konyvekService.retrieveKonyvekById(id);
        model.addAttribute("konyvek", konyvek);
        return "edit";
    }


    @GetMapping
    public String getAllKonyvek(Model model) {
        List<Konyvek> allKonyvek = konyvekService.retrieveAllKonyvek();
        model.addAttribute("konyvek", allKonyvek);
        return "list";
    }


    @GetMapping("/create")
    public String createKonyvek() {
        return "create";
    }


    @PostMapping("/create")
    public String createKonyvek(Model model, Konyvek konyvek) {
        Konyvek newKonyvek = konyvekService.createKonyvek(konyvek);
        model.addAttribute("konyvek", newKonyvek);
        return "edit";
    }


    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String updateKonyvek(Model model, Konyvek konyvek) {
        Konyvek updatedKonyvek = konyvekService.updateKonyvek(konyvek);
        model.addAttribute("konyvek", updatedKonyvek);
        return "edit";
    }


    @GetMapping("/{id}/delete")
    public String deleteKonyvekById(Model model, @PathVariable Long id) {
        konyvekService.deleteKonyvekById(id);
        List<Konyvek> allKonyvek = konyvekService.retrieveAllKonyvek();
        model.addAttribute("konyvek", allKonyvek);
        return "list";
    }
}