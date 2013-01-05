package com.vgs.beans;

import java.util.Date;

public class Person {
	private long PersonId;
	private String Fname;
	private String Mname;
	private String Lname;
	private String VoterId;
	private String Gender;
	private Date DOB;
	private String BloodGroup;
	private Address LocalAdd;
	private Address PerAdd;
	private boolean SameAdd;
	private String Education;
	private String Email;
	private String Occupation;
	private String OrgName;
	private String Pancard;
	private String RationCard;
	private boolean SenierCitizen;
	private String Adharcard;
	private boolean OnRent;
	private String OwnerFname;
	private String OwnerLname;
	private long OwnerContact;
	private String OwnerOccupation;
	private boolean ChairPerson;
	private String FormNo;
	private User User;
	private long ParentId;
	private long RelationshipId;
	private long Contact;

	public Person() {
	}
	public User getUser() {
		return User;
	}
	public void setUser(User user) {
		User = user;
	}
	public long getContact() {
		return Contact;
	}
	public void setContact(long contact) {
		Contact = contact;
	}
	public long getPersonId() {
		return PersonId;
	}
	public void setPersonId(long personId) {
		PersonId = personId;
	}
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getMname() {
		return Mname;
	}
	public void setMname(String mname) {
		Mname = mname;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	public String getVoterId() {
		return VoterId;
	}
	public void setVoterId(String voterId) {
		VoterId = voterId;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	public String getBloodGroup() {
		return BloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		BloodGroup = bloodGroup;
	}
	public Address getLocalAdd() {
		return LocalAdd;
	}
	public void setLocalAdd(Address localAdd) {
		LocalAdd = localAdd;
	}
	public Address getPerAdd() {
		return PerAdd;
	}
	public void setPerAdd(Address perAdd) {
		PerAdd = perAdd;
	}
	public boolean isSameAdd() {
		return SameAdd;
	}
	public void setSameAdd(boolean sameAdd) {
		SameAdd = sameAdd;
	}

	public String getEducation() {
		return Education;
	}
	public void setEducation(String education) {
		Education = education;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getOccupation() {
		return Occupation;
	}
	public void setOccupation(String occupation) {
		Occupation = occupation;
	}
	public String getOrgName() {
		return OrgName;
	}
	public void setOrgName(String orgName) {
		OrgName = orgName;
	}
	public String getPancard() {
		return Pancard;
	}
	public void setPancard(String pancard) {
		Pancard = pancard;
	}
	public String getRationCard() {
		return RationCard;
	}
	public void setRationCard(String rationCard) {
		RationCard = rationCard;
	}
	public boolean isSenierCitizen() {
		return SenierCitizen;
	}
	public void setSenierCitizen(boolean senierCitizen) {
		SenierCitizen = senierCitizen;
	}
	public String getAdharcard() {
		return Adharcard;
	}
	public void setAdharcard(String adharcard) {
		Adharcard = adharcard;
	}
	public boolean isOnRent() {
		return OnRent;
	}
	public void setOnRent(boolean onRent) {
		OnRent = onRent;
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
	public boolean isChairPerson() {
		return ChairPerson;
	}
	public void setChairPerson(boolean chairPerson) {
		ChairPerson = chairPerson;
	}
	public String getFormNo() {
		return FormNo;
	}
	public void setFormNo(String formNo) {
		FormNo = formNo;
	}
	public long getParentId() {
		return ParentId;
	}
	public void setParentId(long parentId) {
		ParentId = parentId;
	}
	public long getRelationshipId() {
		return RelationshipId;
	}
	public void setRelationshipId(long relationshipId) {
		RelationshipId = relationshipId;
	}


}
