package com.green.biz.dao;

import java.util.HashMap;
import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.dto.NoticeVO;
import com.green.biz.utils.Criteria;

@Repository
public class NoticeDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<NoticeVO> getNoticeList(){
		
		return mybatis.selectList("NoticeDAO.getNoticeList");
	}
	
	public List<NoticeVO> noticeByTitleId(String key){
		
		return mybatis.selectList("NoticeDAO.noticeByTitleId", key);
	}
	
	public NoticeVO getNotice(int nseq){
		
		return mybatis.selectOne("NoticeDAO.getNotice", nseq);
	}
	
	public void updateNotice(NoticeVO vo) {
		mybatis.update("NoticeDAO.updateNotice", vo);
	}
	
	public void insertNotice(NoticeVO vo) {
		mybatis.insert("NoticeDAO.insertNotice", vo);
	}
	
	public void deleteNotice(int nseq) {
		
		mybatis.delete("NoticeDAO.deleteNotice",nseq);
	}
	
	public List<NoticeVO> getBoardListWithPaging(Criteria criteria, String key){
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("criteria", criteria);
		map.put("key", key);
		
		return mybatis.selectList("NoticeDAO.getBoardListWithPaging",map);
	
	}
	
	public int countBoardList(String key) {
		return mybatis.selectOne("NoticeDAO.countBoardList", key);
	}
	
	public List<NoticeVO> indexnotice() {
		return mybatis.selectList("NoticeDAO.indexnotice");
	}
}











