package in.pwskills.deepesh.main;

import java.util.Scanner;

import org.hibernate.Session;

import in.pwskills.deepesh.Insurance;
import in.pwskills.deepesh.util.HibernateUtil;

public class InsuranceAllRecordFatch {
	
	// Bootstrapping the hibernate.

	public static void main(String[] args) {

		Session session = null;
		Insurance insurance = null;

		try {
			session = HibernateUtil.getSession();
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter Insurance No :: ");
			Long nextLong = scanner.nextLong();
			
			
			if(session != null) {
				insurance = session.load(Insurance.class, nextLong);
				System.out.println("\nInsurance Policy Information:");
				System.out.println("ID: " + insurance.getId());
				System.out.println("Policy Number: " + insurance.getPolicyNumber());
				System.out.println("Holder Name: " + insurance.getHolderName());
				System.out.println("Premium Amount: " + insurance.getPremiumAmount());
				System.out.println("Coverage Amount: " + insurance.getCoverageAmount());
				System.out.println("Term (Years): " + insurance.getTermYears());
				System.out.println("Policy Type: " + insurance.getPolicyType());
				System.out.println("Status: " + insurance.getStatus());
				System.out.println("Nominee Name: " + insurance.getNomineeName());
				System.out.println("Nominee Relation: " + insurance.getNomineeRelation());
				System.out.println("Contact Number: " + insurance.getContactNumber());
				System.out.println("Email: " + insurance.getEmail());
				
				System.in.read();
				
				insurance = session.load(Insurance.class, nextLong);
				System.out.println("Insurance Policy Information:");
				System.out.println("ID: " + insurance.getId());
				System.out.println("Policy Number: " + insurance.getPolicyNumber());
				System.out.println("Holder Name: " + insurance.getHolderName());
				System.out.println("Premium Amount: " + insurance.getPremiumAmount());
				System.out.println("Coverage Amount: " + insurance.getCoverageAmount());
				System.out.println("Term (Years): " + insurance.getTermYears());
				System.out.println("Policy Type: " + insurance.getPolicyType());
				System.out.println("Status: " + insurance.getStatus());
				System.out.println("Nominee Name: " + insurance.getNomineeName());
				System.out.println("Nominee Relation: " + insurance.getNomineeRelation());
				System.out.println("Contact Number: " + insurance.getContactNumber());
				System.out.println("Email: " + insurance.getEmail());
				
				System.in.read();
				
//				session.clear(); // clear cache data
//				session.evict(company);
				insurance = session.load(Insurance.class, nextLong);
				System.out.println("Insurance Policy Information:");
				System.out.println("ID: " + insurance.getId());
				System.out.println("Policy Number: " + insurance.getPolicyNumber());
				System.out.println("Holder Name: " + insurance.getHolderName());
				System.out.println("Premium Amount: " + insurance.getPremiumAmount());
				System.out.println("Coverage Amount: " + insurance.getCoverageAmount());
				System.out.println("Term (Years): " + insurance.getTermYears());
				System.out.println("Policy Type: " + insurance.getPolicyType());
				System.out.println("Status: " + insurance.getStatus());
				System.out.println("Nominee Name: " + insurance.getNomineeName());
				System.out.println("Nominee Relation: " + insurance.getNomineeRelation());
				System.out.println("Contact Number: " + insurance.getContactNumber());
				System.out.println("Email: " + insurance.getEmail());

			}
			
			if(insurance != null) {
				System.out.println("Customer Information..!!");
			}else {
				System.out.println("Customer Record Not Found...!!");
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
