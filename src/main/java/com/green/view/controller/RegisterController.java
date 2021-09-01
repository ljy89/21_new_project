package com.green.view.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.biz.cart.CartService;
import com.green.biz.dto.CartVO;
import com.green.biz.dto.RegisterVO;
import com.green.biz.dto.StudentVO;
import com.green.biz.register.RegisterService;

@Controller
public class RegisterController {

	@Autowired
	private RegisterService registerService;
	
	@Autowired
	private CartService cartService;
	
	
	@RequestMapping(value="/register_insert")
	public String registerInsert(@RequestParam(value="cseq") int[] cseqArr,
							RegisterVO vo, HttpSession session, Model model, CartVO cVo) {
		
		int rseq = 0;
		int sseq = 0;
		String url = "redirect:register_list";
		
		
		StudentVO loginUser = (StudentVO) session.getAttribute("loginUser");
		
		if(loginUser == null) {
			url = "student/login";
		}else {
			for (int i=0; i<cseqArr.length; i++) {
				System.out.println("cart seq=" + cseqArr[i]);
				
				cVo.setCseq(cseqArr[i]);
				cVo.setSid(loginUser.getSid());
				sseq = cartService.getSseqByCseq(cVo);
				cVo.setSseq(sseq);
				
				CartVO result = cartService.getSseq(cVo);
				
				if(result != null) {
					System.out.println("cart seq=" + cseqArr[i]+"이미 수강 신청되어있습니다.");
				}else {
					vo.setCseq(cseqArr[i]);
					vo.setSid(loginUser.getSid());
					rseq = registerService.insertRegister(vo, cseqArr);
				}
				
			}

			model.addAttribute("rseq" , rseq);
		
		}
		return url;
		
	}
	
	@RequestMapping(value="/register_list")
	public String registerList(@RequestParam(value="rseq") int rseq, HttpSession session,
								RegisterVO register, Model model) {
		
		StudentVO loginUser = (StudentVO) session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "studnet/login";
		}else {
			//register.setSid(loginUser.getSid());
			//register.setRdseq(rseq);
			//register.setResult("1");
			
			List<RegisterVO> registerList = registerService.listRegisterById(loginUser.getSid());
			
			model.addAttribute("registerList", registerList);
		
		return "cart/mySubjectList";
		}
	}
	@RequestMapping(value="/go_register_insert")
	public String registerInsert(@RequestParam(value="sseq") int sseq,
									RegisterVO vo, HttpSession session, Model model) {
		
		int rseq = 0;
		String url = "redirect:register_list";
		
		
		StudentVO loginUser = (StudentVO) session.getAttribute("loginUser");
		
		if(loginUser == null) {
			url = "student/login";
		}else {
			vo.setSseq(sseq);
			vo.setSid(loginUser.getSid());
			rseq = registerService.goInsertRegister(vo,sseq);
			model.addAttribute("rseq" , rseq);
		
			
		}
		return url;
		
	}
	
	
	  
	@RequestMapping(value="/my_register_list")
	public String cartList(HttpSession session, Model model,RegisterVO vo) {
		String url = null;
	
		StudentVO loginUser = (StudentVO) session.getAttribute("loginUser");
		
		if (loginUser == null) {
			url = "student/login";
		} else {
			List<RegisterVO> registerList = registerService.listRegisterById(loginUser.getSid());
			
			
			model.addAttribute("registerList", registerList);
			
			url = "cart/mySubjectList";
		}
		
		return url;
	}
	 
	
	
	@RequestMapping(value="go_register_delete")
	public String deleteSubject(@RequestParam(value="rdseq") int[] rdseqArr,
								HttpSession session , RegisterVO vo, Model model) {
		
		StudentVO loginUser = (StudentVO) session.getAttribute("loginUser");
		
		if (loginUser == null) {
			return "student/login";
		
		} else {
			for(int i=0; i<rdseqArr.length; i++) {
				System.out.println("register rdseq ="+ rdseqArr[i]);
				registerService.deleteSubject(rdseqArr[i]);
			}
			
			List<RegisterVO> registerList = registerService.listRegisterById(loginUser.getSid());
			
			
			model.addAttribute("registerList", registerList);
			
			return "cart/mySubjectList";
		}
	}
}
