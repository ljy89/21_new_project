package com.green.biz.cart;

import java.util.List;

import com.green.biz.dto.CartVO;

public interface CartService {

	public List<CartVO> listCart(String id);
	public void insertCart(CartVO vo);
	public void updateCart(CartVO vo);
	public void deleteCart(int cseq);
}