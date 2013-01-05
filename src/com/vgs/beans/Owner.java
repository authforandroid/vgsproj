package com.vgs.beans;

public class Owner {
	/*psmtUpdateOwnerInPerson.setBoolean(1,person.isOnRent());
	psmtUpdateOwnerInPerson.setString(2, person.getOwnerFname());
	psmtUpdateOwnerInPerson.setString(3, person.getOwnerLname());
	psmtUpdateOwnerInPerson.setLong(4, person.getOwnerContact());
	psmtUpdateOwnerInPerson.setString(5, person.getOwnerOccupation());
	psmtUpdateOwnerInPerson.setLong(6,person.getPersonId());

	psmtUpdateOwnerInPerson.executeUpdate();
	*/
	private String OwnerFname;
	private String OwnerLname;
	private long OwnerContact;
	private String OwnerOccupation;
	
	public Owner() {
	
	}

	public String getOwnerFname() {
		return OwnerFname;
	}

	public void setOwnerFname(String ownerFname) {
		OwnerFname = ownerFname;
	}

	public String getOwnerLname() {
		return OwnerLname;
	}

	public void setOwnerLname(String ownerLname) {
		OwnerLname = ownerLname;
	}

	public long getOwnerContact() {
		return OwnerContact;
	}

	public void setOwnerContact(long ownerContact) {
		OwnerContact = ownerContact;
	}

	public String getOwnerOccupation() {
		return OwnerOccupation;
	}

	public void setOwnerOccupation(String ownerOccupation) {
		OwnerOccupation = ownerOccupation;
	}
	
	
}
