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
import com.vgs.beans.Person;
import com.vgs.beans.Relationship;
import com.vgs.beans.User;

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

	public int insertPerson(Person person){
		try {
			psmtInsertPerson.setString(1, person.getFname());
			psmtInsertPerson.setString(2, person.getMname());
			psmtInsertPerson.setString(3, person.getLname());
			psmtInsertPerson.setString(4, person.getGender());
			psmtInsertPerson.setDate(5, (Date)person.getDOB());
			psmtInsertPerson.setString(6, person.getBloodGroup());
			psmtInsertPerson.setString(7, person.getEmail());
			psmtInsertPerson.setInt(8, person.getContact());
			psmtInsertPerson.setString(9, person.getEducation());
			psmtInsertPerson.setString(10, person.getOccupation());
			psmtInsertPerson.setString(11, person.getOrgName());
			psmtInsertPerson.setString(12, person.getPancard());
			psmtInsertPerson.setString(13, person.getRationCard());
			psmtInsertPerson.setString(14, person.getVoterId());
			psmtInsertPerson.setString(15, person.getAdharcard());
			psmtInsertPerson.setBoolean(16, person.isSenierCitizen());
			psmtInsertPerson.setBoolean(17, person.isChairPerson());
			psmtInsertPerson.setString(18, person.getFormNo());
			psmtInsertPerson.setString(19, person.getUser().getUsername());

			psmtInsertPerson.executeUpdate();
			ResultSet rs=psmtInsertPerson.getGeneratedKeys();

			while (rs.next()) {
				person.setPersonId(rs.getInt("personId"));
			}


			//if not a chair person then relation needs to be mentioned with parent 
			if(person.isChairPerson()){
				int localAddressId=insertAddress(person.getLocalAdd());
				//true means update the local address using psmtLocalAddress
				updateAddRefInPerson(person.getPersonId(), localAddressId, true);
				int perAddressId=0;
				if(!person.isSameAdd())
					perAddressId=insertAddress(person.getPerAdd());

				if(perAddressId!=0)
					updateAddRefInPerson(person.getPersonId(), localAddressId, false);

				if(person.isOnRent()){
					psmtUpdateOwnerInPerson.setBoolean(1,person.isOnRent());
					psmtUpdateOwnerInPerson.setString(2, person.getOwnerFname());
					psmtUpdateOwnerInPerson.setString(3, person.getOwnerLname());
					psmtUpdateOwnerInPerson.setInt(4, person.getOwnerContact());
					psmtUpdateOwnerInPerson.setString(5, person.getOwnerOccupation());
					psmtUpdateOwnerInPerson.setInt(6,person.getPersonId());

					psmtUpdateOwnerInPerson.executeUpdate();

				}
			}
			else{
				psmtInsertMember.setInt(1,person.getPersonId());
				psmtInsertMember.setInt(2,person.getParentId());
				psmtInsertMember.setInt(3,person.getRelationshipId());

				psmtInsertMember.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return person.getPersonId();
	}
	public int insertAddress(Address address){
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
				address.setAddressId(rs.getInt("addressId"));
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return address.getAddressId();
	}
	public boolean updateAddRefInPerson(int personId, int addressId,boolean isLocal){
		int status=0;
		try{
			if(isLocal){
				psmtUpdateLocalAddInPerson.setInt(1, addressId);
				psmtUpdateLocalAddInPerson.setInt(2, personId);

				status=psmtUpdateLocalAddInPerson.executeUpdate();

			}else{
				psmtUpdatePermanantAddInPerson.setInt(1, addressId);
				psmtUpdatePermanantAddInPerson.setInt(2, personId);

				status=psmtUpdatePermanantAddInPerson.executeUpdate();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(status>0)
			return true;
		else 
			return false;
	}

	public Map<Integer, String> getAllRelationshipConstant(){
		Map<Integer, String> constants= new HashMap<Integer, String>();
		try{
			ResultSet rs=psmtGetAllRelationshipConstants.executeQuery();
			while (rs.next()) {
				constants.put(rs.getInt("relationshipId"), rs.getString("relation"));				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return constants;
	}
	public List<Member> getAllMembers(int parentId){
		List<Member> members=new LinkedList<Member>();
		try {
			psmtGetAllFamilyMembers.setInt(1, parentId);
			ResultSet rs=psmtGetAllFamilyMembers.executeQuery();

			while (rs.next()) {
				Member member=new Member();
				member.setSelf(getPerson(rs.getInt("personId")));
				member.setSelf(getPerson(rs.getInt("personId")));
				member.setRelation(getRelationship(rs.getInt("relationshipId")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return members;
	}
	public Person getPerson(int personId){
		Person person=new Person();
		try {
			psmtGetPerson.setInt(1, personId);
			ResultSet rs=psmtGetPerson.executeQuery();
			while(rs.next()){
				person.setPersonId(rs.getInt("personId"));
				person.setFname(rs.getString("fname"));
				person.setMname(rs.getString("mname"));
				person.setLname(rs.getString("lname"));
				person.setGender(rs.getString("gender"));
				person.setDOB(rs.getDate("dob"));
				person.setBloodGroup(rs.getString("bloodgroup"));
				person.setChairPerson(rs.getBoolean("chairperson"));
				if(rs.getInt("perAdd")!=0 && rs.getInt("localAdd")==rs.getInt("perAdd"))
					person.setSameAdd(true);
				else
					person.setSameAdd(false);

				person.setLocalAdd(getAddress(rs.getInt("localAdd")));
				person.setPerAdd(getAddress(rs.getInt("perAdd")));

				person.setEducation(rs.getString("education"));
				person.setEmail(rs.getString("email"));
				person.setOccupation(rs.getString("occupation"));
				person.setOrgName(rs.getString("orgname"));
				person.setPancard(rs.getString("pancard"));
				person.setRationCard(rs.getString("rationcard"));
				person.setVoterId(rs.getString("voterid"));

				person.setSenierCitizen(rs.getBoolean("seniorcitizen"));
				person.setOwnerFname(rs.getString("ownerfname"));
				person.setOwnerLname(rs.getString("ownmerlname"));
				person.setOwnerContact(rs.getInt("ownercontact"));
				person.setOwnerOccupation(rs.getString("owneroccupation"));

				
				person.setFormNo(rs.getString("formno"));

				person.setUser(getUser(rs.getInt("byUser")));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return person;
	}

	public Address getAddress(int addressId){
		Address address=new Address();
		try {
			psmtGetAddress.setInt(1, addressId);
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
	public User getUser(int userId){
		User user =new User();
		try {
			psmtGetUser.setInt(1,userId);
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
	public Relationship getRelationship(int relationshipId){
		Relationship relationship=new Relationship();
		try {
			psmtGetRelationship.setInt(1,relationshipId);
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
	
	public Person getChairPerson(int personId){
		Person person=null;
		try {
			psmtGetChairPerson.setInt(1,personId);
			ResultSet rs=psmtGetChairPerson.executeQuery();
			if(rs.next()){
				person=getPerson(rs.getInt("parentId"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return person;
		
	}
}

