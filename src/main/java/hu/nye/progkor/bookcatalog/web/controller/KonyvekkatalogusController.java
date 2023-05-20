package hu.nye.progkor.bookcatalog.web.controller;

import hu.nye.progkor.bookcatalog.data.model.Konyvek;
import hu.nye.progkor.bookcatalog.service.KonyvekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/konyvekkalaogus")
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
        return "konyvkatalogus/list";
    }

    @GetMapping("/create")
    public String createKonyvek(Model model) {
        return "konyvkatalogus/create";
    }

    @PostMapping("/create")
    public String createKonyvek(Model model, @RequestBody Konyvek konyvek) {
        Konyvek newKonyvek = konyvekService.createKonyvek(konyvek);
        model.addAttribute("konyvek", newKonyvek);
        return "konyvkatalogus/edit";
    }

    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String updateKonyvek(Model model, @RequestBody Konyvek konyvek) {
        Konyvek updateKonyvek = konyvekService.updateKonyvek(konyvek);
        return "konyvkatalogus/edit";
    }

    @GetMapping("/{id}/delete")
    public String deleteKonyvekById(Model model, @PathVariable Long id) {
        konyvekService.deleteKonyvekById(id);
        List<Konyvek> allKonyvek = konyvekService.retrieveAllKonyvek();
        model.addAttribute("konyvek", allKonyvek);
        return "konyvkatalogus/list";
    }
}
