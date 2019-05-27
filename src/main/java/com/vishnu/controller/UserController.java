package com.vishnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vishnu.Daoimpl.ProductDao;
import com.vishnu.Daoimpl.SupplierDao;
import com.vishnu.Daoimpl.UserDaoImpl;
import com.vishnu.model.Product;
import com.vishnu.model.Supplier;
import com.vishnu.model.UserRegister;


@Controller
public class UserController {

	@Autowired
	ProductDao proDao;
	
	@Autowired
	UserDaoImpl userDao;
	
	@Autowired
	SupplierDao supplierDao;
	
	public UserController() {
		System.out.println("user controller is loaded");
	}
	
	@RequestMapping("/displayproduct")
	public ModelAndView displayUserProduct()
	{
		ModelAndView modelAndView= new ModelAndView("UserProducts");
		List<Product> list=userDao.receiveProductList();
		for(Product pro:list)
		{
			System.out.println(pro.getProductId());
			System.out.println(pro.getProductName());
		}
		modelAndView.addObject("userProduct",list);
		return modelAndView;
	}
	
	@RequestMapping("/displayProduct")
	public ModelAndView displayUserViewProduct(@RequestParam("pro_id") int productId,@RequestParam("pro_sup") String supName)
	{
		Product product= proDao.getProduct(productId);
		ModelAndView modelAndView =new ModelAndView("ProductDetails");
		Supplier supplier=supplierDao.getSupplierName(supName);
		System.out.println(supplier.getSupplierAddress());
		
		modelAndView.addObject("proDetails",product);
		modelAndView.addObject("sup",supplier);
		return modelAndView;
		
	}
	
	@RequestMapping("/userHome")
	public String userhome()
	{
		return "UserHome";
	}
	
	@RequestMapping("/userRegister")
	
	public ModelAndView gotoRegForm()
	{
		ModelAndView modelAndView =new ModelAndView("UserRegister");
		
		UserRegister reg =new UserRegister();
		modelAndView.addObject("register",reg);
		
		return modelAndView;
		
	}
	
	@RequestMapping("/registration")
	public String saveUserRegister(@ModelAttribute("register") UserRegister user)
	{
		userDao.saveUser(user);
		
		return "redirect:login";
	}
	//==========================================================login=================================================
	@RequestMapping("/login")
	public ModelAndView gotoLogin()
	{
		ModelAndView modelAndView=new ModelAndView("Login");
		UserRegister user=new UserRegister();
		modelAndView.addObject("login",user);
		
		return modelAndView;
	}
	
	
	@RequestMapping("/loginForm")
	public ModelAndView validateLogin(@ModelAttribute("login") UserRegister user)
	{
		boolean b=userDao.validateloginForm(user);
		System.out.println(b);
		if(b)
		{
			ModelAndView modelAndView= new ModelAndView("UserSucess");
			
			
		return modelAndView;
		}
		else
		{
			ModelAndView modelAndView= new ModelAndView("Login");
			modelAndView.addObject("msg","Login Failed");
			return modelAndView;
			
		}
	}
	@RequestMapping("/loginerror")
	public ModelAndView Afterloginfailure()
	{

	    ModelAndView mv=new ModelAndView("Login");
	    mv.addObject("invaliduser","invalid user name / password");
	    mv.addObject("login",new UserRegister());
	    return mv;
	}
	@RequestMapping("/afterloginSuccess")
	public String Afterloginsuccess()
	{
	     String pagename="";
	     SecurityContext securityContext=SecurityContextHolder.getContext();
	     Authentication authentication=securityContext.getAuthentication();
	     String nameId=authentication.getName();
	     System.out.println(nameId);

	 java.util.Collection<GrantedAuthority> grantedAuthorities=  (java.util.Collection<GrantedAuthority>) authentication.getAuthorities();
	    for (GrantedAuthority grantedAuthority : grantedAuthorities)
	    {   System.out.println(grantedAuthority);
	        String authority= grantedAuthority.getAuthority();
	        if(authority.equals("ROLE_USER"))
	        {
	             pagename="UserHome";    
	        }
	        else if(authority.equals("ROLE_ADMIN"))
	        {
	            pagename="Home";
	        }
	        
	        
	    }
	    return pagename;

	}
}
