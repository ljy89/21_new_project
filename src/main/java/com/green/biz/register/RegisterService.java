package com.green.biz.register;

import java.util.List;

import com.green.biz.dto.RegisterVO;

public interface RegisterService {

	public int selectMaxRseq();
	
	public int insertRegister(RegisterVO vo, int[] cseqArr);
	
	public int goInsertRegister(RegisterVO vo , int sseq);
	
	public void insertOrderDetail(RegisterVO vo);
	
	public void deleteSubject(int rdseq);
	
	public List<RegisterVO> listRegisterById(String id);
	
	public void updateRegisterResult(int rseq);
	
	public RegisterVO confirmSseq(RegisterVO vo);
}
