package in.pwskills.deepesh;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PERSION")
public class Person implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pName=" + pName + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pid;
	
	@Column(name = "pname")
	private String pName;
	
	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public Set<PersonMobile> getpMobile() {
		return pMobile;
	}

	public void setpMobile(Set<PersonMobile> pMobile) {
		this.pMobile = pMobile;
	}

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	@OneToMany(targetEntity = PersonMobile.class, cascade = CascadeType.ALL , fetch = FetchType.EAGER , orphanRemoval = true,mappedBy = "person")
	private Set<PersonMobile>pMobile;

}
