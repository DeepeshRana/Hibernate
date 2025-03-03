package in.pwskills.deepesh.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.pwskills.deepesh.User;
import in.pwskills.deepesh.util.HibernateUtil;

public class UserMainApp {

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

				User user = new User();
				user.setAddress("Jamnagar");
				user.setAge(21);
				user.setId(12l);
				user.setName("Krisha");
				session.save(user);
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (flag) {
					transaction.commit();
					System.out.println("In User DB Data Add sucessfully...!!");
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
