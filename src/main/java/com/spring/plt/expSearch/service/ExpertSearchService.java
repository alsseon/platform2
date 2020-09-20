package com.spring.plt.expSearch.service;

import java.util.List;

import com.spring.plt.expert.vo.ExpertVO;
import com.spring.plt.page.vo.PageVO;

public interface ExpertSearchService {
	public List<ExpertVO> serchByExpertName(String name);
	public List<ExpertVO> serchByExpertType(String type);
	public ExpertVO viewExpert(String id);
	public List<ExpertVO> allExpert(PageVO pageVO);
	public int listCount();
}
