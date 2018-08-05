package by.yasenchak.library.service;

import by.yasenchak.library.entity.Book;
import by.yasenchak.library.interface_pack.IBookListDao;
import by.yasenchak.library.interface_pack.IFindByTag;
import by.yasenchak.library.interface_pack.ISortByTag;
import by.yasenchak.library.service.sort.SortByName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookListDaoArrayList implements IBookListDao {
    List<Book> bookList = new ArrayList<>();

    @Override
    public void addBook(Book book) {
        if(bookList.contains(book)){
            throw new RuntimeException("This book already exist!");
        } else {
            bookList.add(book);
        }
    }

    @Override
    public void removeBook(Book book) {
        if(bookList.contains(book)) {
            bookList.remove(book);
        } else {
            throw new RuntimeException("There is no book!");
        }
    }

    @Override
    public List<Book> findByTag(String search, IFindByTag findByTag) {
        List<Book> searchList = findByTag.search(search, this.bookList);
        return searchList;
    }

    @Override
    public void sortByTag(ISortByTag sortByTag) {
        Collections.sort(bookList, sortByTag);
    }

    @Override
    public void getAllBook() {
        for (Book book: bookList) {
            System.out.println(book);
        }
    }
}
