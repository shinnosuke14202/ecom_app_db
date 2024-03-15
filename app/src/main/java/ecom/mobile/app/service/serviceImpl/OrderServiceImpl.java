package ecom.mobile.app.service.serviceImpl;

import ecom.mobile.app.model.Order;
import ecom.mobile.app.repository.OrderRepository;
import ecom.mobile.app.service.serviceInterface.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getOrdersByUserId(int uid) {
        return orderRepository.getOrdersByUserId(uid);
    }

    @Override
    public void updateOrderStatus(int oid, String status) {
        orderRepository.updateOrderStatus(oid, status);
    }
}
