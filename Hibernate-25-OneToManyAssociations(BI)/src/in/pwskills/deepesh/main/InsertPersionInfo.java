package in.pwskills.deepesh.main;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.pwskills.deepesh.Person;
import in.pwskills.deepesh.PersonMobile;
import in.pwskills.deepesh.util.HibernateUtil;

public class InsertPersionInfo {

	// Bootstrapping the Hibernate

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		Boolean flage = false;

		try {
			session = HibernateUtil.getSession();
			
			if(session != null) {	
				
				transaction = session.beginTransaction();
				
				
				
				PersonMobile personMobile1 = new PersonMobile();
				personMobile1.setMobileNo("474747");
				
				Person person = new Person();
				person.setpName("Kiran Kumar");

				personMobile1.setPerson(person);
				
				person.setpMobile(Set.of(personMobile1));
				
				session.save(personMobile1);
				
				flage = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			if(flage) {
				transaction.commit();
				System.out.println("Data Update sucessfully in DB...!!!");
			}
			if (session != null) {
				session.close();
			}
		}

	}

}
