package com.sqlquries;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.tut.Certificate;
import com.tut.Student;

public class SQLExample {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		String q = "select * from student";
		NativeQuery nq = session.createSQLQuery(q);
		
		List<Object[]> list = nq.list();
		
		
		for(Object[] s: list) {
			System.out.println(s[0]+" : "+s[1]+" : "+" : "+s[2]);
			
		}
		session.close();
		factory.close();

	}

}
