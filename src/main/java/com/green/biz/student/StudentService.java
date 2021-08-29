package com.green.biz.student;

import java.util.*;
import com.green.biz.dto.StudentVO;

public interface StudentService {

	public StudentVO getStudent(String id);
	
	//紐⑤뱺 �븰�깮 議고쉶
	public List<StudentVO> getStudentList();
	
	//id 議댁옱�븯�뒗吏� �솗�씤
	public int confirmID(String id);
	
	//login �븷�븣 id,pwd �씪移� �솗�씤
	public int loginID(StudentVO vo);
	
	public void insertStudent(StudentVO vo);
	
	public void updateStudent(StudentVO vo);
	
	public List<StudentVO> listStudent(String sname);
	
}
