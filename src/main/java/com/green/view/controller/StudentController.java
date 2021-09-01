package com.green.view.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.green.biz.dto.StudentVO;
import com.green.biz.student.StudentService;


@Controller
@SessionAttributes("loginUser")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	
	
	@RequestMapping(value="/login_form", method=RequestMethod.GET)
	public String loginView() {
		
		return "student/login";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(SessionStatus status) {
		
		status.setComplete();   
		
		return "student/login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginAction(StudentVO vo ,Model model) {
		

			StudentVO loginUser = null;
			
			int result = studentService.loginID(vo);
			
			if (result == 1) { 
				loginUser = studentService.getStudent(vo.getSid());
				
				model.addAttribute("loginUser", loginUser);
				
				return "redirect:/index";
			} else  {
				return "student/login_fail";
			}
		
	}
	
	
	
	@RequestMapping(value="/join" , method=RequestMethod.GET)
	public String joinView() {
		
		return "student/join";
	}
	
	
	
	@RequestMapping(value="/id_check_form", method=RequestMethod.GET)
	public String idCheckView(@RequestParam(value="id", defaultValue="", required=true)
							  String id, Model model) {
		
		model.addAttribute("id", id);
		return "student/idcheck";
	}
	
	
	
	@RequestMapping(value="/id_check_form", method=RequestMethod.POST)
	public String idCheckAction(@RequestParam(value="id", defaultValue="", required=true)
	  							String id, Model model) {
		
		StudentVO user = studentService.getStudent(id);
		
		
		if (user != null) {
			model.addAttribute("message", 1);
		} else {
			model.addAttribute("message", -1);
		}
		
		model.addAttribute("id", id);
		
			return "student/idcheck";
	}
	
	@RequestMapping(value="/id_check_confirmed", method=RequestMethod.GET)
	public String idCheckConfirmed(StudentVO vo, Model model) {
		
		model.addAttribute("id", vo.getSid());
		model.addAttribute("reid", vo.getSid());
		
		return "student/join";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String joinAction(StudentVO vo) {
		
		studentService.insertStudent(vo);
		return "student/login";
	}
	
	@RequestMapping(value="/studentDetail")
	public String studentDetilView(StudentVO vo, HttpSession session, Model model) {
		
		StudentVO loginUser = (StudentVO) session.getAttribute("loginUser");
			
		if (loginUser == null) {
			
			return "student/login";
			
		} else {
			
			StudentVO studentVO =studentService.getStudent(loginUser.getSid());
			model.addAttribute("studentVO",studentVO);
			
			return "student/studentDetail";
		}

	}
	
	@RequestMapping(value="/studentEdit", method=RequestMethod.GET)
	public String studentEditView(StudentVO vo, HttpSession session, Model model) {
		
		StudentVO loginUser = (StudentVO) session.getAttribute("loginUser");
			
		StudentVO studentVO =studentService.getStudent(loginUser.getSid());
		model.addAttribute("studentVO",studentVO);
		
		return "student/studentEdit";

	}
	
	@RequestMapping(value="/studentEditAction", method=RequestMethod.POST)
	public String studentEditAction(@RequestParam(value="email", defaultValue="", required=true)
									String email, 
									@RequestParam(value="phone", defaultValue="", required=true)
		  							String phone,
		  							StudentVO vo, HttpSession session, Model model) {
		
		StudentVO loginUser = (StudentVO) session.getAttribute("loginUser");
		
		
		vo.setSname(loginUser.getSname());
		vo.setDname(loginUser.getDname());
		vo.setSid(loginUser.getSid());
		vo.setEmail(email);
		vo.setPhone(phone);
		
		studentService.updateStudent(vo);
	
		return "student/studentDetail";

	}
	
	
	
}











