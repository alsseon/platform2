package com.spring.plt.admin.dao;

import org.springframework.dao.DataAccessException;

import com.spring.plt.admin.vo.AdminVO;

public interface AdminDAO {
	public AdminVO loginById(AdminVO adminVO) throws DataAccessException;
}
