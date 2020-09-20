package com.spring.plt.manufacpage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.spring.plt.manufacpage.dao.ManufacPageDAO;
import com.spring.plt.manufacpage.vo.ManufacPageVO;
import com.spring.plt.page.vo.PageVO;

@Service("manufacPageService")
public class ManufacPageServiceImpl implements ManufacPageService{
	@Autowired
	private ManufacPageDAO manufacdao;
	
	public List<ManufacPageVO> listesti(PageVO pagevo) throws DataAccessException{
		List<ManufacPageVO> estilist = null;
		estilist = manufacdao.selectAllEstiList(pagevo);
		return estilist;
	}
	public List<ManufacPageVO> w_estiList(PageVO pagevo) throws Exception{
		List<ManufacPageVO> estilist = null;
		estilist = manufacdao.selectWaitingEstiList(pagevo);
		return estilist;
	}
	public List<ManufacPageVO> i_estiList(PageVO pagevo) throws Exception{
		List<ManufacPageVO> estilist = null;
		estilist = manufacdao.selectIngEstiList(pagevo);
		return estilist;
	}
	public List<ManufacPageVO> c_estiList(PageVO pagevo) throws Exception{
		List<ManufacPageVO> estilist = null;
		estilist = manufacdao.selectComEstiList(pagevo);
		return estilist;
	}
	public List<ManufacPageVO> d_estiList(PageVO pagevo) throws Exception{
		List<ManufacPageVO> estilist = null;
		estilist = manufacdao.selectDeEstiList(pagevo);
		return estilist;
	}
	public int listCount() throws DataAccessException{
		return manufacdao.listCount();
	}
	public List<ManufacPageVO> listprod(PageVO pagevo) throws DataAccessException{
		List<ManufacPageVO> prodlist = null;
		prodlist = manufacdao.selectAllProdList(pagevo);
		return prodlist;
	}
	public List<ManufacPageVO> w_listprod(PageVO pagevo) throws DataAccessException{
		List<ManufacPageVO> w_prodlist = null;
		w_prodlist = manufacdao.selectAllProdList(pagevo);
		return w_prodlist;
	}
	public List<ManufacPageVO> i_listprod(PageVO pagevo) throws DataAccessException{
		List<ManufacPageVO> i_prodlist = null;
		i_prodlist = manufacdao.selectAllProdList(pagevo);
		return i_prodlist;
	}
	public List<ManufacPageVO> c_listprod(PageVO pagevo) throws DataAccessException{
		List<ManufacPageVO> c_prodlist = null;
		c_prodlist = manufacdao.selectAllProdList(pagevo);
		return c_prodlist;
	}
	public List<ManufacPageVO> s_listprod(PageVO pagevo) throws DataAccessException{
		List<ManufacPageVO> s_prodlist = null;
		s_prodlist = manufacdao.selectAllProdList(pagevo);
		return s_prodlist;
	}
	public List<ManufacPageVO> e_listprod(PageVO pagevo) throws DataAccessException{
		List<ManufacPageVO> e_prodlist = null;
		e_prodlist = manufacdao.selectAllProdList(pagevo);
		return e_prodlist;
	}
	public List<ManufacPageVO> d_listprod(PageVO pagevo) throws DataAccessException{
		List<ManufacPageVO> d_prodlist = null;
		d_prodlist = manufacdao.selectAllProdList(pagevo);
		return d_prodlist;
	}
	public int deleteesti(int no) throws Exception {
		return manufacdao.deleteesti(no);
	}
	public int updatestatus(int quotestatus, int no)throws DataAccessException{
		return manufacdao.quotestatus(quotestatus,no);
	}
	public int updatestatus_de(int quotestatus, int no)throws DataAccessException{
		return manufacdao.quotestatus_de(quotestatus,no);
	}
	public int listCount_i() throws Exception{
		return manufacdao.estilistCount_i();
	}
	public int listCount_w() throws Exception{
		return manufacdao.estilistCount_w();
	}
	public int listCount_d() throws Exception{
		return manufacdao.estilistCount_d();
	}
	public int listCount_c() throws Exception{
		return manufacdao.estilistCount_c();
	}
}
