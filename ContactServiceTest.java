package mobileapp.contactservice;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
	
	/*
	 * Successful contact added test
	 */
	@Test
	public void testAddContactSuccessfully() {
		ContactService service = new ContactService();
		Contact contact = new Contact("001", "Artie", "Lange", "1234567890", "456 Pie Street");
		
		service.addContact(contact);
		
		assertEquals("Artie", service.getContact("001").getFirstName());
	}
	
	/*
	 * Duplicate contactId test
	 */
	@Test
	public void testAddDuplicateContactThrowsException() {
		ContactService service = new ContactService();
		Contact contact1 = new Contact("002", "Bob", "Roberts", "1234567890", "789 Dye Street");
		Contact contact2 = new Contact("002", "Doc", "Brown", "0987654321", "1955 Hill Valley Dr.");
		
		service.addContact(contact1);
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.addContact(contact2);
		});
	}
	
	/*
	 * Successfully deleted contact test
	 */
	@Test
	public void testDeleteContactSuccessfully() {
		ContactService service = new ContactService();
		Contact contact = new Contact("003", "Charlie", "Brown", "1234567890", "123 Pig Pen Way");
				
		service.addContact(contact);
		service.deleteContact("003");
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.getContact("003");
		});
	}
	
	/*
	 * Successfully update contact test
	 */
	@Test
	public void testUpdateContactSuccessfully() {
		ContactService service = new ContactService();
		Contact contact = new Contact("004", "Peter", "Griffin", "1234567890", "89 Quahog Way");
		service.addContact(contact);
		
		service.updateContact("004", "Petuh", "Gryffyn", "6549873210", "98 Quahog Way");
		
		
		Contact updated = service.getContact("004");
		assertEquals("Petuh", updated.getFirstName());
		assertEquals("Gryffyn", updated.getLastName());
		assertEquals("6549873210", updated.getPhone());
		assertEquals("98 Quahog Way", updated.getAddress());
	}
	
	/*
	 * Test updating nonexistent contact
	 */
	@Test
	public void testUpdateNonexistentContactThrowsException() {
		ContactService service = new ContactService();
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateContact("888", "Who", "Dis", "3213213210", "NoIdeaWhoThisIs");
		});
		
	}
	
	/*
	 * Test updating with invalid phone number
	 */
	@Test
	public void testUpdateContactWithInvalidPhoneThrowsException() {
		ContactService service = new ContactService();
		Contact contact = new Contact("005", "Grant", "Crapp", "9879879875", "354 Wallaby Way");
		service.addContact(contact);
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateContact("005", "Grant", "Crapp", "321321", "354 Wallaby Way");
		});
		
	}
	
	/*
	 * Test updating first name method individually
	 */
	@Test
	public void testUpdateFirstNameIndv() {
		ContactService service = new ContactService();
		Contact contact = new Contact("010", "Jane", "Doe", "1234567890", "123 Main Street");
		service.addContact(contact);
		
		service.updateFirstName("010", "Janelle");
		assertEquals("Janelle", service.getContact("010").getFirstName());
	}
	
	/*
	 * Test updating last name method individually
	 */
	@Test
	public void testUpdateLastNameIndv() {
		ContactService service = new ContactService();
		Contact contact = new Contact("011", "Jane", "Doe", "1234567890", "123 Main Street");
		service.addContact(contact);
		
		service.updateLastName("011", "Smith");
		assertEquals("Smith", service.getContact("011").getLastName());
	}
	
	/*
	 * Test updating phone method individually
	 */
	@Test
	public void testUpdatePhoneIndv() {
		ContactService service = new ContactService();
		Contact contact = new Contact("012", "Jane", "Doe", "1234567890", "123 Main Street");
		service.addContact(contact);
		
		service.updatePhone("012", "2345678901");
		assertEquals("2345678901", service.getContact("012").getPhone());
	}
	
	/*
	 * Test updating address method individually
	 */
	@Test
	public void testAddressIndv() {
		ContactService service = new ContactService();
		Contact contact = new Contact("013", "Jane", "Doe", "1234567890", "123 Main Street");
		service.addContact(contact);
		
		service.updateAddress("013", "213 Main Street");
		assertEquals("213 Main Street", service.getContact("013").getAddress());
	}
}
