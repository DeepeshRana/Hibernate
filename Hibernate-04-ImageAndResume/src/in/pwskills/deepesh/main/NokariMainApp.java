package in.pwskills.deepesh.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.pwskills.deepesh.bean.Nokari;
import in.pwskills.deepesh.util.HibernateUtil;

public class NokariMainApp {

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
			fis = new FileInputStream("C:\\Users\\Deepesh Rana\\Pictures\\20210123_210149.jpg");
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
	            nokari.setAddress("Palanpur");
	            nokari.setApplicantName("Keyur");
	            nokari.setProfileImage(image);
	            nokari.setResumeContent(resume);
	            nokari.setJobTitle("Software Engineer");
	            nokari.setCompanyName("Tech Solutions");
	            nokari.setJobLocation("Palanpur");
	            nokari.setSalaryRange(60000.00);
	            nokari.setJobDescription("Responsible for developing software solutions.");
	            nokari.setDatePosted(LocalDate.now());
	            nokari.setApplicationDeadline(LocalDate.of(2023, 12, 31));

	            session.save(nokari);
	            
	            flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (flag) {
					transaction.commit();
					System.out.println("Data add sucessfully...!!");
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
