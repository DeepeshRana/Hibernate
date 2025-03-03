package in.pwskills.deepesh.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.pwskills.deepesh.ProgrammerProjectId;
import in.pwskills.deepesh.ProgrammerProjectInfo;
import in.pwskills.deepesh.util.HibernateUtil;

public class ProgrammerMainApp {

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

				ProgrammerProjectInfo info = new ProgrammerProjectInfo();
				info.setPname("Kiran1");
				info.setProjName("Tesla");

				ProgrammerProjectId pId = new ProgrammerProjectId();
				pId.setId(111);
				pId.setProId(121);

				info.setId(pId);

				session.save(info);
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (flag) {
					transaction.commit();
					System.out.println("Programmer data and project data add sucessfully...!!");
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
