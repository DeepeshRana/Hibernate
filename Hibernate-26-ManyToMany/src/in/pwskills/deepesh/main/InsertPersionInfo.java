package in.pwskills.deepesh.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.pwskills.deepesh.Doctor;
import in.pwskills.deepesh.Patient;
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
				
				Doctor doctor = new Doctor();
				doctor.setName("Harsh");
				doctor.setSpecialization("SICK");
				
				Doctor doctor2 = new Doctor();
				doctor2.setName("Shah");
				doctor2.setSpecialization("AAA");
				
				Patient patient = new Patient();
				patient.setAge(12);
				patient.setName("Tilak");
				
				Patient patient1 = new Patient();
				patient1.setAge(19 );
				patient1.setName("JAY");
				
				doctor.setPatients(List.of(patient , patient1));
				doctor2.setPatients(List.of(patient , patient1));
				
				patient.setDoctor(List.of(doctor , doctor2));
				patient1.setDoctor(List.of(doctor , doctor2));
				
				session.save(doctor);
				session.save(doctor2);
								
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
