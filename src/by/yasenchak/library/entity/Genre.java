package by.yasenchak.library.entity;

import java.io.Serializable;
import java.util.Objects;

public class Genre implements Serializable {
    private String genre;

    public Genre(String genre){
        this.genre = genre;
    }

    public Genre(){}

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Genre)) return false;
        Genre genre1 = (Genre) o;
        return Objects.equals(genre, genre1.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genre);
    }

    @Override
    public String toString() {
        return genre;
    }
}
