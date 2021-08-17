package com.green.biz.admin.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.admin.AdminService;
import com.green.biz.dao.AdminDAO;
import com.green.biz.dto.AdminVO;

@Service("adminService")
public class AdminSerivceImpl implements AdminService {
	
	@Autowired
	private AdminDAO aDao;
	
	@Override
	public int adminCheck(AdminVO vo) {
		
		return aDao.adminCheck(vo);
	}

	@Override
	public AdminVO getAdmin(String id) {
		
		return aDao.getAdmin(id);
	}

}
