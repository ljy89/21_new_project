package com.green.biz.score;

import java.util.List;

import com.green.biz.dto.ScoreVO;

public interface ScoreService {

	public void updateScore(ScoreVO vo);
	
	//학생 id로 성적 조회
	public List<ScoreVO> getScoreList(String id);
	
	public List<ScoreVO> completeStudentList(String name);
	
	public List<ScoreVO> subjectListByProfessor(String id);
}
