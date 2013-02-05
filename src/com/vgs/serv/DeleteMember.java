package com.vgs.serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.vgs.beans.Member;
import com.vgs.beans.Person;
import com.vgs.db.DB;


public class DeleteMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public DeleteMember() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		long memberId=Long.parseLong(request.getParameter("memberId"));
		DB db=DB.getInstance();
		Person personToDelete=db.getPerson(memberId);
		if(personToDelete!=null & !personToDelete.isChairPerson()){
			db.deletePerson(personToDelete.getPersonId());
		}else{
			List<Member> members= db.getAllMembers(personToDelete.getPersonId());
			for(Member member : members){
				db.deletePerson(member.getSelf().getPersonId());
			}
			db.deletePerson(personToDelete.getPersonId());
			db.deleteAddress(personToDelete.getLocalAdd().getAddressId());
			db.deleteAddress(personToDelete.getPerAdd().getAddressId());
		}
		out.print(new Gson().toJson(personToDelete));
		out.flush();
	}

}
