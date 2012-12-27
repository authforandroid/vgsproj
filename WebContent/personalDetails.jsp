<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
<jsp:include page="stylesheets.jsp" flush="true"></jsp:include>
</head>
<body>
	<jsp:include page="header.jsp" flush="true"></jsp:include>
	<div class="conatiner-fluid">
		<div class="row-fluid">
			<form class="form-horizontal">
				<div class="span4">
					<fieldset>
						<legend>Personal Details</legend>
						<div class="control-group">
							<label class="control-label" for="fname">First Name</label>
							<div class="controls">
								<input type="text" id="fname" placeholder="First Name">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="mname">Middle Name</label>
							<div class="controls">
								<input type="text" id="mname" placeholder="Middle Name">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="lname">Last Name</label>
							<div class="controls">
								<input type="text" id="lname" placeholder="Last Name">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="gender">Gender</label>
							<div class="controls">
								<select id="gender">
									<option value="male">Male</option>
									<option value="female">Female</option>
									<option value="other">Other</option>
								</select>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="dob">Date Of Birth</label>
							<div class="controls">
								<input type="text" id="dob" placeholder="Date Of birth">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="bloodgroup">Blood Group</label>
							<div class="controls">
								<select id="bloodgroup">
									<option value="o+">O +ve</option>
									<option value="o-">O -ve</option>
									<option value="A+">A +ve</option>
									<option value="A-">A -ve</option>
									<option value="B+">B +ve</option>
									<option value="B-">B -ve</option>
									<option value="AB+">AB +ve</option>
									<option value="AB-">AB -ve</option>
								</select>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="contact">Contact No</label>
							<div class="controls">
								<input type="text" id="contact" placeholder="Primary Contact No">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="email">Email Id</label>
							<div class="controls">
								<input type="text" id="email" placeholder="Email id">
							</div>
						</div>
					</fieldset>
				</div>
				<!-- end of 1st column -->
				<div class="span4">
					<fieldset>
						<legend>Identity Details</legend>
						<div class="control-group">
							<label class="control-label" for="voterid">Voter Id</label>
							<div class="controls">
								<input type="text" id="voterid" placeholder="Voter Id">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="pancard">Pancard</label>
							<div class="controls">
								<input type="text" id="pancard" placeholder="Pancard No">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="adharcard">Adharcard</label>
							<div class="controls">
								<input type="text" id="adharcard" placeholder="Adharcard No">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="rationcard">Ration card</label>
							<div class="controls">
								<input type="text" id="rationcard" placeholder="Rationcard No">
							</div>
						</div>
						<div class="control-group">
							<div class="controls">
								<label class="checkbox" for="seniorcitizen"> <input
									type="checkbox" id="seniorcitizen" value="seniorcitizen">I am a senior
									citizen
								</label>
							</div>
						</div>
					</fieldset>
				</div>
				<!-- end of 2nd-1st column -->
				<div class="span4">
					<fieldset>
						<legend>Education & Occupation</legend>
						<div class="control-group">
							<label class="control-label" for="education">Highest
								Education</label>
							<div class="controls">
								<select id="education">
									<option value="none">None</option>
									<option value="lessthan4">Less than 4th</option>
									<option value="lessthan7">Less than 7th</option>
									<option value="lessthan10">Less than 10th</option>
									<option value="lessthan12">Less than 12th</option>
									<option value="iti">ITI</option>
									<option value="diploma">Diploma</option>
									<option value="engginering">Engineering</option>
									<option value="graduation">Graduation</option>
									<option value="doctorgraduate">Doctor Graduatie</option>
									<option value="postgraducation">Post Graduation</option>
									<option value="PHD">PHD</option>
									<option value="Other">Other</option>
								</select>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="occupation">Occupation</label>
							<div class="controls">
								<input type="text" id="occupation" placeholder="Occupation">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="orgname">Organization
								Name</label>
							<div class="controls">
								<input type="text" id="orgname" placeholder="Organization name">
							</div>
						</div>
					</fieldset>
				</div>
				<!-- end of 2nd-2nd column -->
			</form>
		</div>
		<!-- end of container-fluid row-fluid -->
	</div>
	<jsp:include page="scripts.jsp" flush="true"></jsp:include>
</body>
<script type="text/javascript">
	$(document).ready(function() {

	});
</script>
</html>