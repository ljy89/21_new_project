package com.green.biz.professor;

import java.util.List;

import com.green.biz.dto.ProfessorVO;
import com.green.biz.utils.Criteria;

public interface ProfessorService {

	public int loginID(ProfessorVO vo);
	
	public ProfessorVO getProfessor(String id);
	
	public List<ProfessorVO> subjectByProfessor(String pid, String key);
	
	public ProfessorVO ProSubjectDetail(int sseq);
	
	public void sujectUpdate(ProfessorVO vo);
	
	public void insertSubject(ProfessorVO vo);
	
	public List<ProfessorVO> subjectByProfessorWithPagin(Criteria criteria, String key, String pid);
	
	public int countByProfessor(String key, String pid);
	
}
