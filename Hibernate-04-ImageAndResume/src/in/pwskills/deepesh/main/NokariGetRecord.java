package in.pwskills.deepesh.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Scanner;

import org.hibernate.Session;

import in.pwskills.deepesh.bean.Nokari;
import in.pwskills.deepesh.util.HibernateUtil;

public class NokariGetRecord {

	// Bootstrapping the Hibernate

	public static void main(String[] args) {

		Session session = null;
		Nokari nokari = null;

		try {
			session = HibernateUtil.getSession();

			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter Company employee id :: ");
			Integer personId = scanner.nextInt();

			if (session != null) {
				nokari = session.load(Nokari.class, personId);
				if (nokari != null) {
					 System.out.println("Nokari ID is ::" + nokari.getNokariId());
			            System.out.println("Applicant Name is ::" + nokari.getApplicantName());
			            System.out.println("Address is ::" + nokari.getAddress());
			            System.out.println("Job Title is ::" + nokari.getJobTitle());
			            System.out.println("Company Name is ::" + nokari.getCompanyName());
			            System.out.println("Job Location is ::" + nokari.getJobLocation());
			            System.out.println("Salary Range is ::" + nokari.getSalaryRange());
			            System.out.println("Job Description is ::" + nokari.getJobDescription());
			            System.out.println("Date Posted is ::" + nokari.getDatePosted());
			            System.out.println("Application Deadline is ::" + nokari.getApplicationDeadline());


					System.out.println("RESUME DETAILS BELOW ::");
					String resumeLoc = "D:\\AD JAVA\\resume.txt";
					String imageLoc = "D:\\AD JAVA\\image.png";
					try (FileWriter fw = new FileWriter(new File(resumeLoc));
							FileOutputStream fos = new FileOutputStream(new File(imageLoc))) {
						fw.write(nokari.getResumeContent());
						fw.flush();
						System.out.println("Resume details in ::" + resumeLoc);

						System.out.println();
						fos.write(nokari.getProfileImage());
						fos.flush();
						System.out.println("Image details in ::" + imageLoc);
					}
				}

				System.in.read();

				nokari = session.load(Nokari.class, personId);
				System.out.println("Company employee information ::" + nokari.hashCode());

			}

			if (nokari != null) {
				System.out.println("Company Information..!!");
			} else {
				System.out.println("Record Not Found...!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

}
