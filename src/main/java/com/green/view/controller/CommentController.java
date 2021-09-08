package com.green.view.controller;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.green.biz.comment.CommentService;
import com.green.biz.dto.NoticeCommentVO;
import com.green.biz.dto.StudentVO;
import com.green.biz.utils.Criteria;
import com.green.biz.utils.PageMaker;

@RequestMapping("/comments/")
@RestController //데이터를 리턴하는 콘트롤러
public class CommentController {
	
	@Autowired
	private CommentService commentservice;
	
	
	
	@GetMapping(value="/list")
	public Map<String,Object> commentList(@RequestParam(value="nseq")int nseq,
											Criteria criteria, Model model){
		
		Map<String,Object> commentInfo = new HashMap<>();
		
		//List<ProductCommentVO> commentList = commentservice.getCommentList(pseq);
		List<NoticeCommentVO> commentList = commentservice.getCommentListWithPageing(criteria, nseq);
		
		PageMaker pageMaker = new PageMaker();
		
		pageMaker.setCri(criteria);
		
		//int totalComment = commentList.size();
		int totalComment = commentservice.countCommentList(nseq);
		pageMaker.setTotalCount(totalComment);
		
		
		commentInfo.put("total", totalComment);
		commentInfo.put("commentList", commentList);
		commentInfo.put("pageInfo", pageMaker);
		
		return commentInfo;
	}
	
	
	@PostMapping(value="/save")
	public String saveComment(NoticeCommentVO commentVO, HttpSession session) {
		
		StudentVO loginUser = (StudentVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "not_logedin"; 
		}else {
			//작성자는 화면에서 입력되지 않아 로그인 정보에서 가져온다
			commentVO.setWriter(loginUser.getSid());
			
			if(commentservice.saveComment(commentVO) ==1) {
				return "success";
			}else {
				return "fail";
			}
			
			
			
		}
		
		
		
	}
}
