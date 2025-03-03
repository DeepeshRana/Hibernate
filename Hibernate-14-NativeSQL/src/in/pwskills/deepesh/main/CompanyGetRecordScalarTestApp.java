package in.pwskills.deepesh.main;

import java.net.SocketTimeoutException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import in.pwskills.deepesh.Company;
import in.pwskills.deepesh.util.HibernateUtil;

public class CompanyGetRecordScalarTestApp {

	// Bootstrapping the Hibernate

	public static void main(String[] args) {

		Session session = null;
		Query<Company> query = null;

		try {
			session = HibernateUtil.getSession();
			
			if(session != null) {
				query = session.createQuery("FROM in.pwskills.deepesh.Company");
				List<Company> resultList = query.getResultList();
				
				resultList.forEach(result ->  System.out.println(result));
				session.clear();
				
				
				System.out.println("\n*****************************************");
				
				System.out.println("Working with Named parameter.....");
				
				query = session.createQuery("FROM in.pwskills.deepesh.Company where age in (:arg1)");
				query.setParameter("arg1" , 16);
				
				System.out.println("\n");
				List<Company> record = query.getResultList();
				
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
