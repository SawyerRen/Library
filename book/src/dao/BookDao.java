package dao;

import pojo.Book;

import java.awt.*;

import java.util.List;

/**
 * @ClassName BookDao
 * @Description TODO
 * @Author SawyerRen
 * @Date 2020/3/26 17:02
 */
public interface BookDao {

    public int addBook(Book book);

    public int deleteById(Integer id);

    public int updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    Integer queryForPageTotalCount();

    List<Book> queryForPageItems(int begin, int pageSize);

    Integer queryForPageTotalCountByPrice(int min,int max);

    List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max);
}
