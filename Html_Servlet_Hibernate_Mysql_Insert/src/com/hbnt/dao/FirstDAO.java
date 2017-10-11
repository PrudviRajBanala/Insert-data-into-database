package com.hbnt.dao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hbnt.bean.FirstPOJO;

public class FirstDAO {

	public void addFirstDetails(String name, String password) {
		try {
			Configuration conn = new Configuration().configure();
			
			SessionFactory sf = conn.buildSessionFactory();
			Session s = sf.openSession();
			
			Transaction t = s.beginTransaction();
			
			FirstPOJO fp = new FirstPOJO();
			fp.setName(name);
			fp.setPassword(password);
			
			s.save(fp);
			t.commit();
			System.out.println("Connection Established");
		}catch(HibernateException e) {
			System.out.println(e);
		}
	}
}
