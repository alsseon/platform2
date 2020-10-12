package com.spring.plt.startupViewStatus.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.plt.startupViewStatus.vo.StartupViewStatusVO;

@Repository
public class StartupViewStatusDAO {
	@Autowired
	private SqlSession sqlSession;

	public List<StartupViewStatusVO> allQuotationList(String id) {
		List<StartupViewStatusVO> list = sqlSession.selectList("mapper.startupViewStatus.allQuotationList",id);
		return list;
	}

}
