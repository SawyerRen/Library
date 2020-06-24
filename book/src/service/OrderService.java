package service;

import pojo.Cart;

/**
 * @ClassName OrderService
 * @Description TODO
 * @Author SawyerRen
 * @Date 2020/3/28 15:54
 */
public interface OrderService {
    String createOrder(Cart cart,Integer userId);
}
