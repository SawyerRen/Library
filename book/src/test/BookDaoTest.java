package test;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import org.junit.Test;
import pojo.Book;

import java.util.List;

import static org.junit.Assert.*;

public class BookDaoTest {
    private BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(null, "123", "1231", 999, 1000, 0, null));
    }

    @Test
    public void deleteById() {
        bookDao.deleteById(42);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(42, "321", "1231", 999, 1000, 0, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(42));
    }

    @Test
    public void queryBooks() {
        for (Book book : bookDao.queryBooks()) {
            System.out.println(book);
        }
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println(bookDao.queryForPageTotalCount());
    }

    @Test
    public void queryForPageItems() {
        List<Book> books = bookDao.queryForPageItems(0, 4);
        for (Book book : books) {
            System.out.println(book);
        }
    }
}