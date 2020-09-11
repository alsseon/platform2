package com.spring.plt.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.plt.admin.vo.AdminVO;
import com.spring.plt.admin.vo.EditInfoVO;

@Repository("adminDAO")
public class AdminDAOImpl implements AdminDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public AdminVO loginById(AdminVO adminVO) throws DataAccessException {
		AdminVO vo = sqlSession.selectOne("mapper.admin.loginById", adminVO);
		return vo;
	}
	
	@Override
	   public List<EditInfoVO> startUpEdit() throws Exception {
	      List<EditInfoVO> startUpEdit = sqlSession.selectList("mapper.admin.startUpEdit");
	      return startUpEdit;
	   }

   @Override
   public List<EditInfoVO> manuEdit() throws Exception {
      List<EditInfoVO> manuEdit = sqlSession.selectList("mapper.admin.manuEdit");
      return manuEdit;
   }

   @Override
   public List<EditInfoVO> expertEdit() throws Exception {
      List<EditInfoVO> expertEdit = sqlSession.selectList("mapper.admin.expertEdit");
      return expertEdit;
   }
	
}
