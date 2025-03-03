package in.pwskills.deepesh.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import in.pwskills.deepesh.util.HibernateUtil;

public class LoadRecords {

	// Bootstrapping the Hibernate

	public static void main(String[] args) {

		Session session = null;
		Boolean flage = false;

		try {
			session = HibernateUtil.getSession();
			
			if(session != null) {	
				Query query = session.createQuery("from Doctor");
				List resultList = query.getResultList();
				resultList.forEach(System.out::println);
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
