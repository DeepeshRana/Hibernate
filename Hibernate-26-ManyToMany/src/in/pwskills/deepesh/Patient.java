package in.pwskills.deepesh;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "patients")
public class Patient implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

	@ManyToMany(targetEntity = Doctor.class , cascade = CascadeType.ALL , fetch = FetchType.EAGER , mappedBy = "patients")
    private List<Doctor> doctor;

    // Constructors
    public Patient() {}

    public Patient(String name, int age, List<Doctor> doctor) {
        this.name = name;
        this.age = age;
        this.doctor = doctor;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public List<Doctor> getDoctor() { return doctor; }
    public void setDoctor(List<Doctor> doctor) { this.doctor = doctor; }
}