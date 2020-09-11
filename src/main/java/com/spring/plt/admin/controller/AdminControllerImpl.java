package com.spring.plt.admin.controller;

import java.util.List;

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
import com.spring.plt.admin.vo.EditInfoVO;
import com.spring.plt.admin.vo.LoginLogVO;

@Controller("adminController")
@EnableAspectJAutoProxy
public class AdminControllerImpl implements AdminController {

	@Autowired
	private AdminService adminService;
	@Autowired
	private AdminVO adminVO;
	private LoginLogVO loginVO;
		
	@Override
	@RequestMapping(value= {"/admin/changeLogForm.do","/admin/startchangeLogForm.do","/admin/manuchangeLogForm.do","/admin/expertchangeLogForm.do"}, method = {RequestMethod.GET, RequestMethod.POST})
	   public ModelAndView changeLog(HttpServletRequest request, HttpServletResponse response) throws Exception{
	      List<EditInfoVO> startEdit = adminService.startUpEdit();
	      List<EditInfoVO> manuEdit = adminService.manuEdit();
	      List<EditInfoVO> expertEdit = adminService.expertEdit();
	      
	      String viewName = (String)request.getAttribute("viewName");
	      ModelAndView mav = new ModelAndView();
	      
	      mav.addObject("manufacVO", manuEdit);
	      mav.addObject("startUpVO", startEdit);
	      mav.addObject("expertVO", expertEdit);
	      
	      mav.setViewName(viewName);
	      return mav;
	   }
	@RequestMapping(value="/admin/LoginLogForm.do", method= {RequestMethod.GET, RequestMethod.GET})
	public ModelAndView LoginLog(HttpServletRequest request, HttpServletResponse response) throws Exception{
		List<LoginLogVO> LoginLog = adminService.LoginLog();
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		
    	mav.addObject("LoginLogVO", LoginLog);
    		
		mav.setViewName(viewName);
		return mav;
	}
	   @RequestMapping(value="admin/*Form.do", method= {RequestMethod.POST, RequestMethod.GET})
	   public ModelAndView Form(HttpServletRequest request, HttpServletResponse response) throws Exception{
	      String viewName = (String)request.getAttribute("viewName");
	      ModelAndView mav = new ModelAndView();
	      mav.setViewName(viewName);
	      return mav;
	   }

	@RequestMapping(value="/admin/login.do", method=RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("member") AdminVO member, RedirectAttributes rAttr, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("adminVO: "+member);
		ModelAndView mav = new ModelAndView();
		adminVO = adminService.login(member);
		System.out.println("DB를 거친 후 member: "+adminVO);
		
		String ip = request.getHeader("X-Forwarded-For");

        if (ip == null) {

            ip = request.getRemoteAddr();

        }
        System.out.println(ip+"+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		if(adminVO != null && ip.equals("127.0.0.1")) {
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
