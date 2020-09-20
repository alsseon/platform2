package com.spring.plt.manufacpage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.plt.page.vo.PageVO;

public interface ManufacPageController {
	public ModelAndView prodlist(PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView deletestatus(@RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response)throws Exception;
	public ModelAndView com_deletestatus(@RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response)throws Exception;
	public ModelAndView updatestatus(@RequestParam("quotestatus") int quotestatus, @RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response)throws Exception;
	public ModelAndView updatestatus_de(@RequestParam("quotestatus") int quotestatus, @RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response)throws Exception;
	public ModelAndView prodlist_w(PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView prodlist_ing(PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView prodlist_com(PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView prodlist_de(PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception;
}
