package com.vgs.serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.vgs.db.DB;

/**
 * Servlet implementation class GetRelationshipMap
 */
public class GetRelationshipMap extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public GetRelationshipMap() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		Map<Long, String>map=DB.getInstance().getAllRelationshipConstant();
		for (Map.Entry<Long, String> entry : map.entrySet()) {
		    out.print("<option value="+ entry.getKey() + ">" + entry.getValue()+"</option>");
		}
		//out.print(new Gson().toJson(persMon));
		out.flush();
	}

}
