package com.green.biz.notice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.dao.NoticeDAO;
import com.green.biz.dto.NoticeVO;
import com.green.biz.notice.NoticeService;
import com.green.biz.utils.Criteria;

@Service("noticeSerive")
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeDAO nDao;
	
	@Override
	public List<NoticeVO> getNoticeList() {
		
		return nDao.getNoticeList();
	}

	@Override
	public List<NoticeVO> noticeByTitleId(String key) {
		
		return nDao.noticeByTitleId(key);
	}

	@Override
	public NoticeVO getNotice(int nseq) {
		
		return nDao.getNotice(nseq);
	}

	@Override
	public void updateNotice(NoticeVO vo) {
		nDao.updateNotice(vo);

	}

	@Override
	public void insertNotice(NoticeVO vo) {
		nDao.insertNotice(vo);

	}

	@Override
	public void deleteNotice(int nseq) {
		nDao.deleteNotice(nseq);

	}

	@Override
	public List<NoticeVO> getBoardListWithPaging(Criteria criteria, String key) {
		
		return nDao.getBoardListWithPaging(criteria, key);
	}

	@Override
	public int countBoardList(String key) {
		
		return nDao.countBoardList(key);
	}

}
