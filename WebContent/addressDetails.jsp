<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Address Details</title>
<jsp:include page="stylesheets.jsp" flush="true"></jsp:include>
</head>
<body>
	<jsp:include page="header.jsp" flush="true"></jsp:include>
	<div class="conatiner-fluid">
		<div class="row-fluid">
			<h3>Address details of -Person name-</h3>
			<input type="hidden" id="perentid" value="#">
		</div>
		<div class="row-fluid">
			<form class="form-horizontal">
				<fieldset>
					<legend>Address Details</legend>

					<div class="span4" style="margin-left:0;">
						<div class="control-group">
							<div class="controls">
								<label class="checkbox" for=onrent> <input
									type="checkbox" id="onrent" value="onrent">I stay on
									rent
								</label>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="ownerlname">Owner's
								Last Name</label>
							<div class="controls">
								<input type="text" id="ownerlname"
									placeholder="Owner's Last Name">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="owneroccupation">Owner's
								Occupation</label>
							<div class="controls">
								<input type="text" id="owneroccupation"
									placeholder="Owner's Occupation">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="ownercontact">Owner's
								contact</label>
							<div class="controls">
								<input type="text" id="ownercontact"
									placeholder="Owner's Contact">
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
								<input type="text" id="line1" placeholder="Line 1">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="line2">Line 2</label>
							<div class="controls">
								<input type="text" id="line2" placeholder="Line 2">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="area">Area</label>
							<div class="controls">
								<input type="text" id="area" placeholder="Area">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="city">City</label>
							<div class="controls">
								<input type="text" id="city" placeholder="City">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="state">State</label>
							<div class="controls">
								<input type="text" id="state" placeholder="State">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="pincode">Pincode</label>
							<div class="controls">
								<input type="text" id="pincode" placeholder="Pincode ">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="contact">Contact</label>
							<div class="controls">
								<input type="text" id="contact" placeholder="Contact">
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
								<label class="checkbox" for="sameadd"> <input
									type="checkbox" value="sameadd">same as Local
								</label>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="line1">Line 1</label>
							<div class="controls">
								<input type="text" id="line1" placeholder="Line 1">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="line2">Line 2</label>
							<div class="controls">
								<input type="text" id="line2" placeholder="Line 2">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="area">Area</label>
							<div class="controls">
								<input type="text" id="area" placeholder="Area">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="city">City</label>
							<div class="controls">
								<input type="text" id="city" placeholder="City">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="state">State</label>
							<div class="controls">
								<input type="text" id="state" placeholder="State">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="pincode">Pincode</label>
							<div class="controls">
								<input type="text" id="pincode" placeholder="Pincode ">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="contact">Contact</label>
							<div class="controls">
								<input type="text" id="contact" placeholder="Contact">
							</div>
						</div>
					</div>
					<!-- end of permanant address -->
				</fieldset>
			</form>
		</div>
	</div>
	<jsp:include page="scripts.jsp" flush="true"></jsp:include>

</body>
</html>