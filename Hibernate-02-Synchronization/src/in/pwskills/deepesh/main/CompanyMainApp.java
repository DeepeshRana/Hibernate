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
		Company company = null;
		try {
			session = HibernateUtil.getSession();
			if (session != null) {
				
				company = session.get(Company.class, 1l);
				System.out.println("Company employee details before synchroniztion ::" + company);
				System.out.println("Company name ::" + company.getName());
				System.out.println("Company id ::" + company.getId());
				System.out.println("Company address ::" + company.getAddress());
				System.out.println("Company age ::" + company.getAge());
				
				if(company != null) {
					transaction = session.beginTransaction();
					company.setAddress("Rajkot");
					company.setAge(101);
				}
				
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (flag) {
					transaction.commit();
					System.out.println("\n\nIn Company DB Data Add sucessfully...!!");
					System.out.println("Company employee details After synchroniztion ::" + company);
					System.out.println("Company name ::" + company.getName());
					System.out.println("Company id ::" + company.getId());
					System.out.println("Company address ::" + company.getAddress());
					System.out.println("Company age ::" + company.getAge());
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
