package com.green.biz.register;

import java.util.List;

import com.green.biz.dto.RegisterVO;

public interface RegisterService {

	public int selectMaxRseq();
	
	public void insertRegister(RegisterVO vo);
	
	public void deleteSubject(int rseq);
	
	public List<RegisterVO> listRegisterById(String id);
	
	public void updateRegisterResult(int rseq);
}
