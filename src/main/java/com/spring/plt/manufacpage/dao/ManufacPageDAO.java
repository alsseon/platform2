package com.spring.plt.manufacpage.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.plt.manufacpage.vo.ManufacPageVO;
import com.spring.plt.page.vo.PageVO;

public interface ManufacPageDAO {
	public int listCount() throws DataAccessException;
	public List<ManufacPageVO> selectAllEstiList(PageVO pagevo) throws DataAccessException;
	public List<ManufacPageVO> selectWaitingEstiList(PageVO pagevo) throws Exception;
	public List<ManufacPageVO> selectIngEstiList(PageVO pagevo) throws Exception;
	public List<ManufacPageVO> selectComEstiList(PageVO pagevo) throws Exception;
	public List<ManufacPageVO> selectDeEstiList(PageVO pagevo) throws Exception;
	public List<ManufacPageVO> selectAllProdList(PageVO pagevo) throws DataAccessException;
	public List<ManufacPageVO> selectWaitProdList(PageVO pagevo) throws DataAccessException;
	public List<ManufacPageVO> selectIngProdList(PageVO pagevo) throws DataAccessException;
	public List<ManufacPageVO> selectComProdList(PageVO pagevo) throws DataAccessException;
	public List<ManufacPageVO> selectSailProdList(PageVO pagevo) throws DataAccessException;
	public List<ManufacPageVO> selectEndProdList(PageVO pagevo) throws DataAccessException;
	public List<ManufacPageVO> selectDeProdList(PageVO pagevo) throws DataAccessException;
	public int deleteesti(int no) throws DataAccessException;
	public int quotestatus(int quotestatus, int no) throws DataAccessException;
	public int quotestatus_de(int quotestatus, int no) throws DataAccessException;
	public int estilistCount_i() throws Exception;
	public int estilistCount_w() throws Exception;
	public int estilistCount_c() throws Exception;
	public int estilistCount_d() throws Exception;
}
