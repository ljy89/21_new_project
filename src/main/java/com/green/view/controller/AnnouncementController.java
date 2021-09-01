package com.green.view.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.biz.announcement.AnnouncementService;
import com.green.biz.dto.AdminVO;
import com.green.biz.dto.AnnouncementVO;
import com.green.biz.dto.StudentVO;
import com.green.biz.utils.Criteria;
import com.green.biz.utils.PageMaker;

@Controller
public class AnnouncementController {

	@Autowired
	private AnnouncementService annoucemanetService;
	
	//공지글 전체 목록 조회
	@RequestMapping(value="admin_announcement_list")
	public String adminAnnList(@RequestParam(value="key", defaultValue="") String key,
								HttpSession session, Model model, Criteria criteria) {
		
		AdminVO adminUser = (AdminVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/login";
		}else {
			List<AnnouncementVO> annList = annoucemanetService.getAnnounceListWithPaging(criteria, key);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(criteria); 
			
			int totalCount = annoucemanetService.countAnnounceList(key);
			pageMaker.setTotalCount(totalCount);
			System.out.println("PageMaker =" +pageMaker);
			
			model.addAttribute("annListSize", annList.size());
			model.addAttribute("annList", annList);
			model.addAttribute("pageMaker", pageMaker);
			
			return "admin/announcement/announcementList";
		}

	}
	
	
	@RequestMapping(value="admin_announcement_detail")
	public String adminAnnounceDetail(@RequestParam(value="aseq") int aseq,
										Model model, HttpSession session) {
		AdminVO adminUser = (AdminVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/login";
		}else {
			AnnouncementVO announcementVO = annoucemanetService.getAnnounce(aseq);
			model.addAttribute("announcementVO", announcementVO);
			return "admin/announcement/announcementDetail";
		}
	
	}
	@RequestMapping(value="ann_modify")
	public String annModifyView(@RequestParam(value="aseq") int aseq,
								HttpSession session, Model model) {
		
		AdminVO adminUser = (AdminVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/login";
		}else {
			
			AnnouncementVO announcementVO = annoucemanetService.getAnnounce(aseq);
			model.addAttribute("announcementVO", announcementVO);
			
			return "admin/announcement/announcementUpdate";
		}
	}
	
	@RequestMapping(value="ann_modify_action")
	public String annModifyAcion(@RequestParam(value="aseq") int aseq,
								@RequestParam(value="subject") String subject,
								@RequestParam(value="content") String content,
								HttpSession session, Model model, AnnouncementVO vo) {
		
		AdminVO adminUser = (AdminVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/login";
		}else {
			vo.setSubject(subject);
			vo.setContent(content);
			
			annoucemanetService.updateAnnounce(vo);
			
			AnnouncementVO announcementVO = annoucemanetService.getAnnounce(aseq);
			model.addAttribute("announcementVO", announcementVO);
			
			return "admin/announcement/announcementDetail";
		}
	}
	
	@RequestMapping(value="ann_delete")
	public String AnnDelete(@RequestParam(value="aseq") int aseq, 
							HttpSession session, Model model, AnnouncementVO vo) {
		
		AdminVO adminUser = (AdminVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/login";
		}else {
			
			annoucemanetService.deleteAnnounce(aseq);
			
			return "redirect:admin_announcement_list";
		}
			
	}
	
	@RequestMapping(value="ann_write_form")
	public String annWriteView(HttpSession session) {
		AdminVO adminUser = (AdminVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/login";
		}else {
			
			return "admin/announcement/announcementWrite";
		}
	}
	
	@RequestMapping(value="ann_write")
	public String annWriteAcion(@RequestParam(value="subject") String subject,
								@RequestParam(value="content") String content,
								AnnouncementVO vo, HttpSession session, Model model) {
		
		AdminVO adminUser = (AdminVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/login";
		}else {
			vo.setSubject(subject);
			vo.setContent(content);
			
			annoucemanetService.insertAnnounce(vo);
			
			return "redirect:admin_announcement_list";
		}
	}
	
	
	@RequestMapping(value="announcement_list")
	public String AnnList(@RequestParam(value="key", defaultValue="") String key,
								HttpSession session, Model model, Criteria criteria) {
		
		StudentVO loginUser = (StudentVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "student/login";
		}else {
			List<AnnouncementVO> annList = annoucemanetService.getAnnounceListWithPaging(criteria, key);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(criteria); 
			
			int totalCount = annoucemanetService.countAnnounceList(key);
			pageMaker.setTotalCount(totalCount);
			System.out.println("PageMaker =" +pageMaker);
			
			model.addAttribute("annListSize", annList.size());
			model.addAttribute("annList", annList);
			model.addAttribute("pageMaker", pageMaker);
			
			return "notice/ann/announcementList";
		}

	}
	
	
	@RequestMapping(value="announcement_detail")
	public String AnnounceDetail(@RequestParam(value="aseq") int aseq,
									Model model, HttpSession session) {
		StudentVO loginUser = (StudentVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "student/login";
		}else {
			AnnouncementVO announcementVO = annoucemanetService.getAnnounce(aseq);
			model.addAttribute("announcementVO", announcementVO);
			return "notice/ann/announcementDetail";
		}
	
	}
}
