package com.green.biz.comment.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.green.biz.comment.CommentService;
import com.green.biz.dao.CommentDAO;
import com.green.biz.dto.NoticeCommentVO;
import com.green.biz.utils.Criteria;

@Service("commentService")
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDAO cDao;
	
	@Override
	public List<NoticeCommentVO> getCommentList(int nseq) {
		
		return cDao.getCommentList(nseq);
	}

	@Override
	public int saveComment(NoticeCommentVO vo) {
		
		return cDao.saveComment(vo);
	}

	@Override
	public int updateComment(NoticeCommentVO vo) {
		
		return cDao.updateComment(vo);
		
	}

	@Override
	public int deleteComment(int comment_seq) {
		
		return cDao.deleteComment(comment_seq);
	}

	@Override
	public int countCommentList(int nseq) {
		
		return cDao.countCommentList(nseq);
	}

	@Override
	public List<NoticeCommentVO> getCommentListWithPageing(Criteria criteria, int nseq) {
		
		return cDao.getCommentListWithPageing(criteria, nseq);
	}

}
