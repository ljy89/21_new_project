package com.green.biz.notice;

import java.util.List;

import com.green.biz.dto.NoticeVO;

public interface NoticeService {

	public List<NoticeVO> getNoticeList();
	
	public List<NoticeVO> noticeByTitleId(String key);
	
	public NoticeVO getNotice(int nseq);
	
	public void updateNotice(NoticeVO vo);
	
	public void insertNotice(NoticeVO vo);
	
	public void deleteNotice(int nseq);
}
