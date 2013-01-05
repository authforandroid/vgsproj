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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAddress() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long personId=Long.parseLong(request.getParameter("personId"));
		boolean onRent=Integer.parseInt(request.getParameter("onrent"))==1?true:false;
		boolean sameAdd=Integer.parseInt(request.getParameter("sameadd"))==1?true:false;
		long localId=0,perId=0;
		
		DB dbref= DB.getInstance();
		if(onRent){
			Owner owner=new Owner();
			owner.setOwnerFname(request.getParameter("ownerfname"));
			owner.setOwnerLname(request.getParameter("ownerlname"));
			owner.setOwnerContact(Long.parseLong(request.getParameter("ownerContact")));
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
		
		if(sameAdd){
			localId=dbref.insertAddress(localAdd);
			if(localId>0){
				dbref.updateAddRefInPerson(personId, localId, true);
				dbref.updateAddRefInPerson(personId, localId, false);
				perId=localId;
			}
		}else{
			Address perAdd=new Address();
			perAdd.setLine1(request.getParameter("line1"));
			perAdd.setLine2(request.getParameter("line2"));
			perAdd.setArea(request.getParameter("area"));
			perAdd.setCity(request.getParameter("city"));
			perAdd.setState(request.getParameter("state"));
			perAdd.setPincode(request.getParameter("pincode"));
			perId=dbref.insertAddress(perAdd);
			if(perId>0)
			dbref.updateAddRefInPerson(personId, perId, false);
			
		}
		
		response.sendRedirect("insertFamilyMembers.jsp?parentId="+personId+"&&localAdd="+localId+"&&perAdd="+perId+"&&sameAdd="+sameAdd+"&&onRent="+onRent);
	}

}
