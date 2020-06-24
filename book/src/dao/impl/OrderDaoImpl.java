package dao.impl;

import dao.OrderDao;
import pojo.Order;

/**
 * @ClassName OrderDaoImpl
 * @Description TODO
 * @Author SawyerRen
 * @Date 2020/3/28 15:44
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order(`order_id`,`create_time`,`price`,`status`,`user_id`)" +
                "values(?,?,?,?,?)";
        return update(sql, order.getOrderId(), order.getCreateTime(), order.getPrice(), order.getStatus(), order.getUserId());
    }
}
