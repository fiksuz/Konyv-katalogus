package hu.nye.progkor.bookcatalog.data.model;

import java.util.Objects;

/**
 * Model osztaly a konyveknek
 */
public class Konyvek {
    private Long Id;
    private String writer;
    private Genre genre;
    private int releasedate;
    private int pages;
    private String name;

    public Konyvek(Long id, String writer, Genre genre, int releasedate, int pages, String name) {
        Id = id;
        this.writer = writer;
        this.genre = genre;
        this.releasedate = releasedate;
        this.pages = pages;
        this.name = name;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(int releasedate) {
        this.releasedate = releasedate;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Konyvek konyvek = (Konyvek) o;

        if (releasedate != konyvek.releasedate) return false;
        if (pages != konyvek.pages) return false;
        if (!Objects.equals(Id, konyvek.Id)) return false;
        if (!Objects.equals(writer, konyvek.writer)) return false;
        if (genre != konyvek.genre) return false;
        return Objects.equals(name, konyvek.name);
    }

    @Override
    public int hashCode() {
        int result = Id != null ? Id.hashCode() : 0;
        result = 31 * result + (writer != null ? writer.hashCode() : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        result = 31 * result + releasedate;
        result = 31 * result + pages;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Konyvek{" +
                "Id=" + Id +
                ", writer='" + writer + '\'' +
                ", genre=" + genre +
                ", releasedate=" + releasedate +
                ", pages=" + pages +
                ", name='" + name + '\'' +
                '}';
    }
}
