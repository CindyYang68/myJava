package tw.com.spring.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import tw.com.spring.web.model.Product;
import tw.com.spring.web.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService pService;
	
	@GetMapping("/showAllProduct") 
	public String showAllProduct(Model model) {
		model.addAttribute("listProduct",pService.getAllProducts());
		return "/admin/list_product";
	}
	
	@GetMapping("/showNewProductForm") 
	public String showNewProductForm(Model model) {
		Product product=new Product();
		model.addAttribute("product",product);
		return "/admin/new_product"; 
	}
	
	@PostMapping("/saveProduct")
	public String addProduct(@ModelAttribute("product")MultipartFile file, Product product)throws IOException  {
		String filePath = "C:\\Code_File\\Java_Servlet_2\\ShopingMall01\\src\\main\\resources\\static\\images";
        
        String originalFilename = file.getOriginalFilename();
        
        String newFileName = UUID.randomUUID() + originalFilename;
        
        File targetFile = new File(filePath, newFileName);
        
        file.transferTo(targetFile);
        product.setImage(newFileName);
        
		pService.addProduct(product);
		return "redirect:/showAllProduct";
	}
	
	@PostMapping("/updateProduct")
	public String updateProduct(@ModelAttribute("product")Product product)throws IOException  {
		pService.addProduct(product);
		return "redirect:/showAllProduct";
	}
	
	@GetMapping("/showProductFormForUpdate/{id}")
	public String showProductFormForUpdate(@PathVariable(value="id")Long id,Model model) {
		Product product=pService.updateProductById(id);
		model.addAttribute("product",product);
		return "/admin/update_product";
	}
	
	@GetMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable(value="id")Long id) {
		this.pService.deleteProduct(id);
		return "redirect:/showAllProduct";
	}
	
	
}
