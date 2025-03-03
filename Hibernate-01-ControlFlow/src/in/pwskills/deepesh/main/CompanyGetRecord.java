package in.pwskills.deepesh.main;

import java.awt.datatransfer.Transferable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.pwskills.deepesh.Company;
import in.pwskills.deepesh.util.HibernateUtil;

public class CompanyGetRecord {

	// Bootstrapping the Hibernate

	public static void main(String[] args) {

		Session session = null;
		Company company = null;
		Transaction transaction = null;
		Boolean flag = false;

		try {
			session = HibernateUtil.getSession();
			
			if(session != null) {
				company = session.get(Company.class, 2l);
				System.out.println("Company employee information ::"+company.hashCode());
			}
			
			if(company != null) {
				transaction = session.beginTransaction();
				session.delete(company);
				flag = true;
			}else {
				System.out.println("Record Not Found...!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			if(flag) {
				transaction.commit();
				System.out.println("Record Delete sucessfully....!!");
			}
			if (session != null) {
				session.close();
			}
		}

	}

}
