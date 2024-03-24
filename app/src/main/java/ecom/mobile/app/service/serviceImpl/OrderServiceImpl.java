package ecom.mobile.app.service.serviceImpl;

import ecom.mobile.app.model.Order;
import ecom.mobile.app.repository.OrderRepository;
import ecom.mobile.app.service.serviceInterface.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        return orderRepository.getOrdersByUserId(uid).orElse(new ArrayList<>());
    }

    @Override
    public List<Order> getOrdersByUserIdAndStatus(int uid, String status) {
        return orderRepository.findByUserIdAndStatus(uid, status).orElse(new ArrayList<>());
    }

    @Override
    public List<Order> getOrderByUserIdAndProductName(int uid, String productName) {
        return orderRepository.getOrderByUserIdAndProductName(uid, productName);
    }

    @Override
    public Order getOrderById(int oid) {
        return orderRepository.findById(oid).orElse(new Order());
    }

    @Override
    public void updateOrderStatus(int oid, String status) {
        orderRepository.updateOrderStatus(oid, status);
    }
}
