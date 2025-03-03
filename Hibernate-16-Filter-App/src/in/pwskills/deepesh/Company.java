package in.pwskills.deepesh;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "COMPANY")
@FilterDef(name = "FILTER_COMPANY" , 
		   parameters = {
		@ParamDef(type = "int" , name = "param1")
})
@Filter(name = "FILTER_COMPANY" , condition = "age not in (:param1)")
public class Company implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Uses MySQL's AUTO_INCREMENT
	private Long id;

	@Column(name = "name", nullable = false, length = 100) // Added constraints
	private String name;

	@Column(name = "age", nullable = false)
	private Integer age;

	@Column(name = "address", length = 255)
	private String address;

	static {
		System.out.println("Company .class file loading...!!");
	}

	public Company() {
		System.out.println("Company 0-parameter constructor...!!");
	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + "]";
	}
}