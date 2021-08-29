package com.green.view.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.green.biz.dto.NoticeVO;
import com.green.biz.dto.StudentVO;
import com.green.biz.notice.NoticeService;


@Controller
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	
	@RequestMapping(value="board_list", method=RequestMethod.GET)
	public String boardList(HttpSession session, Model model) {
		
		StudentVO loginUser = (StudentVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "student/login";
		}else {
			List<NoticeVO> noticeList = noticeService.getNoticeList();
			model.addAttribute("noticeList", noticeList);
			return "notice/noticeList";
		}

	}
	
	@RequestMapping(value="board_detail", method=RequestMethod.POST)
	public String boardDetail(@RequestParam(value="nseq") int nseq,
							Model model, HttpSession session) {
		StudentVO loginUser = (StudentVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "student/login";
		}else {
			
			NoticeVO noticeVO = noticeService.getNotice(nseq);
			model.addAttribute("noticeVO", noticeVO);
			return "notice/noticeDetail";
		}
	}
	
	@RequestMapping(value = "board_modify")
	public String boardModifyView(@RequestParam(value="nseq") int nseq,
									HttpSession session, Model model) {
		StudentVO loginUser = (StudentVO)session.getAttribute("loginUser");
		if(loginUser == null) {
			return "student/login";
		}else {
			
			NoticeVO noticeVO = noticeService.getNotice(nseq);
			model.addAttribute("noticeVO", noticeVO);
			return "notice/noticeUpdate";
		}
	}
	
	@RequestMapping(value="board_modify_action")
	public String boardModifyAction(@RequestParam(value="nseq") int nseq,
									@RequestParam(value="subject") String subject,
									@RequestParam(value="content") String content,
									HttpSession session, Model model,
									NoticeVO vo) {
		
		StudentVO loginUser = (StudentVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "student/login";
		}else {
			vo.setSubject(subject);
			vo.setContent(content);
			
			noticeService.updateNotice(vo);
			noticeService.getNotice(nseq);
			return "notice/noticeDetail";
		}
	}
	
	@RequestMapping(value="board_delete")
	public String boardDelete(@RequestParam(value="nseq") int nseq, 
							HttpSession session, Model model,
							NoticeVO vo) {
		
		StudentVO loginUser = (StudentVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "student/login";
		}else {
			
			if(vo.getSid().equals(loginUser.getSid())) {
				noticeService.deleteNotice(nseq);
				
				List<NoticeVO> noticeList = noticeService.getNoticeList();
				model.addAttribute("noticeList", noticeList);
				
				return "notice/noticeList";
				
				
			}else {
				List<NoticeVO> noticeList = noticeService.getNoticeList();
				model.addAttribute("noticeList", noticeList);
				
				return "notice/noticeList";
			}
			
		}
	}
	
	@RequestMapping(value="board_write_form")
	public String boardWriteView(HttpSession session) {
		StudentVO loginUser = (StudentVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "student/login";
		}else {

			return "notice/noticeWrite";
		}
	}
	
	
	@RequestMapping(value="board_write")
	public String boardWriteAction(@RequestParam(value="subject") String subject,
									@RequestParam(value="content") String content,
									NoticeVO vo,HttpSession session, Model model) {
		StudentVO loginUser = (StudentVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "student/login";
		}else {
			vo.setSid(loginUser.getSid());
			vo.setSubject(subject);
			vo.setContent(content);
			
			noticeService.insertNotice(vo);
			
			List<NoticeVO> noticeList = noticeService.getNoticeList();
			model.addAttribute("noticeList", noticeList);
			
			return "notice/noticeList";
		}
	}
	
}
