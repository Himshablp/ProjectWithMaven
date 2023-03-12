package com.secondcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class SecondCacheExample {

	public static void main(String[] args) {
		SessionFactory factory =  new Configuration().configure().buildSessionFactory();
		
		Session session1 = factory.openSession();
		Student stu1 = session1.get(Student.class,137);
		System.out.println(stu1);
		session1.close();
		
		Session session2 = factory.openSession();
		Student stu2 = session2.get(Student.class, 137);
		System.out.println(stu2);
		session2.close();
		
		factory.close();

	}

}
