package com.spring.plt.map.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.plt.map.vo.MapVO;

@Controller
public class MapController {
	@Autowired
	SqlSession sqlSession;
	
	@RequestMapping(value="/map/viewMap.do", method = RequestMethod.GET)
	public ModelAndView viewMap(HttpServletRequest request, HttpServletResponse response) {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		List<MapVO> manuAddrList = sqlSession.selectList("mapper.map.getManuAddrList");
		mav.addObject("manuAddrList", manuAddrList);
		System.out.println(mav);
		return mav;
	}
	
	
	@RequestMapping("/getGeo")
	public Map<String, Map<String,Integer>> getGeo(HttpServletRequest requset ){
		return null;
	}
}
