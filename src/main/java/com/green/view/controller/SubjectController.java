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
import com.green.biz.dto.ScheduleVO;
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
								HttpSession session,Model model, RegisterVO vo, SubjectVO subVo) {
		
		
		StudentVO loginUser = (StudentVO)session.getAttribute("loginUser");
			
			List<ScheduleVO> scheList = new ArrayList<>();
			String time = null;
			int rseq = 0;
			boolean flag = true;
			
			vo.setSseq(sseq);
			vo.setSid(loginUser.getSid());
			
			RegisterVO register = registerService.confirmSseq(vo);
			
			
			if (register != null) {
				model.addAttribute("message", 1);
				model.addAttribute("register", register);
			} else { //수강 신청 한 과목이 아닐때
				
				subVo = subjectService.getSubjectInfo(sseq); // sseq로 과목 정보 모두 조회
				time = subVo.getTime();
				System.out.println(time);
				
				List<RegisterVO> registerList = registerService.listRegisterById(loginUser.getSid());
				// 해당 학생이 이미 수강한 내용을 리스트에 저장

				for (RegisterVO registerVo : registerList) {

					ScheduleVO sVO = new ScheduleVO(registerVo.getTime()); // 객체에 수강 신청 한 시간들을 모두 저장
					scheList.add(sVO);

				}
				
				for (ScheduleVO schevo : scheList) {

					if ((time.charAt(0)) == (schevo.getAssigned_class().charAt(0))) {
						// 요일이 같다면 123 시간 비교
						for (int n = 1; n < time.length(); n++) {
							for (int m = 1; m < schevo.getAssigned_class().length(); m++) {

								if (time.charAt(n) == (schevo.getAssigned_class().charAt(m))) {
									// 요일이 같고 시간 중복되는 경우가 생기면
									flag = false;
									model.addAttribute("message", 0);
									System.out.println("중복되는 시간이 있습니다");
									break; // 수강신청 테이블에 insert 하지 않음

								}

							}
						}
					} else {
						// 요일이 다르면
						continue;
					}

				}
				
				
				if (flag == true) { // 중복되는 시간이 없었으면 insert
					model.addAttribute("message", -1);
					model.addAttribute("register", register);
					
					rseq = registerService.goInsertRegister(vo,sseq);
					model.addAttribute("rseq" , rseq);
					
					System.out.println("insert");
				}
				
				
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
