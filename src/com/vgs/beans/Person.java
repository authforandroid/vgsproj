package com.vgs.beans;

import java.util.Date;

public class Person {
	int PersonId;
	String Fname;
	String Mname;
	String Lname;
	String VoterId;
	String Gender;
	Date DOB;
	String BloodGroup;
	Address LocalAdd;
	Address PerAdd;
	String Education;
	String Email;
	String Occupation;
	String OrgName;
	String Pancard;
	String RationCard;
	boolean SenierCitizen;
	String Adharcard;
	boolean OnRent;
	String OwnerFname;
	String OwnerLname;
	int OwnerContact;
	String OwnerOccupation;
	boolean ChairPerson;
	String FormNo;
	int EnteredByUser;
	
	public Person() {
	}
	public int getPersonId() {
		return PersonId;
	}
	public void setPersonId(int personId) {
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
	public int getOwnerContact() {
		return OwnerContact;
	}
	public void setOwnerContact(int ownerContact) {
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
	public int getEnteredByUser() {
		return EnteredByUser;
	}
	public void setEnteredByUser(int enteredByUser) {
		EnteredByUser = enteredByUser;
	}
}
