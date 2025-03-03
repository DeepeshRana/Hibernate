package in.pwskills.deepesh;

import java.io.Serializable;

import javax.persistence.Embeddable;


@Embeddable
public class Address implements Serializable {

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private String street;
    private String city;
    private String state;
    private String zipCode;

    public Address(String street, String city, String state, String zipCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public String getStreet() { return street; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getZipCode() { return zipCode; }

    @Override
    public String toString() {
        return street + ", " + city + ", " + state + " - " + zipCode;
    }

}
