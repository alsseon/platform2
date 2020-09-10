package com.spring.plt.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.spring.plt.admin.dao.AdminDAO;
import com.spring.plt.admin.vo.AdminVO;

@Service("adminService")
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminDAO adminDAO;
	
	@Override
	public AdminVO login(AdminVO adminVO) throws DataAccessException {
		
		return adminDAO.loginById(adminVO);
	}

}
