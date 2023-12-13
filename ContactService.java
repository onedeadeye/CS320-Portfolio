package contactPackage;

// Hash map my beloved <3
import java.util.Map;
import java.util.HashMap;

public class ContactService {
	private Map<String, Contact> contacts;
	
	public ContactService() {
		contacts = new HashMap<>();
	}
	
	// @return true if successfully added
	public boolean addContact(Contact nNewContact) {
		// return true if there wasn't already something there
		return (contacts.put(nNewContact.getContactID(), nNewContact) == null);
	}
	
	// @return true if successfully removed
	public boolean removeContact(String nRemoveID) {
		if (contacts.containsKey(nRemoveID)) {
			contacts.remove(nRemoveID);
			return true;
		}
		
		return false;
	}
	
	// Accepts field names firstname, lastname, phonenum, and address
	// @return the updated Contact
	public Contact updateContactField(String nContactID, String nFieldName, String nNewValue) throws IllegalArgumentException {
        Contact targetContact;
        
        try {
        	targetContact = contacts.get(nContactID);
        } catch (Exception e) {
        	System.out.println(e);
        	throw new IllegalArgumentException("Failed to find contact from ID");
        }
        
        nFieldName = nFieldName.toLowerCase();
        
        if (targetContact != null) {
        	switch (nFieldName) {
                case "firstname":
                    targetContact.setFirstName(nNewValue);
                    break;
                case "lastname":
                    targetContact.setLastName(nNewValue);
                    break;
                case "phonenum":
                    targetContact.setPhoneNum(nNewValue);
                    break;
                case "address":
                    targetContact.setAddress(nNewValue);
                    break;
                default:
                    // Default case shouldn't be happening
                	throw new IllegalArgumentException("Argument did not correlate to a contact property.\nValid properties are: firstname, lastname, phonenum, address");
            }
        } else {
        	throw new IllegalArgumentException("Somehow didn't find a contact!");
        }
        
        return targetContact;
    }
	
	// @return the contact assigned to the ID, throws a NullPointerException if it can't find it
	public Contact getContact(String nContactID) throws NullPointerException {
		Contact returnValue = contacts.get(nContactID);
		
		if (returnValue == null) {
			throw new NullPointerException("No contact found for given contactID");
		}
		
		return returnValue;
	}
}