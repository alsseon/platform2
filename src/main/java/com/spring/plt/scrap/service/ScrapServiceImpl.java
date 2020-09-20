package com.spring.plt.scrap.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.spring.plt.scrap.dao.ScrapDAO;
import com.spring.plt.scrap.vo.ScrapVO;

@Service("scrapService")
public class ScrapServiceImpl implements ScrapService{
	@Autowired
	ScrapDAO scrapDAO;
	
	//scrap
	@Override
	public List<ScrapVO> printExpertScrapAll(Map compMap) throws Exception{
		List<ScrapVO> expertScrapAllList = scrapDAO.printExpertScrapAll(compMap);
		return expertScrapAllList;
	}
	
	@Override
	public List<ScrapVO> printExpertScrap(String compId) throws Exception{
		List<ScrapVO> expertScrapList = scrapDAO.printExpertScrap(compId);
		return expertScrapList;
	}
	
	@Override
	public List<ScrapVO> printManuScrapAll(Map compMap) throws Exception{
		List<ScrapVO> manuScrapAllList = scrapDAO.printManuScrapAll(compMap);
		return manuScrapAllList;
	}
	
	@Override
	public List<ScrapVO> printManuScrap(String compId) throws Exception{
		List<ScrapVO> manuScrapList = scrapDAO.printManuScrap(compId);
		return manuScrapList;
	}
		
	@Override
	public Map<String, List<ScrapVO>> printScrap(String compId) throws Exception{
		Map<String, List<ScrapVO>> allScrapMap = new HashMap<String, List<ScrapVO>>();
		List<ScrapVO> expertScrapList = scrapDAO.printExpertScrap(compId);
		List<ScrapVO> manuScrapList = scrapDAO.printManuScrap(compId);
		allScrapMap.put("expertScrap", expertScrapList);
		allScrapMap.put("manuScrap", manuScrapList);
		return allScrapMap;
	}
	
	//insert scrap
	@Override
	public void scrapExpert(ScrapVO scrap) throws DataAccessException{
		scrapDAO.scrapExpert(scrap);
	}

	@Override
	public void scrapManu(ScrapVO scrap) throws DataAccessException{
		scrapDAO.scrapManu(scrap);
		System.out.println("scrapService �Ϸ�");
	}

	
	//scrap delete
	@Override
	public int deleteExpertScrap(int no) throws DataAccessException{
		return scrapDAO.deleteExpertScrap(no);
	}
	
	@Override
	public int deleteManuScrap(int no) throws DataAccessException{
		return scrapDAO.deleteManuScrap(no);
	}

	public int listCount(String compId) throws Exception{
		return scrapDAO.listCount(compId);
	}
	
	public int listExpScrapCount(String compId) throws Exception{
		return scrapDAO.listExpScrapCount(compId);
	}
	
	public int isOverlapE(String expId) throws Exception{
		return scrapDAO.isOverlapE(expId);
	}

	public int isOverlapM(String expId) throws Exception{
		return scrapDAO.isOverlapM(expId);
	}
}
