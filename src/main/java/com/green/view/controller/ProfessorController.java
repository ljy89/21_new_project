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
import org.springframework.web.bind.support.SessionStatus;

import com.green.biz.dto.ProfessorVO;
import com.green.biz.professor.ProfessorService;

@Controller
@SessionAttributes("professorUser")
public class ProfessorController {
	
	@Autowired
	private ProfessorService professorService;
	
	@RequestMapping(value="/professor_login_form", method=RequestMethod.GET)
	public String loginView() {
		
		return "professor/login";
	}
	
	@RequestMapping(value="professor_logout")
	public String adminLogout(SessionStatus status) {
		
		status.setComplete();
		
		return "redirect:/index";
	}
	
	@RequestMapping(value="/professor_login", method=RequestMethod.POST)
	public String loginAction(ProfessorVO vo, Model model) {
		
		ProfessorVO professorUser = null;
			
			int result = professorService.loginID(vo);
			
			if (result == 1) { //로그인 성공
				professorUser = professorService.getProfessor(vo.getPid());
				
				model.addAttribute("professorUser", professorUser);
				
				return "redirect:pro_subject_list";
			} else  {
				return "professor/login_fail";
			}
	}
	
	@RequestMapping(value="pro_subject_list")
	public String SubjectListView(@RequestParam(value="key", defaultValue="") String key,
									HttpSession session, Model model) {
		
		ProfessorVO professorUser = (ProfessorVO)session.getAttribute("professorUser");
		//System.out.println(professorUser.getPid());
		
		
		  
		 if(professorUser ==null) {
			return "professor/login";
		}else {
			List<ProfessorVO> subjectList = professorService.subjectByProfessor(professorUser.getPid(),key);
			
			model.addAttribute("subjectList", subjectList);
			
			return "professor/subjectList";
		}
	
		
		
	}
	@RequestMapping(value="pro_subject_detail")
	public String ProSubjectDetail(@RequestParam(value="sseq", defaultValue="")int sseq,
									Model model) {
		
		ProfessorVO professorVO =professorService.ProSubjectDetail(sseq);
		
		model.addAttribute("professorVO",professorVO);
		
		return "professor/subjectDetail";
	}
	
	@RequestMapping(value="pro_subject_editionView")
	public String ProSubjectEditView(@RequestParam(value="sseq", defaultValue="")int sseq,
									ProfessorVO vo, Model model) {
		
		ProfessorVO professorVO =professorService.ProSubjectDetail(sseq);
		
		model.addAttribute("professorVO", professorVO);
		return "professor/subjectEdit";
	}
	
	@RequestMapping(value="pro_subject_editionAction")
	public String ProSubjectEdit(@RequestParam(value="sseq", defaultValue="")int sseq,
								@RequestParam(value="majoryn", defaultValue="", required=true)String majoryn,
								@RequestParam(value="subname", defaultValue="", required=true)String subname,
								@RequestParam(value="content", defaultValue="", required=true)String content,
								@RequestParam(value="time", defaultValue="", required=true)String time,
								@RequestParam(value="location", defaultValue="", required=true)String location,
								  ProfessorVO vo) {
		
		ProfessorVO professorVO =professorService.ProSubjectDetail(sseq);
		vo.setContent(content);
		vo.setDname(professorVO.getDname());
		vo.setLocation(location);
		vo.setMajoryn(majoryn);
		vo.setPname(professorVO.getPname());
		vo.setSseq(sseq);
		vo.setSubname(subname);
		vo.setTime(time);
		
		professorService.sujectUpdate(vo);
		
		return "professor/subjectDetail";
	}
	
	@RequestMapping(value="pro_subject_write_form")
	public String subjectWriteView(ProfessorVO vo,HttpSession session, Model model) {

		ProfessorVO professorUser =  (ProfessorVO)session.getAttribute("professorUser");
		
		if(professorUser == null) {
			return "professor/login";
		}else {
			model.addAttribute("professorUser", professorUser);
			
			return "professor/subjectWrite";
		}
		
	}
	
	@RequestMapping(value="pro_subject_write")
	public String subjectWriteAction(@RequestParam(value="majoryn", defaultValue="")String majoryn,
									@RequestParam(value="subname", defaultValue="", required=true)String subname,
									@RequestParam(value="pid", defaultValue="", required=true)String pid,
									@RequestParam(value="content", defaultValue="", required=true)String content,
									@RequestParam(value="time", defaultValue="", required=true)String time,
									@RequestParam(value="location", defaultValue="", required=true)String location,
									@RequestParam(value="dseq", defaultValue="", required=true)int dseq,
									ProfessorVO vo,HttpSession session) {

		ProfessorVO professorUser =  (ProfessorVO)session.getAttribute("professorUser");
		
		if(professorUser == null) {
			return "professor/login";
		}else {
			vo.setMajoryn(majoryn);
			vo.setSubname(subname);
			vo.setPid(pid);
			vo.setContent(content);
			vo.setTime(time);
			vo.setLocation(location);
			vo.setDseq(dseq);
			
			professorService.insertSubject(vo);
			
			return "redirect:pro_subject_list";
		}
		
	}
	
}
