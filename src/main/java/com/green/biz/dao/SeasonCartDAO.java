package com.green.biz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.dto.CartVO;
import com.green.biz.dto.SeasonCartVO;

@Repository
public class SeasonCartDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<SeasonCartVO> getSeaonCartList(String sid){
		return mybatis.selectList("SeasonCartDAO.getSeaonCartList", sid);
	}
	public void insertCart(SeasonCartVO vo) {
		mybatis.insert("SeasonCartDAO.insertCart", vo);
	}
	
	public void updateCart(int secseq) {
		mybatis.update("SeasonCartDAO.updateCart", secseq);
	}
	
	public void deleteCart(int secseq) {
		mybatis.delete("SeasonCartDAO.deleteCart", secseq);
	}

	public int getCartPrice(int secseq) {
		return mybatis.selectOne("SeasonCartDAO.getCartPrice", secseq);
	}
}
