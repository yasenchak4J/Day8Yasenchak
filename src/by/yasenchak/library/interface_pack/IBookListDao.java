package by.yasenchak.library.interface_pack;

import by.yasenchak.library.entity.Book;

import java.io.IOException;
import java.util.List;

public interface IBookListDao {
    void addBook(Book book) throws IOException;
    void removeBook(Book book);
    List<Book> findByTag(String search, IFindByTag findByTag);
    void sortByTag(ISortByTag sortByTag);
    void getAllBook();
}
