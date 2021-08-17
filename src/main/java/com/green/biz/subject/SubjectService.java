package com.green.biz.subject;

import java.util.List;

import com.green.biz.dto.SubjectVO;

public interface SubjectService {

	public List<SubjectVO> getMajorList();
	
	public List<SubjectVO> getLiberalArtsList();
	
	public SubjectVO getSubject(SubjectVO vo);
	
	public List<SubjectVO> searchSubjectList(String key);
	
	public void insertSubject(SubjectVO vo);
	
	public void updateSubject(SubjectVO vo);
	
	public List<SubjectVO> mySubjectList(String id);
	
}
