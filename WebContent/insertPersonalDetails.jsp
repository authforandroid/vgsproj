<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Page</title>
<jsp:include page="stylesheets.jsp" flush="true"></jsp:include>
</head>
<body>
	<jsp:include page="header.jsp" flush="true"></jsp:include>
	<form class="form-horizontal" method="post" action="AddPerson">
		<input type="hidden" name="chairperson" value="1">
			<div class="conatiner-fluid">
			<div class="row-fluid">
				<div class="span4">
					<fieldset>
						<legend>Personal Details</legend>
						<div class="control-group">
							<label class="control-label" for="fname">First Name</label>
							<div class="controls">
								<input type="text" id="fname" name="fname" placeholder="First Name">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="mname">Middle Name</label>
							<div class="controls">
								<input type="text" id="mname" name="mname" placeholder="Middle Name">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="lname">Last Name</label>
							<div class="controls">
								<input type="text" id="lname" name="lname" placeholder="Last Name">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="gender">Gender</label>
							<div class="controls">
								<select id="gender" name="gender">
									<option value="male">Male</option>
									<option value="female">Female</option>
									<option value="other">Other</option>
								</select>
							</div>
						</div>
						<div class="control-group dob">
							<label class="control-label" for="dob">Date Of Birth</label>
							<div class="controls">
								<input type="text" id="dd" name="dd" placeholder="Day">
								<input type="text" id="mm" name="mm" placeholder="month">
								<input type="text" id="yyyy" name="yyyy" placeholder="year">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="bloodgroup">Blood Group</label>
							<div class="controls">
								<select id="bloodgroup" name="bloodgroup">
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
								<input type="text" id="contact" name="contact" placeholder="Primary Contact No">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="email">Email Id</label>
							<div class="controls">
								<input type="text" id="email" name="email" placeholder="Email id">
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
								<input type="text" id="voterid" name="voterid" placeholder="Voter Id">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="pancard">Pancard</label>
							<div class="controls">
								<input type="text" id="pancard" name="pancard" placeholder="Pancard No">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="adharcard">Adharcard</label>
							<div class="controls">
								<input type="text" id="adharcard" name="adharcard" placeholder="Adharcard No">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="rationcard">Ration card</label>
							<div class="controls">
								<input type="text" id="rationcard" name="rationcard" placeholder="Rationcard No">
							</div>
						</div>
						<div class="control-group"> 
							<div class="controls">
								<label class="checkbox" for="seniorcitizen"> 
									<input type="checkbox" id="seniorcitizen" name="seniorcitizen" value="0">I am a senior citizen
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
								<select id="education" name="education" >
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
								<input type="text" id="occupation" name="occupation" placeholder="Occupation">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="orgname">Organization
								Name</label>
							<div class="controls">
								<input type="text" id="orgname" name="orgname" placeholder="Organization name">
							</div>
						</div>
					</fieldset>
				</div>
				<!-- end of 2nd-2nd column -->


			</div>
			<!-- end of container-fluid row-fluid -->
			<div class="row-fluid">
				<div class="offset4 span4">
					<input class="btn btn-large btn-primary pull-right" type="submit" value="Save And Continue">
				</div>
			</div>
		</div>
	</form>
	<jsp:include page="scripts.jsp" flush="true"></jsp:include>
</body>
<script type="text/javascript">
	$(document).ready(function() {

	});
</script>
</html>