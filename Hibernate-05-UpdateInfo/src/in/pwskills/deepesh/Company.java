package in.pwskills.deepesh;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "COMPANY")
public class Company implements Serializable {

    @Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + "]";
	}

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Uses MySQL's AUTO_INCREMENT
    private Long id;

    public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Column(name = "name", nullable = false, length = 100)  // Added constraints
    private String name;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "address", length = 255)
    private String address;
    
    @Version
    private Integer count;
    
    @CreationTimestamp
    private LocalDateTime recordCreate;
    
    @UpdateTimestamp
    private LocalDateTime recordUpdate;

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
}
