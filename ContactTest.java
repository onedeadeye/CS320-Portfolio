package contactPackage;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContactTest {
    private Contact validContact;

    @Before
    public void setUp() {
        // Create a valid contact for testing
        validContact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
    }

    @Test
    public void testValidContact() {
        assertNotNull(validContact);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidContactIdNull() {
        new Contact(null, "John", "Doe", "1234567890", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidContactIdTooLong() {
        new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St");
    }
    
    @Test
    public void testValidContactIdShort() {
    	Contact shortIdContact = new Contact("1234", "John", "Doe", "1234567890", "123 Main St");
    	assertEquals("1234", shortIdContact.getContactID());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidFirstNameNull() {
        new Contact("1234567890", null, "Doe", "1234567890", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidFirstNameTooLong() {
        new Contact("1234567890", "JohnJohnJohn", "Doe", "1234567890", "123 Main St");
    }
    
    @Test
    public void testValidContactFirstNameExactSize() {
    	Contact exactFirstNameContact = new Contact("1234567890", "Tenletters", "Doe", "1234567890", "123 Main St");
    	assertEquals("Tenletters", exactFirstNameContact.getFirstName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidLastNameNull() {
        new Contact("1234567890", "John", null, "1234567890", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidLastNameTooLong() {
        new Contact("1234567890", "John", "DoeSuperLongLastName", "1234567890", "123 Main St");
    }
    
    @Test
    public void testValidContactLastNameExactSize() {
    	Contact exactLastNameContact = new Contact("1234567890", "John", "Tenletters", "1234567890", "123 Main St");
    	assertEquals("Tenletters", exactLastNameContact.getLastName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPhoneNull() {
        new Contact("1234567890", "John", "Doe", null, "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPhoneNotExactly10Digits() {
        new Contact("1234567890", "John", "Doe", "12345", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPhoneContainsNonDigits() {
        new Contact("1234567890", "John", "Doe", "1234a5678b", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidAddressNull() {
        new Contact("1234567890", "John", "Doe", "1234567890", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidAddressTooLong() {
        new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St, Apartment 123, Very Very Long Address");
    }
    
    @Test
    public void testValidAddressExactSize() {
    	Contact exactAddressContact = new Contact("1234567890", "John", "Doe", "1234567890", "123456789012345678901234567890");
        assertEquals("123456789012345678901234567890", exactAddressContact.getAddress());
    }
}