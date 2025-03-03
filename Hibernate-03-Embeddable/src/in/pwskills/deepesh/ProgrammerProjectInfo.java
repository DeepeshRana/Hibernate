package in.pwskills.deepesh;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ProgrammerProjectInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ProgrammerProjectId id;
	
	@Column(name = "pname" , length = 20)
	private String pname;
	
	@Override
	public String toString() {
		return "ProgrammerProjectInfo [id=" + id + ", pname=" + pname + ", projName=" + projName + "]";
	}

	public ProgrammerProjectId getId() {
		return id;
	}

	public void setId(ProgrammerProjectId id) {
		this.id = id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	@Column(name = "projname" , length = 20)
	private String projName;

}
