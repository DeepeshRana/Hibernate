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
@Table(name = "persion_info")
public class PersonInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "pname" , length = 30)
	private String name;
	
	@Column(name = "paddre" , length = 30)
	private String addre;
	
	@Column(name = "date")
    private LocalDate date;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Column(name = "local_time")
    private LocalTime localTime;

	
	static {
		System.out.println("Hibernate .class file load...!!");
	}
	
	public PersonInfo() {
		System.out.println("Hibernate Object create...!!");
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
	public String getAddre() {
		return addre;
	}
	public void setAddre(String addre) {
		this.addre = addre;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public LocalTime getLocalTime() {
		return localTime;
	}
	public void setLocalTime(LocalTime localTime) {
		this.localTime = localTime;
	}}
