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

public class LoadRecords {

	// Bootstrapping the Hibernate

	public static void main(String[] args) {

		Session session = null;
		Boolean flage = false;

		try {
			session = HibernateUtil.getSession();
			
			if(session != null) {	
//				Person person = session.load(Person.class, 3);
//				System.out.println(person);
				
				
				Query<Person> query = session.createQuery("from Person");
				List<Person> resultList = query.getResultList();
				resultList.forEach(parent ->{
					System.out.println(parent);
					Set<PersonMobile> getpMobile = parent.getpMobile();
					getpMobile.forEach(System.out::println);
				});
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

}
