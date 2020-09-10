package com.spring.plt.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.plt.admin.service.AdminService;
import com.spring.plt.admin.vo.AdminVO;

@Controller("adminController")
@EnableAspectJAutoProxy
public class AdminControllerImpl implements AdminController {
	
	@Autowired
	private AdminService adminService;
	@Autowired
	private AdminVO adminVO;
	
	@Override
	@RequestMapping(value="/admin/login.do", method=RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("member") AdminVO member, RedirectAttributes rAttr, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("adminVO: "+member);
		ModelAndView mav = new ModelAndView();
		adminVO = adminService.login(member);
		System.out.println("DB를 거친 후 member: "+adminVO);
		if(adminVO != null) {
			HttpSession session = request.getSession();
			session.setAttribute("member", adminVO);
			session.setAttribute("isLogOn", true);
			mav.setViewName("redirect:/main.do");				
			} else {
				rAttr.addAttribute("result", "loginFailed");
				mav.setViewName("redirect:/common/loginForm.do");
			}		
		return mav;
	}
	
	@Override
	@RequestMapping(value="/admin/logout.do", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("member");
		session.removeAttribute("isLogOn");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/main.do");
		return mav;
	}
}
