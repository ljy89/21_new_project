package com.green.view.controller;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.biz.dto.RegisterVO;
import com.green.biz.dto.StudentVO;
import com.green.biz.dto.SubjectVO;
import com.green.biz.register.RegisterService;
import com.green.biz.subject.SubjectService;
import com.green.biz.utils.Criteria;
import com.green.biz.utils.PageMaker;

@Controller
public class SubjectController {

	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private RegisterService registerService;
	
	@RequestMapping(value="/major", method=RequestMethod.GET)
	public String majorView(SubjectVO vo, Model model) {
		
		
		List<SubjectVO> majorList = subjectService.getMajorList();
		
		model.addAttribute("majorList", majorList);
		
		return "subject/majorList";
	}
	
	@RequestMapping(value="liberalArts", method=RequestMethod.GET)
	public String liberalArtsView(SubjectVO vo, Model model) {
		
		List<SubjectVO> liberalArtsList = subjectService.getLiberalArtsList();
		
		model.addAttribute("liberalArtsList", liberalArtsList);
		
		return "subject/liberalArtsList";
	}
	
	@RequestMapping(value="/major", method=RequestMethod.POST)
	public String majorAction(@RequestParam(value="key", defaultValue="") String key,
							SubjectVO vo, Model model) {
		
		
		List<SubjectVO> majorList = subjectService.searchMajorList(key);
		
		model.addAttribute("majorList", majorList);
		
		return "subject/majorList";
	}
	
	@RequestMapping(value="/liberalArts", method=RequestMethod.POST)
	public String liberalArtsAction(@RequestParam(value="key", defaultValue="") String key,
									SubjectVO vo, Model model) {
		
		List<SubjectVO> liberalArtsList = subjectService.searchLiberalArts(key);
		
		model.addAttribute("liberalArtsList", liberalArtsList);
		
		return "subject/liberalArtsList";
	}
	
	@RequestMapping(value="/subject_detail")
	public String getSubject(SubjectVO vo, Model model) {
		
		SubjectVO subjectVO = subjectService.getSubject(vo);
		
		model.addAttribute("subjectVO", subjectVO);
		//System.out.println(vo.getSseq());
		return "subject/subjectDetail";
	}
	
	
	@RequestMapping(value="major_list")
	public String majorList(@RequestParam(value="key", defaultValue="") String key,
							Criteria criteria, HttpSession session, Model model) {
		
		StudentVO loginUser = (StudentVO)session.getAttribute("loginUser");
		
		if (loginUser == null) {
			return "student/login";
		} else {
			
			List<SubjectVO> majorList = subjectService.getMajorListWithPaging(criteria, key);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(criteria); 
	
			
			int totalCount = subjectService.countMajorList(key);
			pageMaker.setTotalCount(totalCount);
			System.out.println("PageMaker =" +pageMaker);
			
			model.addAttribute("majorListSize", majorList.size());
			model.addAttribute("majorList", majorList);
			model.addAttribute("pageMaker", pageMaker);
			
			return "subject/majorList";
		}
	}
	 
	
	@RequestMapping(value="subject_major_list")
	public String majorSearchList(@RequestParam(value="key", defaultValue="") String key,
									@RequestParam(value="dseq", defaultValue="0") int dseq,
									Criteria criteria, HttpSession session, Model model) {
		
		StudentVO loginUser = (StudentVO)session.getAttribute("loginUser");
		
		if (loginUser == null) {
			return "student/login";
		} else {
			
			List<SubjectVO> majorList = subjectService.getMajorListWithSearch(criteria, key, dseq);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(criteria); 
	
			
			int totalCount = subjectService.countSearchMajorList(key, dseq);
			
			pageMaker.setTotalCount(totalCount);
			System.out.println("PageMaker =" +pageMaker);
			
			model.addAttribute("majorListSize", majorList.size());
			model.addAttribute("majorList", majorList);
			model.addAttribute("pageMaker", pageMaker);
			
			return "subject/majorList";
		}
	}
	
	@RequestMapping(value = "liberalArts_list")
	public String liveralArtsList(@RequestParam(value="key", defaultValue="") String key,
									Criteria criteria, HttpSession session, Model model) {
		
		StudentVO loginUser = (StudentVO)session.getAttribute("loginUser");
		
		if (loginUser == null) {
			return "student/login";
		} else {
			List<SubjectVO> liberalArtsList = subjectService.getliberalArtsListWithPaging(criteria, key);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(criteria); 
			
			int totalCount = subjectService.countliberalArtsLisList(key);
			pageMaker.setTotalCount(totalCount);
			System.out.println("PageMaker =" +pageMaker);
			
			model.addAttribute("liberalArtsListSize", liberalArtsList.size());
			model.addAttribute("pageMaker", pageMaker);
			model.addAttribute("liberalArtsList", liberalArtsList);
			
			return "subject/liberalArtsList";
		}
	}
	/*
	@RequestMapping(value = "subject_liberalArts_list")
	public String liveralArtsSearchList(@RequestParam(value="key", defaultValue="") String key,
									Criteria criteria, HttpSession session, Model model) {
		
		StudentVO loginUser = (StudentVO)session.getAttribute("loginUser");
		
		if (loginUser == null) {
			return "student/login";
		} else {
			List<SubjectVO> liberalArtsList = subjectService.getliberalArtsListWithPaging(criteria, key);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(criteria); 
			
			int totalCount = subjectService.countliberalArtsLisList(key);
			pageMaker.setTotalCount(totalCount);
			System.out.println("PageMaker =" +pageMaker);
			
			model.addAttribute("liberalArtsListSize", liberalArtsList.size());
			model.addAttribute("pageMaker", pageMaker);
			model.addAttribute("liberalArtsList", liberalArtsList);
			
			return "subject/liberalArtsList";
		}
	}
	*/
	@RequestMapping(value="/register_check_form")
	public String idCheckAction(@RequestParam(value="sseq", defaultValue="", required=true) int sseq, 
								HttpSession session,Model model, RegisterVO vo) {
		
		
		StudentVO loginUser = (StudentVO)session.getAttribute("loginUser");
		
			int rseq = 0;
			
			vo.setSseq(sseq);
			vo.setSid(loginUser.getSid());
			
			RegisterVO register = registerService.confirmSseq(vo);
			
			
			if (register != null) {
				model.addAttribute("message", 1);
				model.addAttribute("register", register);
			} else {
				model.addAttribute("message", -1);
				model.addAttribute("register", register);
				
				rseq = registerService.goInsertRegister(vo,sseq);
				model.addAttribute("rseq" , rseq);
			}
			
				model.addAttribute("sseq", sseq);
			
			
			
				return "subject/sseqcheck";
			
			
		
	}
	
	
	
	@RequestMapping(value="/register_check_confirmed", method=RequestMethod.POST)
	public String idCheckConfirmed(@RequestParam(value="sseq", defaultValue="", required=true) int sseq,
								RegisterVO rVo, HttpSession session,Model model, SubjectVO vo) {
		
		int rseq = 0;
		String url = "redirect:register_list";
		
		
		StudentVO loginUser = (StudentVO) session.getAttribute("loginUser");
		
		if(loginUser == null) {
			url = "student/login";
		}else {
			rVo.setSseq(sseq);
			rVo.setSid(loginUser.getSid());
			rseq = registerService.goInsertRegister(rVo,sseq);
			model.addAttribute("rseq" , rseq);
		
			
		}
		return url;
		
	}
	
}
