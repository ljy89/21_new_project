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
	
	//id濡� �븰�깮 議고쉶
	public StudentVO getStudent(String id) {
		
		return mybatis.selectOne("StudentDAO.getStudent", id);
	}
	
	//紐⑤뱺 �븰�깮 議고쉶
	public List<StudentVO> getStudentList() {
		
		return mybatis.selectList("StudentDAO.getStdentList");
	}
	
	//id 議댁옱�븯�뒗吏� �솗�씤
	public int confirmID(String id) {
		String pwd = mybatis.selectOne("StudentDAO.confirmID", id);
		
		if (pwd!=null) {
			return 1;
		} else {
			return -1;
		}
	}
	
	
	//login �븷�븣 id,pwd �씪移� �솗�씤
	public int loginID(StudentVO vo) {
		
		String pwd = mybatis.selectOne("StudentDAO.confirmID", vo.getSid());
		
		if(pwd==null) {
			return -1; //id 議댁옱�븯吏� �븡�쓬
		}else if(pwd.equals(vo.getPwd())) { //�엯�젰諛쏆� pwd�� id �씪移�
			return 1;
		}else {
			return 0;  //pwd 遺덉씪移�
		}
	}
	
	public void insertStudent(StudentVO vo) {
		
		mybatis.insert("StudentDAO.insertStudent", vo);
	}
	
	public void updateStudent(StudentVO vo) {
		mybatis.update("StudentDAO.updateStudent",vo);
	}
	
	public List<StudentVO> listStudent(String sname){
		
		return mybatis.selectList("StudentDAO.listStudent", sname);
	}
	
}











