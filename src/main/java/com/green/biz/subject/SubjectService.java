package com.green.biz.subject;

import java.util.HashMap;
import java.util.List;

import com.green.biz.dto.SubjectVO;
import com.green.biz.utils.Criteria;

public interface SubjectService {

	public List<SubjectVO> getMajorList();
	
	public List<SubjectVO> getLiberalArtsList();
	
	public SubjectVO getSubject(SubjectVO vo);
	
	public List<SubjectVO> searchMajorList(String key);
	
	public List<SubjectVO> searchLiberalArts(String key);
	
	public void insertSubject(SubjectVO vo);
	
	public void updateSubject(SubjectVO vo);
	
	public List<SubjectVO> mySubjectList(String id);
	
	public List<SubjectVO> getMajorListWithPaging(Criteria criteria, String key);
	public List<SubjectVO> getMajorListWithSearch(Criteria criteria, String key, int dseq);
	
	public List<SubjectVO> getliberalArtsListWithPaging(Criteria criteria, String key);
	
	public int countMajorList(String key);
	
	public int countliberalArtsLisList(String key);
	
	public int countSearchMajorList(String key, int dseq);
	
	public SubjectVO getSubjectInfo(int sseq);
}
