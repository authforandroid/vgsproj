package com.vgs.serv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.classfile.LocalVariableTable;
import com.vgs.beans.Address;
import com.vgs.beans.Owner;
import com.vgs.db.DB;

/**
 * Servlet implementation class AddAddress
 */
public class AddAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AddAddress() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long personId=Long.parseLong(request.getParameter("personId"));
		boolean onRent=false;
		boolean sameAdd=false;
		if(request.getParameter("onrent")!=null){
			onRent=request.getParameter("onrent").equalsIgnoreCase("1")?true:false;
		}
		if(request.getParameter("sameadd")!=null){
			sameAdd=request.getParameter("sameadd").equalsIgnoreCase("1")?true:false;
		}
		
		long localId=0,perId=0;
		DB dbref= DB.getInstance();
		if(onRent){
			Owner owner=new Owner();
			owner.setOwnerFname(request.getParameter("ownerfname"));
			owner.setOwnerLname(request.getParameter("ownerlname"));
			long ph=0;
			if(request.getParameter("ownercontact").length()!=0){
				ph=Long.parseLong(request.getParameter("ownercontact"));
			}
			owner.setOwnerContact(ph);
			owner.setOwnerOccupation(request.getParameter("owneroccupation"));
			
			dbref.addOwnerDetails(personId, owner);
		}
		
		Address localAdd=new Address();
		localAdd.setLine1(request.getParameter("line1"));
		localAdd.setLine2(request.getParameter("line2"));
		localAdd.setArea(request.getParameter("area"));
		localAdd.setCity(request.getParameter("city"));
		localAdd.setState(request.getParameter("state"));
		localAdd.setPincode(request.getParameter("pincode"));
		String locPh=null;
		if(request.getParameter("contact").length()!=0){
			locPh=request.getParameter("contact");
		}
		localAdd.setPincode(locPh);
		
		if(sameAdd){
			localId=dbref.insertAddress(localAdd);
			if(localId>0){
				dbref.updateAddRefInPerson(personId, localId, true);
				dbref.updateAddRefInPerson(personId, localId, false);
				perId=localId;
			}
		}else{
			localId=dbref.insertAddress(localAdd);
			Address perAdd=new Address();
			perAdd.setLine1(request.getParameter("perline1"));
			perAdd.setLine2(request.getParameter("perline2"));
			perAdd.setArea(request.getParameter("perarea"));
			perAdd.setCity(request.getParameter("percity"));
			perAdd.setState(request.getParameter("perstate"));
			perAdd.setPincode(request.getParameter("perpincode"));
			String perPh=null;
			if(request.getParameter("percontact").length()!=0){
				perPh=request.getParameter("percontact");
			}
			perAdd.setPincode(perPh);
			perId=dbref.insertAddress(perAdd);
			if(perId>0)
			dbref.updateAddRefInPerson(personId, perId, false);
			
		}
		
		response.sendRedirect("insertFamilyMembers.jsp?parentId="+personId+"&&localAdd="+localId+"&&perAdd="+perId+"&&sameAdd="+sameAdd+"&&onRent="+onRent);
	}

}
