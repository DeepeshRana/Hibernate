package in.pwskills.deepesh;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "INSURANCE")
@SQLDelete(sql = "update Insurance set status = 'closed' where id=?")
@Where(clause = "status not in ('Closed', 'Expired')")
public class Insurance implements Serializable {

    private static final long serialVersionUID = 1L;

    static {
        System.out.println("Insurance .class file loading...!!");
    }

    public Insurance() {
        System.out.println("Insurance 0-parameter constructor...!!");
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Uses MySQL's AUTO_INCREMENT
    private Long id;

    @Column(name = "policy_number", nullable = false, unique = true, length = 50)
    private String policyNumber;

    @Column(name = "holder_name", nullable = false, length = 100)
    private String holderName;

    @Column(name = "premium_amount", nullable = false)
    private Double premiumAmount;

    @Column(name = "coverage_amount", nullable = false)
    private Double coverageAmount;

    @Column(name = "term_years", nullable = false)
    private Integer termYears;

    @Column(name = "policy_type", nullable = false, length = 50)
    private String policyType; // e.g., Life, Health, Vehicle

    @Column(name = "status", nullable = false, length = 20)
    private String status; // e.g., Active, Expired, Cancelled

    @Column(name = "nominee_name", length = 100)
    private String nomineeName;

    @Column(name = "nominee_relation", length = 50)
    private String nomineeRelation;

    @Column(name = "contact_number", length = 15)
    private String contactNumber;

    @Column(name = "email", length = 100)
    private String email;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public Double getPremiumAmount() {
        return premiumAmount;
    }

    public void setPremiumAmount(Double premiumAmount) {
        this.premiumAmount = premiumAmount;
    }

    public Double getCoverageAmount() {
        return coverageAmount;
    }

    public void setCoverageAmount(Double coverageAmount) {
        this.coverageAmount = coverageAmount;
    }

    public Integer getTermYears() {
        return termYears;
    }

    public void setTermYears(Integer termYears) {
        this.termYears = termYears;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNomineeName() {
        return nomineeName;
    }

    public void setNomineeName(String nomineeName) {
        this.nomineeName = nomineeName;
    }

    public String getNomineeRelation() {
        return nomineeRelation;
    }

    public void setNomineeRelation(String nomineeRelation) {
        this.nomineeRelation = nomineeRelation;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Insurance [id=" + id + ", policyNumber=" + policyNumber + ", holderName=" + holderName
                + ", premiumAmount=" + premiumAmount + ", coverageAmount=" + coverageAmount + ", termYears=" + termYears
                + ", policyType=" + policyType + ", status=" + status + ", nomineeName=" + nomineeName
                + ", nomineeRelation=" + nomineeRelation + ", contactNumber=" + contactNumber + ", email=" + email + "]";
    }
}
