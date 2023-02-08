package tw.com.spring.web.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.spring.web.model.Product;
import tw.com.spring.web.repository.ProductRepository;
import tw.com.spring.web.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository pRepository;
	
	@Override
	public List<Product> getAllProducts() {
		
		return pRepository.findAll();
	}

	@Override
	public void addProduct(Product product) {
		this.pRepository.save(product);
		
	}

	@Override
	public Product updateProductById(Long id) {
		Optional<Product> optional=pRepository.findById(id);
		Product product=null;
		if(optional.isPresent()) {
			product=optional.get();
		}else {
			throw new RuntimeException("找不到 ID:"+id);
		}
		return product;
	}

	@Override
	public void deleteProduct(Long id) {
		
		this.pRepository.deleteById(id);
	}

}
