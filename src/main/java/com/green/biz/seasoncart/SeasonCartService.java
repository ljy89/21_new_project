package com.green.biz.seasoncart;

import java.util.List;

import com.green.biz.dto.SeasonCartVO;

public interface SeasonCartService {
	
	public List<SeasonCartVO> getSeaonCartList(String sid);
	
	public void insertCart(SeasonCartVO vo);
	
	public void updateCart(int secseq);
	
	public void deleteCart(int secseq);
	
	public int getCartPrice(int secseq);
}
