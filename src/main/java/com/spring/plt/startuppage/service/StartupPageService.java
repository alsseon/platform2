package com.spring.plt.startuppage.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.plt.page.vo.PageVO;
import com.spring.plt.startuppage.vo.StartupPageVO;

public interface StartupPageService {
	public int deleteesti(int no) throws Exception;
	public int deletecon(int no) throws Exception;
	
	public List<StartupPageVO> listesti(PageVO pagevo) throws DataAccessException;  
	public int listCount() throws DataAccessException;
	public List<StartupPageVO> listprod(PageVO pagevo) throws DataAccessException;
	public List<StartupPageVO> listcon(PageVO pagevo) throws DataAccessException;
	
	public int estilistCount_i() throws Exception;
	public int estilistCount_w() throws Exception;
	public int estilistCount_c() throws Exception;
	public int estilistCount_d() throws Exception;
	
	public List<StartupPageVO> w_listesti(PageVO pagevo) throws DataAccessException; 
	public List<StartupPageVO> c_listesti(PageVO pagevo) throws DataAccessException; 
	public List<StartupPageVO> i_listesti(PageVO pagevo) throws DataAccessException; 
	public List<StartupPageVO> d_listesti(PageVO pagevo) throws DataAccessException; 
	
	
	
	public int status_y(int status, int no)throws Exception;
	public int status_n(int status, int no)throws Exception;
	public int constatus_n(int status, int no)throws Exception;
	public int constatus_y(int status, int no)throws Exception;
	
	
	public List<StartupPageVO> i_listcon(PageVO pagevo) throws DataAccessException;
	public List<StartupPageVO> c_listcon(PageVO pagevo) throws DataAccessException;
	public List<StartupPageVO> w_listcon(PageVO pagevo) throws DataAccessException;
	public List<StartupPageVO> d_listcon(PageVO pagevo) throws DataAccessException;
	
	
	public int conlistCount_i() throws Exception;
	public int conlistCount_c() throws Exception;
	public int conlistCount_w() throws Exception;
	public int conlistCount_d() throws Exception;
}
