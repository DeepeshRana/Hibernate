package in.pwskills.deepesh.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.pwskills.deepesh.CardPayment;
import in.pwskills.deepesh.ChequePayment;
import in.pwskills.deepesh.Payment;

public class HibernateUtil {

	private static SessionFactory sessionFactory = null;
	private static Session session = null;

	static {
		if (sessionFactory == null)
			sessionFactory = new Configuration().configure()
			.addAnnotatedClass(Payment.class)
			.addAnnotatedClass(CardPayment.class)
			.addAnnotatedClass(ChequePayment.class)
			.buildSessionFactory();
	}

	public static Session getSession() {
		if (session == null)
			session = sessionFactory.openSession();
		return session;
	}

	public static void closingSessionFactory() {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}
}
