package com.green.view.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.green.biz.dto.SubjectVO;
import com.green.biz.subject.SubjectService;

@Controller
public class SubjectController {

	@Autowired
	private SubjectService subjectService;
	
	@RequestMapping(value="/major", method=RequestMethod.GET)
	public String majorView(SubjectVO vo, Model model) {
		
		List<SubjectVO> majorList = subjectService.getMajorList();
		
		model.addAttribute("majorList", majorList);
		
		return "subject/majorList";
	}
	
	
	@RequestMapping(value="liberalArts", method=RequestMethod.GET)
	public String liberalArtsView(SubjectVO vo, Model model) {
		
		List<SubjectVO> liberalArtsList = subjectService.getMajorList();
		
		model.addAttribute("liberalArtsList", liberalArtsList);
		
		return "subject/liberalArtsList";
	}
}
