package by.yasenchak.library.dao;

import by.yasenchak.library.entity.Book;
import by.yasenchak.library.interface_pack.IBookListDao;
import by.yasenchak.library.interface_pack.IFindByTag;
import by.yasenchak.library.interface_pack.ISortByTag;
import by.yasenchak.library.service.BookListDaoArrayList;
import by.yasenchak.library.service.searchByTag.SearchByName;
import by.yasenchak.library.service.sort.SortByName;

import java.io.IOException;
import java.util.List;

public class BookListDao {

    private IBookListDao iBookListDao;

    public BookListDao(){
        iBookListDao = new BookListDaoArrayList();
    }

    public BookListDao(IBookListDao iBookListDao){
        this.iBookListDao = iBookListDao;
    }

    public void addBook(Book book) {
        try {
            iBookListDao.addBook(book);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeBook(Book book){
        iBookListDao.removeBook(book);
    }

    public List<Book> findByTag(String search, IFindByTag findByTag){
        return iBookListDao.findByTag(search, findByTag);
    }

    public void sortByTag(ISortByTag sortByTag){
        iBookListDao.sortByTag(sortByTag);
    }

    public void getAllBook(){
        iBookListDao.getAllBook();
    }

    public List<Book> findByTag(String search){
        IFindByTag findByTag = new SearchByName();
        return iBookListDao.findByTag(search, findByTag);
    }

    public void sortByTag(){
        ISortByTag sortByTag = new SortByName();
        iBookListDao.sortByTag(sortByTag);
    }

}
