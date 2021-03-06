package com.green.view.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.green.biz.dto.QnaVO;
import com.green.biz.dto.StudentVO;
import com.green.biz.qna.QnaService;

@Controller
public class QnaController {

	@Autowired
	private QnaService qnaService;
	
	@RequestMapping(value="qna_list",method=RequestMethod.GET)
	public String qnaList(HttpSession session, Model model) {
		
		StudentVO loginUser = (StudentVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "student/login";
		}else {
			List<QnaVO> qnaList = qnaService.getMyQnaList(loginUser.getSid());
			
			model.addAttribute("qnaList", qnaList);
			
			return "qna/qnaList";
		}
	}
	
	@RequestMapping(value="qna_write_form",method=RequestMethod.GET)
	public String qnaWriteView(HttpSession session) {
		
		StudentVO loginUser = (StudentVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "student/login";
		}else {
			
			return "qna/qnaWrite";
		}
	}
	
	@RequestMapping(value="qna_write",method=RequestMethod.POST)
	public String qnaWriteAction(HttpSession session, QnaVO vo) {
		
		StudentVO loginUser = (StudentVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "student/login";
		}else {
			vo.setSid(loginUser.getSid());
			
			qnaService.insertQna(vo);
			return "redirect:qna_list";
		}
	}	
		@RequestMapping(value="qna_view",method=RequestMethod.GET)
		public String qnaWriteView(HttpSession session, QnaVO vo, Model model) {
			
			StudentVO loginUser = (StudentVO)session.getAttribute("loginUser");
			
			if(loginUser == null) {
				return "student/login";
			}else {
				
				QnaVO qnaVO = qnaService.getQna(vo.getQseq());
				
				model.addAttribute("qnaVO", qnaVO);
				return "qna/qnaView";
			}
	}
	
}
