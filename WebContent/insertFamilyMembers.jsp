<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Members</title>
<jsp:include page="stylesheets.jsp" flush="true"></jsp:include>
</head>
<body>
	<form>
<%-- 		<input type="hidden" id="parentId" name="parentId" value="<%=request.getParameter("parentId")%>"> --%>
<%-- 		<input type="hidden" id="localId" name="localId" value="<%=request.getParameter("localId")%>"> --%>
<%-- 		<input type="hidden" id="perId" name="perId" value="<%=request.getParameter("perId")%>"> --%>
<%-- 		<input type="hidden" id="onRent" name="onRent" value="<%=request.getParameter("onRent")%>"> --%>
<%-- 		<input type="hidden" id="sameAdd" name="sameAdd" value="<%=request.getParameter("sameAdd")%>"> --%>
	</form>
	<jsp:include page="header.jsp" flush="true"></jsp:include>
	<div class="conatiner-fluid">
		<div class="row-fluid">
			<h3>Member details of -Person name-<%=request.getParameter("parentId")%></h3>
		</div>
		<div class="row-fluid">
			<a href="#memberModal" role="button" class="btn" data-toggle="modal">Add
				New Member</a>
		</div>
		<div class="row-fluid">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>#</th>
						<th>First Name</th>
						<th>Middle Name</th>
						<th>Last Name</th>
						<th>Relation</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody id="memberstbl">
				<jsp:include page="GetAllMembers.jsp"></jsp:include>
<!-- 					<tr> -->
<!-- 						<td>1</td> -->
<!-- 						<td>&nbsp;</td> -->
<!-- 						<td>&nbsp;</td> -->
<!-- 						<td>&nbsp;</td> -->
<!-- 						<td>&nbsp;</td> -->
<!-- 						<td><a href="#" class="btn btn btn-danger">Delete</a>&nbsp; <a -->
<!-- 							href="#" class="btn btn btn-success">Edit</a></td> -->
<!-- 					</tr> -->
				</tbody>
			</table>
		</div>
		<div class="row-fluid">
			<div class="offset4 span4">
				<a href="home.jsp" class="btn btn-large btn-primary pull-center" type="submit"> Finish</a>
			</div>
		</div>
	</div>
	<div id="memberModal" class="modal hide fade" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">x</button>
			<h3 id="myModalLabel">Family Member</h3>
		</div>
		<div class="modal-body">
			<jsp:include page="insertPersonTmpl.jsp"></jsp:include>
		</div>
		<div class="modal-footer">
			<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
			<button id="addMemberSubmit" class="btn btn-primary">Save changes</button>
		</div>
	</div>

	<jsp:include page="scripts.jsp" flush="true"></jsp:include>
	<script type="text/javascript">
		
	</script>
</body>
</html>

