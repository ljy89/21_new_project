package com.green.biz.subject.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.dao.SubjectDAO;
import com.green.biz.dto.SubjectVO;
import com.green.biz.subject.SubjectService;

@Service("subjectService")
public class SubjectServiceImpl implements SubjectService {
	
	@Autowired
	private SubjectDAO sDao;
	
	@Override
	public List<SubjectVO> getMajorList() {
		
		return sDao.getMajorList();
	}

	@Override
	public List<SubjectVO> getLiberalArtsList() {
		
		return sDao.getLiberalArtsList();
	}

	@Override
	public SubjectVO getSubject(SubjectVO vo) {
		
		return sDao.getSubject(vo);
	}

	@Override
	public List<SubjectVO> searchSubjectList(String key) {
		
		return sDao.searchSubjectList(key);
	}

	@Override
	public void insertSubject(SubjectVO vo) {
		
		sDao.insertSubject(vo);

	}

	@Override
	public void updateSubject(SubjectVO vo) {
		sDao.updateSubject(vo);

	}

	@Override
	public List<SubjectVO> mySubjectList(String id) {
		
		return sDao.mySubjectList(id);
	}

}
