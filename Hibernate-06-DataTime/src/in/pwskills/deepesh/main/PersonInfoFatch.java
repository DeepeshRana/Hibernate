package in.pwskills.deepesh.main;

import org.hibernate.Session;

import in.pwskills.deepesh.bean.PersonInfo;
import in.pwskills.deepesh.util.HibernateUtil;

public class PersonInfoFatch {

	// Bootstrapping the Hibernate

	public static void main(String[] args) {

		Session session = null;
		PersonInfo personInfo = null;

		try {
			session = HibernateUtil.getSession();

			if (session != null) {
				personInfo = session.get(PersonInfo.class, 2);
				System.out.println("Company employee information ::" + personInfo.hashCode());

				System.in.read();

				// session.evict(company);
				// session.clear()

				personInfo = session.get(PersonInfo.class, 2);
				System.out.println("Company employee information ::" + personInfo.hashCode());

			}

			if (personInfo != null) {
				System.out.println("Person Information Fetched Successfully...!!\n");
				System.out.println("Person Name      : " + personInfo.getName());
				System.out.println("Person ID        : " + personInfo.getId());
				System.out.println("Person Date      : " + personInfo.getDate());
				System.out.println("Person Local Time: " + personInfo.getLocalTime());
			} else {
				System.out.println("\nRecord Not Found...!!");
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
