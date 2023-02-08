package tw.com.spring.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.com.spring.web.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
