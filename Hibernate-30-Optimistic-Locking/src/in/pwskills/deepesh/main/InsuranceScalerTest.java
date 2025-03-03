package in.pwskills.deepesh.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import in.pwskills.deepesh.util.HibernateUtil;

public class InsuranceScalerTest {

	// Bootstrapping the Hibernate

	public static void main(String[] args) {

		Session session = null;
		Query query = null;

		try {
			session = HibernateUtil.getSession();

			if (session != null) {
				query = session.createQuery(
						"SELECT holderName , policyType FROM in.pwskills.deepesh.Insurance WHERE term_years= :id");
				query.setParameter("id", 20);
				List<Object[]> resultList = query.getResultList();

				resultList.forEach(result -> System.out.println(result[0] + " " + result[1]));
				session.clear();
				
				
				System.in.read();
				System.out.println("\n************Using Optional*******************");
				
				query = session.createQuery(
						"SELECT count(*) FROM in.pwskills.deepesh.Insurance WHERE term_years= :id");
				query.setParameter("id", 20);
				
				List<?> resultList2 = query.getResultList();
				resultList2.forEach(System.out::println);
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
