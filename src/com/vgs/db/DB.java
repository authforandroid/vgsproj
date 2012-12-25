package com.vgs.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.vgs.beans.Address;
import com.vgs.beans.Person;

public class DB {

	private static DB dbRef=null;;
	private Connection conn;
	private PreparedStatement psmtInsertPerson;
	private PreparedStatement psmtInsertAddress;
	private PreparedStatement psmtUpdateLocalAddInPerson;
	private PreparedStatement psmtUpdatePerAddInPerson;
	private PreparedStatement psmtUpdateOwnerInPerson;

	private DB() {
		String myDriver = "org.gjt.mm.mysql.Driver";
		String myUrl = "jdbc:mysql://localhost/vgsdb";
		try {
			Class.forName(myDriver);
			conn = DriverManager.getConnection(myUrl, "root", "mysql");
			/*
			 * Statement stmt = db.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
						numero = stmt.executeUpdate();
				ResultSet rs = stmt.getGeneratedKeys();
				if (rs.next()){
    				risultato=rs.getInt(1);
				}
			 */
			psmtInsertPerson=conn.prepareStatement("insert into persontbl (fname, mname, lname, gender, dob, bloodgroup, email ,contact," +
					" education, occupation, orgname, pancard,rationcard,voterid, adharcard,seniorcitizen,chairperson,formno,byUser)" +
					" values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)" , Statement.RETURN_GENERATED_KEYS);
			psmtInsertAddress=conn.prepareStatement("insert into addresstbl (line1, line2, area, city , state, pincode ,contactNo) " +
					" values (?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			psmtUpdatePerAddInPerson=conn.prepareStatement("update persontbl set localAdd= ? where personId=?");
			psmtUpdatePerAddInPerson=conn.prepareStatement("update persontbl set perAdd= ? where personId=?");
			psmtUpdateOwnerInPerson=conn.prepareStatement("update persontbl set onrent=? ,ownerfname=? ," +
					" ownerlname=?, ownercontact=?, owneroccupation=? where personId=?");


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
	
	public boolean insertPerson(Person person){

		return false;
	}
	public int insertAddress(Address address){

		return 0;
	}
	public boolean updateAddRefInPerson(int personId, int addressId,boolean isPerAdd){

		return false;
	}
}
