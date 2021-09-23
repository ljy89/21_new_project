package com.green.biz.season;

import java.util.List;

import com.green.biz.dto.SeasonSubjectVO;
import com.green.biz.utils.Criteria;

public interface SeasonService {
	
	//전체조회
	public List<SeasonSubjectVO> getSeasonList();
	
	//상세조회
	public SeasonSubjectVO getSeasonSubject(SeasonSubjectVO vo);
	
	//강의 등록
	public void insertSubject(SeasonSubjectVO vo);
		
	//강의 수정
	public void updateSubject(SeasonSubjectVO vo);
	
	//페이징
	public List<SeasonSubjectVO> getSeasonListWithPaging(Criteria criteria, String key);
		
	public int countSeasonLisList(String key);
		
	public int getPrice(int seseq);
}
