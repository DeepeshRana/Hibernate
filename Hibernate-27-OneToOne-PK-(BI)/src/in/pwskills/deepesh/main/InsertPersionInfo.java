package in.pwskills.deepesh.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.pwskills.deepesh.Passport_O2O;
import in.pwskills.deepesh.Person_O2O;
import in.pwskills.deepesh.util.HibernateUtil;

public class InsertPersionInfo {

	// Bootstrapping the Hibernate

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		Boolean flage = false;

		try {
			session = HibernateUtil.getSession();
			
			if(session != null) {	
				
				transaction = session.beginTransaction();
				
				Person_O2O collegeStudent = new Person_O2O();
				collegeStudent.setSname("Akash");
				collegeStudent.setSaddre(19);
				
				Passport_O2O collegeLibrary = new Passport_O2O();
				collegeLibrary.setType("SCIENCE1");
				
				collegeStudent.setCollegeLibrary(collegeLibrary);
				collegeLibrary.setCollegeStudent(collegeStudent);
					
				session.save(collegeStudent);
				
				flage = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			if(flage) {
				transaction.commit();
				System.out.println("Data Update sucessfully in DB...!!!");
			}
			if (session != null) {
				session.close();
			}
		}

	}

}
