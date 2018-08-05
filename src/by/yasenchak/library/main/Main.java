package by.yasenchak.library.main;

import by.yasenchak.library.dao.BookListDao;
import by.yasenchak.library.entity.Author;
import by.yasenchak.library.entity.Book;
import by.yasenchak.library.entity.Genre;
import by.yasenchak.library.service.BookListDaoArrayList;
import by.yasenchak.library.service.BookListDaoFile;
import by.yasenchak.library.service.searchByTag.SearchByName;
import by.yasenchak.library.service.sort.SortByName;
import by.yasenchak.library.service.sort.SortByPageCount;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Book book = new Book(new Author("Stephen Edwin King"), 321, 1234567, new Genre("Horrors"), "Pet cemetery");
        Book book2 = new Book(new Author("Yasenchak"), 123, 654321, new Genre("Fantasy"), "Azerb");
        Book book3 = new Book(new Author("George Orwe"), 318, 122341124, new Genre("Fantasy"), "1948");
        BookListDao bookListDao = new BookListDao(new BookListDaoFile());
        bookListDao.addBook(book);
        bookListDao.addBook(book2);
        bookListDao.addBook(book3);
        bookListDao.removeBook(book);
        bookListDao.sortByTag(new SortByName());
        bookListDao.getAllBook();
        List<Book> searh = bookListDao.findByTag("Azerb",new SearchByName());
        System.out.println("Find: " + searh);
//        Alternative
//        BookListDao bookListDao = new BookListDao();
//        bookListDao.addBook(book);
//        bookListDao.addBook(book2);
//        bookListDao.addBook(book3);
//        bookListDao.removeBook(book);
//        bookListDao.sortByTag(new SortByPageCount());
//        bookListDao.getAllBook();
//        List<Book> searh = bookListDao.findByTag("Azerb",new SearchByAuthor());
//        System.out.println("Find: " + searh);
    }
}
