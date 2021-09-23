package com.green.biz.seasoncart.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.dao.SeasonCartDAO;
import com.green.biz.dto.SeasonCartVO;
import com.green.biz.seasoncart.SeasonCartService;

@Service("seasonCartService")
public class SeasonCartServiceImpl implements SeasonCartService {

	@Autowired
	private SeasonCartDAO sesonCartDao;
	
	@Override
	public List<SeasonCartVO> getSeaonCartList(String sid) {
		
		return sesonCartDao.getSeaonCartList(sid);
	}

	@Override
	public void insertCart(SeasonCartVO vo) {
		sesonCartDao.insertCart(vo);

	}

	@Override
	public void updateCart(int secseq) {
		sesonCartDao.updateCart(secseq);

	}

	@Override
	public void deleteCart(int secseq) {
		
		sesonCartDao.deleteCart(secseq);
	}

	@Override
	public int getCartPrice(int secseq) {
		
		return sesonCartDao.getCartPrice(secseq);
	}

}
