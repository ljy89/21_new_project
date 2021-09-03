package com.green.biz.announcement;

import java.util.List;
import com.green.biz.dto.AnnouncementVO;
import com.green.biz.utils.Criteria;

public interface AnnouncementService {
	
	public List<AnnouncementVO> getAnnounceList();
	
	public List<AnnouncementVO> announceByTitle(String key);
	
	public AnnouncementVO getAnnounce(int aseq);
	
	public void updateAnnounce(AnnouncementVO vo);
	
	public void insertAnnounce(AnnouncementVO vo);
	
	public void deleteAnnounce(int aseq);
	
	public List<AnnouncementVO> getAnnounceListWithPaging(Criteria criteria, String key);
	
	public int countAnnounceList(String key);
	
	public List<AnnouncementVO> indexAcc();
}
