package in.pwskills.deepesh.main;

import java.awt.datatransfer.Transferable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.pwskills.deepesh.Insurance;
import in.pwskills.deepesh.util.HibernateUtil;

public class InsuranceSoftDelete {

	// Bootstrapping the Hibernate

	public static void main(String[] args) {

		Session session = null;
		Query query = null;
		Transaction transaction = null;
		Boolean flag = false;
		

		try {
			session = HibernateUtil.getSession();

			if (session != null) {
				
				Insurance insurance = session.get(Insurance.class, 2l);
				
				System.out.println(insurance);
				
				System.in.read();
				
				transaction = session.beginTransaction();
				
				session.delete(insurance);
				
				flag = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			if(flag) {
				transaction.commit();
				System.out.println("Record Delete Sucessfully...!!@");
			}
			if (session != null) {
				session.close();
			}
		}

	}

}
