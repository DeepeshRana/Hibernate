package in.pwskills.deepesh;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Payment {
	
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Payment [pid=" + pid + ", amount=" + amount + "]";
	}
	public Payment(Integer pid, Float amount) {
		super();
		this.pid = pid;
		this.amount = amount;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Integer pid;
	private Float amount;
	
}
