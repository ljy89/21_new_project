package com.green.view.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.green.biz.announcement.AnnouncementService;
import com.green.biz.dto.AnnouncementVO;
import com.green.biz.dto.NoticeVO;
import com.green.biz.notice.NoticeService;

@Controller
public class HomeController {

	@Autowired
	private AnnouncementService annoucemanetService;
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String home(Model model) {
		
		List<AnnouncementVO> annList = annoucemanetService.indexAcc();
		List<NoticeVO> noticeList = noticeService.indexnotice();
		
		model.addAttribute("annListSize", annList.size());
		model.addAttribute("annList", annList);
		
		model.addAttribute("noticeListSize", noticeList.size());
		model.addAttribute("noticeList", noticeList);
		
		return "index"; // index.jsp 
	}
}

