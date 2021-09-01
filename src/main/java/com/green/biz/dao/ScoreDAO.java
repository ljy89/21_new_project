package com.green.biz.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.dto.ScoreVO;
import com.green.biz.dto.StudentVO;
import com.green.biz.utils.Criteria;

@Repository
public class ScoreDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	//�꽦�쟻�벑濡�
	public void updateScore(ScoreVO vo) {
		mybatis.update("ScoreDAO.updateScore", vo);
	}
	
	//�븰�깮 id濡� �꽦�쟻 議고쉶
	public List<ScoreVO> getScoreList(String id) {
		
		return mybatis.selectList("ScoreDAO.getScore", id);
	}
	
	public List<ScoreVO> completeStudentList(int sseq) {
		
		return mybatis.selectList("ScoreDAO.completeStudentList", sseq);
	}
	
	public List<ScoreVO> subjectListByProfessor(String id) {
		
		return mybatis.selectList("ScoreDAO.subjectListByProfessor", id);
	}
	
	public List<ScoreVO> subjectByKey(String pid, String key) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("pid", pid);
		map.put("key", key);
		return mybatis.selectList("ScoreDAO.subjectByKey", map);
	}
	
	public int getSore(int rdseq) {
		return mybatis.selectOne("ScoreDAO.getSore", rdseq);
	}
	
	public List<ScoreVO> confirmMyScore(String sid){
		return mybatis.selectList("ScoreDAO.confirmMyScore", sid);
	}
	
	public List<ScoreVO> subjectListByProfessorWithPaging(Criteria criteria, String pid) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("criteria", criteria);
		map.put("pid", pid);
		
		return mybatis.selectList("ScoreDAO.subjectListByProfessorWithPaging", map);
	}
	
	public int countScoreSubList(String pid) {
		
		return mybatis.selectOne("ScoreDAO.countScoreSubList", pid);
	}
}
