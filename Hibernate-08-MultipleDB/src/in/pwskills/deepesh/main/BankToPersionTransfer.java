package in.pwskills.deepesh.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.pwskills.deepesh.bean.Bank;
import in.pwskills.deepesh.bean.PersonInfo;
import in.pwskills.deepesh.util.BankHibernateUtil;
import in.pwskills.deepesh.util.PersionHibernateUtil;

public class BankToPersionTransfer {

	// Bootstrapping the Hibernate

	public static void main(String[] args) {

		Session session = null;
		Bank bankInfo = null;
		Transaction transaction = null;
		Boolean flag = false;


		try {
			session = PersionHibernateUtil.getSession();
			
			session = BankHibernateUtil.getSession();

			if (session != null) {
				bankInfo = session.get(Bank.class, 1);
				System.out.println("Bank info ::"+bankInfo.hashCode());

				System.in.read();

				// session.evict(company);
				// session.clear()

				if(bankInfo != null) {
					transaction = session.beginTransaction();
					session.save(bankInfo);
					flag = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			if(flag) {
				transaction.commit();
				System.out.println("\nData add sucessfully in Persion DB...!!");
			}else {
				System.out.println("\nRecord Not Found...!!");
			}
			if (session != null) {
				session.close();
			}
		}

	}

}
