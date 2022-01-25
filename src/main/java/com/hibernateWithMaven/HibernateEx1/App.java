package com.hibernateWithMaven.HibernateEx1;

import java.io.IOException;
//import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class App {

	  public static void main(String[] args)throws IOException {

	    Session session = HibernateUtil.getSessionFactory().openSession();
	    session.beginTransaction();

	    Student student = new Student();
	    student.setFirstName("John");
	    student.setLastName("Bloch");
	    student.setContactNo("+1-408-575-1317");

	    Address address=new Address();
	    address.setStreet("Street 1");
	    address.setCity("Pune");
	    address.setOpen(true);
	    address.setImage(null);
	    //address.setAddedDate(new Date(0) );
	    address.setX(1234.234);
	    
	    session.save(student);
	    session.save(address);
	    session.getTransaction().commit();
        
        System.out.println("Save Done...");
	    Query<Student> q = session.createQuery("From Student", Student.class);

	    List<Student> resultList = q.list();
	    System.out.println("total students:" + resultList.size());
	    
	    for (Student s : resultList) {
	      System.out.println("student : " + s);   //its used for calling toString method of Student for Printing Student list 
	    }
	    Query<Address> q1 = session.createQuery("From Address", Address.class);

	    List<Address> resultList1 = q1.list();
	    System.out.println("total students:" + resultList1.size());
	    
	    for (Address add : resultList1) {
		      System.out.println("student_address : " + add);   //its used for calling toString method of Student for Printing Student list 
		    }
	    session.close();
	    
	  }
	}