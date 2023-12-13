package contactPackage;

public class Contact {
	private final String contactID;
	private String firstName;
	private String lastName;
	private String phoneNum;
	private String address;
	
	public Contact(String nContactID, String nFirstName, String nLastName, String nPhoneNum, String nAddress)
			throws IllegalArgumentException {
		if (nContactID == null || nContactID.length() > 10) {
            throw new IllegalArgumentException("Contact ID must not be null and cannot exceed 10 characters");
        }
		
		this.contactID = nContactID;
		
		setFirstName(nFirstName);
		setLastName(nLastName);
		setPhoneNum(nPhoneNum);
		setAddress(nAddress);
	}
	
	// Getters
	public String getContactID() { return this.contactID; }

    public String getFirstName() { return this.firstName; }

    public String getLastName() { return this.lastName; }

    public String getPhone() { return this.phoneNum; }

    public String getAddress() { return this.address; }
    
    // Setters
    public void setFirstName(String nNewFirstName) throws IllegalArgumentException {
    	if (nNewFirstName == null || nNewFirstName.length() > 10) {
            throw new IllegalArgumentException("First Name must not be null and cannot exceed 10 characters");
        }
    	
    	this.firstName = nNewFirstName;
    }
    
    public void setLastName(String nNewLastName) throws IllegalArgumentException {
    	if (nNewLastName == null || nNewLastName.length() > 10) {
            throw new IllegalArgumentException("Last Name must not be null and cannot exceed 10 characters");
        }
    	
    	this.lastName = nNewLastName;
    }
    
    public void setPhoneNum(String nNewPhoneNum) throws IllegalArgumentException {
    	if (nNewPhoneNum == null || nNewPhoneNum.length() != 10 || !nNewPhoneNum.matches("\\d+")) {
            throw new IllegalArgumentException("Phone number must not be null, must be exactly 10 digits");
        }
    	
    	this.phoneNum = nNewPhoneNum;
    }
    
    public void setAddress(String nNewAddress) throws IllegalArgumentException {
    	if (nNewAddress == null || nNewAddress.length() > 30) {
            throw new IllegalArgumentException("Address must not be null and cannot exceed 30 characters");
        }
    	
    	this.address = nNewAddress;
    }
}