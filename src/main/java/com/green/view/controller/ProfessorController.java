package com.green.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.green.biz.dto.ProfessorVO;
import com.green.biz.professor.ProfessorService;

@Controller
//@SessionAttributes("professorUser")
public class ProfessorController {
	
	@Autowired
	private ProfessorService professorService;
	
	@RequestMapping(value="/professor_login_form", method=RequestMethod.GET)
	public String loginView() {
		
		return "professor/login";
	}
	
	
	@RequestMapping(value="/professor_login", method=RequestMethod.POST)
	public String loginAction(ProfessorVO vo, Model model) {
		
		ProfessorVO professorUser = null;
			
			int result = professorService.loginID(vo);
			
			if (result == 1) { //로그인 성공
				professorUser = professorService.getProfessor(vo.getPid());
				
				model.addAttribute("professorUser", professorUser);
				
				return "redirect:/index";
			} else  {
				return "professor/login_fail";
			}
	}
	
}
