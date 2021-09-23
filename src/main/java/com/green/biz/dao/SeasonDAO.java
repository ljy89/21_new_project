package com.green.biz.dao;

import java.util.HashMap;
import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.dto.SeasonSubjectVO;
import com.green.biz.dto.SubjectVO;
import com.green.biz.utils.Criteria;


@Repository
public class SeasonDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	//전공과목 목록 조회
	public List<SeasonSubjectVO> getSeasonList() {
		
		return mybatis.selectList("SeasonDAO.getSeasonList");
	}
	
	
	//상세조회
	public SeasonSubjectVO getSeasonSubject(SeasonSubjectVO vo) {
		
		return mybatis.selectOne("SeasonDAO.getSeasonSubject", vo);
	}
	
	//강의 등록
	public void insertSubject(SeasonSubjectVO vo) {
		mybatis.insert("SeasonDAO.insertSeasonSubject");
	}
	
	//강의 수정
	public void updateSubject(SeasonSubjectVO vo) {
		mybatis.update("SeasonDAO.updateSeasonSubject",vo);
	}

	//페이징
	public List<SeasonSubjectVO> getSeasonListWithPaging(Criteria criteria, String key){
		HashMap<String, Object> map = new HashMap<>();
		map.put("criteria", criteria);
		map.put("key", key);
		return mybatis.selectList("SeasonDAO.seasonListWithPaging" ,map);
	}
	
	public int countSeasonLisList(String key) {
		return mybatis.selectOne("SeasonDAO.countSeasonList", key);
	}
	
	public int getPrice(int seseq) {
		return mybatis.selectOne("SeasonDAO.getPrice",seseq);
	}
}








