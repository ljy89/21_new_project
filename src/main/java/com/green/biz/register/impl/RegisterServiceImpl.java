package com.green.biz.register.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.dao.RegisterDAO;
import com.green.biz.dto.RegisterVO;
import com.green.biz.register.RegisterService;

@Service("registerService")
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private RegisterDAO rDao;
	
	@Override
	public int selectMaxRseq() {
		
		return rDao.selectMaxRseq();
	}

	@Override
	public void insertRegister(RegisterVO vo) {
		rDao.insertRegister(vo);

	}

	@Override
	public void deleteSubject(int rseq) {
		rDao.deleteSubject(rseq);

	}

	@Override
	public List<RegisterVO> listRegisterById(String id) {
		
		return rDao.listRegisterById(id);
	}

	@Override
	public void updateRegisterResult(int rseq) {
		rDao.updateRegisterResult(rseq);

	}

}
