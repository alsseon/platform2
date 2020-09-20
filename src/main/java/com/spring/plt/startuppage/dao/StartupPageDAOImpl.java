package com.spring.plt.startuppage.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.plt.page.vo.PageVO;
import com.spring.plt.startuppage.vo.StartupPageVO;

@Repository("startupPageDAO")
public class StartupPageDAOImpl implements StartupPageDAO{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int deleteesti(int no) throws DataAccessException {
		int deleteesti = sqlSession.delete("mapper.startuppage.deleteesti", no);
		System.out.println("dao : " + deleteesti);
		return deleteesti;
	}
	@Override
	public int deletecon(int no) throws DataAccessException {
		int deletecon = sqlSession.delete("mapper.startuppage.deletecon", no);
		return deletecon;
	}
	
	@Override
	public int listCount() throws DataAccessException{
		int listCount = sqlSession.selectOne("mapper.startuppage.listCount");
		return listCount;
	}
	@Override
	public int estilistCount_i() throws Exception{
		int EstiListCount_i = sqlSession.selectOne("mapper.startuppage.estilistCount_i");
		return EstiListCount_i;
	}
	@Override
	public int estilistCount_w() throws Exception{
		int estilistCount_w = sqlSession.selectOne("mapper.startuppage.estilistCount_w");
		System.out.println("dao count" + estilistCount_w);
		return estilistCount_w;
	}
	@Override
	public int estilistCount_d() throws Exception{
		int EstiListCount_d = sqlSession.selectOne("mapper.startuppage.estilistCount_d");
		return EstiListCount_d;
	}
	@Override
	public int estilistCount_c() throws Exception{
		int EstiListCount_c = sqlSession.selectOne("mapper.startuppage.estilistCount_c");
		return EstiListCount_c;
	}
	@Override
	public List<StartupPageVO> selectAllEstiList(PageVO pagevo) throws DataAccessException{
		List<StartupPageVO> estiList = null;
		estiList = sqlSession.selectList("mapper.startuppage.selectAllEstilist",pagevo);
		return estiList;
	}
	@Override
	public List<StartupPageVO> selectWaitEstiList(PageVO pagevo) throws DataAccessException{
		List<StartupPageVO> w_estiList = null;
		w_estiList = sqlSession.selectList("mapper.startuppage.selectWaitEstilist",pagevo);
		return w_estiList;
	}
	@Override
	public List<StartupPageVO> selectIngEstiList(PageVO pagevo) throws DataAccessException{
		List<StartupPageVO> i_estiList = null;
		i_estiList = sqlSession.selectList("mapper.startuppage.selectIngEstilist",pagevo);
		return i_estiList;
	}
	@Override
	public List<StartupPageVO> selectComEstiList(PageVO pagevo) throws DataAccessException{
		List<StartupPageVO> c_estiList = null;
		c_estiList = sqlSession.selectList("mapper.startuppage.selectComEstilist",pagevo);
		return c_estiList;
	}
	@Override
	public List<StartupPageVO> selectDeEstiList(PageVO pagevo) throws DataAccessException{
		List<StartupPageVO> d_estiList = null;
		d_estiList = sqlSession.selectList("mapper.startuppage.selectDeEstilist",pagevo);
		return d_estiList;
	}
	public int status_y(int status, int no)throws DataAccessException{
		int result = 0;
		if (status == 0) {
			result = sqlSession.update("mapper.startuppage.upstatus_esti_ing",no); //누르면 진행중으로 업데이트
			System.out.println("dao result" + result);
		}else if(status == 1) {
			result = sqlSession.update("mapper.startuppage.upstatus_esti_com",no);//완료로 업데이트ㄴ
		}
		return result;
	}
	public int status_n(int status, int no) throws DataAccessException{
		int result = 0;
		if (status == 0) {
			result = sqlSession.update("mapper.startuppage.upstatus_esti_de",no);
		}
		return result;
	}
	
	
	
	
	public int constatus_y(int status, int no)throws DataAccessException{
		int result = 0;
		if (status == 0) {
			result = sqlSession.update("mapper.startuppage.upstatus_con_ing",no); //누르면 진행중으로 업데이트
			System.out.println("dao result" + result);
		}else if(status == 1) {
			result = sqlSession.update("mapper.startuppage.upstatus_con_com",no);//완료로 업데이트ㄴ
		}
		return result;
	}
	public int constatus_n(int status, int no) throws DataAccessException{
		int result = 0;
		if (status == 0) {
			result = sqlSession.update("mapper.startuppage.upstatus_con_de",no);
		}
		return result;
	}
	
	
	
	
	@Override
	public int conlistCount_i() throws Exception{
		int conlistCount_i = sqlSession.selectOne("mapper.startuppage.conlistCount_i");
		return conlistCount_i;
	}
	@Override
	public int conlistCount_w() throws Exception{
		int conlistCount_w = sqlSession.selectOne("mapper.startuppage.conlistCount_w");
		return conlistCount_w;
	}
	@Override
	public int conlistCount_d() throws Exception{
		int conlistCount_d = sqlSession.selectOne("mapper.startuppage.conlistCount_d");
		return conlistCount_d;
	}
	@Override
	public int conlistCount_c() throws Exception{
		int conlistCount_c = sqlSession.selectOne("mapper.startuppage.conlistCount_c");
		return conlistCount_c;
	}
	
	
	
	
	
	@Override
	public List<StartupPageVO> selectAllProdList(PageVO pagevo) throws DataAccessException{
		List<StartupPageVO> prodList = null;
		prodList = sqlSession.selectList("mapper.startuppage.selectAllProdlist",pagevo);
		return prodList;
	}	
	@Override
	public List<StartupPageVO> selectAllConList(PageVO pagevo) throws DataAccessException{
		List<StartupPageVO> conList = null;
		conList = sqlSession.selectList("mapper.startuppage.selectAllConlist",pagevo);
		return conList;
	}
	@Override
	public List<StartupPageVO> selectWaitConList(PageVO pagevo) throws DataAccessException{
		List<StartupPageVO> w_conList = null;
		w_conList = sqlSession.selectList("mapper.startuppage.selectWaitConlist",pagevo);
		return w_conList;
	}
	public List<StartupPageVO> selectIngConList(PageVO pagevo) throws DataAccessException{
		List<StartupPageVO> i_conList = null;
		i_conList = sqlSession.selectList("mapper.startuppage.selectIngConlist",pagevo);
		return i_conList;
	}
	public List<StartupPageVO> selectComConList(PageVO pagevo) throws DataAccessException{
		List<StartupPageVO> c_conList = null;
		c_conList = sqlSession.selectList("mapper.startuppage.selectComConlist",pagevo);
		System.out.println("dao Comconlist : " + c_conList);
		return c_conList;
	}
	public List<StartupPageVO> selectDeConList(PageVO pagevo) throws DataAccessException{
		List<StartupPageVO> d_conList = null;
		d_conList = sqlSession.selectList("mapper.startuppage.selectDeConlist",pagevo);
		return d_conList;
	}
}
