package com.green.biz.notice;

import java.util.List;

import com.green.biz.dto.NoticeVO;
import com.green.biz.utils.Criteria;

public interface NoticeService {

	public List<NoticeVO> getNoticeList();
	
	public List<NoticeVO> noticeByTitleId(String key);
	
	public NoticeVO getNotice(int nseq);
	
	public void updateNotice(NoticeVO vo);
	
	public void insertNotice(NoticeVO vo);
	
	public void deleteNotice(int nseq);
	
	public List<NoticeVO> getBoardListWithPaging(Criteria criteria, String key);
	
	public int countBoardList(String key);
}
