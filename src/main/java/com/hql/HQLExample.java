package com.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tut.Student;

public class HQLExample {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		String query = "from Student where city=:x";
		Query q = session.createQuery(query);
		
		q.setParameter("x","Baliya");
		
		List<Student> list = q.list();
		for(Student s:list) {
			System.out.println(s); 
		}
		
		Transaction trx = session.beginTransaction();
		
//		Query q2 = session.createQuery("delete from Student  s where s.city=:c");
//		q2.setParameter("c", "Baliya");
//		int r = q2.executeUpdate();
//		System.out.println("Deleted:");
//		System.out.println(r);
		
		Query q3 = session.createQuery("update Student set city=:newCity where name=:n");
		q3.setParameter("newCity", "Azamgarh");
		q3.setParameter("n", "Arpit Rai");
		q3.executeUpdate();
		
		
		trx.commit();
		session.close();
		factory.close();
		
	}

}
