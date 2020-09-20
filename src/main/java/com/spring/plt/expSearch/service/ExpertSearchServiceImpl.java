package com.spring.plt.expSearch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.plt.expSearch.dao.ExpertSearchDAO;
import com.spring.plt.expert.vo.ExpertVO;
import com.spring.plt.page.vo.PageVO;

@Service("expertSearchService")
public class ExpertSearchServiceImpl implements ExpertSearchService{
	@Autowired
	ExpertSearchDAO dao;
	
	@Override
	public List<ExpertVO> serchByExpertName(String name) {
		System.out.println("expert Service name");
		return dao.serchByExpertName(name);
	}

	@Override
	public List<ExpertVO> serchByExpertType(String type) {
		System.out.println("expert Service type");
		return dao.serchByExpertType(type);
	}

	@Override
	public ExpertVO viewExpert(String id) {
		System.out.println("expert service view");
		return dao.viewExpert(id);
	}

	@Override
	public List<ExpertVO> allExpert(PageVO pageVO) {
		System.out.println("expert Service all");
		return dao.allExpert(pageVO);
	}

	@Override
	public int listCount() {
		return dao.listCount();
	}
}
