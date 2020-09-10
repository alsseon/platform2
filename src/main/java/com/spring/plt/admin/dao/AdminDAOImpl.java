package com.spring.plt.admin.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.plt.admin.vo.AdminVO;

@Repository("adminDAO")
public class AdminDAOImpl implements AdminDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public AdminVO loginById(AdminVO adminVO) throws DataAccessException {
		AdminVO vo = sqlSession.selectOne("mapper.admin.loginById", adminVO);
		return vo;
	}
	
}
