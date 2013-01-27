package com.vgs.serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.vgs.beans.Person;
import com.vgs.db.DB;


public class AddMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AddMember() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		Person person=new Person();
		DB dbref=DB.getInstance();
		
		String parentId=request.getParameter("parentId");
		String localAdd=request.getParameter("localAdd");
		String perAdd=request.getParameter("perAdd");
		String sameAdd=request.getParameter("sameAdd");
		String onRent=request.getParameter("onRent");
		if(parentId.length()!=0){
			person.setParentId(Long.parseLong(parentId));
		}
		if(onRent!=null && onRent.length()!=0){
			person.setOnRent(Boolean.getBoolean(onRent));
		}
		if(sameAdd!=null && sameAdd.length()!=0 && Boolean.getBoolean(sameAdd) && localAdd.length()!=0 && Long.parseLong(localAdd)!=0){
			person.setSameAdd(Boolean.getBoolean(sameAdd));
			person.setLocalAdd(dbref.getAddress(Long.parseLong(localAdd)));
			person.setPerAdd(dbref.getAddress(Long.parseLong(localAdd)));
		}
		else if(localAdd.length()!=0 && Long.parseLong(localAdd)!=0 && perAdd.length()!=0 && Long.parseLong(perAdd)!=0){
			person.setLocalAdd(dbref.getAddress(Long.parseLong(localAdd)));
			person.setPerAdd(dbref.getAddress(Long.parseLong(perAdd)));
		}
		String relationshipId=request.getParameter("relationshipid");
		person.setRelationshipId(Long.parseLong(relationshipId));
		
		person.setFname(request.getParameter("fname"));
		person.setMname(request.getParameter("mname"));
		person.setLname(request.getParameter("lname"));
		person.setGender(request.getParameter("gender"));
		String dd=request.getParameter("dd");
		String mm=request.getParameter("mm");
		String yyyy=request.getParameter("yyyy");
		Date dob=null;
		if(dd.length()!=0 && mm.length()!=0 && yyyy.length()!=0)
		{
			try {
				dob = new SimpleDateFormat("yyyy-mm-dd").parse(yyyy+"-"+mm+"-"+dd);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		person.setDOB(dob);
		person.setBloodGroup(request.getParameter("bloodgroup"));
		long contact=Long.parseLong(request.getParameter("contact").length()!=0?request.getParameter("contact"):"0");
		person.setContact(contact);
		person.setEmail(request.getParameter("email"));
		person.setVoterId(request.getParameter("voterid"));
		person.setPancard(request.getParameter("pancard"));
		person.setAdharcard(request.getParameter("adharcard"));
		person.setRationCard(request.getParameter("rationcard"));
		String[] senior=request.getParameterValues("seniorcitizen");
		if(senior!= null){
			person.setSenierCitizen(Integer.parseInt(senior[0])==1?true:false);
		}else{
			person.setSenierCitizen(false);
		}
		person.setChairPerson((request.getParameter("chairperson")!=null && request.getParameter("chairperson").equalsIgnoreCase("1"))?true:false);
		person.setEducation(request.getParameter("education"));
		person.setOccupation(request.getParameter("occupation"));
		person.setOrgName(request.getParameter("orgname"));
		
		long personId=dbref.insertPerson(person);
		
		out.print(new Gson().toJson(person));
		out.flush();
	}

}
