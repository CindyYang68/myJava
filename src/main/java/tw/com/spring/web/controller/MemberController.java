package tw.com.spring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import tw.com.spring.web.model.Member;
import tw.com.spring.web.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService mService;
	
	@GetMapping("/showAllMember") 
	public String showAllMember(Model model) {
		model.addAttribute("listMember",mService.getAllMembers());
		return "/admin/list_member";
	}
	
	@GetMapping("/showNewMemberForm") 
	public String showNewMemberForm(Model model) {
		Member member=new Member();
		model.addAttribute("member",member);
		return "/admin/new_member"; 
	}
	
	@PostMapping("/saveMember")
	public String addMember(@ModelAttribute("member") Member member) {
		mService.addMember(member);
		return "redirect:/showAllMember";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value="id")Long id,Model model) {
		Member member=mService.updateMemberById(id);
		model.addAttribute("member",member);
		return "/admin/update_member";
	}
	
	@GetMapping("/deleteMember/{id}")
	public String deleteMember(@PathVariable(value="id")Long id) {
		this.mService.deleteMember(id);
		return "redirect:/showAllMember";
	}
	
	
	
}
