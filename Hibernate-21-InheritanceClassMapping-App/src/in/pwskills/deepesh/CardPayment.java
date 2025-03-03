package in.pwskills.deepesh;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "card")
public class CardPayment extends Payment {
	
	private Long cardNo;
	private String cardType;
	private String paymentGateway;
	public CardPayment(Long cardNo, String cardType, String paymentGateway) {
		super();
		this.cardNo = cardNo;
		this.cardType = cardType;
		this.paymentGateway = paymentGateway;
	}
	public CardPayment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getCardNo() {
		return cardNo;
	}
	public void setCardNo(Long cardNo) {
		this.cardNo = cardNo;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getPaymentGateway() {
		return paymentGateway;
	}
	public void setPaymentGateway(String paymentGateway) {
		this.paymentGateway = paymentGateway;
	}
	@Override
	public String toString() {
		return "CardPayment [cardNo=" + cardNo + ", cardType=" + cardType + ", paymentGateway=" + paymentGateway + "]";
	}
}
