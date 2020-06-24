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

/**
 * @ClassName ClientBookServlet
 * @Description TODO
 * @Author SawyerRen
 * @Date 2020/3/27 12:32
 */
public class ClientBookServlet extends BookServlet {
    private BookService bookService = new BookServiceImpl();

    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Book> page = bookService.page(pageNo, pageSize);
        page.setUrl("client/bookServlet?action=page");
        request.setAttribute("page", page);
        request.getRequestDispatcher("/pages/client/client_index.jsp").forward(request, response);
    }

    protected void pageByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtils.parseInt(request.getParameter("min"), 0);
        int max = WebUtils.parseInt(request.getParameter("max"), Integer.MAX_VALUE);
        Page<Book> page = bookService.pageByPrice(pageNo, pageSize, min, max);
        StringBuilder builder = new StringBuilder("client/bookServlet?action=pageByPrice");
        if (request.getParameter("min") != null) {
            builder.append("&min=").append(request.getParameter("min"));
        }
        if (request.getParameter("max") != null) {
            builder.append("&max=").append(request.getParameter("max"));
        }
        page.setUrl(builder.toString());
        request.setAttribute("page", page);
        request.getRequestDispatcher("/pages/client/client_index.jsp").forward(request, response);
    }
}
