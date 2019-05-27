package com.vishnu.controller;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vishnu.Daoimpl.CartDaoImpl;
import com.vishnu.Daoimpl.ProductDao;
import com.vishnu.model.Cart;
import com.vishnu.model.Product;

@Controller
public class CartController {
	@Autowired
	CartDaoImpl cartDao;
	@Autowired
	ProductDao proDao;
	

//	@RequestMapping("/cartProduct")
//	public String cartDetails(@RequestParam("pro_id") int productId)
//	{
//		System.out.println("pro---------id"+productId);
//		Product product=proDao.getProduct(productId);
//		cartDao.saveCartDetails(product);
//		
//		return "ProductDetails";
//	}
	
	public CartController() {
		System.out.println("cart controller");
	}
	@PostMapping("/cartProductss")
	public String cartProDetails(HttpServletRequest request)
	{
		
		Cart cat= new Cart();
		Random rd=new Random();
		cat.setCartId(rd.nextInt(10000));
		cat.setProductId(Integer.parseInt(request.getParameter("proId")));
		cat.setProductName(request.getParameter("proName"));
		cat.setProductDescription(request.getParameter("proDes"));
		cat.setProductPrice(request.getParameter("proPrice"));
		cat.setProductSupplier(request.getParameter("proSup"));
		
		int quant=(Integer.parseInt(request.getParameter("quantity")));
			
		cat.setQuantity(quant);
	
		
		cartDao.saveCartDetails(cat);
		System.out.println("pro---------id through post"+cat.getCartId());
		System.out.println("pro---------id through post"+cat.getProductId());
		System.out.println("pro---------id through post"+cat.getProductName());
		System.out.println("pro---------id through post"+cat.getProductPrice());
		
		return "UserHome";
		
	}
	@RequestMapping("/cartDisplay")
	public ModelAndView displayCart()
	{
		List<Cart> list=cartDao.showCartData();
		ModelAndView modelAndView=new ModelAndView("ViewCart");
		modelAndView.addObject("cartlist",list);
		return modelAndView;
		
	}
}
