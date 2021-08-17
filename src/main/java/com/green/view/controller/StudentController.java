package com.green.view.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.green.biz.dto.StudentVO;
import com.green.biz.student.StudentService;


@Controller
@SessionAttributes("loginUser")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	//로그인폼 요렁 get 메소드로 들어오면 login 폼으로 페이지 연결
	
	@RequestMapping(value="/login_form", method=RequestMethod.GET)
	public String loginView() {
		
		return "student/login";
	}
	
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginAction(StudentVO vo ,Model model) {
		

			StudentVO loginUser = null;
			
			int result = studentService.loginID(vo);
			
			if (result == 1) { //로그인 성공
				loginUser = studentService.getStudent(vo.getSid());
				
				model.addAttribute("loginUser", loginUser);
				
				return "redirect:/index";
			} else  {
				return "student/login_fail";
			}
		
	}
	
	//회원가입 폼 열기
	
	@RequestMapping(value="/join" , method=RequestMethod.GET)
	public String joinView() {
		
		return "student/join";
	}
	
	
	/*
	 * Id 중복 체크 화면 출력
	 */
	@RequestMapping(value="/id_check_form", method=RequestMethod.GET)
	public String idCheckView(@RequestParam(value="id", defaultValue="", required=true)
							  String id, Model model) {
		
		model.addAttribute("id", id);
		return "student/idcheck";
	}
	
	/*
	 * 사용자 ID 중복 체크
	 * POST 방식 처리
	 * URLL: /id_check_form
	 */
	
	@RequestMapping(value="/id_check_form", method=RequestMethod.POST)
	public String idCheckAction(@RequestParam(value="id", defaultValue="", required=true)
	  							String id, Model model) {
		// 입력된 ID를 가지고 getStudent() 서비스로 조회한 후
		StudentVO user = studentService.getStudent(id);
		
		// 데이터가 있으면 message 속성에 1을 설정
		// 데이터가 옶으면 message 속성에 -1을 설정
		if (user != null) {// 사용자ID가 존재
			model.addAttribute("message", 1);
		} else {
			model.addAttribute("message", -1);
		}
		// id값을 model에 저장하여
		model.addAttribute("id", id);
		// member/idcheck.jsp 화면 리턴
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
	
	@RequestMapping(value="/studentDetail", method=RequestMethod.GET)
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
		
		vo = studentService.getStudent(loginUser.getSid());
		
		vo.setEmail(email);
		vo.setPhone(phone);
		
		studentService.updateStudent(vo);
	
		return "student/studentDetail";

	}
	
}











