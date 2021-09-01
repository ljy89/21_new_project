package com.green.biz.score.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.green.biz.dao.ScoreDAO;
import com.green.biz.dto.ScoreVO;
import com.green.biz.dto.StudentVO;
import com.green.biz.score.ScoreService;
import com.green.biz.utils.Criteria;


@Service("scoreService")
public class ScoreServiceImpl implements ScoreService {
	
	@Autowired
	private ScoreDAO sDao;
	
	@Override
	public void updateScore(ScoreVO vo) {
		sDao.updateScore(vo);
	}

	@Override
	public List<ScoreVO> getScoreList(String id) {
		
		return sDao.getScoreList(id);
	}

	@Override
	public List<ScoreVO> completeStudentList(int sseq) {
		
		return sDao.completeStudentList(sseq);
	}

	@Override
	public List<ScoreVO> subjectListByProfessor(String id) {
		
		return sDao.subjectListByProfessor(id);
	}

	@Override
	public List<ScoreVO> subjectByKey(String pid, String key) {
		
		return sDao.subjectByKey(pid, key);
	}

	@Override
	public int getSore(int rdseq) {
		
		return sDao.getSore(rdseq);
	}

	@Override
	public List<ScoreVO> confirmMyScore(String sid) {
		
		return sDao.confirmMyScore(sid);
	}

	@Override
	public List<ScoreVO> subjectListByProfessorWithPaging(Criteria criteria, String pid) {
		
		return sDao.subjectListByProfessorWithPaging(criteria, pid);
	}

	@Override
	public int countScoreSubList(String pid) {
		
		return sDao.countScoreSubList(pid);
	}

	

}
