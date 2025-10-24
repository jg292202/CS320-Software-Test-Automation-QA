package mobileapp.contactservice;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.NullSource;
public class ContactTest {
	
	/*
	 * Parameterized test to test for invalid ContactIds (null, empty and more than 10 characters)
	 */
	@ParameterizedTest
	@ValueSource(strings = {"", "toolongcontactId123123", "12345678901"})
	@NullSource
	void testInvalidContactIds(String id) {
			assertThrows(IllegalArgumentException.class, () -> {
			new Contact(id, "Jane", "Doe", "1234567890", "123 Main Street");
		});
	}
	
	/*
	 * Test successful creation of contact
	 */
	@Test
	public void testValidContactCreation() {
		Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main Street");
		
		assertEquals("1234567890", contact.getContactId());
		assertEquals("John", contact.getFirstName());
		assertEquals("Doe", contact.getLastName());
		assertEquals("1234567890", contact.getPhone());
		assertEquals("123 Main Street", contact.getAddress());
	}
	
	/*
	 * Max length fields accepted
	 */
	@Test
	public void testMaxLengthFieldsAccepted() {
		Contact contact = new Contact("1234568790", "MaximumLen", "MaximuLeng", "1234567890","123456789012345678901234567890");
		assertEquals("MaximumLen", contact.getFirstName());
		assertEquals("MaximuLeng", contact.getLastName());
		assertEquals("1234567890", contact.getPhone());
		assertEquals("123456789012345678901234567890", contact.getAddress());
	}
	
	
	//*************** contactID tests ***********************
	/*
	 * Test null contactId
	 */
	@Test
	public void testNullContactId() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Jane", "Doe", "1234567890", "123 Main Street");
		});
	}
	
	/*
	 * Test contactId too long
	 */
	@Test
	public void testContactIdTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("321321321321321321", "Jane", "Doe", "1234567890", "123 Main Street");
		});
	}
	
	/*
	 * Test contactId is immutable
	 */
	@Test
	public void testContactIdIsImmutable() {
		Contact contact = new Contact("999", "Jane", "Doe", "1234567890", "123 Main Street");
		assertEquals("999", contact.getContactId());
	}
	
	//***************** First name tests ********************
	/*
	 * Test null first name
	 */
	@Test
	public void testNullFirstName() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("003", null, "Doe", "1234567890", "123 Main Street");
		});
	}
	
	/*
	 * Test first name too long
	 */
	@Test
	public void testFirstNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("004", "Janehasafirstnamethatistoolong", "Doe", "1234567890", "123 Main Street");
		});
	}
	
	
	
	//*************** Last name tests **************
	/*
	 * Test last name is null
	 */
	@Test
	public void testLastNameNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("005", "Jane", null, "1234567890", "123 Main Street");
		});
	}
	
	/*
	 * Test last name too long
	 */
	@Test
	public void testLastNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("006", "Jane", "Doeslastnameiswaytoolong", "1234567890", "123 Main Street");
		});
	}
	
	
	
	
	//************* Phone number tests ************
	/*
	 * Test phone number that is null
	 */
	@Test
	public void testNullPhone() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("007", "Jane", "Doe", null, "123 Main Street");
		});
	}
	
	/*
	 * Test phone number that is too short
	 */
	@Test
	public void testInvalidPhoneTooShort() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("008", "Jane", "Doe", "12345", "123 Main Street");
		});
	}
	
	/*
	 * Test phone number that is too long
	 */
	@Test
	public void testInvalidPhoneTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("009", "Jane", "Doe", "12345123451234512345", "123 Main Street");
		});
	}
	
	/*
	 * Test phone number that has characters
	 */
	@Test
	public void testInvalidPhoneCharacters() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("010", "Jane", "Doe", "12345E6789", "123 Main Street");
		});
	}
	
	
	
	//************** Address tests *************
	/*
	 * Test address is null
	 */
	@Test
	public void testAddressIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("011", "Jane", "Doe", "1234567890", null);
		});
	}
	
	/*
	 * Test address too long
	 */
	@Test
	public void testAddressTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("012", "Jane", "Doe", "1234567890", "123 Main Main Main Main Main Main Main Street");
		});
	}
	
	
	
	
	//*********************************************
	//*************** Setter tests ****************
	//*********************************************
	
	/*
	 * Test that setFirstName enforces firstName is not null
	 */
	@Test
	public void testSetNullFirstName() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("016", null, "Doe", "1234567890", "123 Main Street");
		});
	}
	/*
	 * Test that setFirstName enforces firstName too long
	 */
	@Test
	public void testSetFirstNameTooLong() {
		Contact contact = new Contact("017", "Jane", "Doe", "1234567890", "123 Main Street");
		
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setFirstName("Thisnameiswaytoolong");
		});
	}
	
	/*
	 * Test first name set successfully
	 */
	@Test
	public void testSetFirstNameSuccessfully() {
		Contact contact = new Contact("30", "Jane", "Doe", "1234567890", "123 Main Street");
		contact.setFirstName("Janelle");
		assertEquals("Janelle", contact.getFirstName());
	}
	
	/*
	 * Test that setLastName enforces lastName is not null
	 */
	@Test
	public void testSetLastNameNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("018", "Jane", null, "1234567890", "123 Main Street");
		});
	}
	
	/*
	 * Test that setLastName enforces lastName is too long
	 */
	@Test
	public void testSetLastNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("019", "Jane", "Doeslastnameiswaytoolong", "1234567890", "123 Main Street");
		});
	}
	
	/*
	 * Test last name set successfully
	 */
	@Test
	public void testSetLastNameSuccessfully() {
		Contact contact = new Contact("31", "Jane", "Doe", "1234567890", "123 Main Street");
		contact.setLastName("Smith");
		assertEquals("Smith", contact.getLastName());
	}

	/*
	 * Test that setPhone enforces phone is not null
	 */
	@Test
	public void testSetNullPhone() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("020", "Jane", "Doe", null, "123 Main Street");
		});
	}
	
	/*
	 * Test that setPhone enforces phone is not too short
	 */
	@Test
	public void testSetInvalidPhoneTooShort() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("021", "Jane", "Doe", "12345", "123 Main Street");
		});
	}
	
	/*
	 * Test that setPhone enforces phone is not long
	 */
	@Test
	public void testSetInvalidPhoneTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("022", "Jane", "Doe", "12345123451234512345", "123 Main Street");
		});
	}
	
	/*
	 * Test that setPhone enforces phone does not have characters.
	 */
	@Test
	public void testSetInvalidPhoneCharacters() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("023", "Jane", "Doe", "12345E6789", "123 Main Street");
		});
	}
	
	/*
	 * Test phone set successfully
	 */
	@Test
	public void testSetPhoneSuccessfully() {
		Contact contact = new Contact("32", "Jane", "Doe", "1234567890", "123 Main Street");
		contact.setPhone("0987654321");
		assertEquals("0987654321", contact.getPhone());
	}
	
	/*
	 * Test that setAddress enforces address is not null.
	 */
	@Test
	public void testSetAddressIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("024", "Jane", "Doe", "1234567890", null);
		});
	}
	
	/*
	 * Test that setAddress enforces address is not too long.
	 */
	@Test
	public void testSetAddressTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("025", "Jane", "Doe", "1234567890", "123 Main Main Main Main Main Main Main Street");
		});
	}
	/*
	 * Set address correctly
	 */
	@Test
	public void testSetAddressSuccessfully() {
		Contact contact = new Contact("33", "Jane", "Doe", "1234567890", "123 Main Street");
		contact.setAddress("321 Main Street");
		assertEquals("321 Main Street", contact.getAddress());
	}
}