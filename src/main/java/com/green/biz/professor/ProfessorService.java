package com.green.biz.professor;

import com.green.biz.dto.ProfessorVO;

public interface ProfessorService {

	public int loginID(ProfessorVO vo);
	public ProfessorVO getProfessor(String id);
}
