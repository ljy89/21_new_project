package com.green.biz.professor.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.dao.ProfessorDAO;
import com.green.biz.dto.ProfessorVO;
import com.green.biz.professor.ProfessorService;
import com.green.biz.utils.Criteria;

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

	@Override
	public List<ProfessorVO> subjectByProfessor(String pid, String key) {
		
		return pDao.subjectByProfessor(pid, key);
	}

	@Override
	public ProfessorVO ProSubjectDetail(int sseq) {
		
		return pDao.ProSubjectDetail(sseq);
	}

	@Override
	public void sujectUpdate(ProfessorVO vo) {
		
		pDao.sujectUpdate(vo);
	}

	@Override
	public void insertSubject(ProfessorVO vo) {
		pDao.insertSubject(vo);
		
	}

	@Override
	public List<ProfessorVO> subjectByProfessorWithPagin(Criteria criteria, String key, String pid) {
		
		return pDao.subjectByProfessorWithPagin(criteria, key, pid);
	}

	@Override
	public int countByProfessor(String key, String pid) {
		
		return pDao.countByProfessor(key, pid);
	}

	

}
