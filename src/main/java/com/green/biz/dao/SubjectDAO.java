package com.green.biz.dao;

import java.util.HashMap;
import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.green.biz.dto.SubjectVO;
import com.green.biz.utils.Criteria;


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
	
	//전공을 교수명, 과목명으로 검색한 조회 목록
	public List<SubjectVO> searchMajorList(String key){
		
		return mybatis.selectList("SubjectDAO.searchMajorList",key);
	}
	
	//교양을 교수명 , 과목명으로 검색한 조회 목록
	public List<SubjectVO> searchLiberalArts(String key){
		
		return mybatis.selectList("SubjectDAO.searchLiberalArts",key);
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
	
	public List<SubjectVO> getMajorListWithPaging(Criteria criteria, String key){
		HashMap<String, Object> map = new HashMap<>();
		map.put("criteria", criteria);
		map.put("key", key);
		return mybatis.selectList("SubjectDAO.majorListWithPaging" ,map);
	}
	
	public int countMajorList(String subname) {
		
		return mybatis.selectOne("SubjectDAO.countMajorList", subname);
	}
}








