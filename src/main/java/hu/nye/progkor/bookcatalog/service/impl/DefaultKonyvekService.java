package hu.nye.progkor.bookcatalog.service.impl;

import hu.nye.progkor.bookcatalog.data.model.Konyvek;
import hu.nye.progkor.bookcatalog.data.repository.Repository;
import hu.nye.progkor.bookcatalog.service.KonyvekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * .
 */
@Service
public class DefaultKonyvekService implements KonyvekService {
    private final Repository<Konyvek, Long> konyvekRepository;

    @Autowired
    public DefaultKonyvekService(Repository<Konyvek, Long> konyvekRepsotiory) {
        this.konyvekRepository = konyvekRepsotiory;
    }

    @Override
    public Konyvek createKonyvek(Konyvek konyvek) {
        return konyvekRepository.save(konyvek);
    }

    @Override
    public Konyvek retrieveKonyvekById(Long id) {
        return konyvekRepository.getById(id);
    }

    @Override
    public List<Konyvek> retrieveAllKonyvek() {
        return konyvekRepository.getAll();
    }

    @Override
    public Konyvek updateKonyvek(Konyvek konyvek) {
        return konyvekRepository.update(konyvek);
    }

    @Override
    public void deleteKonyvekById(Long id) {
        konyvekRepository.deleteById(id);
    }
}
