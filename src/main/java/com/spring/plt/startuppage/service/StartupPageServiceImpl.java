package com.spring.plt.startuppage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.spring.plt.page.vo.PageVO;
import com.spring.plt.startuppage.dao.StartupPageDAO;
import com.spring.plt.startuppage.vo.StartupPageVO;

@Service("startupPageService")
public class StartupPageServiceImpl implements StartupPageService{
	@Autowired
	private StartupPageDAO startuppagedao;

	
	public int deleteesti(int no) throws Exception{
		return startuppagedao.deleteesti(no); //제조업ㅊ견적 철회 삭제 기능
	}
	public int deletecon(int no) throws Exception{
		return startuppagedao.deletecon(no); //컨설팅 견적 철회 삭제 기능
	}
	
	public List<StartupPageVO> listesti(PageVO pagevo) throws DataAccessException{
		List<StartupPageVO> estilist = null;
		estilist = startuppagedao.selectAllEstiList(pagevo);
		return estilist; 
	}
	public List<StartupPageVO> w_listesti(PageVO pagevo) throws DataAccessException{
		List<StartupPageVO> w_estilist = null;
		w_estilist = startuppagedao.selectWaitEstiList(pagevo);
		return w_estilist;
	}
	public List<StartupPageVO> c_listesti(PageVO pagevo) throws DataAccessException{
		List<StartupPageVO> c_estilist = null;
		c_estilist = startuppagedao.selectComEstiList(pagevo);
		return c_estilist;
	}
	public List<StartupPageVO> i_listesti(PageVO pagevo) throws DataAccessException{
		List<StartupPageVO> i_estilist = null;
		i_estilist = startuppagedao.selectIngEstiList(pagevo);
		return i_estilist;
	}
	public List<StartupPageVO> d_listesti(PageVO pagevo) throws DataAccessException{
		List<StartupPageVO> d_estilist = null;
		d_estilist = startuppagedao.selectDeEstiList(pagevo);
		return d_estilist;
	}
	
	
	
	
	public int listCount() throws DataAccessException{
		return startuppagedao.listCount();
	}
	public int estilistCount_i() throws Exception{
		return startuppagedao.estilistCount_i();
	}
	public int estilistCount_w() throws Exception{
		int result = startuppagedao.estilistCount_w();
		System.out.println("service count : " + result);
		return result;
	}
	public int estilistCount_d() throws Exception{
		return startuppagedao.estilistCount_d();
	}
	public int estilistCount_c() throws Exception{
		return startuppagedao.estilistCount_c();
	}
	
	
	
	public List<StartupPageVO> listprod(PageVO pagevo) throws DataAccessException{
		List<StartupPageVO> prodlist = null;
		prodlist = startuppagedao.selectAllProdList(pagevo);
		return prodlist;
	}
	
	
	
	
	public List<StartupPageVO> listcon(PageVO pagevo) throws DataAccessException{
		List<StartupPageVO> conlist = null;
		conlist = startuppagedao.selectAllConList(pagevo);
		return conlist;
	}
	public List<StartupPageVO> w_listcon(PageVO pagevo) throws DataAccessException{
		List<StartupPageVO> w_conlist = null;
		w_conlist = startuppagedao.selectWaitConList(pagevo);
		return w_conlist;
	}
	public List<StartupPageVO> d_listcon(PageVO pagevo) throws DataAccessException{
		List<StartupPageVO> d_conlist = null;
		d_conlist = startuppagedao.selectDeConList(pagevo);
		return d_conlist;
	}
	public List<StartupPageVO> c_listcon(PageVO pagevo) throws DataAccessException{
		List<StartupPageVO> c_conlist = null;
		c_conlist = startuppagedao.selectComConList(pagevo);
		return c_conlist;
	}
	public List<StartupPageVO> i_listcon(PageVO pagevo) throws DataAccessException{
		List<StartupPageVO> i_conlist = null;
		i_conlist = startuppagedao.selectIngConList(pagevo);
		
		return i_conlist;
	}
	
	
	
	
	
	public int conlistCount_i() throws Exception{
		return startuppagedao.conlistCount_i();
	}
	public int conlistCount_w() throws Exception{
		return startuppagedao.conlistCount_w();
	}
	public int conlistCount_d() throws Exception{
		return startuppagedao.conlistCount_d();
	}
	public int conlistCount_c() throws Exception{
		return startuppagedao.conlistCount_c();
	}
	
	
	
	public int status_y(int status, int no)throws Exception{
		return startuppagedao.status_y(status, no);
	}
	public int status_n(int status, int no)throws Exception{
		return startuppagedao.status_n(status, no);
	}
	public int constatus_y(int status, int no)throws Exception{
		return startuppagedao.constatus_y(status, no);
	}
	public int constatus_n(int status, int no)throws Exception{
		return startuppagedao.constatus_n(status, no);
	}
}
