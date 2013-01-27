
<%@page import="java.util.List"%>
<%@page import="com.vgs.db.DB" %>
<%@page import="com.vgs.beans.Member" %>
<%
List<Member> members  = DB.getInstance().getAllMembers(Long.parseLong(request.getParameter("parentId")));
for(Member member : members){
%>
	<tr>
	<td><%=member.getSelf().getFname() %></td>
	<td><%=member.getSelf().getMname() %></td>
	<td><%=member.getSelf().getLname() %></td>
	<td><%=member.getRelation().getRelation() %></td>
	<td><a href="DeleteMember?memberId="+<%=member.getSelf().getPersonId()%>+">Delete</a></td>
	</tr>
<%
}
%>
