package web;

import pojo.Book;
import pojo.Page;
import service.BookService;
import service.impl.BookServiceImpl;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class BookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book book = WebUtils.copyParamToBean(request.getParameterMap(), new Book());
        bookService.addBook(book);
//        request.getRequestDispatcher("/manager/bookServlet?action=list").forward(request, response);
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNo="+request.getParameter("pageNo"));
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        bookService.deleteBookById(id);
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page");
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book book = WebUtils.copyParamToBean(request.getParameterMap(), new Book());
        bookService.updateBook(book);
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page");
    }

    protected void getBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        Book book = bookService.queryBookById(id);
        request.setAttribute("book", book);
        request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request, response);
    }

    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = bookService.queryBooks();
        request.setAttribute("books", books);
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
    }

    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Book> page = bookService.page(pageNo, pageSize);
        page.setUrl("manager/bookServlet?action=page");
        request.setAttribute("page", page);
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
    }
}
