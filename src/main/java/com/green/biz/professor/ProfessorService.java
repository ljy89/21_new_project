package com.green.biz.professor;

import java.util.List;

import com.green.biz.dto.ProfessorVO;

public interface ProfessorService {

	public int loginID(ProfessorVO vo);
	
	public ProfessorVO getProfessor(String id);
	
	public List<ProfessorVO> subjectByProfessor(String pid, String key);
	
	public ProfessorVO ProSubjectDetail(int sseq);
	
	public void sujectUpdate(ProfessorVO vo);
	
	public void insertSubject(ProfessorVO vo);
}
