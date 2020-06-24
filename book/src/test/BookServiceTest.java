package test;

import org.junit.Test;
import pojo.Book;
import service.BookService;
import service.impl.BookServiceImpl;

import static org.junit.Assert.*;

public class BookServiceTest {
    BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null, "1234", "1234", 999, 10, 0, null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(44);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(44, "lalalaa", "lala", 1000, 20, 20, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(44));
    }

    @Test
    public void queryBooks() {
        for (Book queryBook : bookService.queryBooks()) {
            System.out.println(queryBook);
        }
    }

    @Test
    public void page() {
        System.out.println(bookService.page(1,4));
    }
}