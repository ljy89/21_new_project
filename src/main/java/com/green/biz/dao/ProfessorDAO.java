package com.green.biz.dao;

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
}
