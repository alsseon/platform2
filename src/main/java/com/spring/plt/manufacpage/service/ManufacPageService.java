package com.spring.plt.manufacpage.service;

import java.util.List;

import com.spring.plt.manufacpage.vo.ManufacPageVO;
import com.spring.plt.page.vo.PageVO;

public interface ManufacPageService {
	public int listCount();

	public List<ManufacPageVO> listesti(PageVO pagevo);

	public List<ManufacPageVO> listprod(PageVO pagevo);

	public int deleteesti(int no) throws Exception;

	public int updatestatus(int quotestatus, int no);

	public int updatestatus_de(int quotestatus, int no);

	public List<ManufacPageVO> w_estiList(PageVO pagevo) throws Exception;
	public List<ManufacPageVO> i_estiList(PageVO pagevo) throws Exception;
	public List<ManufacPageVO> c_estiList(PageVO pagevo) throws Exception;
	public List<ManufacPageVO> d_estiList(PageVO pagevo) throws Exception;

	public List<ManufacPageVO> d_listprod(PageVO pagevo)throws Exception;
	public List<ManufacPageVO> w_listprod(PageVO pagevo)throws Exception;
	public List<ManufacPageVO> i_listprod(PageVO pagevo)throws Exception;
	public List<ManufacPageVO> c_listprod(PageVO pagevo)throws Exception;
	public List<ManufacPageVO> s_listprod(PageVO pagevo)throws Exception;
	public List<ManufacPageVO> e_listprod(PageVO pagevo)throws Exception;
	
	public int listCount_d() throws Exception;
	public int listCount_i() throws Exception;
	public int listCount_w() throws Exception;
	public int listCount_c() throws Exception;
}
