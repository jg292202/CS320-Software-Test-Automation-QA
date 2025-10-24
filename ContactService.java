package mobileapp.contactservice;

import java.util.HashMap;


public class ContactService {
	private HashMap<String, Contact> contacts;
	
	public ContactService() {
		contacts = new HashMap<>();
	}
	
	/*
	 * Add a new contact
	 */
	public void addContact(Contact contact) {
		if (contacts.containsKey(contact.getContactId())) {
			throw new IllegalArgumentException("Contact ID already exists");
		}
		contacts.put(contact.getContactId(), contact);
	}
	
	/*
	 * Update a contact
	 */
	public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
		if (!contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("Contact ID not found");
		}
		Contact contact = contacts.get(contactId);
		
		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		contact.setPhone(phone);
		contact.setAddress(address);
	}
	
	
	/*
	 * Delete a contact
	 */
	public void deleteContact(String contactId) {
		if (!contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("Contact ID not found");
		}
		contacts.remove(contactId);
	}
	
	/*
	 * Update first name
	 */
	public void updateFirstName(String contactId, String firstName) {
		Contact contact = getContact(contactId);
		contact.setFirstName(firstName);
	}
	
	/*
	 * Update last name
	 */
	public void updateLastName(String contactId, String lastName) {
		Contact contact = getContact(contactId);
		contact.setLastName(lastName);
	}
	
	/*
	 * Update phone
	 */
	public void updatePhone(String contactId, String phone) {
		Contact contact = getContact(contactId);
		contact.setPhone(phone);
	}
	
	/*
	 * Update address
	 */
	public void updateAddress(String contactId, String address) {
		Contact contact = getContact(contactId);
		contact.setAddress(address);
	}
	
	/*
	 * Retrieve Contact object by objectId method
	 */
	Contact getContact(String contactId) {
		if (!contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("Contact ID not found");
		}
		return contacts.get(contactId);
	}
	
	
}

