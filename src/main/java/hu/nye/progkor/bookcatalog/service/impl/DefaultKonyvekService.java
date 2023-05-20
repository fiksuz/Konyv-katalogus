package hu.nye.progkor.bookcatalog.service.impl;

import hu.nye.progkor.bookcatalog.data.model.Konyvek;
import hu.nye.progkor.bookcatalog.data.repository.Repository;
import hu.nye.progkor.bookcatalog.service.KonyvekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultKonyvekService implements KonyvekService {
    private final Repository<Konyvek, Long> koynvekRepository;
    @Autowired
    public DefaultKonyvekService(Repository<Konyvek, Long> koynvekRepsotiory) {
        this.koynvekRepository = koynvekRepsotiory;
    }

    @Override
    public Konyvek createKonyvek(Konyvek konyvek) {
        return koynvekRepository.save(konyvek);
    }

    @Override
    public Konyvek retrieveKonyvekById(Long id) {
        return koynvekRepository.getById(id);
    }

    @Override
    public List<Konyvek> retrieveAllKonyvek() {
        return koynvekRepository.getAll();
    }

    @Override
    public Konyvek updateKonyvek(Konyvek konyvek) {
        return koynvekRepository.update(konyvek);
    }

    @Override
    public void deleteKonyvekById(Long id) {
    koynvekRepository.deleteById(id);
    }
}
