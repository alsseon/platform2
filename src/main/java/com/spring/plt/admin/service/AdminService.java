package com.spring.plt.admin.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.plt.admin.vo.AdminVO;
import com.spring.plt.admin.vo.EditInfoVO;

public interface AdminService {
	public AdminVO login(AdminVO adminVO) throws DataAccessException;
	public List<EditInfoVO> expertEdit() throws Exception;
    public List<EditInfoVO> startUpEdit() throws Exception;
    public List<EditInfoVO> manuEdit() throws Exception;
}
