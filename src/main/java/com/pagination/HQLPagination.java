package com.pagination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tut.Student;

public class HQLPagination {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Query query = session.createQuery("from Student");
		
		query.setFirstResult(5);
		query.setMaxResults(9);
		List<Student> list1 = query.list();
		for(Student stu :list1) {
			System.out.println(stu.getId());
		}
		
		session.close();
		factory.close();
	}

}
