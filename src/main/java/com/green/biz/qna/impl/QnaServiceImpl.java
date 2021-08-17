package com.green.biz.qna.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.dao.QnaDAO;
import com.green.biz.dto.QnaVO;
import com.green.biz.qna.QnaService;

@Service("qnaService")
public class QnaServiceImpl implements QnaService {
	
	@Autowired
	private QnaDAO qDao;
	
	@Override
	public List<QnaVO> getMyQnaList(String id) {
		
		return qDao.getMyQnaList(id);
	}

	@Override
	public QnaVO getQna(int qseq) {
		
		return qDao.getQna(qseq);
	}

	@Override
	public void insertQna(QnaVO vo) {
		qDao.insertQna(vo);

	}

	@Override
	public void updateQna(QnaVO vo) {
		
		qDao.updateQna(vo);
	}

	@Override
	public List<QnaVO> listAllQna() {
		
		return qDao.listAllQna();
	}

}
