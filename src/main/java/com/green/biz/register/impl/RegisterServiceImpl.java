package com.green.biz.register.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.cart.CartService;
import com.green.biz.dao.RegisterDAO;
import com.green.biz.dto.CartVO;
import com.green.biz.dto.RegisterVO;
import com.green.biz.register.RegisterService;

@Service("registerService")
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private RegisterDAO rDao;
	@Autowired
	private CartService cartService;
	
	@Override
	public int selectMaxRseq() {
		
		return rDao.selectMaxRseq();
	}

	@Override
	public int goInsertRegister(RegisterVO vo, int sseq) {
		
		int rseq =0;
		
		rseq = selectMaxRseq();
		vo.setRseq(rseq);
		rDao.insertRegister(vo);
		
		
		//CartVO cartVO =  (CartVO)cartService.listCart(vo.getSid());
		//register.setSseq(cartVO.getSseq());
		
		RegisterVO register = new RegisterVO();
		register.setRseq(rseq);
		register.setSseq(sseq);
		insertOrderDetail(register);
		
		return rseq;
	}
	
	
	@Override
	public int insertRegister(RegisterVO vo, int[] cseqArr) {
		int rseq =0;
		
		rseq = selectMaxRseq();
		
		//rseq, sid ���옣
		// �닔媛� �떊泥� �뀒�씠釉붿뿉 �닔媛뺤떊泥� ���옣
		vo.setRseq(rseq);
		rDao.insertRegister(vo);
		
		//�삁鍮� �옣諛붽뎄�땲 紐⑸줉 遺덈윭�삩�떎
		List<CartVO> cartList = cartService.listCart(vo.getSid());
		
		//�옣諛붽뎄�땲 �쁺�뿭�쓣 ���옣
		for(CartVO cartVO:cartList) {
			
			for (int i=0; i<cseqArr.length; i++) {
				if (cartVO.getCseq() == cseqArr[i]) {
					RegisterVO register = new RegisterVO();
					register.setRseq(rseq);
					register.setSseq(cartVO.getSseq());
					
					insertOrderDetail(register);
					cartService.updateCart(cartVO.getCseq());
				}
			}

		}
		return rseq;
	}

	@Override
	public void insertOrderDetail(RegisterVO vo) {

		rDao.insertOrderDetail(vo);
		
	}
	
	
	@Override
	public void deleteSubject(int rdseq) {
		rDao.deleteSubject(rdseq);

	}

	@Override
	public List<RegisterVO> listRegisterById(String id) {
		
		return rDao.listRegisterById(id);
	}

	@Override
	public void updateRegisterResult(int rseq) {
		rDao.updateRegisterResult(rseq);

	}

	@Override
	public RegisterVO confirmSseq(RegisterVO vo) {
		
		return rDao.confirmSseq(vo);
	}

	

	

}
