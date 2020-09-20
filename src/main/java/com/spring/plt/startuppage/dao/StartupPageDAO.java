package com.spring.plt.startuppage.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.plt.page.vo.PageVO;
import com.spring.plt.startuppage.vo.StartupPageVO;

public interface StartupPageDAO {
	List<StartupPageVO> selectAllEstiList(PageVO pagevo) throws DataAccessException;

	int listCount() throws DataAccessException;

	List<StartupPageVO> selectAllProdList(PageVO pagevo) throws DataAccessException;

	List<StartupPageVO> selectAllConList(PageVO pagevo) throws DataAccessException;

	List<StartupPageVO> selectWaitEstiList(PageVO pagevo) throws DataAccessException;

	List<StartupPageVO> selectIngEstiList(PageVO pagevo) throws DataAccessException;

	List<StartupPageVO> selectComEstiList(PageVO pagevo) throws DataAccessException;

	List<StartupPageVO> selectDeEstiList(PageVO pagevo) throws DataAccessException;

	int deleteesti(int no) throws DataAccessException;
	
	public int status_n(int status, int no) throws DataAccessException;
	public int status_y(int status, int no) throws DataAccessException;

	int estilistCount_i() throws Exception;
	int estilistCount_w() throws Exception;
	int estilistCount_d() throws Exception;
	int estilistCount_c() throws Exception;

	List<StartupPageVO> selectWaitConList(PageVO pagevo) throws DataAccessException;
	List<StartupPageVO> selectDeConList(PageVO pagevo) throws DataAccessException;
	List<StartupPageVO> selectIngConList(PageVO pagevo) throws DataAccessException;
	List<StartupPageVO> selectComConList(PageVO pagevo) throws DataAccessException;

	int deletecon(int no) throws DataAccessException;
	
	public int constatus_n(int status, int no) throws DataAccessException;
	public int constatus_y(int status, int no) throws DataAccessException;

	int conlistCount_i() throws Exception;
	int conlistCount_d() throws Exception;
	int conlistCount_c() throws Exception;
	int conlistCount_w() throws Exception;
}
