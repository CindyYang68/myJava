package tw.com.spring.web.service;

import java.util.List;

import tw.com.spring.web.model.Product;


public interface ProductService {

	List<Product> getAllProducts();
	
	void addProduct(Product product);
	
	Product updateProductById(Long id);
	
	void deleteProduct(Long id);
}
