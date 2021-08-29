package com.green.view.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.green.biz.cart.CartService;
import com.green.biz.dto.CartVO;
import com.green.biz.dto.StudentVO;

@Controller
public class CartController {

	@Autowired
	private CartService cartService;
	
	
	@RequestMapping(value="/cart_insert", method=RequestMethod.POST)
	public String cartInsert(CartVO vo, Model model, HttpSession session) {
		String url = null;
		
		
		StudentVO loginUser = (StudentVO) session.getAttribute("loginUser");
		
		
		if (loginUser == null) { 
			
			url = "student/login";
		
		} else {
			vo.setSid(loginUser.getSid()); 
			
			
			//System.out.println(vo);
			cartService.insertCart(vo);
			
			url = "redirect:cart_list";  
		}
		
		return url;
		
	}
	
	@RequestMapping(value="/cart_list")
	public String cartList(HttpSession session, Model model) {
		String url = null;
		
		
		StudentVO loginUser = (StudentVO) session.getAttribute("loginUser");
		
		if (loginUser == null) {
			url = "student/login";
		} else {
			List<CartVO> cartList = cartService.listCart(loginUser.getSid());
			
			
			model.addAttribute("cartList", cartList);
			
			url = "cart/cartList";
		}
		
		return url;
	}
	
	@RequestMapping(value="/cart_delete")
	public String cartDelete(@RequestParam(value="cseq") int[] cseq) {
		
		// 숫자 배열에 cseq값을 받아와서 반복문으로 삭제를 진행 한다.(배열에 담아 여러 한번에 삭제 진행 가능 )
		
		for (int i=0; i<cseq.length; i++) {
			System.out.println("cart seq=" + cseq[i]);
			cartService.deleteCart(cseq[i]);
		}
		
		return "redirect:cart_list";
	}
}
