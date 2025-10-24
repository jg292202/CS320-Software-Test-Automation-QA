package mobileapp.contactservice;

public class Contact {
	private final String contactId;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	// Constructor with validation
	public Contact(String contactId, String firstName, String lastName, String phone, String address) {
		if (contactId == null || contactId.length() > 10 || contactId.isEmpty()) {
			throw new IllegalArgumentException("Invalid contact ID");
		}
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		if (phone == null || !phone.matches("\\d{10}")) {			// "\\d" means digit, "[10}" means exactly 10 times
			throw new IllegalArgumentException("Phone must be exactly 10 digits");
		}
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		
		/*
		 * Initialize object's initial state
		 */
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
		}
	
	
	
	/*
	 * Getter methods
	 */
	
	public String getContactId() {
		return contactId;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}
	
	
	
	/*
	 * Setter methods for all except contactID since it is immutable.
	 */
		
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		this.lastName = lastName;
	}
	
	public void setPhone(String phone) {
		if (phone == null || !phone.matches("\\d{10}")) {
			throw new IllegalArgumentException("Phone must be exactly 10 digits");
		}
		this.phone = phone;
	}
	
	public void setAddress(String address) {
		if (address == null || address.length() > 30){
			throw new IllegalArgumentException("Invalid address");
		}
		this.address = address;
	}
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
