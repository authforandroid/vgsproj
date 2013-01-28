<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Address Details</title>
<jsp:include page="stylesheets.jsp" flush="true"></jsp:include>
</head>
<body>
	<jsp:include page="header.jsp" flush="true"></jsp:include>
	<div class="conatiner-fluid">
		<div class="row-fluid">
			<h3>Address details of -Person name-<%=request.getParameter("personId")%></h3>
		</div>
		<form class="form-horizontal" method="post" action="AddAddress">
			<input type="hidden" id="personId" name="personId" value="<%=request.getParameter("personId")%>">
			<div class="row-fluid">
				<fieldset>
					<legend>Address Details</legend>

					<div class="span4 ownerdetails" style="margin-left: 0;">
						<div class="control-group">
							<div class="controls">
								<label class="checkbox" for=onrent> 
								<input type="checkbox" id="onrent" name="onrent" value="onrent" >I stay on
									rent
								</label>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="ownerfname">Owner's
								Last Name</label>
							<div class="controls">
								<input type="text" id="ownerfname" name="ownerfname" placeholder="Owner's First Name" disabled>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="ownerlname">Owner's
								Last Name</label>
							<div class="controls">
								<input type="text" id="ownerlname" name="ownerlname" placeholder="Owner's Last Name" disabled>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="owneroccupation">Owner's
								Occupation</label>
							<div class="controls">
								<input type="text" id="owneroccupation" name="owneroccupation" placeholder="Owner's Occupation" disabled>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="ownercontact">Owner's
								contact</label>
							<div class="controls">
								<input type="text" id="ownercontact" name="ownercontact" placeholder="Owner's Contact" disabled>
							</div>
						</div>
					</div>
					<!-- rent info -->
					<div class="span4">
						<div class="control-group">
							<label class="control-label" for="localadd"><b>Local
									Address</b></label>
						</div>
						<div class="control-group">
							<label class="control-label" for="line1">Line 1</label>
							<div class="controls">
								<input type="text" id="line1" name="line1" placeholder="Line 1">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="line2">Line 2</label>
							<div class="controls">
								<input type="text" id="line2" name="line2" placeholder="Line 2">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="area">Area</label>
							<div class="controls">
								<input type="text" id="area" name="area" placeholder="Area">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="city">City</label>
							<div class="controls">
								<input type="text" id="city" name="city" placeholder="City">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="state">State</label>
							<div class="controls">
								<input type="text" id="state" name="state" placeholder="State">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="pincode">Pincode</label>
							<div class="controls">
								<input type="text" id="pincode" name="pincode" placeholder="Pincode ">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="contact">Contact</label>
							<div class="controls">
								<input type="text" id="contact" name="contact" placeholder="Contact">
							</div>
						</div>
					</div>
					<!-- end of local address -->
					<div class="span4">
						<div class="control-group">
							<label class="control-label" for="peradd"><b>Permanent
									Address</b></label>
						</div>
						<div class="control-group">
							<div class="controls">
								<label class="checkbox" for="sameadd">
								 <input type="checkbox" id="sameadd" name="sameadd" value="sameadd">same as Local
								</label>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="perline1">Line 1</label>
							<div class="controls">
								<input type="text" id="perline1" name="perline1" placeholder="Line 1">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="perline2">Line 2</label>
							<div class="controls">
								<input type="text" id="perline2" name="perline2" placeholder="Line 2">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="perarea">Area</label>
							<div class="controls">
								<input type="text" id="perarea" name="perarea" placeholder="Area">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="percity">City</label>
							<div class="controls">
								<input type="text" id="percity" name="percity" placeholder="City">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="perstate">State</label>
							<div class="controls">
								<input type="text" id="perstate" name="perstate" placeholder="State">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="perpincode">Pincode</label>
							<div class="controls">
								<input type="text" id="perpincode" name="perpincode" placeholder="Pincode ">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="percontact">Contact</label>
							<div class="controls">
								<input type="text" id="percontact" name="percontact" placeholder="Contact">
							</div>
						</div>
					</div>
					<!-- end of permanant address -->
				</fieldset>
			</div>
			<div class="row-fluid">
				<div class="offset4 span4">
					<button id="saveaddress" class="btn btn-large btn-primary pull-right" type="submit">Save
						And Continue</button>
				</div>
			</div>
		</form>
	</div>
	<jsp:include page="scripts.jsp" flush="true"></jsp:include>

</body>
</html>