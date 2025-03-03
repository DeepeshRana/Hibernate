package in.pwskills.deepesh.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.pwskills.deepesh.Address;
import in.pwskills.deepesh.Student;
import in.pwskills.deepesh.util.HibernateUtil;

public class ComponentMappingInsertApp {

	// Bootstrapping the Hibernate

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		Boolean flage = false;

		try {
			session = HibernateUtil.getSession();
			
			if(session != null) {	
				
				transaction = session.beginTransaction();
				
				Address address = new Address("AAAA", "BBBB", "CCCC", "DDDD");
				Student student = new Student(2,"XXX" , address);
				
				session.save(student);
				
				flage = true;
				
				System.in.read();
				
				Student student2 = session.get(Student.class, 2);
				System.out.println(student2);
				
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
