package in.pwskills.deepesh;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ProgrammerProjectId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer proId;
	@Override
	public String toString() {
		return "ProgrammerProjectId [id=" + id + ", proId=" + proId + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProId() {
		return proId;
	}
	public void setProId(Integer proId) {
		this.proId = proId;
	}
}
