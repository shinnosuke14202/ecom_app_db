package ecom.mobile.app.repository;

import ecom.mobile.app.model.ItemOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemOrderRepository extends JpaRepository<ItemOrder,Integer> {
}
