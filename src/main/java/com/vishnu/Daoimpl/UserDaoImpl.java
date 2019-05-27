package com.vishnu.Daoimpl;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vishnu.model.Product;
import com.vishnu.model.UserRegister;

@Component
public class UserDaoImpl {
	
	@Autowired
	SessionFactory factory;
	
	public List<Product> receiveProductList()
	{
		Session session=factory.openSession();
		Query query= session.createQuery("from Product");
		List<Product> list=query.list();
		
		Transaction transaction=session.beginTransaction();
		transaction.commit();
		session.close();
		return list;
		
	}

	public UserRegister saveUser(UserRegister user)
	{
		Session session=factory.openSession();
		user.setRole("ROLE_USER");
		user.setEnabled(true);
		session.save(user);
		Transaction transaction=session.beginTransaction();
		transaction.commit();
		session.close();
		return null;
		
	}

	public String loginForm() 
	{
		
		return null;
		
		
	}

	public boolean validateloginForm(UserRegister user) 
	{
		Session session= factory.openSession();
		Query query= session.createQuery("from UserRegister where email=:em and password=:pw");
		query.setParameter("em", user.getEmail());
		query.setParameter("pw", user.getPassword());
		UserRegister us=null;
		us=(UserRegister)query.uniqueResult();
		System.out.println(us);
		if(us!=null)
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
	}

	
}
