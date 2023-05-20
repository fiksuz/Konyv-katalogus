package hu.nye.progkor.bookcatalog.service.impl;

import hu.nye.progkor.bookcatalog.data.model.Genre;
import hu.nye.progkor.bookcatalog.data.model.Konyvek;
import hu.nye.progkor.bookcatalog.data.repository.Repository;
import hu.nye.progkor.bookcatalog.service.KonyvekService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

/**
 * Unit tests for {@link  DefaultKonyvekService}
 */

class DefaultKonyvekServiceTest {

    private static final  Long DUMMY_KONYVEK_ID = 1L;
   private static final Konyvek DUMMY_KONNYVEK = new Konyvek(DUMMY_KONYVEK_ID, "writer", Genre.Fantasy,2001,520, "Angel");
    @Mock
    private Repository<Konyvek, Long> koynvekRepository;
    private KonyvekService underTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        underTest = new DefaultKonyvekService(koynvekRepository);
    }

    @Test
    void createKonyvekShouldDelegadeToRepositoryAndReturnSavedKonyvek() {
        //Given
        given(koynvekRepository.save(DUMMY_KONNYVEK)).willReturn(DUMMY_KONNYVEK);

        //When
        final Konyvek actual = underTest.createKonyvek(DUMMY_KONNYVEK);

        //Then
        assertThat(actual, equalTo(DUMMY_KONNYVEK));
        verify(koynvekRepository).save(DUMMY_KONNYVEK);
        verifyNoMoreInteractions(koynvekRepository);
    }

    @Test
    void retrieveKonyvekById() {
    }

    @Test
    void retrieveAllKonyvek() {
    }

    @Test
    void updateKonyvek() {
    }

    @Test
    void deleteKonyvekById() {
    }
}