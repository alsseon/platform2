package com.spring.plt.manufacpage.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.plt.manufacpage.vo.ManufacPageVO;
import com.spring.plt.page.vo.PageVO;

@Repository("manufacPageDAO")
public class ManufacPageDAOImpl implements ManufacPageDAO{
	@Autowired
	private SqlSession sqlSession;
	@Override
	public int listCount() throws DataAccessException{
		int listCount = sqlSession.selectOne("mapper.manufacpage.listCount");
		
		return listCount;
	}
	@Override
	public List<ManufacPageVO> selectAllEstiList(PageVO pagevo) throws DataAccessException{
		List<ManufacPageVO> estiList = null;
		estiList = sqlSession.selectList("mapper.manufacpage.selectAllEstilist",pagevo);
		return estiList;
	}
	public List<ManufacPageVO> selectWaitingEstiList(PageVO pagevo) throws Exception{
		List<ManufacPageVO> estiList = null;
		estiList = sqlSession.selectList("mapper.manufacpage.selectWaitingEstiList",pagevo);
		return estiList;
	}
	public List<ManufacPageVO> selectIngEstiList(PageVO pagevo) throws Exception{
		List<ManufacPageVO> estiList = null;
		estiList = sqlSession.selectList("mapper.manufacpage.selectIngEstiList",pagevo);
		return estiList;
	}
	public List<ManufacPageVO> selectComEstiList(PageVO pagevo) throws Exception{
		List<ManufacPageVO> estiList = null;
		estiList = sqlSession.selectList("mapper.manufacpage.selectComEstiList",pagevo);
		return estiList;
	}
	public List<ManufacPageVO> selectDeEstiList(PageVO pagevo) throws Exception{
		List<ManufacPageVO> estiList = null;
		estiList = sqlSession.selectList("mapper.manufacpage.selectDeEstiList",pagevo);
		return estiList;
	}
	@Override
	public List<ManufacPageVO> selectAllProdList(PageVO pagevo) throws DataAccessException{
		
		List<ManufacPageVO> prodList = null;
		prodList = sqlSession.selectList("mapper.manufacpage.selectAllProdlist",pagevo);
		
		return prodList;
	}
	@Override
	public List<ManufacPageVO> selectWaitProdList(PageVO pagevo) throws DataAccessException{
		
		List<ManufacPageVO> w_prodList = null;
		w_prodList = sqlSession.selectList("mapper.manufacpage.selectWaitProdlist",pagevo);
		
		return w_prodList;
	}
	@Override
	public List<ManufacPageVO> selectIngProdList(PageVO pagevo) throws DataAccessException{
		
		List<ManufacPageVO> i_prodList = null;
		i_prodList = sqlSession.selectList("mapper.manufacpage.selectIngProdList",pagevo);
		
		return i_prodList;
	}
	@Override
	public List<ManufacPageVO> selectComProdList(PageVO pagevo) throws DataAccessException{
		
		List<ManufacPageVO> c_prodList = null;
		c_prodList = sqlSession.selectList("mapper.manufacpage.selectComProdList",pagevo);
		
		return c_prodList;
	}
	@Override
	public List<ManufacPageVO> selectSailProdList(PageVO pagevo) throws DataAccessException{
		
		List<ManufacPageVO> s_prodList = null;
		s_prodList = sqlSession.selectList("mapper.manufacpage.selectSailProdList",pagevo);
		
		return s_prodList;
	}
	@Override
	public List<ManufacPageVO> selectEndProdList(PageVO pagevo) throws DataAccessException{
		
		List<ManufacPageVO> e_prodList = null;
		e_prodList = sqlSession.selectList("mapper.manufacpage.selectEndProdList",pagevo);
		
		return e_prodList;
	}
	@Override
	public List<ManufacPageVO> selectDeProdList(PageVO pagevo) throws DataAccessException{
		
		List<ManufacPageVO> d_prodList = null;
		d_prodList = sqlSession.selectList("mapper.manufacpage.selectDeProdList",pagevo);
		
		return d_prodList;
	}
	@Override
	public int deleteesti(int no) throws DataAccessException {
		int deleteesti = sqlSession.delete("mapper.manufacpage.deleteesti", no);
		
		return deleteesti;
	}
	@Override
	public int quotestatus(int quotestatus, int no) throws DataAccessException{
		int result = 0;
		if (quotestatus == 0) {
			result = sqlSession.update("mapper.manufacpage.upstatus_esti_ing",no); //�늻瑜대㈃ 吏꾪뻾以묒쑝濡� �뾽�뜲�씠�듃
			System.out.println("dao result" + result);
		}else if(quotestatus == 1) {
			result = sqlSession.update("mapper.manufacpage.upstatus_esti_com",no);//�셿猷뚮줈 �뾽�뜲�씠�듃�꽩
		}
		return result;
	}
	public int quotestatus_de(int quotestatus, int no) throws DataAccessException{
		int result = 0;
		if (quotestatus == 0) {
			result = sqlSession.update("mapper.manufacpage.upstatus_esti_de",no);
		}
		return result;
	}
	@Override
	public int estilistCount_i() throws Exception{
		int estilistCount_i = sqlSession.selectOne("mapper.manufacpage.estilistCount_i");
		return estilistCount_i;
	}
	@Override
	public int estilistCount_w() throws Exception{
		int estilistCount_w = sqlSession.selectOne("mapper.manufacpage.estilistCount_w");
		System.out.println("목록이 없을때 Count값이 어떻게 나오는지 확인"+estilistCount_w);
		return estilistCount_w;
	}
	@Override
	public int estilistCount_c() throws Exception{
		int estilistCount_c = sqlSession.selectOne("mapper.manufacpage.estilistCount_c");
		return estilistCount_c;
	}
	@Override
	public int estilistCount_d() throws Exception{
		int estilistCount_d = sqlSession.selectOne("mapper.manufacpage.estilistCount_d");
		return estilistCount_d;
	}
}
