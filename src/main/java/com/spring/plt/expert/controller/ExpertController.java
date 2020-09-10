package com.spring.plt.expert.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.plt.expert.vo.ExpertVO;

public interface ExpertController {
	public ModelAndView login(@ModelAttribute("member") ExpertVO member, RedirectAttributes rAttr, HttpServletRequest request,
			HttpServletResponse response) throws Exception;
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView join_expert(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView expertList(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView deleteexpert(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity updateexpert(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView expertselect(@RequestParam("id")String id ,HttpServletRequest request, HttpServletResponse response) throws Exception;
}
