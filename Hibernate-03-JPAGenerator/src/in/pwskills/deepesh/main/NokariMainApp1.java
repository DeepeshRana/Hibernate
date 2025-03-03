package in.pwskills.deepesh.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.pwskills.deepesh.bean.Nokari;
import in.pwskills.deepesh.bean.PersonInfo;
import in.pwskills.deepesh.util.HibernateUtil;

public class NokariMainApp1 {

	// Bootstrapping the Hibernate

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		Boolean flag = false;
		byte[] image = null;
		char[] resume = null;

		FileInputStream fis = null;
		BufferedReader br = null;

		try {
			fis = new FileInputStream("C:\\Users\\deepe\\Pictures\\Screenshots\\Screenshot (1).png");
			int size = fis.available();
			image = new byte[size];
			fis.read(image);

			// reading resume
			File file = new File("C:\\Users\\deepe\\Documents\\resume.txt");
			br = new BufferedReader(new FileReader(file));
			resume = new char[(int) file.length()];
			br.read(resume);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			session = HibernateUtil.getSession();
			if (session != null) {
				transaction = session.beginTransaction();
			}

			if (transaction != null) {

				Nokari nokari = new Nokari();
				nokari.setAddre("Ahm");
				nokari.setName("Deep");
				nokari.setImage(image);
				nokari.setResume(resume);

				session.save(nokari);
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
