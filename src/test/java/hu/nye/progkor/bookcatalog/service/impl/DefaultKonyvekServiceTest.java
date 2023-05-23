package hu.nye.progkor.bookcatalog.service.impl;

import hu.nye.progkor.bookcatalog.data.model.Genre;
import hu.nye.progkor.bookcatalog.data.model.Konyvek;
import hu.nye.progkor.bookcatalog.data.repository.Repository;
import hu.nye.progkor.bookcatalog.service.KonyvekService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

/**
 * Unit tests for {@link  DefaultKonyvekService}
 */

class DefaultKonyvekServiceTest {

    private static final Long D_KONYVEK_ID = 1L;
    private static final Konyvek D_KONNYVEK = new Konyvek(D_KONYVEK_ID, "writer", Genre.Fantasy, 2001, 520, "Angel");
    @Mock
    private Repository<Konyvek, Long> konyvekRepository;
    private KonyvekService underTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        underTest = new DefaultKonyvekService(konyvekRepository);
    }

    @Test
    void createKonyvekShouldDelegadeToRepositoryAndReturnSavedKonyvek() {
        //Given
        given(konyvekRepository.save(D_KONNYVEK)).willReturn(D_KONNYVEK);

        //When
        final Konyvek actual = underTest.createKonyvek(D_KONNYVEK);

        //Then
        assertThat(actual, equalTo(D_KONNYVEK));
        verify(konyvekRepository).save(D_KONNYVEK);
        verifyNoMoreInteractions(konyvekRepository);
    }

    @Test
    void retrieveKonyvekById() {
        //Given
        given(konyvekRepository.getById(D_KONYVEK_ID)).willReturn(D_KONNYVEK);

        //when
        final Konyvek actual = underTest.retrieveKonyvekById(D_KONYVEK_ID);

        //then
        assertThat(actual, equalTo(D_KONNYVEK));
        verify(konyvekRepository).getById(D_KONYVEK_ID);
        verifyNoMoreInteractions(konyvekRepository);
    }

    @Test
    void retrieveAllKonyvek() {
        //Given
        given(konyvekRepository.getAll()).willReturn(List.of(D_KONNYVEK));

        //when
        final List<Konyvek> actual = underTest.retrieveAllKonyvek();

        //then
        assertThat(actual, equalTo(List.of(D_KONNYVEK)));
        verify(konyvekRepository).getAll();
        verifyNoMoreInteractions(konyvekRepository);
    }

    @Test
    void updateKonyvek() {
    }

    @Test
    void deleteKonyvekById() {
    }
}