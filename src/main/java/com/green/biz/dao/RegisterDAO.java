package com.green.biz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.dto.RegisterVO;

@Repository
public class RegisterDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public int selectMaxRseq() {
		return mybatis.selectOne("RegisterDAO.selectMaxRseq");
	}
	
	public void insertRegister(RegisterVO vo) {
		mybatis.insert("RegisterDAO.insertRegister", vo);
	}
	
	public void deleteSubject(int rseq) {
		mybatis.delete("RegisterDAO.deleteSubject" , rseq);
	}
	
	public List<RegisterVO> listRegisterById(String id) {
		
		return mybatis.selectList("RegisterDAO.listRegisterById", id);
	}
	
	public void updateRegisterResult(int rseq) {
		
		mybatis.update("RegisterDAO.updateRegisterResult", rseq);
	
	}
}
