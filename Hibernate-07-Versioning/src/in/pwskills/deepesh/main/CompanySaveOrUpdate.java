package in.pwskills.deepesh.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.pwskills.deepesh.Company;
import in.pwskills.deepesh.util.HibernateUtil;

public class CompanySaveOrUpdate {
	// Bootstrapping the Hibernate

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		Boolean flag = false;
		Company company = null;

		try {
			session = HibernateUtil.getSession();
			if (session != null) {
				transaction = session.beginTransaction();
			}

			if (transaction != null) {

				company = session.get(Company.class, 1l);
				company.setAddress("Jamnagar");
				company.setName("Akash011");
				session.saveOrUpdate(company);
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (flag) {
					transaction.commit();
					System.out.println("In Company DB Data Add sucessfully...!!");
				} else {
					transaction.rollback();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}

			if (session != null) {
				session.close();
			}
		}

	}
}
