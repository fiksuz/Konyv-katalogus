package hu.nye.progkor.bookcatalog.data.repository;

import java.util.List;

/**
 * TODO.
 */
public interface Repository<T, I> {
    T save(T item);

    T getById(I id);

    List<T> getAll();

    T update(T item);

    void deleteById(I id);
}
