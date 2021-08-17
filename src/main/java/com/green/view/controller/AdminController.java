package com.green.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.green.biz.admin.AdminService;
import com.green.biz.dto.AdminVO;

@Controller
//@SessionAttributes("adminUser")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value="/admin_login_form", method=RequestMethod.GET)
	public String loginView() {
		
		return "admin/login";
	}
	
	
	@RequestMapping(value="/admin_login", method=RequestMethod.POST)
	public String loginAction(AdminVO vo, Model model) {
		
		AdminVO adminUser = null;
			
			int result = adminService.adminCheck(vo);
			
			if (result == 1) { //로그인 성공
				adminUser = adminService.getAdmin(vo.getAdmin_id());
				
				model.addAttribute("adminUser", adminUser);
				
				return "redirect:/index";
			} else  {
				return "professor/login_fail";
			}
	}
}
