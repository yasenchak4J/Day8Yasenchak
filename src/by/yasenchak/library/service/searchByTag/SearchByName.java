package by.yasenchak.library.service.searchByTag;

import by.yasenchak.library.entity.Book;
import by.yasenchak.library.interface_pack.IFindByTag;

import java.util.ArrayList;
import java.util.List;

public class SearchByName implements IFindByTag {
    @Override
    public List<Book> search(String search, List<Book> bookList) {
        List<Book> searchBook = new ArrayList<>();
        for (Book book: bookList) {
            if(book.getName().equals(search)){
                searchBook.add(book);
            }
        }
        return searchBook;
    }
}
