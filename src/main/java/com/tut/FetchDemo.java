package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

	public static void main(String[] args) {
		// get , load
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		//getting Student 106
		Student stu = (Student)session.get(Student.class,106);
		System.out.println(stu);
		
		Address adr = session.get(Address.class,1);
		System.out.println(adr.getCity());
		
		session.close();
		factory.close();
				

	}

}
