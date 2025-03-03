package in.pwskills.deepesh.main;

import java.awt.Checkbox;
import java.time.LocalDate;

import javax.persistence.Tuple;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.pwskills.deepesh.CardPayment;
import in.pwskills.deepesh.ChequePayment;
import in.pwskills.deepesh.Payment;
import in.pwskills.deepesh.util.HibernateUtil;

public class InheritanceMapping {

	// Bootstrapping the Hibernate

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		Boolean flage = false;

		try {
			session = HibernateUtil.getSession();
			
			if(session != null) {	
				
				transaction = session.beginTransaction();
				
				
				CardPayment cardPayment = new CardPayment();
				cardPayment.setCardNo(111l);
				cardPayment.setCardType("debi");
				cardPayment.setPaymentGateway("VISA");
				cardPayment.setAmount(20000f);
				
				session.save(cardPayment);	
				
				System.in.read();
				
				ChequePayment chequePayment = new ChequePayment();
				chequePayment.setAmount(30000f);
				chequePayment.setChequeType("SAVING");
				chequePayment.setExpiry(LocalDate.of(2026, 12, 12));
				chequePayment.setChequeNo(151515l);
				
				session.save(chequePayment);
				
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
