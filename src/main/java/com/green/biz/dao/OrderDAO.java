package com.green.biz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.dto.SeasonOrderVO;

@Repository
public class OrderDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public int selectMaxseason_order_seq() {
		
		return mybatis.selectOne("OrderDAO.selectMaxseason_order_seq");
	}
	
	public void insertOrder(SeasonOrderVO vo) {
		
		mybatis.insert("OrderDAO.insertOrder", vo);
	}
	
	public void insertOrderDetail(SeasonOrderVO vo) {
		
		mybatis.insert("OrderDAO.insertOrderDetail", vo);
	}
	
	public List<SeasonOrderVO> listOrderById(SeasonOrderVO vo) {
		
		return mybatis.selectList("OrderDAO.listOrderById", vo);
	}
	
	public List<Integer> selectSeqOrdering(SeasonOrderVO vo) {
		
		return mybatis.selectList("OrderDAO.selectSeqOrdering", vo);
	}
	
	//전체 주문 내역 조회
	public List<SeasonOrderVO> listOrder(String key){
			
		return mybatis.selectList("OrderDAO.listOrder", key);
	}
		
		//주문 완료 처리
	public void updateOrderResult(int sedseq) {
		mybatis.update("OrderDAO.updateOrderResult" , sedseq);
	}
}
