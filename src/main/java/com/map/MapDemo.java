package com.map;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Question q1 = new Question();
		q1.setQuestionId(130);
		q1.setQuestion("What is Java");
		session.save(q1);
		
		
		Answer a1 = new Answer();
		a1.setAnswerId(343);
		a1.setAnswer("Java is a Language");
		a1.setQues(q1);
		
		Answer a2 = new Answer();
		a2.setAnswerId(124);
		a2.setAnswer("Java is Used for Web Application");
		a2.setQues(q1);
		
		Answer a3 = new Answer();
		a3.setAnswerId(125);
		a3.setAnswer("Java is Object Oriented");
		a3.setQues(q1);
		
		List<Answer> list1=new ArrayList<>();
		list1.add(a1);
		list1.add(a2);
		list1.add(a3);
		
		q1.setAnswer(list1);
		
		
		session.save(a1);
		session.save(a2);
		session.save(a3);
		
		tx.commit();
		 
		//fetching Data
		Question newQ = session.get(Question.class, 130);
		System.out.println(newQ.getQuestionId()+" : "+newQ.getQuestion());
		System.out.println(newQ.getAnswer().size());
		
		
//		for(Answer ans: newQ.getAnswer()) {
//			System.out.println(ans.getAnswerId()+" : "+ans.getAnswer());
//		}
		session.close();
		factory.close();
		

	}

}
