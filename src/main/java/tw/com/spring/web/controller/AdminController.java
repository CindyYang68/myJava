package tw.com.spring.web.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import tw.com.spring.web.model.Admin;
import tw.com.spring.web.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService aService;

	@GetMapping("/register")
	public String viewRegisterPage(Model model) {
		model.addAttribute("titleName", "註冊");
		model.addAttribute("admin", new Admin());
		return "register";
	}

	@PostMapping("/saveAdmin")
	public String registerProcess(@Valid Admin admin, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			String message = Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage();
			redirectAttributes.addFlashAttribute("error", message);
			return "redirect:/register";
		}
		aService.addAdmin(admin);
		return "/login";
	}

	@GetMapping("/loginPage")
	public String viewLoginPage() {

		return "/login";
	}

	@PostMapping(value = "/login")
	public String login(@RequestParam("aName") String aName, @RequestParam("aPassword") String aPassword, Model model) {

		Admin admin = null;

		try {
			admin = aService.loginAdminByName(aName);
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		if (admin == null) {
			return "/login";

		} else {

			if (admin.getName().equals(aName) && admin.getPassword().equals(aPassword)) {

				return "/admin/index";
			} else {
				return "/login";
			}
		}
	}
}
