package com.vishnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vishnu.Daoimpl.SupplierDao;
import com.vishnu.Daoimpl.TestSessionFactory;
import com.vishnu.model.Supplier;

@Controller
public class SupplierController 
{

	@Autowired
	SupplierDao supplyDao;
	
	@Autowired
	TestSessionFactory ts;
	
public SupplierController() {

	System.out.println("supplier controller is loaded");
}
	
@RequestMapping(value="/supp",method=RequestMethod.GET)
	
	public ModelAndView supplyFormData()
	{
		 ModelAndView mv=new ModelAndView("Supplier");
		 mv.addObject("ButtonName","Add Supplier");
		 mv.addObject("sup",new Supplier());
		 
		 return mv;
		 
				 
	}
	@RequestMapping("/sup_1")
	 public ModelAndView recieveSupplyFormData(@ModelAttribute ("sup") Supplier s)
	    {
			ModelAndView modelAndView=new ModelAndView("Home");
			ts.testSesssionFactory();
	        
	           System.out.println("sup------------id"+s.getSupplierId());
	        supplyDao.saveSupplier(s);
	       
	        
	        return modelAndView;
	    }
	@RequestMapping("/showsupply")
	
	public ModelAndView recieveSupplyData()
	{
		
		ModelAndView modelAndView=new ModelAndView("ShowSupplier");
		List<Supplier> l=supplyDao.receiveSupData();
		modelAndView.addObject("showsup",l);
		
	return modelAndView;
	
	}
	
	
	@RequestMapping("/dele")
	public String deleteSupplyData(@RequestParam("sup_id") int supplierId)
	{
		
		Supplier supplier=supplyDao.getsupplier(supplierId);
		supplyDao.deleteSupplierData(supplier);
		return "redirect:showsupply";
	}
	
	@RequestMapping("/edits")
	public ModelAndView updateSupplyData(@RequestParam("sup_id") int supplierId)
	{
		Supplier supplier=supplyDao.getsupplier(supplierId);
		ModelAndView modelAndView=new ModelAndView("Supplier");
		modelAndView.addObject("sup",supplier);
		modelAndView.addObject("ButtonName","Update Supplier");
		return modelAndView;
		
	}
	
}
