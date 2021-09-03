package com.green.biz.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.dto.AnnouncementVO;
import com.green.biz.utils.Criteria;

@Repository
public class AnnouncementDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<AnnouncementVO> getAnnounceList(){
		return mybatis.selectList("AnnouncementDAO.getAnnounceList");
	}
	
	public List<AnnouncementVO> announceByTitle(String key){
		return mybatis.selectList("AnnouncementDAO.announceByTitle", key);
	}
	
	public AnnouncementVO getAnnounce(int aseq) {
		return mybatis.selectOne("AnnouncementDAO.getAnnounce", aseq);
	}
	
	public void updateAnnounce(AnnouncementVO vo) {
		mybatis.update("AnnouncementDAO.updateAnnounce", vo);
	}
	
	public void insertAnnounce(AnnouncementVO vo) {
		mybatis.insert("AnnouncementDAO.insertAnnounce", vo);
	}
	
	public void deleteAnnounce(int aseq) {
		mybatis.delete("AnnouncementDAO.deleteAnnounce", aseq);
	}
	
	public List<AnnouncementVO> getAnnounceListWithPaging(Criteria criteria, String key){
		HashMap<String, Object> map = new HashMap<>();
		
		map.put("criteria", criteria);
		map.put("key", key);
		
		return mybatis.selectList("AnnouncementDAO.getAnnounceListWithPaging", map);
	}
	
	public int countAnnounceList(String key) {
		return mybatis.selectOne("AnnouncementDAO.countAnnounceList", key);
	}
	
	public List<AnnouncementVO> indexAcc(){
		return mybatis.selectList("AnnouncementDAO.indexAcc");
	}
}
