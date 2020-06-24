package dao.impl;

import dao.OrderItemDao;
import pojo.OrderItem;

/**
 * @ClassName OrderItemImpl
 * @Description TODO
 * @Author SawyerRen
 * @Date 2020/3/28 15:46
 */
public class OrderItemImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item(`name`,`count`,`price`,`total_price`,`order_id`)" +
                "values(?,?,?,?,?)";
        return update(sql, orderItem.getName(), orderItem.getCount(), orderItem.getPrice(), orderItem.getTotalPrice(), orderItem.getOrderId());
    }
}
