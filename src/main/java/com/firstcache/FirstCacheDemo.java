package com.firstcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class FirstCacheDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Student stu = session.get(Student.class, 102);
		System.out.println(stu);
		
		System.out.println("Working Something");
		
		Student stu1 = session.get(Student.class, 102);
		System.out.println(stu1);
		System.out.println(session.contains(stu1));
		
		session.close();
		factory.close();

	}

}
