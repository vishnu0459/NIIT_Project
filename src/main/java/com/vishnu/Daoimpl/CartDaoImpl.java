package com.vishnu.Daoimpl;

import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vishnu.model.Cart;
import com.vishnu.model.Product;

@Component
public class CartDaoImpl {

	@Autowired
	SessionFactory factory;
	
	
	 public void saveCartDetails(Cart cat)
	{
		Session session=factory.openSession();
		int proprice=Integer.parseInt(cat.getProductPrice());
		int cartprice=cart_priceList();
		int cartTotalPrice=cartprice+proprice*(cat.getQuantity());
		cat.setCartTotalPrice(cartTotalPrice);
		session.save(cat);
		Transaction transaction=session.beginTransaction();
		transaction.commit();
		session.close();
	}
	 
	public int cart_priceList() 
	{
		int sum=0;
		Session session=factory.openSession();
		Query query=session.createQuery("from Cart");
		List<Cart> list=query.list();
		for(Cart cat:list)
		{
			sum=sum+cat.getCartTotalPrice();
		}
		Transaction transaction=session.beginTransaction();
		transaction.commit();
		session.close();
		return sum;
	}
	
	public List<Cart> showCartData()
	{
		Session session=factory.openSession();
		Query query=session.createQuery("from Cart");
		List<Cart> list=query.list();
		Transaction transaction=session.beginTransaction();
		transaction.commit();
		session.close();
		return list;
		
	}
}
