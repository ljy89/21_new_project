package com.green.biz.admin;

import com.green.biz.dto.AdminVO;

public interface AdminService {

	public int adminCheck(AdminVO vo);
	public AdminVO getAdmin(String id);
}
