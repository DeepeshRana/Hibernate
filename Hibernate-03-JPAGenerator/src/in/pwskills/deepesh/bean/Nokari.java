package in.pwskills.deepesh.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "nokari")
public class Nokari implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static {
		System.out.println("Nokari .class file loading");
	}
	
	public Nokari() {
		System.out.println("Noakri 0 parameter const create...!");
	}
	
	@Id
	@GeneratedValue(strategy = )
	private Integer id;
	private String name;
	private String addre;
	
	@Lob
	private byte[] image;
	
	@Lob
	private char[] resume;
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
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public char[] getResume() {
		return resume;
	}
	public void setResume(char[] resume) {
		this.resume = resume;
	}
	
}
