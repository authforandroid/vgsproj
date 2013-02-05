
<%@page import="java.util.List"%>
<%@page import="com.vgs.db.DB" %>
<%@page import="com.vgs.beans.Member" %>
<%
List<Member> members  = DB.getInstance().getAllMembers(Long.parseLong(request.getParameter("parentId")));
int i=1;
for(Member member : members){
%>
	<tr>
	<td><%=i++%></td>
	<td><%=member.getSelf().getFname() %></td>
	<td><%=member.getSelf().getMname() %></td>
	<td><%=member.getSelf().getLname() %></td>
	<td><%=member.getRelation().getRelation() %></td>
	<td><button  id="<%=member.getSelf().getPersonId()%>" class="btn btn-danger delete">Delete</button></td>
	</tr>
<%
}
%>
