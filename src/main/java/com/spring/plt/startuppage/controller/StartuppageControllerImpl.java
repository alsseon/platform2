package com.spring.plt.startuppage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.plt.page.vo.PageVO;
import com.spring.plt.startuppage.service.StartupPageService;
import com.spring.plt.startuppage.vo.StartupPageVO;

@Controller("startuppageController")
public class StartuppageControllerImpl implements StartuppageController{
	@Autowired
	private StartupPageService startuppageservice;

	
	@RequestMapping(value = "/startuppage/manu_estilist.do", method = RequestMethod.GET)
	public ModelAndView prodlist(PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		String viewName = (String)request.getAttribute("viewName");
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
		List<StartupPageVO> prodlist = startuppageservice.listprod(pagevo);
		List<StartupPageVO> estilist = startuppageservice.listesti(pagevo);
		List<StartupPageVO> w_estilist = startuppageservice.w_listesti(pagevo);
		List<StartupPageVO> c_estilist = startuppageservice.c_listesti(pagevo);
		List<StartupPageVO> d_estilist = startuppageservice.d_listesti(pagevo);
		List<StartupPageVO> i_estilist = startuppageservice.i_listesti(pagevo);
		
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("prodlist",prodlist);
		mav.addObject("estilist",estilist);
		mav.addObject("w_estilist",w_estilist);
		mav.addObject("c_estilist",c_estilist);
		mav.addObject("d_estilist",d_estilist);
		mav.addObject("i_estilist",i_estilist);
		
		System.out.println(prodlist);
		return mav;
	}
	@RequestMapping(value = "/startuppage/estilist_more_w.do", method = RequestMethod.GET)
	public ModelAndView estilist_w(PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		String viewName = (String)request.getAttribute("viewName");
		System.out.println("estilist_more_w의 viewName: "+viewName);
		int total = startuppageservice.estilistCount_w();
		System.out.println("total : " + total);
		if(nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		}else if(nowPage == null) {
			nowPage = "1";
		}else if(cntPerPage == null) {
			cntPerPage = "10";
		}
		pagevo = new PageVO(total, Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
		List<StartupPageVO> w_estilist = startuppageservice.w_listesti(pagevo);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("w_estilist",w_estilist);
		mav.addObject("pagevo",pagevo);
		return mav;
	}
	@RequestMapping(value = "/startuppage/estilist_more_ing.do", method = RequestMethod.GET)
	public ModelAndView estilist_ing(PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		String viewName = (String)request.getAttribute("viewName");
		int total = startuppageservice.estilistCount_i();
		System.out.println("total : " + total);
		if(nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		}else if(nowPage == null) {
			nowPage = "1";
		}else if(cntPerPage == null) {
			cntPerPage = "10";
		}
		pagevo = new PageVO(total, Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
		List<StartupPageVO> i_estilist = startuppageservice.i_listesti(pagevo);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("i_estilist",i_estilist);
		mav.addObject("pagevo",pagevo);
		return mav;
	}
	@RequestMapping(value = "/startuppage/estilist_more_de.do", method = RequestMethod.GET)
	public ModelAndView estilist_de(PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		int total = startuppageservice.estilistCount_d();
		System.out.println("total : " + total);
		if(nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		}else if(nowPage == null) {
			nowPage = "1";
		}else if(cntPerPage == null) {
			cntPerPage = "10";
		}
		pagevo = new PageVO(total, Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
		List<StartupPageVO> d_estilist = startuppageservice.d_listesti(pagevo);
		ModelAndView mav = new ModelAndView();
		mav.addObject("d_estilist",d_estilist);
		mav.addObject("pagevo",pagevo);
		return mav;
	}
	@RequestMapping(value="/startuppage/estilist_del.do" , method = RequestMethod.GET)
	public ModelAndView deletestatus(@RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		System.out.println("delete NO: "+no);
		startuppageservice.deleteesti(no);
		ModelAndView mav = new ModelAndView("redirect:/startuppage/manu_estilist.do");
		return mav;
	}
	@RequestMapping(value="/startuppage/conlist_del.do" , method = RequestMethod.GET)
	public ModelAndView deletestatus_con(@RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		startuppageservice.deletecon(no);
		ModelAndView mav = new ModelAndView("redirect:/startuppage/consultinglist.do");
		return mav;
	}
	@RequestMapping(value ="/startuppage/updatestatus_y.do", method = RequestMethod.GET)//견적 수락으로 상태 업데이트
	public ModelAndView updatestatus_y(@RequestParam("status") int status, @RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		startuppageservice.status_y(status,no);
		ModelAndView mav = new ModelAndView("redirect:/startuppage/manu_estilist.do");
		return mav;
	}
	@RequestMapping(value ="/startuppage/updatestatus_n.do", method = RequestMethod.GET)//견적 거절로 상태 업데이트
	public ModelAndView updatestatus_n(@RequestParam("status") int status, @RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		startuppageservice.status_n(status,no);
		ModelAndView mav = new ModelAndView("redirect:/startuppage/manu_estilist.do");
	
		return mav;
	}
	
	@RequestMapping(value ="/startuppage/conupdatestatus_y.do", method = RequestMethod.GET)//컨설팅 수락으로 상태 업데이트
	public ModelAndView conupdatestatus_y(@RequestParam("status") int status, @RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		startuppageservice.constatus_y(status,no);
		ModelAndView mav = new ModelAndView("redirect:/startuppage/consultinglist.do");
		return mav;
	}
	@RequestMapping(value ="/startuppage/conupdatestatus_n.do", method = RequestMethod.GET)//컨설팅 거절로 상태 업데이트
	public ModelAndView conupdatestatus_n(@RequestParam("status") int status, @RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		startuppageservice.constatus_n(status,no);
		ModelAndView mav = new ModelAndView("redirect:/startuppage/consultinglist.do");
		return mav;
	}
	@RequestMapping(value = "/startuppage/consultinglist.do", method = RequestMethod.GET)
	public ModelAndView conlist(PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		String viewName = (String)request.getAttribute("viewName");
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
		List<StartupPageVO> conlist = startuppageservice.listcon(pagevo);
		List<StartupPageVO> w_conlist = startuppageservice.w_listcon(pagevo);
		List<StartupPageVO> c_conlist = startuppageservice.c_listcon(pagevo);
		List<StartupPageVO> d_conlist = startuppageservice.d_listcon(pagevo);
		List<StartupPageVO> i_conlist = startuppageservice.i_listcon(pagevo);
		
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("conlist",conlist);
		mav.addObject("w_conlist",w_conlist);
		mav.addObject("c_conlist",c_conlist);
		mav.addObject("d_conlist",d_conlist);
		mav.addObject("i_conlist",i_conlist);
		return mav;
	}
	@RequestMapping(value = "/startuppage/consulting_more_w.do", method = RequestMethod.GET)
	public ModelAndView conlist_w(PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		String viewName = (String)request.getAttribute("viewName");
		int total = startuppageservice.conlistCount_w();
		System.out.println("total : " + total);
		if(nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		}else if(nowPage == null) {
			nowPage = "1";
		}else if(cntPerPage == null) {
			cntPerPage = "10";
		}
		pagevo = new PageVO(total, Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
		List<StartupPageVO> w_conlist = startuppageservice.w_listcon(pagevo);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("w_conlist",w_conlist);
		mav.addObject("pagevo",pagevo);
		return mav;
	}
	@RequestMapping(value = "/startuppage/consulting_more_i.do", method = RequestMethod.GET)
	public ModelAndView conlist_i(PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		String viewName = (String)request.getAttribute("viewName");
		int total = startuppageservice.conlistCount_i();
		System.out.println("total : " + total);
		if(nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		}else if(nowPage == null) {
			nowPage = "1";
		}else if(cntPerPage == null) {
			cntPerPage = "10";
		}
		pagevo = new PageVO(total, Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
		List<StartupPageVO> i_conlist = startuppageservice.i_listcon(pagevo);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("i_conlist",i_conlist);
		mav.addObject("pagevo",pagevo);
		return mav;
	}
	@RequestMapping(value = "/startuppage/consulting_more_d.do", method = RequestMethod.GET)
	public ModelAndView conlist_d(PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		String viewName = (String)request.getAttribute("viewName");
		int total = startuppageservice.conlistCount_d();
		System.out.println("total : " + total);
		if(nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		}else if(nowPage == null) {
			nowPage = "1";
		}else if(cntPerPage == null) {
			cntPerPage = "10";
		}
		pagevo = new PageVO(total, Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
		List<StartupPageVO> d_conlist = startuppageservice.d_listcon(pagevo);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("d_conlist",d_conlist);
		mav.addObject("pagevo",pagevo);
		return mav;
	}
	@RequestMapping(value = "/startuppage/com_consultinglist", method = RequestMethod.GET)//완료 된 컨설팅 목록 출력
	public ModelAndView com_consulting(PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		String viewName = (String)request.getAttribute("viewName");
		int total = startuppageservice.conlistCount_c();
		System.out.println("total : " + total);
		if(nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		}else if(nowPage == null) {
			nowPage = "1";
		}else if(cntPerPage == null) {
			cntPerPage = "10";
		}
		pagevo = new PageVO(total, Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
		List<StartupPageVO> c_conlist = startuppageservice.c_listcon(pagevo);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("c_conlist",c_conlist);
		mav.addObject("pagevo",pagevo);
		return mav;
	}
}
