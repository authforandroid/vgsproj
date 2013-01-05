package com.vgs.serv;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vgs.beans.Person;
import com.vgs.db.DB;

/**
 * Servlet implementation class AddPerson
 */
public class AddPerson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPerson() {
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
	 * INSERT INTO test VALUES(STR_TO_DATE('03/08/2009', '%m/%d/%Y'));
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Person person=new Person();
		
		person.setFname(request.getParameter("fname"));
		person.setMname(request.getParameter("mname"));
		person.setLname(request.getParameter("lname"));
		person.setGender(request.getParameter("gender"));
		String dd=request.getParameter("dd");
		String mm=request.getParameter("mm");
		String yyyy=request.getParameter("yyyy");
		Date dob=null;
		try {
			dob = new SimpleDateFormat("yyyy-mm-dd").parse(yyyy+"-"+mm+"-"+dd);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		person.setDOB(dob);
		person.setBloodGroup(request.getParameter("bloodgroup"));
		long contact=Long.parseLong(request.getParameter("contact"));
		person.setContact(contact);
		person.setEmail(request.getParameter("email"));
		person.setVoterId(request.getParameter("voterid"));
		person.setPancard(request.getParameter("pancard"));
		person.setAdharcard(request.getParameter("adharcard"));
		person.setRationCard(request.getParameter("rationcard"));
		String[] senior=request.getParameterValues("seniorcitizen");
		person.setSenierCitizen(Integer.parseInt(senior[0])==1?true:false);
		person.setEducation(request.getParameter("education"));
		person.setOccupation(request.getParameter("occupation"));
		person.setOrgName(request.getParameter("orgname"));
		
		long personId=DB.getInstance().insertPerson(person);
		response.sendRedirect("insertAddressDetails.jsp?personId="+personId);
	}

}
