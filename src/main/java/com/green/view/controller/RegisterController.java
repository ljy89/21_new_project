package com.green.view.controller;

import java.util.ArrayList;
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
import com.green.biz.dto.ScheduleVO;
import com.green.biz.dto.StudentVO;
import com.green.biz.dto.SubjectVO;
import com.green.biz.register.RegisterService;
import com.green.biz.subject.SubjectService;

@Controller
public class RegisterController {

	@Autowired
	private RegisterService registerService;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private SubjectService subjectService;
	
	@RequestMapping(value="/register_insert")
	public String registerInsert(@RequestParam(value="cseq") int[] cseqArr,
								RegisterVO vo, HttpSession session, Model model, 
								CartVO cVo, SubjectVO subVo) {
		
		List<ScheduleVO> scheList = new ArrayList<>();
		int rseq = 0;
		int sseq = 0;
		String url = "redirect:register_list";
		String time = null;
		boolean flag = true;
		String message = null;
		
		StudentVO loginUser = (StudentVO) session.getAttribute("loginUser");
		
		if(loginUser == null) { //로그인이 안되어있으면 로그인 페이지로 이동
			url = "student/login";
		}else {
			for (int i=0; i<cseqArr.length; i++) { //cssArr 배열 수만큼 반복
				System.out.println("cart seq=" + cseqArr[i]);
				
				cVo.setCseq(cseqArr[i]); //장바구니 객체에 화면에서 들어온 cseq 저장
				cVo.setSid(loginUser.getSid()); //로그인한 sid 저장
				sseq = cartService.getSseqByCseq(cVo); //sid와 cseq로 sseq 조회
				cVo.setSseq(sseq); // cvo객체에 조회해온 sseq 저장
				
				CartVO result = cartService.getSseq(cVo); // 수강 신청 테이블에 해당 과목이 수강 되어있는지 조회
				
				if(result != null) { // 이미 수강 신청된 과목 수강 테이블에 insert 하지 않음
					System.out.println("cart seq=" + cseqArr[i]+"이미 수강 신청되어있습니다.");
					message = "이미 수강 신청한 과목입니다";
				}else {
					
					subVo = subjectService.getSubjectInfo(sseq); // sseq로 과목 정보 모두 조회
					time = subVo.getTime(); // time 타임에 수강하려는 과목의 수강시간을 저장한다
					System.out.println(time);
					
					List<RegisterVO> registerList = registerService.listRegisterById(loginUser.getSid());
					// 해당 학생이 이미 수강한 내용을 리스트에 저장

					for (RegisterVO register : registerList) {

						ScheduleVO sVO = new ScheduleVO(register.getTime()); // 객체에 수강 신청 한 시간들을 모두 저장
						scheList.add(sVO);

					}

					for (ScheduleVO schevo : scheList) {

						if ((time.substring(0, 1)).equals(schevo.getAssigned_class().substring(0, 1))) {
							// 요일이 같다면 123 시간 비교
							for (int n = 1; n < time.length(); n++) {
								for (int m = 1; m < schevo.getAssigned_class().length(); m++) {

									if (time.substring(n, n).equals(schevo.getAssigned_class().substring(m, m))) {
										// 요일이 같고 시간 중복되는 경우가 생기면
										flag = false;
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
						vo.setCseq(cseqArr[i]);
						vo.setSid(loginUser.getSid());
						rseq = registerService.insertRegister(vo, cseqArr);
						System.out.println("insert");
					}

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
