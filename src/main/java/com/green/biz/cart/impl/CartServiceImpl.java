package com.green.biz.cart.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.cart.CartService;
import com.green.biz.dao.CartDAO;
import com.green.biz.dto.CartVO;

@Service("cartService")
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDAO cDao;
	
	@Override
	public List<CartVO> listCart(String id) {
		
		return cDao.listCart(id);
	}

	@Override
	public void insertCart(CartVO vo) {
		cDao.insertCart(vo);
	}

	@Override
	public void updateCart(CartVO vo) {
		cDao.updateCart(vo);

	}

	@Override
	public void deleteCart(int cseq) {
		cDao.deleteCart(cseq);

	}

}
