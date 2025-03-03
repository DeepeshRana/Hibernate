package in.pwskills.deepesh;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COLLEGE_LIBRARY")
public class Passport_O2O implements Serializable {

	public Passport_O2O() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "CollegeLibrary [lid=" + lid + ", type=" + type + "]";
	}

	public Passport_O2O(Long lid, String type) {
		super();
		this.lid = lid;
		this.type = type;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long lid;

	@Column(nullable = false, unique = true)
	private String type;

	public Long getLid() {
		return lid;
	}

	public void setLid(Long lid) {
		this.lid = lid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Person_O2O getCollegeStudent() {
		return collegeStudent;
	}

	public void setCollegeStudent(Person_O2O collegeStudent) {
		this.collegeStudent = collegeStudent;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@OneToOne(targetEntity = Person_O2O.class , cascade = CascadeType.ALL , fetch = FetchType.EAGER , mappedBy = "collegeLibrary")
	private Person_O2O collegeStudent;
}
