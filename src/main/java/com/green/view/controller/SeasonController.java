package com.green.view.controller;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.green.biz.dto.CartVO;
import com.green.biz.dto.SeasonCartVO;
import com.green.biz.dto.SeasonOrderVO;
import com.green.biz.dto.SeasonSubjectVO;
import com.green.biz.dto.StudentVO;
import com.green.biz.dto.SubjectVO;
import com.green.biz.season.SeasonService;
import com.green.biz.seasoncart.SeasonCartService;
import com.green.biz.seasonorder.SeasonOrderService;
import com.green.biz.utils.Criteria;
import com.green.biz.utils.PageMaker;


@Controller
public class SeasonController {

	@Autowired
	private SeasonService seasonService;
	
	@Autowired
	private SeasonCartService seasonCartService;
	
	@Autowired
	private SeasonOrderService orderService;
	
	@RequestMapping(value="/season_detail")
	public String getSeasonSubject(SeasonSubjectVO vo, Model model) {
		
		SeasonSubjectVO seasonVO = seasonService.getSeasonSubject(vo);
		
		model.addAttribute("seasonVO", seasonVO);
		//System.out.println(vo.getSseq());
		return "season/seasonDetail";
	}
	
	@RequestMapping(value = "season")
	public String seasonList(@RequestParam(value="key", defaultValue="") String key,
									Criteria criteria, HttpSession session, Model model) {
		
		StudentVO loginUser = (StudentVO)session.getAttribute("loginUser");
		
		if (loginUser == null) {
			return "student/login";
		} else {
			List<SeasonSubjectVO> seasonList = seasonService.getSeasonListWithPaging(criteria, key);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(criteria); 
			
			int totalCount = seasonService.countSeasonLisList(key);
			pageMaker.setTotalCount(totalCount);
			System.out.println("PageMaker =" +pageMaker);
			
			model.addAttribute("seasonListSize", seasonList.size());
			model.addAttribute("pageMaker", pageMaker);
			model.addAttribute("seasonList", seasonList);
			
			return "season/seasonSubjectList";
		}
	}
	
	
	// 장바구니에 담기
	@RequestMapping(value="/season_cart_insert", method=RequestMethod.POST)
	public String saesonCartInsert(@RequestParam(value="seseq") int seseq,
									SeasonCartVO vo, Model model, HttpSession session) {
		String url = "student/login";
		
		
		StudentVO loginUser = (StudentVO)session.getAttribute("loginUser");
		
		if (loginUser == null) { //로그인 되있지 않음
			return url;
		} else {
			
			vo.setSid(loginUser.getSid());
			vo.setSeseq(seseq);
			
			seasonCartService.insertCart(vo);
			
			return "redirect:season_cart_list";  
		}
	}
	
	@RequestMapping(value="/season_cart_list")
	public String cartList(HttpSession session, Model model) {
		String url = null;
		
		
		StudentVO loginUser = (StudentVO)session.getAttribute("loginUser");
		
		if (loginUser == null) {
			url = "student/login";
		} else {
			//System.out.println(loginUser.getSid());
			List<SeasonCartVO> sesonCartList = seasonCartService.getSeaonCartList(loginUser.getSid());
			
			
			int totalAmount = 0;
			for (SeasonCartVO vo : sesonCartList) {
				totalAmount += vo.getPrice();
			}
			
			model.addAttribute("sesonCartList", sesonCartList);
			model.addAttribute("totalPrice", totalAmount);
			
			url = "season/cartList";
		}
		
		return url;
	}
	
	@RequestMapping(value="/season_cart_delete")
	public String cartDelete(@RequestParam(value="secseq") int[] secseq) {
		
		for (int i=0; i<secseq.length; i++) {
			System.out.println("season cart seq=" + secseq[i]);
			seasonCartService.deleteCart(secseq[i]);
		}
		
		return "redirect:season_cart_list";
	}
	
	@RequestMapping(value="/order_insert")
	public String orderInsert(@RequestParam(value="secseq") int[] secseqArr,
								SeasonOrderVO vo, HttpSession session, Model model) {
		
		String url = "redirect:order_list";
		int season_order_seq = 0;
		int subTotalPrice = 0;
		
		StudentVO loginUser = (StudentVO)session.getAttribute("loginUser");
		
		if (loginUser == null) {
			url = "student/login";
		} else {
			for (int i=0; i<secseqArr.length; i++) {
				
				subTotalPrice += (int)seasonCartService.getCartPrice(secseqArr[i]);
			
			}
			
			for (int i=0; i<secseqArr.length; i++) {
				
				vo.setSid(loginUser.getSid());
				season_order_seq = orderService.insertOrder(vo);
			
				model.addAttribute("season_order_seq", season_order_seq);

			}
		}
		System.out.println("장바구니에서 넘어온 토탈값"+subTotalPrice);
		model.addAttribute("subTotalPrice", subTotalPrice);
		return url;
	}
	
	@RequestMapping(value="/season_order_insert")
	public String seasonOrderInsert(@RequestParam(value="seseq") int seseq,
									SeasonOrderVO vo, HttpSession session, Model model) {
		
		String url = "redirect:order_list";
		int season_order_seq = 0;
		
		
		StudentVO loginUser = (StudentVO)session.getAttribute("loginUser");
		
		if (loginUser == null) {
			url = "student/login";
		} else {
				//추가 부분
				int subTotalPrice = 0;
						
				subTotalPrice=	(int)seasonService.getPrice(seseq);
				System.out.println("subTotalPrice ="+subTotalPrice);
				//끝
				
				vo.setSid(loginUser.getSid());
				season_order_seq = orderService.goInsertOrder(vo, seseq);
				model.addAttribute("season_order_seq", season_order_seq);
				model.addAttribute("subTotalPrice", subTotalPrice);
			
		}
		
		return url;
	}
	
	@RequestMapping(value="order_list")
	public String myPageAction(@RequestParam(value="subTotalPrice") int subTotalPrice,
								HttpSession session, Model model) {
		
		StudentVO loginUser = (StudentVO)session.getAttribute("loginUser");
		
		if (loginUser == null) {
			return "student/login";
		} else {
			
			
			SeasonOrderVO vo = new SeasonOrderVO();
			vo.setSid(loginUser.getSid());
			vo.setResult("1");
			List<Integer> season_order_seqList = orderService.selectSeqOrdering(vo);
			
			
			List<SeasonOrderVO> orderList = new ArrayList<SeasonOrderVO>();
			
			
			for(int season_order_seq : season_order_seqList) {
				SeasonOrderVO orderVO = new SeasonOrderVO();
				
				orderVO.setSid(loginUser.getSid());
				orderVO.setSeason_order_seq(season_order_seq);
				orderVO.setResult("1");
				
				List<SeasonOrderVO> listBySeoseq = orderService.listOrderById(orderVO);
				
				
				SeasonOrderVO order = new SeasonOrderVO();
			
				order.setSeason_order_seq(listBySeoseq.get(0).getSeason_order_seq());
				order.setIndate(listBySeoseq.get(0).getIndate());
			
				if (listBySeoseq.size() > 1) {
					order.setSeasonname(listBySeoseq.get(0).getSeasonname() + " 외" + (listBySeoseq.size()-1) +"건");
				} else {
					order.setSeasonname(listBySeoseq.get(0).getSeasonname());
				}
				int amount = 0;
				
				for(int i=0; i<listBySeoseq.size(); i++) {
					amount += listBySeoseq.get(i).getPrice();
				}
				
				order.setPrice(amount);
				
				orderList.add(order);
			}
			System.out.println("subTotalPrice :::" +subTotalPrice);
			model.addAttribute("title", "주문 내역 조회");
			model.addAttribute("orderList", orderList);
			model.addAttribute("subTotalPrice", subTotalPrice);
		}
		
		return "season/mypage";
	}
	
	@RequestMapping(value="order_list_view")
	public String myPageView(HttpSession session, Model model) {
		
		StudentVO loginUser = (StudentVO)session.getAttribute("loginUser");
		
		if (loginUser == null) {
			return "student/login";
		} else {
			
			
			SeasonOrderVO vo = new SeasonOrderVO();
			vo.setSid(loginUser.getSid());
			vo.setResult("1");
			List<Integer> season_order_seqList = orderService.selectSeqOrdering(vo);
			
			
			List<SeasonOrderVO> orderList = new ArrayList<SeasonOrderVO>();
			
			
			for(int season_order_seq : season_order_seqList) {
				SeasonOrderVO orderVO = new SeasonOrderVO();
				
				orderVO.setSid(loginUser.getSid());
				orderVO.setSeason_order_seq(season_order_seq);
				orderVO.setResult("1");
				
				List<SeasonOrderVO> listBySeoseq = orderService.listOrderById(orderVO);
				
				
				SeasonOrderVO order = new SeasonOrderVO();
			
				order.setSeason_order_seq(listBySeoseq.get(0).getSeason_order_seq());
				order.setIndate(listBySeoseq.get(0).getIndate());
			
				if (listBySeoseq.size() > 1) {
					order.setSeasonname(listBySeoseq.get(0).getSeasonname() + " 외" + (listBySeoseq.size()-1) +"건");
				} else {
					order.setSeasonname(listBySeoseq.get(0).getSeasonname());
				}
				int amount = 0;
				
				for(int i=0; i<listBySeoseq.size(); i++) {
					amount += listBySeoseq.get(i).getPrice();
				}
				
				order.setPrice(amount);
				
				orderList.add(order);
			}
			
			model.addAttribute("title", "주문 내역 조회");
			model.addAttribute("orderList", orderList);
			
		}
		
		return "season/mypage2";
	}
	
	@RequestMapping(value="/order_detail")
	public String orderDetail(SeasonOrderVO vo, HttpSession session, Model model) {
		
		StudentVO loginUser = (StudentVO)session.getAttribute("loginUser");
		
		if (loginUser == null) {
			return "student/login";
		} else {
			
			vo.setSid(loginUser.getSid());
			vo.setResult("");
			
			List<SeasonOrderVO> orderList = orderService.listOrderById(vo);

			
			SeasonOrderVO orderDetail = new SeasonOrderVO();
			orderDetail.setIndate(orderList.get(0).getIndate());
			orderDetail.setSeason_order_seq(orderList.get(0).getSeason_order_seq());
			orderDetail.setSname(orderList.get(0).getSname());
			orderDetail.setResult(orderList.get(0).getResult());
			
			
			int amount = 0;
			for (int i=0; i<orderList.size(); i++) {
				amount +=  orderList.get(i).getPrice();
			}
			
			model.addAttribute("orderDetail", orderDetail);
			model.addAttribute("totalPrice", amount);
			model.addAttribute("orderList", orderList);
			model.addAttribute("title", "결제 내역(주문 상세 내역)");
			
			return "season/orderDetail";
		}
	}
	
}
