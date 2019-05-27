package com.vishnu.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vishnu.Daoimpl.CategoryDaoImpl;

import com.vishnu.Daoimpl.TestSessionFactory;
import com.vishnu.model.Category;



@Controller
public class CategoryController {
	
	@Autowired
	TestSessionFactory ts;
	
	@Autowired 
	CategoryDaoImpl categoryDaoImpl;

	
	public CategoryController()
	{
		System.out.println("Category controller is loaded");
	}
	@RequestMapping(value="/category", method=RequestMethod.GET)
    public ModelAndView goToCategoryForm()
    {
        ModelAndView  mv=new ModelAndView("AddCategory");
        
        mv.addObject("cat",new Category());
        mv.addObject("buttonName","AddCategory");
        
        return  mv;
    }
	@RequestMapping(value="/addCat",method=RequestMethod.POST)
    public String recieveCategoryFormData(@ModelAttribute ("cat") Category ca)
    {
		
		ts.testSesssionFactory();
		
		
        System.out.println(ca.getCategoryName());
        System.out.println(ca.getCategoryDiscription());
            
        categoryDaoImpl.saveCategory(ca);
       
        
        return "Home";
    }
	
	
	
	@RequestMapping("/show")
	public ModelAndView receiveCategoryData()
	{
	  ModelAndView mv=new ModelAndView("ShowCategory");
	List<Category>  li=categoryDaoImpl.receiveData();
	mv.addObject("showcat",li);
	  return mv;
		
		
	}
	@RequestMapping("/del")
	public String deleteCategory(@RequestParam("cat_id") int catid)
	{
		
		Category category=categoryDaoImpl.getCategory(catid);
		categoryDaoImpl.deleteCategoryData(category);
		return "redirect:show";
		
	}
	
	
	@RequestMapping("/edit")
	public ModelAndView updateCatData(@RequestParam("cat_id") int catid) 
	{
		Category category=categoryDaoImpl.getCategory(catid);
		ModelAndView modelAndView = new ModelAndView("AddCategory");
		modelAndView.addObject("cat",category);
		 modelAndView.addObject("buttonName","UpdateCategory");
		
		return modelAndView;
		
	}
	
}
