package com.spring.plt.admin.service;

import org.springframework.dao.DataAccessException;

import com.spring.plt.admin.vo.AdminVO;

public interface AdminService {
	public AdminVO login(AdminVO adminVO) throws DataAccessException;
}
