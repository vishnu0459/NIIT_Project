package com.vishnu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public String goToHome()
	{
		return "Home";
	}
	@RequestMapping("/dfg")
	ModelAndView m5()
	{
		ModelAndView modelAndView=new ModelAndView("hello");
		modelAndView.addObject("nm",128);
		return modelAndView;
	}
	@RequestMapping("/bcd")
	ModelAndView a1()
	{
		ModelAndView modelAndView=new ModelAndView("ShowCategory");
		modelAndView.addObject("nm",120);
		return modelAndView;
	}
	@RequestMapping("/about")
	public String aboutUs()
	{
		return "AboutUs";
	}
	@RequestMapping("/contact")
	public String contactUs()
	
	{
		return "ContactUs";
	}
}
