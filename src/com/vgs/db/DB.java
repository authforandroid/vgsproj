package com.vgs.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.vgs.beans.Address;
import com.vgs.beans.Member;
import com.vgs.beans.Owner;
import com.vgs.beans.Person;
import com.vgs.beans.Relationship;
import com.vgs.beans.User;
/*
 * SHOW ENGINE INNODB STATUS
 * */
public class DB {

	private static DB dbRef=null;;
	private Connection conn;
	private PreparedStatement psmtInsertPerson,psmtInsertAddress,psmtInsertMember;
	private PreparedStatement psmtUpdateLocalAddInPerson,psmtUpdatePermanantAddInPerson;
	private PreparedStatement psmtUpdateOwnerInPerson;

	private PreparedStatement psmtGetAllRelationshipConstants;
	private PreparedStatement psmtGetAllFamilyMembers,psmtGetPerson;
	private PreparedStatement psmtGetAddress,psmtGetUser,psmtGetRelationship;
	
	private PreparedStatement psmtGetChairPerson;
	

	private DB() {
		String myDriver = "org.gjt.mm.mysql.Driver";
		String myUrl = "jdbc:mysql://localhost/vgsdb";
		try {
			Class.forName(myDriver);
			conn = DriverManager.getConnection(myUrl, "root", "mysql");
			psmtInsertPerson=conn.prepareStatement("insert into persontbl (fname, mname, lname, gender, dob, bloodgroup, email ,contact," +
					" education, occupation, orgname, pancard,rationcard,voterid, adharcard,seniorcitizen,chairperson,formno,byUser)" +
					" values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)" , Statement.RETURN_GENERATED_KEYS);
			psmtInsertAddress=conn.prepareStatement("insert into addresstbl (line1, line2, area, city , state, pincode ,contactNo) " +
					" values (?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			psmtUpdateLocalAddInPerson=conn.prepareStatement("update persontbl set localAdd= ? where personId=?");
			psmtUpdatePermanantAddInPerson = conn.prepareStatement("update persontbl set perAdd= ? where personId=?");
			psmtUpdateOwnerInPerson=conn.prepareStatement("update persontbl set onrent=? ,ownerfname=? ," +
					" ownerlname=?, ownercontact=?, owneroccupation=? where personId=?");
			psmtInsertMember=conn.prepareStatement("insert into membertbl(personId, parentId,relationshipId) values (?,?,?)");

			psmtGetAllRelationshipConstants=conn.prepareStatement("select relationshipId, relation from relationshiptbl");
			psmtGetAllFamilyMembers=conn.prepareStatement("select personId, relationshipId where parentId = ? ");
			psmtGetPerson=conn.prepareStatement("select * from persontbl where personId=?");
			psmtGetAddress=conn.prepareStatement("select * from addresstbl where addressId=?");
			psmtGetUser=conn.prepareStatement("select * from usertbl where userId=?");
			psmtGetRelationship=conn.prepareStatement("select relation from relationshiptbl where relationshipid=?");
			
			psmtGetChairPerson= conn.prepareStatement("select parentId from membertbl where personId=?");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static DB getInstance()
	{
		try
		{
			if(dbRef == null)
				dbRef = new DB();
		}
		catch(Exception e)
		{
			dbRef = null;
		}
		return dbRef;
	}

	public long insertPerson(Person person){
		try {
			psmtInsertPerson.setString(1, person.getFname());
			psmtInsertPerson.setString(2, person.getMname());
			psmtInsertPerson.setString(3, person.getLname());
			psmtInsertPerson.setString(4, person.getGender());
			java.sql.Date dob=null;
			if(person.getDOB()!=null){
				dob=new java.sql.Date(person.getDOB().getTime());
			}
			psmtInsertPerson.setDate(5, dob);
			psmtInsertPerson.setString(6, person.getBloodGroup());
			psmtInsertPerson.setString(7, person.getEmail());
			psmtInsertPerson.setLong(8, person.getContact());
			psmtInsertPerson.setString(9, person.getEducation());
			psmtInsertPerson.setString(10, person.getOccupation());
			psmtInsertPerson.setString(11, person.getOrgName());
			psmtInsertPerson.setString(12, person.getPancard());
			psmtInsertPerson.setString(13, person.getRationCard());
			psmtInsertPerson.setString(14, person.getVoterId());
			psmtInsertPerson.setString(15, person.getAdharcard());
			psmtInsertPerson.setBoolean(16, person.isSenierCitizen());
			psmtInsertPerson.setBoolean(17, person.isChairPerson());
			//psmtInsertPerson.setString(18, person.getFormNo());
			//psmtInsertPerson.setString(19, person.getUser().getUsername());
			psmtInsertPerson.setString(18, "TestForm0");
			psmtInsertPerson.setString(19, "1");

			if(psmtInsertPerson.executeUpdate()>0)
				System.out.println("inserted successful");
			
			ResultSet rs=psmtInsertPerson.getGeneratedKeys();

			while (rs.next()) {
				long temp=rs.getLong(1);
				person.setPersonId(temp);
			}
			
			if(person.isChairPerson()){
				//do nothing
			}else{
				//update address as of parent and add relationship 
				if(person.getParentId()>0){
					Person parent=getPerson(person.getParentId());
					if(parent!= null){
						Owner owner=new Owner();
						owner.setOwnerContact(parent.getOwnerContact());
						owner.setOwnerFname(parent.getFname());
						owner.setOwnerLname(parent.getOwnerLname());
						owner.setOwnerOccupation(parent.getOwnerOccupation());
						
						addOwnerDetails(person.getPersonId(), owner);
						updateAddRefInPerson(person.getPersonId(), parent.getLocalAdd().getAddressId(), true);
						updateAddRefInPerson(person.getPersonId(), parent.getPerAdd().getAddressId(),false);
						
						addMember(person.getPersonId(), person.getParentId(), person.getRelationshipId());
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return person.getPersonId();
	}
		
	public boolean addOwnerDetails(long personId,Owner owner){
		int status=0;
		try {
			psmtUpdateOwnerInPerson.setBoolean(1,true);
			psmtUpdateOwnerInPerson.setString(2, owner.getOwnerFname());
			psmtUpdateOwnerInPerson.setString(3, owner.getOwnerLname());
			psmtUpdateOwnerInPerson.setLong(4, owner.getOwnerContact());
			psmtUpdateOwnerInPerson.setString(5, owner.getOwnerOccupation());
			psmtUpdateOwnerInPerson.setLong(6,personId);

			status=psmtUpdateOwnerInPerson.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status>0?true:false;
	}
	
	public boolean addMember(long personId,long parentId,long relationshipId ){
		int status=0;
		try {
			psmtInsertMember.setLong(1,personId);
			psmtInsertMember.setLong(2,parentId);
			psmtInsertMember.setLong(3,relationshipId);

			status=psmtInsertMember.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status>0?true:false;
	}
	public long insertAddress(Address address){
		try {
			psmtInsertAddress.setString(1, address.getLine1());
			psmtInsertAddress.setString(2, address.getLine2());
			psmtInsertAddress.setString(3, address.getArea());
			psmtInsertAddress.setString(4, address.getCity());
			psmtInsertAddress.setString(5, address.getState());
			psmtInsertAddress.setString(6, address.getPincode());
			psmtInsertAddress.setString(7, address.getContact());

			psmtInsertAddress.executeUpdate();
			ResultSet rs=psmtInsertAddress.getGeneratedKeys();

			while (rs.next()) {
				address.setAddressId(rs.getLong(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return address.getAddressId();
	}
	public boolean updateAddRefInPerson(long personId, long addressId,boolean isLocal){
		int status=0;
		try{
			if(isLocal){
				psmtUpdateLocalAddInPerson.setLong(1, addressId);
				psmtUpdateLocalAddInPerson.setLong(2, personId);

				status=psmtUpdateLocalAddInPerson.executeUpdate();

			}else{
				psmtUpdatePermanantAddInPerson.setLong(1, addressId);
				psmtUpdatePermanantAddInPerson.setLong(2, personId);

				status=psmtUpdatePermanantAddInPerson.executeUpdate();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status>0?true:false;
	}

	public Map<Long, String> getAllRelationshipConstant(){
		Map<Long, String> constants= new HashMap<Long, String>();
		try{
			ResultSet rs=psmtGetAllRelationshipConstants.executeQuery();
			while (rs.next()) {
				constants.put(rs.getLong("relationshipId"), rs.getString("relation"));				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return constants;
	}
	public List<Member> getAllMembers(long parentId){
		List<Member> members=new LinkedList<Member>();
		try {
			psmtGetAllFamilyMembers.setLong(1, parentId);
			ResultSet rs=psmtGetAllFamilyMembers.executeQuery();

			while (rs.next()) {
				Member member=new Member();
				member.setSelf(getPerson(rs.getLong("personId")));
				member.setSelf(getPerson(rs.getLong("personId")));
				member.setRelation(getRelationship(rs.getLong("relationshipId")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return members;
	}
	public Person getPerson(long personId){
		Person person=new Person();
		try {
			psmtGetPerson.setLong(1, personId);
			ResultSet rs=psmtGetPerson.executeQuery();
			while(rs.next()){
				person.setPersonId(rs.getLong("personId"));
				person.setFname(rs.getString("fname"));
				person.setMname(rs.getString("mname"));
				person.setLname(rs.getString("lname"));
				person.setGender(rs.getString("gender"));
				person.setDOB(rs.getDate("dob"));
				person.setBloodGroup(rs.getString("bloodgroup"));
				person.setChairPerson(rs.getBoolean("chairperson"));
				if(rs.getLong("perAdd")!=0 && rs.getLong("localAdd")==rs.getLong("perAdd"))
					person.setSameAdd(true);
				else
					person.setSameAdd(false);

				person.setLocalAdd(getAddress(rs.getLong("localAdd")));
				person.setPerAdd(getAddress(rs.getLong("perAdd")));

				person.setEducation(rs.getString("education"));
				person.setEmail(rs.getString("email"));
				person.setOccupation(rs.getString("occupation"));
				person.setOrgName(rs.getString("orgname"));
				person.setPancard(rs.getString("pancard"));
				person.setRationCard(rs.getString("rationcard"));
				person.setVoterId(rs.getString("voterid"));

				person.setSenierCitizen(rs.getBoolean("seniorcitizen"));
				person.setOwnerFname(rs.getString("ownerfname"));
				person.setOwnerLname(rs.getString("ownerlname"));
				person.setOwnerContact(rs.getLong("ownercontact"));
				person.setOwnerOccupation(rs.getString("owneroccupation"));
				person.setFormNo(rs.getString("formno"));
				person.setUser(getUser(rs.getLong("byUser")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return person;
	}

	public Address getAddress(long addressId){
		Address address=new Address();
		try {
			psmtGetAddress.setLong(1, addressId);
			ResultSet rs= psmtGetAddress.executeQuery();
			if (rs.next()) {
				address.setAddressId(addressId);
				address.setLine1(rs.getString("line1"));
				address.setLine2(rs.getString("line2"));
				address.setArea(rs.getString("area"));
				address.setCity(rs.getString("city"));
				address.setState(rs.getString("state"));
				address.setPincode(rs.getString("pincode"));
				address.setContact(rs.getString("contactNo"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return address;
	}
	public User getUser(long userId){
		User user =new User();
		try {
			psmtGetUser.setLong(1,userId);
			ResultSet rs= psmtGetUser.executeQuery();
			if(rs.next()){
				user.setUserId(userId);
				user.setUsername(rs.getString("username"));
				user.setRole(rs.getString("role"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;

	}
	public Relationship getRelationship(long relationshipId){
		Relationship relationship=new Relationship();
		try {
			psmtGetRelationship.setLong(1,relationshipId);
			ResultSet rs= psmtGetRelationship.executeQuery();
			if(rs.next()){
				relationship.setRelationshipId(relationshipId);
				relationship.setRelation(rs.getString("relation"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return relationship;
	}
	
	public Person getChairPerson(long personId){
		Person person=null;
		try {
			psmtGetChairPerson.setLong(1,personId);
			ResultSet rs=psmtGetChairPerson.executeQuery();
			if(rs.next()){
				person=getPerson(rs.getLong("parentId"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return person;
		
	}
}

