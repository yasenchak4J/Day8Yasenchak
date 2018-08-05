package by.yasenchak.library.service.sort;

import by.yasenchak.library.entity.Book;
import by.yasenchak.library.interface_pack.ISortByTag;

import java.util.Comparator;

public class SortByPageCount implements Comparator<Book>, ISortByTag {
    @Override
    public int compare(Book book, Book t1) {
        return book.getPageCount() - t1.getPageCount();
    }
}
