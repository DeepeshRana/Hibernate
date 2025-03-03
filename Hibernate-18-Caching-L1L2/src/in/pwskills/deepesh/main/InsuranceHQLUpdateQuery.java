package in.pwskills.deepesh.main;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.pwskills.deepesh.util.HibernateUtil;

public class InsuranceHQLUpdateQuery {

	// Bootstrapping the Hibernate

	public static void main(String[] args) {

		Session session = null;
		Query query = null;
		int recordUpdate = 0;
		Boolean flag = false;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSession();

			if (session != null) {
				
				transaction = session.beginTransaction();
				
				query = session.createQuery(
						"UPDATE in.pwskills.deepesh.Insurance set coverage_amount = coverage_amount+:bounce WHERE term_years=:id");
				query.setParameter("bounce", 1000000);
				query.setParameter("id", 20);
				recordUpdate = query.executeUpdate();
				flag = true;
				session.clear();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			if(flag) {
				transaction.commit();
				System.out.println("Numbe of record update in database ::"+recordUpdate);
			}
			if (session != null) {
				session.close();
			}
		}

	}

}
