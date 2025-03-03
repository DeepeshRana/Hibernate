package in.pwskills.deepesh;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "COLLEGE_STUDENT")
public class Person_O2O implements Serializable {

	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Integer getSaddre() {
		return saddre;
	}

	public void setSaddre(Integer saddre) {
		this.saddre = saddre;
	}

	public Passport_O2O getCollegeLibrary() {
		return collegeLibrary;
	}

	public void setCollegeLibrary(Passport_O2O collegeLibrary) {
		this.collegeLibrary = collegeLibrary;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "CollegeStudent [sid=" + sid + ", sname=" + sname + ", saddre=" + saddre + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sid;

	@Column(nullable = false)
	private String sname;

	@Column(nullable = false)
	private Integer saddre;

	public Person_O2O() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person_O2O(Long sid, String sname, Integer saddre) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.saddre = saddre;
	}
	
	@OneToOne(targetEntity = Passport_O2O.class , cascade = CascadeType.ALL , fetch =  FetchType.LAZY)
	@PrimaryKeyJoinColumn(name = "lid" , referencedColumnName = "sid")
	private Passport_O2O collegeLibrary;

}