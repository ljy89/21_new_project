package com.green.biz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.dto.CartVO;

@Repository
public class CartDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<CartVO> listCart(String id){
		return mybatis.selectList("CartDAO.listCart", id);
	}
	public void insertCart(CartVO vo) {
		mybatis.insert("CartDAO.insertCart", vo);
	}
	
	public void updateCart(int cseq) {
		mybatis.update("CartDAO.updateCart", cseq);
	}
	
	public void deleteCart(int cseq) {
		mybatis.delete("CartDAO.deleteCart", cseq);
	}
}
