package com.tut;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session  = factory.openSession();
		Transaction trx = session.beginTransaction();
		
		Student st3 = new Student();
		st3.setId(137);
		st3.setName("Arpit");
		st3.setCity("Gorakhpur");
		
		Certificate ctf1 = new Certificate();
		ctf1.setCourse("BTech");
		ctf1.setDuration("6 months");
		st3.setCerti(ctf1);
		
		Student st4 = new Student();
		st4.setId(111);
		st4.setName("Sanjeev Kumar");
		st4.setCity("Agra");
		
		Certificate ctf2 = new Certificate();
		ctf2.setCourse("B.Pharma");
		ctf2.setDuration("4 Years");
		st4.setCerti(ctf2);
		
		session.save(st3);
		session.save(st4);
		
		
		trx.commit();
		session.close();
		factory.close();
		

	}

}
