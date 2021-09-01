package com.green.biz.announcement.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.announcement.AnnouncementService;
import com.green.biz.dao.AnnouncementDAO;
import com.green.biz.dto.AnnouncementVO;
import com.green.biz.utils.Criteria;

@Service("announcementService")
public class AnnounceSerivceImpl implements AnnouncementService {
	
	@Autowired
	private AnnouncementDAO aDao;
	
	@Override
	public List<AnnouncementVO> getAnnounceList() {
		
		return aDao.getAnnounceList();
	}

	@Override
	public List<AnnouncementVO> announceByTitle(String key) {

		return aDao.announceByTitle(key);
	}

	@Override
	public AnnouncementVO getAnnounce(int aseq) {

		return aDao.getAnnounce(aseq);
	}

	@Override
	public void updateAnnounce(AnnouncementVO vo) {
		aDao.updateAnnounce(vo);

	}

	@Override
	public void insertAnnounce(AnnouncementVO vo) {
		aDao.insertAnnounce(vo);

	}

	@Override
	public void deleteAnnounce(int aseq) {
		aDao.deleteAnnounce(aseq);
	}

	@Override
	public List<AnnouncementVO> getAnnounceListWithPaging(Criteria criteria, String key) {
		
		return aDao.getAnnounceListWithPaging(criteria, key);
		
	}

	@Override
	public int countAnnounceList(String key) {

		return aDao.countAnnounceList(key);
		
	}

}
