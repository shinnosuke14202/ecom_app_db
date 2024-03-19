package ecom.mobile.app.repository;

import ecom.mobile.app.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query("SELECT o FROM Order o WHERE o.user.id=:uid")
    List<Order> getOrdersByUserId(int uid);

    @Modifying
    @Transactional
    @Query("UPDATE Order o SET o.status=:status WHERE o.id=:oid")
    void updateOrderStatus(int oid, String status);

}
