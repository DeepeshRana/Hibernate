package in.pwskills.deepesh.main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.pwskills.deepesh.bean.PersonInfo;
import in.pwskills.deepesh.util.HibernateUtil;

public class PersonInfoMainApp {

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

				PersonInfo personInfo = new PersonInfo();
				personInfo.setName("Kartik");
				personInfo.setAddre("Anand");
				personInfo.setDate(LocalDate.now());
				personInfo.setDateTime(LocalDateTime.of(1993, 1, 3, 18, 45));
				personInfo.setLocalTime(LocalTime.now());
				session.saveOrUpdate(personInfo);
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (flag) {
					transaction.commit();
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
