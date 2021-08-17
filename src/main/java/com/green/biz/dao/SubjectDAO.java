package com.green.biz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.dto.SubjectVO;

@Repository
public class SubjectDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	//전공과목 목록 조회
	public List<SubjectVO> getMajorList() {
		
		return mybatis.selectList("SubjectDAO.getMajorList");
	}
	
	//교양과목 목록 조회
	public List<SubjectVO> getLiberalArtsList() {
	
		return mybatis.selectList("SubjectDAO.getLiberalArtsList");
	}
	
	//상세조회
	public SubjectVO getSubject(SubjectVO vo) {
		
		return mybatis.selectOne("SubjectDAO.getSubject", vo);
	}
	
	//교수명, 과목명으로 검색한 조회 목록
	public List<SubjectVO> searchSubjectList(String key){
		
		return mybatis.selectList("SubjectDAO.searchSubjectList",key);
	}
	//강의 등록
	public void insertSubject(SubjectVO vo) {
		mybatis.insert("SubjectDAO.insertSubject");
	}
	
	//강의 수정
	public void updateSubject(SubjectVO vo) {
		mybatis.update("SubjectDAO.updateSubject",vo);
	}
	
	//내 수강 과목 목록
	
	public List<SubjectVO> mySubjectList(String id) {
		
		return mybatis.selectList("SubjectDAO.mySubjectList", id);
	}
}








