package com.green.biz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.dto.ScoreVO;

@Repository
public class ScoreDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	//성적등록
	public void updateScore(ScoreVO vo) {
		mybatis.update("ScoreDAO.updateScore", vo);
	}
	
	//학생 id로 성적 조회
	public List<ScoreVO> getScoreList(String id) {
		
		return mybatis.selectList("ScoreDAO.getScore", id);
	}
	
	public List<ScoreVO> completeStudentList(String name) {
		
		return mybatis.selectList("ScoreDAO.completeStudentList", name);
	}
	
	public List<ScoreVO> subjectListByProfessor(String id) {
		
		return mybatis.selectList("ScoreDAO.subjectListByProfessor", id);
	}
	
}
