package in.pwskills.deepesh.bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person_info")
public class PersonInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 30)
    private String name;

    @Column(name = "address", length = 30)
    private String address;

    private LocalDate birthDate;
    private LocalDateTime createdDateTime;
    private LocalTime createdTime;

    static {
        System.out.println("Hibernate .class file loaded...!!");
    }

    public PersonInfo() {
        System.out.println("Hibernate Object created...!!");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public LocalTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalTime createdTime) {
        this.createdTime = createdTime;
    }

	@Override
	public String toString() {
		return "PersonInfo [id=" + id + ", name=" + name + ", address=" + address + ", birthDate=" + birthDate
				+ ", createdDateTime=" + createdDateTime + ", createdTime=" + createdTime + "]";
	}
}