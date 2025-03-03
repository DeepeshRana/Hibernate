package in.pwskills.deepesh.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import in.pwskills.deepesh.Insurance;
import in.pwskills.deepesh.util.HibernateUtil;

public class InsuranceAllApp {

	// Bootstrapping the Hibernate

	public static void main(String[] args) {

		Session session = null;
		Query<Insurance> query = null;

		try {
			session = HibernateUtil.getSession();
			
			if(session != null) {
				query = session.createQuery("FROM in.pwskills.deepesh.Insurance");
				List<Insurance> resultList = query.getResultList();
				
				resultList.forEach(result ->  System.out.println(result));
				session.clear();
				
				System.in.read();
				
				resultList.forEach(System.out::println);
				
				System.in.read();
				
				System.out.println("\n******************************************************");
				
				System.out.println("Working with Named parameter.....\n");
				
				query = session.createQuery("FROM in.pwskills.deepesh.Insurance where term_years in (:arg1 , :arg2)");
				query.setParameter("arg1" , 20);
				query.setParameter("arg2", 15);
				List<Insurance> record = query.getResultList();
				record.forEach(result ->  System.out.println(result)); 
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
