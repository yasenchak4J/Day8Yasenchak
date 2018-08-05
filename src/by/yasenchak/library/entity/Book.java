package by.yasenchak.library.entity;

import java.io.Serializable;
import java.util.Objects;

public class Book implements Serializable {

    private Author author;
    private int pageCount;
    private int isbn;
    private Genre genre;
    private String name;

    public Book(Author author, int pageCount, int isbn, Genre genre, String name) {
        this.author = author;
        this.pageCount = pageCount;
        this.isbn = isbn;
        this.genre = genre;
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
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
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return pageCount == book.pageCount &&
                isbn == book.isbn &&
                Objects.equals(author, book.author) &&
                Objects.equals(genre, book.genre) &&
                Objects.equals(name, book.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, pageCount, isbn, genre, name);
    }

    @Override
    public String toString() {
        return "Book name:" + name + " " + "Page count:" + pageCount + " " + "Author:" + author + " " + "Genre:" + genre + " " + "ISBN:" + isbn;
    }
}
