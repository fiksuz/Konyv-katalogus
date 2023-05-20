package hu.nye.progkor.bookcatalog.data.repository.impl;

import hu.nye.progkor.bookcatalog.data.model.Konyvek;
import hu.nye.progkor.bookcatalog.data.repository.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO.
 */
@org.springframework.stereotype.Repository

public class inMemoryKonyvekRepository implements Repository<Konyvek, Long>{
    private static final Map<Long, Konyvek> STORAGE = new HashMap<Long, Konyvek>();

    @Override
    public Konyvek save(Konyvek konyvek) {
        Long id = STORAGE.size() +1L;
        konyvek.setId(id);
        STORAGE.put(id, konyvek);
        return STORAGE.get(id);
    }

    @Override
    public Konyvek getById(Long id) {
        return STORAGE.get(id);
    }

    @Override
    public List<Konyvek> getAll() {
        return STORAGE.values().stream().toList();
    }

    @Override
    public Konyvek update(Konyvek konyvek) {
        Long id = konyvek.getId();
        STORAGE.put(id, konyvek);
        return STORAGE.get(id);
    }


    @Override
    public void deleteById(Long id) {
        STORAGE.remove(id);

    }
}
