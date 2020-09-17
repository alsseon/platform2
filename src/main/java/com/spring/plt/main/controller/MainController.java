package com.spring.plt.main.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface MainController {

	ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception;

}
