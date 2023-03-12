package com.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.map.Answer;
import com.map.Question;

public class CascadeExample {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		Question q1 = new Question();
		q1.setQuestionId(10);
		q1.setQuestion("What is Hibernate");
		
		Answer ans1 = new Answer();
		ans1.setAnswerId(1);
		ans1.setAnswer("Hibernate use for JDBC");
		ans1.setQues(q1);
		
		Answer ans2 = new Answer();
		ans1.setAnswerId(2);
		ans1.setAnswer("Hibernate increase the performance");
		ans1.setQues(q1);
		
		
		List<Answer> list = new ArrayList<Answer>();
		list.add(ans1);
		list.add(ans2);
		
		q1.setAnswer(list);
		
		Transaction trx = session.beginTransaction();
		
		session.save(ans1);
		session.save(ans2);
		session.save(q1);
		
		trx.commit();
		session.close();
		factory.close();

	}

}
