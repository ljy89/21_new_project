package com.green.biz.seasonorder.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.dao.OrderDAO;
import com.green.biz.dto.SeasonCartVO;
import com.green.biz.dto.SeasonOrderVO;
import com.green.biz.seasoncart.SeasonCartService;
import com.green.biz.seasonorder.SeasonOrderService;

@Service("OrderService")
public class SeasonOrderServiceImpl implements SeasonOrderService {

	@Autowired
	private OrderDAO orderDao;
	
	@Autowired
	private SeasonCartService cartService;
	
	@Override
	public int selectMaxseason_order_seq() {
		
		return orderDao.selectMaxseason_order_seq();
	}

	@Override
	public int insertOrder(SeasonOrderVO vo) {
		int season_order_seq = 0;
		
		season_order_seq = selectMaxseason_order_seq();
		
		vo.setSeason_order_seq(season_order_seq);
		orderDao.insertOrder(vo);
		
		List<SeasonCartVO> cartList = cartService.getSeaonCartList(vo.getSid());
		
		// 장바구니의 내역을 order_detail 테이블에 저장
				for(SeasonCartVO cartVO : cartList) {
					SeasonOrderVO order = new SeasonOrderVO();
					order.setSeason_order_seq(season_order_seq);
					order.setSeseq(cartVO.getSeseq());
					
					insertOrderDetail(order);
					
					// 장바구니 업데이트
					cartService.updateCart(cartVO.getSecseq());
				}

				return season_order_seq;

	}
	@Override
	public int goInsertOrder(SeasonOrderVO vo , int seseq) {
		
		int season_order_seq = 0;
		
		season_order_seq = selectMaxseason_order_seq();
		vo.setSeason_order_seq(season_order_seq);
		orderDao.insertOrder(vo);
		
		SeasonOrderVO order = new SeasonOrderVO();
		order.setSeason_order_seq(season_order_seq);
		order.setSeseq(seseq);
		
		insertOrderDetail(order);
		
		return season_order_seq;
	}

	@Override
	public void insertOrderDetail(SeasonOrderVO vo) {
		orderDao.insertOrderDetail(vo);

	}

	@Override
	public List<SeasonOrderVO> listOrderById(SeasonOrderVO vo) {
		
		return orderDao.listOrderById(vo);
	}

	@Override
	public List<Integer> selectSeqOrdering(SeasonOrderVO vo) {
		
		return orderDao.selectSeqOrdering(vo);
	}

	@Override
	public List<SeasonOrderVO> listOrder(String key) {
		
		return orderDao.listOrder(key);
	}

	@Override
	public void updateOrderResult(int sedseq) {
		orderDao.updateOrderResult(sedseq);

	}

}
