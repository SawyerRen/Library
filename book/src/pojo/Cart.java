package pojo;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    private Map<Integer, CartItem> items = new LinkedHashMap<>();

    public void addItem(CartItem cartItem) {
        CartItem item = items.get(cartItem.getId());
        if (item == null) {
            items.put(cartItem.getId(), cartItem);
        } else {
            item.setCount(item.getCount() + 1);
            item.setTotalPrice(item.getPrice() * item.getCount());
        }
    }

    public void deleteItem(Integer id) {
        items.remove(id);
    }

    public void clear() {
        items.clear();
        ;
    }

    public void updateCount(Integer id, Integer count) {
        CartItem item = items.get(id);
        if (item != null) {
            item.setCount(count);
            item.setTotalPrice(item.getPrice() * item.getCount());
        }
    }

    public Integer getTotalCount() {
        Integer totalCount = 0;
        for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
            CartItem item = entry.getValue();
            totalCount += item.getCount();
        }
        return totalCount;
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
            CartItem item = entry.getValue();
            totalPrice += item.getPrice();
        }
        return totalPrice;

    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }
}
