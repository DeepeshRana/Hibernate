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
				
				
				Person person = new Person();
				person.setpName("Harsh Kumar");
				
				PersonMobile personMobile1 = new PersonMobile();
				personMobile1.setMobileNo("9912121212");
				
				PersonMobile personMobile2 = new PersonMobile();
				personMobile2.setMobileNo("8812121212");
				
				PersonMobile personMobile3 = new PersonMobile();
				personMobile3.setMobileNo("7712121212");
				
				PersonMobile personMobile4 = new PersonMobile();
				personMobile4.setMobileNo("6612121212");
				
				person.setpMobile(Set.of(personMobile1 , personMobile2 , personMobile3 , personMobile4));
				
				session.save(person);
				
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
