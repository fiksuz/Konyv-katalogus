package hu.nye.progkor.bookcatalog.service;

import hu.nye.progkor.bookcatalog.data.model.Konyvek;

import java.util.List;

/**
 * TODO.
 */
public interface KonyvekService {
    /**
     * TODO.
     *
     * @param konyvek TODO.
     * @return TODO.
     */
    Konyvek createKonyvek(Konyvek konyvek);

    Konyvek retrieveKonyvekById(Long id);

    List<Konyvek> retrieveAllKonyvek();

    Konyvek updateKonyvek(Konyvek konyvek);

    void deleteKonyvekById(Long id);
}
