package com.map1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		
		Emp e1 = new Emp();
		Emp e2 = new Emp();
		
		e1.setEid(34);
		e1.setName("Ram");
		
		e2.setEid(35);
		e2.setName("Shyam");
		
		Project p1 = new Project();
		Project p2 = new Project();
		
		p1.setPid(12121);
		p1.setProjectName("Library Management System");
		
		p2.setPid(14214);
		p2.setProjectName("CHATBOT");
		
		List<Project> proList = new ArrayList<Project>();
		List<Emp> empList = new ArrayList<Emp>();
		
		proList.add(p1);
		proList.add(p2);
		
		empList.add(e1);
		empList.add(e2);
		
		e1.setProjects(proList);
		e2.setProjects(proList);
		
		p1.setEmps(empList);
		p1.setEmps(empList);
		
		Session session = factory.openSession();
		Transaction trx = session.beginTransaction();
		
		session.save(e1);
		session.save(e2);
		session.save(p1);
		session.save(p2);
		
		trx.commit();
		session.close();
		factory.close();
	
		
	}

}
