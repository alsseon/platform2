package com.spring.plt.startupViewStatus.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.plt.page.vo.PageVO;
import com.spring.plt.startupViewStatus.service.StartupViewStatusService;
import com.spring.plt.startupViewStatus.vo.StartupViewStatusVO;


@Controller
public class StartupViewStatusController {
	@Autowired
	private StartupViewStatusService service;
	
	@Autowired
	private StartupViewStatusVO vo;
	@RequestMapping(value= {"/startupViewStatus/allQuotationList.do","/startupViewStatus/quotationList_Waiting.do"},method = RequestMethod.GET)
	public ModelAndView allQuotationList(@RequestParam("compId") String id, PageVO pagevo, @RequestParam(value="nowPage", required = false) HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("00000000000000000");
		String viewName = (String) request.getAttribute("viewName");
		System.out.println(viewName);
		List<StartupViewStatusVO> allQuotationList = service.allQuotationList(id);
		int total = startuppageservice.listCount();
		if(nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		}else if(nowPage == null) {
			nowPage = "1";
		}else if(cntPerPage == null) {
			cntPerPage = "10";
		}
		pagevo = new PageVO(total, Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("allQuotationList", allQuotationList);
		return mav;
	}
	
}
