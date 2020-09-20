package com.spring.plt.scrap.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.spring.plt.scrap.vo.ScrapVO;

public interface ScrapDAO {
	//?쟾臾멸? 4媛쒕쭔 異쒕젰
		public List<ScrapVO> printExpertScrap(String compId) throws DataAccessException;
		
		//?쟾臾멸? * 異쒕젰
		public List<ScrapVO> printExpertScrapAll(Map compMap) throws DataAccessException;

		
		//?젣議곗뾽泥? 4媛쒕쭔 異쒕젰
		public List<ScrapVO> printManuScrap(String compId) throws DataAccessException;
		
		//?젣議곗뾽泥? * 異쒕젰
		public List<ScrapVO> printManuScrapAll(Map compMap) throws DataAccessException;
			
		//insert scrap
		public void scrapExpert(ScrapVO scrapVO) throws DataAccessException;
		
		public void scrapManu(ScrapVO scrapVO) throws DataAccessException;
			
		//delete scrap
		public int deleteExpertScrap(int no) throws DataAccessException;

		public int deleteManuScrap(int no) throws DataAccessException;

		public int listCount(String compId) throws Exception;
		
		public int listExpScrapCount(String compId) throws Exception;

		public int isOverlapE(String expId) throws Exception;

		public int isOverlapM(String expId) throws Exception;
}
