package com.green.biz.score.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.green.biz.dao.ScoreDAO;
import com.green.biz.dto.ScoreVO;
import com.green.biz.score.ScoreService;


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
	public List<ScoreVO> completeStudentList(String name) {
		
		return sDao.completeStudentList(name);
	}

	@Override
	public List<ScoreVO> subjectListByProfessor(String id) {
		
		return sDao.subjectListByProfessor(id);
	}

}
