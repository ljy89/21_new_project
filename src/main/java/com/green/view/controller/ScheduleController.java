package com.green.view.controller;

import java.util.*;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.green.biz.dto.RegisterVO;
import com.green.biz.dto.ScheduleVO;
import com.green.biz.dto.StudentVO;
import com.green.biz.register.RegisterService;


@Controller
public class ScheduleController {
	
	@Autowired
	private RegisterService registerService;
	
	@RequestMapping(value="/time_table")
	public String getTimeTable(HttpSession session, Model model) {
		
		StudentVO loginUser = (StudentVO) session.getAttribute("loginUser");
		
		List<ScheduleVO> scheList = new ArrayList<>();
		String[][] timeTable = new String[9][5];	// 시간표 배열
		String[] weekDay = {"월", "화", "수", "목", "금"}; // 요일이 저장된 배열
		
		if (loginUser == null) {
			return "student/login";
		} else {
			for(int i=0; i<timeTable.length; i++) {
				timeTable[i] = new String[5];
			}
			
			// 수강신청 테이블에서 수강신청 목록을 읽는다.
			// 이 소스는 테이블이 없어서 강제로 리스트에 설정해 준거에요
			// 수강신청 목록에는 과목, 수업시간이 있다고 가정
			
			List<RegisterVO> registerList = registerService.listRegisterById(loginUser.getSid());
			
			
			model.addAttribute("registerList", registerList);
			
			for(RegisterVO register : registerList) {
				
				ScheduleVO sVO = new ScheduleVO(register.getSubname(), register.getTime());
				scheList.add(sVO);
				
			}
			
		
		}
		
		
		// 여기 까지가 수강신청 목록 읽어온 부분
		
		// 수강신청 List에서 하나씩 수강신청 과목을 읽어서 배열에 저장
		for(ScheduleVO vo : scheList) {
			
			int col = 0;	// col은 요일문자를 정수로 저장하는 변수: 월->0, 화->1, 수->2 등등
			for (int i=0; i < weekDay.length; i++) {
				//System.out.println();
				// 수업시간(예: 월123)을 읽어서 첫번째 문자인 요일값을 가져와 배열의 열번호로 변환 
				if (weekDay[i].equals(vo.getAssigned_class().substring(0,1))) {
					col = i; // 수업시간이 '월'이면 col 값이 0으로 저장됨 
					break;
				}
			}
			// 여기까지가 timTable[?][0]이 결정된 것임. => 월요일이므로
			
			System.out.println("column="+col);
			// 그리고 수업시간 "월123"에서 나머지 "123"값을 추출하여 배열에 과목 저장
			for (int i=1; i<vo.getAssigned_class().length(); i++) {
				// '123'을 차례로 읽어옴. 그리고 문자를 숫자로 변환하여 row에 저장
				int row = vo.getAssigned_class().charAt(i)-'0'-1;
				//System.out.println("row="+row);
				timeTable[row][col] = vo.getSubject();
			}
			// 여기 까지 수행하면 한 과목에 대한 시간표가 저장됨
			System.out.println();
		}
		// 이 부분은 timeTable 데이터 확인용임
		System.out.println("<<< 시간표 >>>\n         ");
		for(int i=0; i<weekDay.length; i++) {
			System.out.printf("      %4s      ", weekDay[i]);
		}
		System.out.println("\n==============================================");

		for(int i=0; i<timeTable.length; i++) {
			System.out.printf("%3d ", i+1);
			for (int j=0; j<timeTable[i].length; j++) {
				if (timeTable[i][j] == null)
					System.out.print("[        ]");
				else
					System.out.printf("[%6s]", timeTable[i][j]);
			}
			System.out.println();
		}
		// timeTable 확인 끝
		
		// 저장된 배열을 화면에 넘김
		model.addAttribute("schedules", timeTable); // 2차원배열 데이터 pass
		
		return "mypage/schedule"; //화면 호출
	}
	
}
