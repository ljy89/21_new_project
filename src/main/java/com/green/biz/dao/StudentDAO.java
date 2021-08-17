package com.green.biz.dao;

import java.util.*;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.dto.StudentVO;

@Repository
public class StudentDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	//id로 학생 조회
	public StudentVO getStudent(String id) {
		
		return mybatis.selectOne("StudentDAO.getStudent", id);
	}
	
	//모든 학생 조회
	public List<StudentVO> getStudentList() {
		
		return mybatis.selectList("StudentDAO.getStdentList");
	}
	
	//id 존재하는지 확인
	public int confirmID(String id) {
		String pwd = mybatis.selectOne("StudentDAO.confirmID", id);
		
		if (pwd!=null) {
			return 1;
		} else {
			return -1;
		}
	}
	
	
	//login 할때 id,pwd 일치 확인
	public int loginID(StudentVO vo) {
		
		String pwd = mybatis.selectOne("StudentDAO.confirmID", vo.getSid());
		
		if(pwd==null) {
			return -1; //id 존재하지 않음
		}else if(pwd.equals(vo.getPwd())) { //입력받은 pwd와 id 일치
			return 1;
		}else {
			return 0;  //pwd 불일치
		}
	}
	
	public void insertStudent(StudentVO vo) {
		
		mybatis.insert("StudentDAO.insertStudent", vo);
	}
	
	public void updateStudent(StudentVO vo) {
		mybatis.update("StudentDAO.updateStudent",vo);
	}
}











