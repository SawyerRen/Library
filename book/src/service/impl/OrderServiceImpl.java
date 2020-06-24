package service.impl;

import dao.OrderDao;
import dao.OrderItemDao;
import dao.impl.OrderDaoImpl;
import dao.impl.OrderItemImpl;
import pojo.Cart;
import pojo.CartItem;
import pojo.Order;
import pojo.OrderItem;
import service.OrderService;

import java.util.Date;
import java.util.Map;

/**
 * @ClassName OrderServiceImpl
 * @Description TODO
 * @Author SawyerRen
 * @Date 2020/3/28 15:55
 */
public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemImpl();

    @Override
    public String createOrder(Cart cart, Integer userId) {
        String orderId = System.currentTimeMillis() + "" + userId;
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);
        orderDao.saveOrder(order);
        for (Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()) {
            CartItem cartItem = entry.getValue();
            OrderItem orderItem = new OrderItem(null, cartItem.getName(), cartItem.getCount(), cartItem.getPrice(), cartItem.getTotalPrice(), orderId);
            orderItemDao.saveOrderItem(orderItem);
        }
        cart.clear();
        return orderId;
    }
}
