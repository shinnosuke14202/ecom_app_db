package ecom.mobile.app.service.serviceInterface;

import ecom.mobile.app.model.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order);

    List<Order> getAllOrder();

    List<Order> getOrdersByUserId(int uid);

    void updateOrderStatus(int oid, String status);

}
