package web;

import pojo.Cart;
import pojo.User;
import service.OrderService;
import service.impl.OrderServiceImpl;
import utils.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName OrderServlet
 * @Description TODO
 * @Author SawyerRen
 * @Date 2020/3/28 16:09
 */
public class OrderServlet extends BaseServlet {
    private OrderService orderService = new OrderServiceImpl();

    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        User loginUser = (User) req.getSession().getAttribute("user");
        Integer id = loginUser.getId();
        String orderId = orderService.createOrder(cart, id);

        req.setAttribute("orderId", orderId);
        req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req, resp);
    }
}
