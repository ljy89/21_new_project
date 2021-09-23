package com.green.biz.season.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.dao.SeasonDAO;
import com.green.biz.dto.SeasonSubjectVO;
import com.green.biz.season.SeasonService;
import com.green.biz.utils.Criteria;

@Service("seasonService")
public class SeasonServiceImpl implements SeasonService {
	
	@Autowired
	private SeasonDAO seasonDao;

	@Override
	public List<SeasonSubjectVO> getSeasonList() {
		
		return seasonDao.getSeasonList();
	}

	@Override
	public SeasonSubjectVO getSeasonSubject(SeasonSubjectVO vo) {
		
		return seasonDao.getSeasonSubject(vo);
	}

	@Override
	public void insertSubject(SeasonSubjectVO vo) {
		
		seasonDao.insertSubject(vo);
	}

	@Override
	public void updateSubject(SeasonSubjectVO vo) {
		seasonDao.updateSubject(vo);
		
	}

	@Override
	public List<SeasonSubjectVO> getSeasonListWithPaging(Criteria criteria, String key) {
		
		return seasonDao.getSeasonListWithPaging(criteria, key);
	}

	@Override
	public int countSeasonLisList(String key) {
	
		return seasonDao.countSeasonLisList(key);
	}

	@Override
	public int getPrice(int seseq) {
		
		return seasonDao.getPrice(seseq);
	}
	
	
}
