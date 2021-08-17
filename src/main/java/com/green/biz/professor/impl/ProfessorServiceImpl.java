package com.green.biz.professor.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.dao.ProfessorDAO;
import com.green.biz.dto.ProfessorVO;
import com.green.biz.professor.ProfessorService;

@Service("professorService")
public class ProfessorServiceImpl implements ProfessorService {

	@Autowired
	private ProfessorDAO pDao;
	
	@Override
	public int loginID(ProfessorVO vo) {
		
		return pDao.loginID(vo);
	}

	@Override
	public ProfessorVO getProfessor(String id) {
		
		return pDao.getProfessor(id);
	}

}
