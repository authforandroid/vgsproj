<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<jsp:include page="stylesheets.jsp" flush="true"></jsp:include>
</head>
<body>
	<jsp:include page="header.jsp" flush="true"></jsp:include>
	<div class="conatiner-fluid">
		<div class="row-fluid">
			<h3>Oops. Something went wrong !! </h3>
			<h5><%=request.getParameter("message")%></h5>
		</div>
	</div>
	<jsp:include page="scripts.jsp" flush="true"></jsp:include>
</body>
</html>