package contactPackage;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContactServiceTest {
    private ContactService contactService;
    private Contact validContact;

    @Before
    public void setUp() {
        // Create a ContactService instance and a valid contact for testing
        contactService = new ContactService();
        validContact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
    }

    @Test
    public void testAddValidContact() {
        contactService.addContact(validContact);
        assertNotNull(contactService.getContact("1234567890"));
    }

    @Test
    public void testAddDuplicateContact() {
        contactService.addContact(validContact);
        assertFalse(contactService.addContact(validContact));
    }

    @Test(expected=NullPointerException.class)
    public void testDeleteContact() {
        contactService.addContact(validContact);
        contactService.removeContact("1234567890");
        assertNull(contactService.getContact("1234567890"));
    }

    @Test
    public void testUpdateFirstName() {
        contactService.addContact(validContact);
        contactService.updateContactField("1234567890", "firstName", "Jane");
        assertEquals("Jane", contactService.getContact("1234567890").getFirstName());
    }

    @Test
    public void testUpdateLastName() {
        contactService.addContact(validContact);
        contactService.updateContactField("1234567890", "lastName", "Smith");
        assertEquals("Smith", contactService.getContact("1234567890").getLastName());
    }

    @Test
    public void testUpdatePhone() {
        contactService.addContact(validContact);
        contactService.updateContactField("1234567890", "phoneNum", "9876543210");
        assertEquals("9876543210", contactService.getContact("1234567890").getPhone());
    }

    @Test
    public void testUpdateAddress() {
        contactService.addContact(validContact);
        contactService.updateContactField("1234567890", "address", "456 Elm St");
        assertEquals("456 Elm St", contactService.getContact("1234567890").getAddress());
    }

    @Test(expected=IllegalArgumentException.class)
    public void testUpdateInvalidField() {
        contactService.addContact(validContact);
        contactService.updateContactField("1234567890", "invalidField", "NewValue");
        // Ensure that the contact remains unchanged
        assertEquals("John", contactService.getContact("1234567890").getFirstName());
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testUpdateInvalidContact() {
    	contactService.addContact(validContact);
    	contactService.updateContactField("NonId1245", "firstName", "Realman");
    }
}