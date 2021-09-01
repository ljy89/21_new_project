package com.green.biz.subject.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.dao.SubjectDAO;
import com.green.biz.dto.SubjectVO;
import com.green.biz.subject.SubjectService;
import com.green.biz.utils.Criteria;

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
	public List<SubjectVO> searchMajorList(String key) {
		
		return sDao.searchMajorList(key);
	}

	@Override
	public List<SubjectVO> searchLiberalArts(String key) {
		
		return sDao.searchLiberalArts(key);
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

	@Override
	public int countMajorList(String key) {
		
		return sDao.countMajorList(key);
	}
	
	@Override
	public int countliberalArtsLisList(String key) {
		
		return sDao.countliberalArtsLisList(key);
	}

	@Override
	public List<SubjectVO> getMajorListWithPaging(Criteria criteria, String key) {
		
		return sDao.getMajorListWithPaging(criteria, key);
	}
	
	@Override
	public List<SubjectVO> getliberalArtsListWithPaging(Criteria criteria, String key) {
		
		return sDao.getliberalArtsListWithPaging(criteria, key);
	}

	@Override
	public List<SubjectVO> getMajorListWithSearch(Criteria criteria, String key, int dseq) {
		
		return sDao.getMajorListWithSearch(criteria, key, dseq);
	}

	@Override
	public int countSearchMajorList(String key, int dseq) {
		
		return sDao.countSearchMajorList(key, dseq);
	}


}
