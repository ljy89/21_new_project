package com.green.biz.student;

import java.util.*;
import com.green.biz.dto.StudentVO;

public interface StudentService {

	public StudentVO getStudent(String id);
	
	//모든 학생 조회
	public List<StudentVO> getStudentList();
	
	//id 존재하는지 확인
	public int confirmID(String id);
	
	//login 할때 id,pwd 일치 확인
	public int loginID(StudentVO vo);
	
	public void insertStudent(StudentVO vo);
	
	public void updateStudent(StudentVO vo);
}
