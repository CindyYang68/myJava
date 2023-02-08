package tw.com.spring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import tw.com.spring.web.service.ProductService;

@Controller
public class IndexServlet {

	@Autowired
	private ProductService pService;
	
	@GetMapping("/login")
    public String login() {
        return "/admin/index";
    }
	
	@GetMapping({"","/","/index"})
	public String getIndex() {
		return "/admin/index";
	}
	
	@GetMapping("/getShoppingMallPage") 
	public String getShoppingMallPage(Model model) {
		model.addAttribute("productPage",pService.getAllProducts());
		return "/index";
	}
	
}
