package in.pwskills.deepesh;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.ListIndexBase;

@Entity
@Table(name = "STUDENTS_RECORD")
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@Embedded
	private Address address;


	@ElementCollection
	@Column(name = "name")
	@CollectionTable(name = "STUDENT_FRIENDS", 
			joinColumns = @JoinColumn(referencedColumnName = "id" , name = "f_id"))
	@OrderColumn(name = "fid")
	@ListIndexBase(value = 1)
	private List<String>friends;
	
	@ElementCollection
	@Column(name = "mobileNumber")
	@CollectionTable(name = "STUDENT_MOBILES" ,
					joinColumns =  @JoinColumn(referencedColumnName = "id" , name = "s_id"))
	private Set<Long>mobileNumbers;

	@ElementCollection
	@Column(name = "account")
	@CollectionTable(name = "BANK_INFO",
			joinColumns = @JoinColumn(referencedColumnName = "id" , name = "b_id"))
	@MapKeyColumn(name = "bankName")
	private Map<String, Long>bankInfo;
	public Student(String name, Address address, List<String> friends, Set<Long> mobileNumbers) {
		super();
		this.name = name;
		this.address = address;
		this.friends = friends;
		this.mobileNumbers = mobileNumbers;
	}

	public Student(int id, String name, Address address, List<String> friends, Set<Long> mobileNumbers,
			Map<String, Long> bankInfo) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.friends = friends;
		this.mobileNumbers = mobileNumbers;
		this.bankInfo = bankInfo;
	}

	public Student(int id, String name, Address address, List<String> friends, Set<Long> mobileNumbers) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.friends = friends;
		this.mobileNumbers = mobileNumbers;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Address getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "Student ID: " + id + ", Name: " + name + ", Address: " + address;
	}

}
