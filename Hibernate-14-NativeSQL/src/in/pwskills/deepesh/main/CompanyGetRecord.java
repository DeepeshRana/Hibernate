package in.pwskills.deepesh.main;

import java.net.SocketTimeoutException;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import in.pwskills.deepesh.Company;
import in.pwskills.deepesh.util.HibernateUtil;

public class CompanyGetRecord {

	private static List resultList2;

	// Bootstrapping the Hibernate

	public static void main(String[] args) {

		Session session = null;

		try {
			session = HibernateUtil.getSession();
			
			if(session != null) {
				
				//NativeQuery
				NativeQuery<Company> sqlQuery = session.createSQLQuery("SELECT * FROM COMPANY WHERE AGE >= :MAX");
				sqlQuery.setParameter("MAX", 16);
				sqlQuery.addEntity(Company.class);
				
				
				List<Company> resultList = sqlQuery.getResultList();
				
	            resultList.forEach(result -> System.out.println(result)); // Print each result as an array
				
	            session.clear();
	            
	            System.in.read();
	            
	            Query query = session.createSQLQuery("SELECT name from COMPANY where age >= :param1");
	            query.setParameter("param1",16);
	            
	            List resultList3 = query.getResultList();
	            resultList3.forEach(System.out::println);
	            
				
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
