package ecom.mobile.app.repository;

import ecom.mobile.app.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p WHERE p.title LIKE %:keyword% OR p.author LIKE %:keyword%")
    public List<Product> findByTitleOrAuthorLike(String keyword);

    public List<Product> findByTypeIs(int id);

//    public List<Product> findByCategoryName(List<String> categoryNames);

}
