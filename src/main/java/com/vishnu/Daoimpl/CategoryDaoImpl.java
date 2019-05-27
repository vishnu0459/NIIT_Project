package com.vishnu.Daoimpl;

import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vishnu.model.Category;

@Component
public class CategoryDaoImpl
{
@Autowired
SessionFactory factory;

	public Category getCategory(int c_id)
	{
		Session session=factory.openSession();
		Category category=session.get(Category.class,c_id);
		session.close();
		return category;
	}
	public void saveCategory(Category category)
	{
		System.out.println(" name=="+category.getCategoryName());
		System.out.println(" id="+category.getCatergoryId());
		
		Session session=factory.openSession();
		if(category.getCatergoryId()==0)
		{
			System.out.println(" id is==="+category.getCatergoryId());
			Random random=new Random();
			category.setCatergoryId(random.nextInt(10000));
		}
		session.saveOrUpdate(category);
	
		Transaction transaction=session.beginTransaction();
		transaction.commit();
		session.close();
	}
	public List<Category> receiveData() 
	{
		Session session=factory.openSession();
		Query query=  session.createQuery("from Category");
		List<Category> list=query.list();
 
		Transaction transaction=session.beginTransaction();
		transaction.commit();
		session.close();
		return list;
	}
	public void deleteCategoryData(Category category)
	{ 
		Session session=factory.openSession();
	
		//System.out.println(category+" "+categoryid); to check whether the category object and id are retreving to this daoimpl
		session.delete(category);
		Transaction transaction=session.beginTransaction();
		transaction.commit();
		session.close();

	}

}
