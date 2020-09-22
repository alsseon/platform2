package com.spring.plt.quotation.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.plt.quotation.service.QuotationService;
import com.spring.plt.quotation.vo.QuotationVO;

@Controller("quotationController")
public class QuotationControllerImpl implements QuotationController{
	@Autowired
	QuotationService service;
	@RequestMapping(value = "/quotation/insertQuotationForm.do", method = RequestMethod.GET)
	@Override
	public ModelAndView insertQuotationView(@RequestParam("manuId") String manuId, HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String viewName = (String) request.getAttribute("viewName");
		System.out.println(viewName);
		ModelAndView mav = new ModelAndView(viewName);
		return mav;
	}
	
	
	@RequestMapping(value = "/insertQuotation.do")
	@Override
	public ModelAndView insertQuotation(@ModelAttribute QuotationVO quotationVO, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("insert Quotation Controller");
		System.out.println(quotationVO.getManuId());
		System.out.println(quotationVO);
		System.out.println("tempSave泥댄겕瑜� �븞�뻽�쓣�븣 媛믪씠 �뼱�뼸寃� �뱾�뼱�삤�뒗吏� �솗�씤 : " + quotationVO.getTempSave());
		if (quotationVO.getTempSave() == null) quotationVO.setTempSave("false");
		System.out.println("tempSave 泥섎━ �썑 quotationVO: "+quotationVO);
		service.insertQuotation(quotationVO);
		String viewName = "redirect:/manufacSearch/viewManufac.do?id=" + quotationVO.getManuId();
		ModelAndView mav = new ModelAndView(viewName);
		return mav;
	}
	
	@RequestMapping(value = "/quotationList.do",  produces="application/json; charset=UTF8")
	@Override
	@ResponseBody
	public List<QuotationVO> quotationList(HttpServletRequest request, HttpServletResponse responset){
		System.out.println("Quotation List Controller");
		List<QuotationVO> list = service.quotationList();
		System.out.println(list);
		return list;
	}
	
	@RequestMapping(value="quotation/viewOneQuotation.do", method = RequestMethod.GET)
	@Override
	public ModelAndView viewOneQuotation(@RequestParam("no") String no, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Quotation NO = " + no);
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		QuotationVO quotationVO = service.viewOneQuotation(no);
		mav.addObject("quotationVO", quotationVO);
		return mav;
	}
	
	@RequestMapping(value="/alarmQuotation.do", method = RequestMethod.GET)
	@Override
	@ResponseBody
	public List<QuotationVO> alarmQuotation(@RequestParam("compId") String compId, HttpServletRequest request, HttpServletResponse response){
		System.out.println("Quotation List Controller");
		List<QuotationVO> list = service.alarmQuotation(compId);
		System.out.println(list);
		return list;
	}
}
