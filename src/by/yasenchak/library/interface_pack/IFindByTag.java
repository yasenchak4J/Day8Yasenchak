package by.yasenchak.library.interface_pack;

import by.yasenchak.library.entity.Book;

import java.util.List;

public interface IFindByTag {
    List<Book> search(String search, List<Book> bookList);
}
