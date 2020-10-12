package com.spring.plt.startupViewStatus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.plt.startupViewStatus.dao.StartupViewStatusDAO;
import com.spring.plt.startupViewStatus.vo.StartupViewStatusVO;

@Service
public class StartupViewStatusService {
	@Autowired
	private StartupViewStatusDAO dao;
	
	public List<StartupViewStatusVO> allQuotationList(String id) {
		List<StartupViewStatusVO> list = dao.allQuotationList(id);
		return list;
	}
}
