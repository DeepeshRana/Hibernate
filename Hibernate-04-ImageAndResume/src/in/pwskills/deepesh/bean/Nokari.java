package in.pwskills.deepesh.bean;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "nokari")
public class Nokari implements Serializable {

    private static final long serialVersionUID = 1L;

    static {
        System.out.println("Nokari .class file loading");
    }

    public Nokari() {
        System.out.println("Nokari 0 parameter constructor create...!");
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer nokariId;
    private String applicantName;
    private String address;

    @Lob
    private byte[] profileImage;

    @Lob
    private char[] resumeContent;

    private String jobTitle;
    private String companyName;
    private String jobLocation;
    private Double salaryRange;
    private String jobDescription;
    private LocalDate datePosted;
    private LocalDate applicationDeadline;

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }

    public Double getSalaryRange() {
        return salaryRange;
    }

    public void setSalaryRange(Double salaryRange) {
        this.salaryRange = salaryRange;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public LocalDate getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(LocalDate datePosted) {
        this.datePosted = datePosted;
    }

    public LocalDate getApplicationDeadline() {
        return applicationDeadline;
    }

    public void setApplicationDeadline(LocalDate applicationDeadline) {
        this.applicationDeadline = applicationDeadline;
    }

    public Integer getNokariId() {
        return nokariId;
    }

    public void setNokariId(Integer nokariId) {
        this.nokariId = nokariId;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public byte[] getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(byte[] profileImage) {
        this.profileImage = profileImage;
    }

    public char[] getResumeContent() {
        return resumeContent;
    }

    public void setResumeContent(char[] resumeContent) {
        this.resumeContent = resumeContent;
    }
}