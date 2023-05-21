package hu.nye.progkor.bookcatalog.web.controller;

import hu.nye.progkor.bookcatalog.data.model.Konyvek;
import hu.nye.progkor.bookcatalog.service.KonyvekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;


import java.util.List;
import java.util.Optional;

/**
 * TODO.
 */
@RestController
@RequestMapping("/api/v1/konyvek")
public class KonyvkatalogusRestController {
    private final KonyvekService konyvekService;

    @Autowired
    public KonyvkatalogusRestController(KonyvekService konyvekService) {
        this.konyvekService = konyvekService;
    }

    /**
     *.
     */
    @GetMapping("/{id}")
    public Konyvek getKonyvekById(@PathVariable Long id) {
       Konyvek konyvek = konyvekService.retrieveKonyvekById(id);
        return konyvekService.retrieveKonyvekById(id);

    }

    @GetMapping
    public List<Konyvek> getAllKonyvek() {
        return konyvekService.retrieveAllKonyvek();
    }

    @PostMapping
    public Konyvek createKonyvek(@RequestBody Konyvek konyvek) {
        return konyvekService.createKonyvek(konyvek);
    }

    @PutMapping
    public Konyvek updateKonyvek(@RequestBody Konyvek konyvek) {
        return konyvekService.updateKonyvek(konyvek);
    }

    @DeleteMapping("/{id}")
    public void deleteKonyvekById(@PathVariable Long id) {
        konyvekService.deleteKonyvekById(id);
    }
}
