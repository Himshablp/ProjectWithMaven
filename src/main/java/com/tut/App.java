package com.tut;


import java.io.FileInputStream;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )throws Exception
    {
        //System.out.println( "Project Started......." );
        SessionFactory factory  = new Configuration().configure().buildSessionFactory();
//        System.out.println(factory);
        Session session =  factory.openSession();
        Transaction tx = session.beginTransaction();
        Student st1 = new Student();
        Student st2 = new Student();
        st1.setId(106);
        st1.setName("Mayank");
        st1.setCity("Gorakhpur");
        
        st2.setId(153);
        st2.setName("Niraj");
        st2.setCity("Nepal");
        
//        System.out.println(st);
        
        //Creating Object of Address Class
        Address adr = new Address();
        adr.setStreet("Street1");
        adr.setCity("Delhi");
        adr.setAddedDate(new Date());
        adr.setIsopen(true);
        adr.setX(32223.3323);
        FileInputStream fis = new FileInputStream("src/main/java/pic.jpg");
        byte[] data = new byte[fis.available()];
        fis.read(data);
        adr.setImage(data);
        
        
        
        session.save(st1);
        session.save(st2);
        session.save(adr);
        tx.commit();
        session.close();
        
        
    }
}
 