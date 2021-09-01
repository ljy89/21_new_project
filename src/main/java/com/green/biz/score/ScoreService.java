package com.green.biz.score;

import java.util.List;

import com.green.biz.dto.ScoreVO;
import com.green.biz.dto.StudentVO;
import com.green.biz.utils.Criteria;

public interface ScoreService {

	public void updateScore(ScoreVO vo);
	
	//�븰�깮 id濡� �꽦�쟻 議고쉶
	public List<ScoreVO> getScoreList(String id);
	
	public List<ScoreVO> completeStudentList(int sseq);
	
	public List<ScoreVO> subjectListByProfessor(String id);
	
	public List<ScoreVO> subjectByKey(String pid, String key);
	
	public int getSore(int rdseq);
	
	public List<ScoreVO> confirmMyScore(String sid);
	
	public List<ScoreVO> subjectListByProfessorWithPaging(Criteria criteria, String pid);
	
	public int countScoreSubList(String pid);
}
