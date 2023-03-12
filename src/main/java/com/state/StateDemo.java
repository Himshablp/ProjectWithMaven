package com.state;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.Student;
import com.tut.Certificate;

public class StateDemo {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction trx = session.beginTransaction();
		
		// Transisent State:--
		Student st1 = new Student();
		st1.setId(204);
		st1.setName("Amar Tripathi");
		st1.setCity("Baliya");
		st1.setCerti(new Certificate("MCA","5 Year"));
		// This is the Transient State of an Object
		
		// Persistent Stste:--
		session.save(st1);
		
		// Now Object goes to Persistent State
		// That means Obj associated with Session + DataBase
		
		// Output Before update
		System.out.println(st1.getName());
		//Output After Update
		Student stu = session.get(Student.class, 204);
		st1.setName("Ananya Tripathi");
		System.out.println(stu.getName());
		
		
		trx.commit();
		session.close();
		// Detached State
		Session othersession = factory.openSession();
		Transaction tr = othersession.beginTransaction();
		st1.setName("Sachine");
		Student stu1 = (Student)othersession.get(Student.class, 130);
		System.out.println(stu1.getName());
		tr.commit();
		othersession.close();
		factory.close();

	}

}
