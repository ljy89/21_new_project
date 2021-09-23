package com.green.biz.seasonorder;

import java.util.List;

import com.green.biz.dto.SeasonOrderVO;

public interface SeasonOrderService {
	
	public int selectMaxseason_order_seq();	
	
	public int insertOrder(SeasonOrderVO vo);
	
	public int goInsertOrder(SeasonOrderVO vo , int seseq);
	
	public void insertOrderDetail(SeasonOrderVO vo);
	
	public List<SeasonOrderVO> listOrderById(SeasonOrderVO vo);
	
	public List<Integer> selectSeqOrdering(SeasonOrderVO vo);
	
	//전체 주문 내역 조회
	public List<SeasonOrderVO> listOrder(String key);
		
		//주문 완료 처리
	public void updateOrderResult(int sedseq);
	
}
