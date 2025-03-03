package in.pwskills.deepesh;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "CHEQUE_PAYMENT_TBCC")
public class ChequePayment extends Payment {

	private Long chequeNo;
	private String chequeType;
	private LocalDate expiry;

	public ChequePayment(Long chequeNo, String chequeType, LocalDate expiry) {
		super();
		this.chequeNo = chequeNo;
		this.chequeType = chequeType;
		this.expiry = expiry;
	}

	public ChequePayment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChequePayment(Integer pid, Float amount) {
		super(pid, amount);
		// TODO Auto-generated constructor stub
	}

	public Long getChequeNo() {
		return chequeNo;
	}

	public void setChequeNo(Long chequeNo) {
		this.chequeNo = chequeNo;
	}

	public String getChequeType() {
		return chequeType;
	}

	public void setChequeType(String chequeType) {
		this.chequeType = chequeType;
	}

	public LocalDate getExpiry() {
		return expiry;
	}

	public void setExpiry(LocalDate expiry) {
		this.expiry = expiry;
	}

	@Override
	public String toString() {
		return "ChequePayment [chequeNo=" + chequeNo + ", chequeType=" + chequeType + ", expiry=" + expiry + "]";
	}

}
