package in.pwskills.deepesh.main;

import java.lang.reflect.Parameter;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.pwskills.deepesh.Person;
import in.pwskills.deepesh.PersonMobile;
import in.pwskills.deepesh.util.HibernateUtil;

public class RemoveRecords {

	// Bootstrapping the Hibernate

	public static void main(String[] args) {

		Session session = null;
		Boolean flage = false;
		Transaction transaction = null;

		try {
			session = HibernateUtil.getSession();
			
			if(session != null) {	
//				Person person = session.load(Person.class, 3);
//				
			transaction = session.beginTransaction();
//				
//				Set<PersonMobile> getpMobile = person.getpMobile();
//				
//				getpMobile.removeAll(getpMobile);
//				
			Person person = session.get(Person.class , 2);
			
			session.delete(person);
			
			flage = true;
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			if(flage) {
				transaction.commit();
				
				System.out.println("Data Remove Sucessfully...!!!");
			}
			if (session != null) {
				session.close();
			}
		}

	}

}
