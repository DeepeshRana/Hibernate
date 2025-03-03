package in.pwskills.deepesh.main;

import org.hibernate.Session;

import in.pwskills.deepesh.User;
import in.pwskills.deepesh.util.HibernateUtil;

public class UserGetRecord {

	// Bootstrapping the Hibernate

	public static void main(String[] args) {

		Session session = null;
		User user = null;

		try {
			session = HibernateUtil.getSession();

			if (session != null) {
				user = session.get(User.class, "u000");
				System.out.println("Company employee information ::" + user.hashCode());

				System.in.read();

				// session.evict(company);
				// session.clear()

				user = session.get(User.class, "u000");
				System.out.println("Company employee information ::" + user.hashCode());

			}

			if (user != null) {
				System.out.println("Company Information Fatch Sucessfully...!!\n\n");
				System.out.println("Company name ::" + user.getName());
				System.out.println("Company id ::" + user.getId());
				System.out.println("Company address ::" + user.getAddress());
				System.out.println("Company age ::" + user.getAge());
			} else {
				System.out.println("Record Not Found...!!");
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
