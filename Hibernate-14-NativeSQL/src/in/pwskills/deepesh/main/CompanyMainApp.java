package in.pwskills.deepesh.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.pwskills.deepesh.Company;
import in.pwskills.deepesh.util.HibernateUtil;

public class CompanyMainApp {

	// Bootstrapping the Hibernate

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		Boolean flag = false;

		try {
			session = HibernateUtil.getSession();
			if (session != null) {
				transaction = session.beginTransaction();
			}

			if (transaction != null) {

				Company com = new Company();
				com.setAge(15);
				com.setAddress("Surat");
				com.setName("Akash");
				session.save(com);
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
