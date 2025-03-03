package in.pwskills.deepesh;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PERSION_MOBILE")
public class PersonMobile implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer mid;
	
	public PersonMobile() {
		super();
	}

	public PersonMobile(Integer mid, String mobileNo) {
		super();
		this.mid = mid;
		this.mobileNo = mobileNo;
	}

	@Override
	public String toString() {
		return "PersonMobile [mid=" + mid + ", mobileNo=" + mobileNo + "]";
	}

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	private String mobileNo;

}
