package in.pwskills.deepesh.main;

import java.util.Scanner;

import org.hibernate.Session;

import in.pwskills.deepesh.Company;
import in.pwskills.deepesh.util.HibernateUtil;

public class CompanyLoadRecordApp {
	
	// Bootstrapping the hibernate.

	public static void main(String[] args) {

		Session session = null;
		Company company = null;

		try {
			session = HibernateUtil.getSession();
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter Company employee id :: ");
			Long nextLong = scanner.nextLong();
			
			
			if(session != null) {
				company = session.load(Company.class, nextLong);
				System.out.println("Company employee information ::"+company.hashCode());
				
				System.in.read();
				
				company = session.load(Company.class, nextLong);
				System.out.println("Company employee information ::"+company.hashCode());
				
				System.in.read();
				
//				session.clear(); // clear cache data
//				session.evict(company);
				company = session.load(Company.class, nextLong);
				System.out.println("Company employee information ::"+company.hashCode());

			}
			
			if(company != null) {
				System.out.println("Company Information..!!");
			}else {
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
