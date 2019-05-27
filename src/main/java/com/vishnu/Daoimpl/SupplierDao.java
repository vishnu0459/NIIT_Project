package com.vishnu.Daoimpl;

import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vishnu.model.Supplier;
@Component
public class SupplierDao {

	@Autowired
	SessionFactory factory;

	public Supplier getsupplier(int s_id)
	{
		Session session=factory.openSession();
		
		Supplier supplier=session.get(Supplier.class,s_id);
		session.close();
		return supplier;
		
	}
	 
	public Supplier getSupplierName(String sup_name)
	{
		Session session=factory.openSession();
		
		Query query=session.createQuery("from Supplier where supplierName=:sn");
		query.setParameter("sn",sup_name); 
		Supplier supplier=(Supplier)query.uniqueResult();
		
		Transaction transaction=session.beginTransaction();
		transaction.commit();
		session.close();
		
		return supplier;
	}
	
	public void saveSupplier(Supplier supplier)
	{
		Session session=factory.openSession();
		if(supplier.getSupplierId()==0)
		{
		Random random=new Random();
		supplier.setSupplierId(random.nextInt(10000));
		}
		session.saveOrUpdate(supplier);
		Transaction transaction=session.beginTransaction();
		transaction.commit();
		session.close();
	}
	public List<Supplier>  receiveSupData()
	{
		Session session= factory.openSession();
		Query query=session.createQuery("from Supplier");
		List<Supplier> list= query.list();
		
		Transaction transaction=session.beginTransaction();
		transaction.commit();
		session.close();
		return list;
	}
	public void deleteSupplierData(Supplier supplier)
	{
	
		Session session =factory.openSession();
		session.delete(supplier);

		Transaction transaction=session.beginTransaction();
		transaction.commit();
		session.close();
	}

}
