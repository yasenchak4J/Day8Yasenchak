package by.yasenchak.library.service;

import by.yasenchak.library.entity.Book;
import by.yasenchak.library.interface_pack.IBookListDao;
import by.yasenchak.library.interface_pack.IFindByTag;
import by.yasenchak.library.interface_pack.ISortByTag;

import java.io.*;
import java.util.*;
import java.util.logging.Logger;

public class BookListDaoFile implements IBookListDao {

    private File file = new File("resurce/BookStore");
    private List<Book> bookList = new ArrayList<>();

    @Override
    public void addBook(Book book){
        try (FileWriter writer = new FileWriter(file, true); Scanner scanner = new Scanner(file)){
            List<String> list = new ArrayList<>();
            while (scanner.hasNextLine()){
                list.add(scanner.nextLine());
            }
            if(list.contains(book.toString())){
                throw new RuntimeException("This book already exist in file!");
            }else {
                writer.write(book.toString());
                writer.append("\n");
                bookList.add(book);
            }
        } catch (IOException e) {
           throw new RuntimeException("File Not Found!");
        }
    }

    @Override
    public void removeBook(Book book) {
        List<String> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }
            if(list.contains(book.toString())){
                list.remove(book.toString());
                bookList.remove(book);
            } else {
                throw new RuntimeException("File haven't this book!");
            }
            try(FileWriter fileWriter = new FileWriter(file, false)){
                for (String bookInList: list) {
                    fileWriter.write(bookInList);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
            try(FileWriter fileWriter = new FileWriter(file, false)){
                for (Book bookInList: bookList) {
                    fileWriter.write(bookInList.toString() + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
    }


    @Override
    public void getAllBook() {
        try(FileReader reader = new FileReader(file)) {
            char[] buf = new char[256];
            int c;
            while((c = reader.read(buf))>0){

                if(c < 256){
                    buf = Arrays.copyOf(buf, c);
                }
                System.out.print(buf);
            }
        } catch (FileNotFoundException e) {
            Logger logger = Logger.getLogger(BookListDaoFile.class.getName());
            logger.info("File not Found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
