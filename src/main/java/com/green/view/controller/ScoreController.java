package com.green.view.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.biz.dto.ProfessorVO;
import com.green.biz.dto.ScoreVO;
import com.green.biz.dto.StudentVO;
import com.green.biz.score.ScoreService;

@Controller
public class ScoreController {

	@Autowired
	private ScoreService scoreService;
	
	@RequestMapping(value="score_update")
	public String scoreUpdateView(HttpSession session, Model model) {
		
		ProfessorVO professorUser = (ProfessorVO)session.getAttribute("professorUser");
		
		 if(professorUser ==null) {
				return "professor/login";
			}else {
				List<ScoreVO> scoreList = scoreService.subjectListByProfessor(professorUser.getPid());
				model.addAttribute("scoreList", scoreList);
				return "score/subjectList";
			}
		
		
	}
	
	@RequestMapping(value="score_subject_list")
	public String scoreSubjectListView(@RequestParam(value="key", defaultValue="") String key,
									HttpSession session, Model model) {
		
		ProfessorVO professorUser = (ProfessorVO)session.getAttribute("professorUser");
		
		 if(professorUser ==null) {
			return "professor/login";
		}else {
			List<ScoreVO> scoreList = scoreService.subjectByKey(professorUser.getPid(), key);
			model.addAttribute("scoreList", scoreList);
			return "score/subjectList";
		}
		
		
		
	}
	
	@RequestMapping(value="score_student_list")
	public String studentList(@RequestParam(value="sseq", defaultValue="") int sseq,
							HttpSession session, Model model) {
		ProfessorVO professorUser = (ProfessorVO)session.getAttribute("professorUser");
		
		 if(professorUser ==null) {
			return "professor/login";
		}else {
			//System.out.println(sseq);
			List<ScoreVO> scoreList = scoreService.completeStudentList(sseq);
			model.addAttribute("scoreList", scoreList);
			return "score/scoreUpdate";
		}
	}
	
	@RequestMapping(value="score_student_update")
	public String studentScoreUpdateView(@RequestParam(value="rdseq", defaultValue="0") int[] rdseqArr,
										@RequestParam(value="score", defaultValue="0",required=true) int[] scoreArr,
										HttpSession session, Model model,ScoreVO vo) {


		ProfessorVO professorUser = (ProfessorVO)session.getAttribute("professorUser");
		   if(professorUser ==null) {
			return "professor/login";
		}else {
			
			for (int i=0; i<rdseqArr.length; i++) {
				System.out.println("rdseq :"+rdseqArr[i]);
				System.out.println("scor :"+scoreArr[i]);
				
				vo.setRdseq(rdseqArr[i]);
				vo.setScore(scoreArr[i]);
				scoreService.updateScore(vo);
				
			}
			List<ScoreVO> scoreList = scoreService.completeStudentList(vo.getSseq());
			model.addAttribute("scoreList", scoreList);
			
		
			return "score/scoreConfirm";
			
		}
		
	}
	
	
	@RequestMapping(value="/scoreList")
	public String scoreList(HttpSession session, Model model) {
		
		StudentVO loginUser = (StudentVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "student/login";
		}else {	
			
			List<ScoreVO> scoreList = scoreService.confirmMyScore(loginUser.getSid());
			
			model.addAttribute("scoreList", scoreList);
			return "student/scoreList";
		}
		
	}
	
	
}
