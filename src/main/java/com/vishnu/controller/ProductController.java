package com.vishnu.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.vishnu.Daoimpl.CategoryDaoImpl;
import com.vishnu.Daoimpl.ProductDao;
import com.vishnu.Daoimpl.SupplierDao;
import com.vishnu.Daoimpl.TestSessionFactory;
import com.vishnu.model.Category;
import com.vishnu.model.Product;
import com.vishnu.model.Supplier;

@Controller
public class ProductController 
{
	@Autowired 
	TestSessionFactory ts;
	
	@Autowired
	ProductDao dao;
	 
	@Autowired
	CategoryDaoImpl categoryDaoImpl;
	
	@Autowired
	SupplierDao supplierDao;
	
	public ProductController() {
		System.out.println("Product Controller is Loaded");
	}
	
	
	
	@RequestMapping("/product")
	public ModelAndView retrieveProductFormData()
	{
		ModelAndView modelAndView= new ModelAndView("Product");
		Product product=new Product();
		Random random=new Random();
		product.setProductId(random.nextInt(10000));
		
		modelAndView.addObject("pro",product);
		List<Category>  cat_list=categoryDaoImpl.receiveData();
		modelAndView.addObject("catList",cat_list);
		List<Supplier> sup_list=supplierDao.receiveSupData();
		modelAndView.addObject("supList",sup_list);
		modelAndView.addObject("ButtonName","Add Product");
		return modelAndView;
		
	}
	@RequestMapping(value="/addpro",method = RequestMethod.POST)
	public String saveProData(@ModelAttribute("pro") Product product)
	
	{
		MultipartFile file=product.getProductImage();
		BufferedOutputStream bos=null;
		System.out.println("----------image"+file);
		try
		{
			
			byte byteArray[]=file.getBytes();
			System.out.println("----------image"+byteArray);
			FileOutputStream fos= new FileOutputStream("E:\\pro\\Wish\\src\\main\\webapp\\photos\\project\\"+product.getProductId()+".jpg");
			bos=new BufferedOutputStream(fos);
			bos.write(byteArray);
			
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			try {
				bos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		dao.saveProduct(product);
		return "Home";
		
	}
	
	@RequestMapping("/showproduct")
	public ModelAndView displayProduct()
	{
		ModelAndView modelAndView=new ModelAndView("ShowProduct");
		List<Product> list=dao.recieveProData();
		modelAndView.addObject("showproduct",list);
		return modelAndView;
		
	}
	@RequestMapping("/delete")
	public String deleteProductData(@RequestParam("pro_id") int productId)
	{
		
		Product product=dao.getProduct(productId);
		dao.deleteProData(product);
		File file= new File("E:\\pro\\Wish\\src\\main\\webapp\\photos\\project\\"+product.getProductId()+".jpg");
		file.delete();
		
		return "redirect:showproduct";
	}
	
	@RequestMapping("/editpro")
	public ModelAndView updateProductData(@RequestParam("pro_id") int productId)
	{
		Product product=dao.getProduct(productId);
		
		ModelAndView modelAndView=new ModelAndView("Product");
		modelAndView.addObject("pro",product);
		List<Category>  cat_list=categoryDaoImpl.receiveData();
		modelAndView.addObject("catList",cat_list);
		List<Supplier> sup_list=supplierDao.receiveSupData();
		modelAndView.addObject("supList",sup_list);
		modelAndView.addObject("ButtonName","Update Product");
		return modelAndView;
		
	}
}
