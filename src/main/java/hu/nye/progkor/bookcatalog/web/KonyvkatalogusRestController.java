package hu.nye.progkor.bookcatalog.web;

import hu.nye.progkor.bookcatalog.data.model.Konyvek;
import hu.nye.progkor.bookcatalog.service.KonyvekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/konyvek")
public class KonyvkatalogusRestController {
    private final KonyvekService konyvekService;
    @Autowired
    public KonyvkatalogusRestController(KonyvekService konyvekService) {
        this.konyvekService = konyvekService;
    }
    @GetMapping("/{id}")
    public Konyvek getKonyvekById(@PathVariable Long id){
        return konyvekService.retrieveKonyvekById(id);
    }

    @GetMapping
    public List<Konyvek> getAllKonyvek(){
        return konyvekService.retrieveAllKonyvek();
    }

    @PostMapping
    public Konyvek createKonyvek(@RequestBody Konyvek konyvek){
        return konyvekService.createKonyvek(konyvek);
    }

    @PutMapping
    public Konyvek updateKonyvek(@RequestBody Konyvek konyvek){
        return konyvekService.updateKonyvek(konyvek);
    }

    @DeleteMapping("/{id}")
    public void deleteKonyvekById(@PathVariable Long id){
        konyvekService.deleteKonyvekById(id);
    }
}
