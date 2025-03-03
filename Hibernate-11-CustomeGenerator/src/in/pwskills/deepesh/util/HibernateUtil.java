package in.pwskills.deepesh.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.pwskills.deepesh.User;

public class HibernateUtil {

	private static SessionFactory sessionFactory = null;
	private static Session session = null;

	static {
		if (sessionFactory == null)
			sessionFactory = new Configuration().configure().buildSessionFactory();
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
