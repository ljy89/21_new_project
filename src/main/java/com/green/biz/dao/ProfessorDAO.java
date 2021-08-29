package com.green.biz.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.dto.ProfessorVO;

@Repository
public class ProfessorDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public int loginID(ProfessorVO vo) {
		
		String pwd = mybatis.selectOne("ProfessorDAO.professorCheck", vo.getPid());
		
		if(pwd == null) {
			return -1;
		}else if(pwd.equals(vo.getPwd())){
			return 1;
		}else {
			return 0;
		}
	}
	
	public ProfessorVO getProfessor(String id){
		
		return mybatis.selectOne("ProfessorDAO.getProfessor", id);
	}
	
	public List<ProfessorVO> subjectByProfessor(String pid, String key){
		HashMap<String, Object> map = new HashMap<>();
		map.put("pid", pid);
		map.put("key", key);
		
		return mybatis.selectList("ProfessorDAO.subjectByProfessor", map);
	}
	
	public ProfessorVO ProSubjectDetail(int sseq) {
		
		return mybatis.selectOne("ProfessorDAO.ProSubjectDetail", sseq);
	}
	
	public void sujectUpdate(ProfessorVO vo) {
		mybatis.update("ProfessorDAO.sujectUpdate", vo);
	}
	
	public void insertSubject(ProfessorVO vo) {
		mybatis.insert("ProfessorDAO.insertSubject", vo);
	}
}
