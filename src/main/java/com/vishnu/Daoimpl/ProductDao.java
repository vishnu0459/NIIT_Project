package com.vishnu.Daoimpl;

import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vishnu.model.Product;

@Component
public class ProductDao {

	@Autowired
	SessionFactory factory;
	
	public void saveProduct(Product product)
	{
		Session session=factory.openSession();
		
		session.saveOrUpdate(product);
		Transaction transaction=session.beginTransaction();
		transaction.commit();
		session.close();
		
	}
	public List<Product> recieveProData()
	{
	
		Session session=factory.openSession();
		Query query= session.createQuery("from Product");
		List<Product> list=query.list();
		session.close();
		return list;
	}
	
	public Product getProduct(int productId) 
	{
		Session session=factory.openSession();
		Product product=session.get(Product.class, productId);
		session.close();
		return product;
	}
	public void deleteProData(Product product) {
		// TODO Auto-generated method stub
		
		Session session=factory.openSession();
		session.delete(product);
		Transaction transaction=session.beginTransaction();
		transaction.commit();
		session.close();
		
	}
	
	

	
}
