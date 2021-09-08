package com.green.biz.comment;

import java.util.List;

import com.green.biz.dto.NoticeCommentVO;
import com.green.biz.utils.Criteria;

public interface CommentService {

	public List<NoticeCommentVO> getCommentList(int nseq);
	
	public int saveComment(NoticeCommentVO vo);
	
	public int updateComment(NoticeCommentVO vo);
	
	public int deleteComment(int comment_seq);
	
	public int countCommentList(int nseq);
	
	public List<NoticeCommentVO> getCommentListWithPageing(Criteria criteria, int nseq);
}
