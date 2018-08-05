package by.yasenchak.library.service.sort;

import by.yasenchak.library.dao.BookListDao;
import by.yasenchak.library.entity.Book;
import by.yasenchak.library.interface_pack.IFindByTag;
import by.yasenchak.library.interface_pack.ISortByTag;

import java.util.Comparator;
import java.util.List;

    public class SortByName implements Comparator<Book>, ISortByTag {

        @Override
        public int compare(Book book, Book book2) {
            return book.getName().compareTo(book2.getName());
        }

    }
