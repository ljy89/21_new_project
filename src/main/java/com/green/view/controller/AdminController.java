package com.green.view.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.green.biz.admin.AdminService;
import com.green.biz.dto.AdminVO;
import com.green.biz.dto.QnaVO;
import com.green.biz.dto.StudentVO;
import com.green.biz.qna.QnaService;
import com.green.biz.student.StudentService;

@Controller
@SessionAttributes("adminUser")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private QnaService qnaService;
	
	@Autowired
	private StudentService studentService;
	
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
				
				return "redirect:admin_qna_list";
			} else  {
				return "professor/login_fail";
			}
	}
	
	@RequestMapping(value="admin_qna_list")
	public String adminQnaList(Model model) {
		
		List<QnaVO> qnaList = qnaService.listAllQna();
		
		model.addAttribute("qnaList", qnaList);
		
		return "admin/qna/qnaList";
	}
	
	@RequestMapping(value="admin_qna_detail")
	public String adminQnaAction(QnaVO vo, Model model) {
		
		QnaVO qnaVO = qnaService.getQna(vo.getQseq());
		
		model.addAttribute("qnaVO", qnaVO);
		return "admin/qna/qnaDetail";
	}
	
	@RequestMapping(value="admin_qna_repsave")
	public String adminQnaRepSave(QnaVO vo) {
		
		qnaService.updateQna(vo);
		
		return "redirect:admin_qna_list";
	}
	
	
	@RequestMapping(value="admin_student_list")
	public String adminStudentList(@RequestParam(value="key" , defaultValue="")String sname,
												HttpSession session, Model model) {
		
		AdminVO adminUser = (AdminVO)session.getAttribute("adminUser");
		if(adminUser == null) {
			
			return "admin/login";
		}else {
			
			List<StudentVO> studentList = studentService.listStudent(sname);
			model.addAttribute("studentList", studentList);
			return "admin/qna/memberList";
		}
		
	}
}
