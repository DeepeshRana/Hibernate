package in.pwskills.deepesh.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.pwskills.deepesh.Passport_O2O;
import in.pwskills.deepesh.Person_O2O;

public class HibernateUtil {

	private static SessionFactory sessionFactory = null;
	private static Session session = null;

	static {
		if (sessionFactory == null)
			sessionFactory = new Configuration().configure()
			.addAnnotatedClass(Passport_O2O.class)
			.addAnnotatedClass(Person_O2O.class)
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
