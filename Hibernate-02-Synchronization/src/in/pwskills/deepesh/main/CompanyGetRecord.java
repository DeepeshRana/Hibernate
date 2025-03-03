package in.pwskills.deepesh.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.pwskills.deepesh.Company;
import in.pwskills.deepesh.util.HibernateUtil;

public class CompanyGetRecord {

	// Bootstrapping the Hibernate

	public static void main(String[] args) {

		Session session = null;
		Company company = null;

		try {
			session = HibernateUtil.getSession();

			if (session != null) {
				company = session.get(Company.class, 1l);
				System.out.println("Company employee details before synchroniztion ::" + company);

				System.in.read();

				// Synchronization eastablished b/w record to java object
				session.refresh(company);

				System.out.println("Company employee details After synchroniztion ::" + company);

			}

			if (company != null) {
				System.out.println("Company Information Fatch Sucessfully...!!\n\n");
				System.out.println("Company name ::" + company.getName());
				System.out.println("Company id ::" + company.getId());
				System.out.println("Company address ::" + company.getAddress());
				System.out.println("Company age ::" + company.getAge());
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
