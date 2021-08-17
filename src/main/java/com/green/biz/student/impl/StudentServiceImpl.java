package com.green.biz.student.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.dao.StudentDAO;
import com.green.biz.dto.StudentVO;
import com.green.biz.student.StudentService;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDAO sDao;
	
	@Override
	public StudentVO getStudent(String id) {
		
		return sDao.getStudent(id);
	}

	@Override
	public List<StudentVO> getStudentList() {
		
		return sDao.getStudentList();
	}

	@Override
	public int confirmID(String id) {
		
		return sDao.confirmID(id);
	}

	@Override
	public int loginID(StudentVO vo) {
		
		return sDao.loginID(vo);
	}

	@Override
	public void insertStudent(StudentVO vo) {
		
		sDao.insertStudent(vo);
	}

	@Override
	public void updateStudent(StudentVO vo) {
		
		sDao.updateStudent(vo);

	}

}
