package in.pwskills.deepesh.main;

import org.hibernate.Session;

import in.pwskills.deepesh.ProgrammerProjectId;
import in.pwskills.deepesh.ProgrammerProjectInfo;
import in.pwskills.deepesh.util.HibernateUtil;

public class ProgrammerGetRecord {

	// Bootstrapping the Hibernate

	public static void main(String[] args) {

		Session session = null;
		ProgrammerProjectInfo info = null;

		try {
			session = HibernateUtil.getSession();

			if (session != null) {

				ProgrammerProjectId id = new ProgrammerProjectId();
				id.setId(100);
				id.setProId(105);

				info = session.get(ProgrammerProjectInfo.class, id);

			}

			if (info != null) {
				System.out.println("\nCompany Information..!!");
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
