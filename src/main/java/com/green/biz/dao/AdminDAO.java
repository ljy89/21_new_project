package com.green.biz.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.dto.AdminVO;

@Repository
public class AdminDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public int adminCheck(AdminVO vo) {
		
		String pwd = mybatis.selectOne("AdminDAO.adminCheck", vo.getAdmin_id());
		
		if(pwd == null) {
			return -1;
		}else if(pwd.equals(vo.getPwd())) {
			return 1;
		}else {
			return 0;
		}
	}
	
	public AdminVO getAdmin(String id) {
		return mybatis.selectOne("AdminDAO.getAdmin", id);
	}
}
