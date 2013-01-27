/**
 * 
 */
$(document).ready(function(){
	$("#savepersonal").click(function(){
			var fname=$("#fname").val();
			var mname=$("#mname").val();
			var lname=$("#lname").val();
			var dd=$("#dd").val();
			var mm=$("#mm").val();
			var yyyy=$("#yyyy").val();
			var message="";
			if(fname==""){
				message=message+"First Name should not be blank \n";
			}
			if(mname==""){
				message=message+"Middle Name should not be blank \n";
			}
			if(lname==""){
				message=message+"Last Name should not be blank \n";
			}
			if(dd==""||mm==""||yyyy==""){
				message=message+"Date of birth is invalid \n";
			}
			if(message==""){
				
			}else{
				alert("Please Check the following Errors \n\n"+message);
				return false;
			}
		});
		$("#saveaddress").click(function(){
			var line1=$("#line1").val();
			var area=$("#area").val();
			var city=$("#city").val();
			var state=$("#state").val();
			var message="";
			if(line1==""){
				message=message+"Line1 should not be blank \n";
			}
			if(area==""){
				message=message+"Area should not be blank \n";
			}
			if(city==""){
				message=message+"City should not be blank \n";
			}
			if(state==""){
				message=message+"State should not be blank \n";
			}
			if(message==""){
				
			}else{
				alert("Please Check the following Errors \n\n"+message);
				return false;
			}
	});
	$("#onrent").click(function(){
		var $this=$(this);
		if($this.is(":checked"))
			$(".ownerdetails input[type='text']").removeAttr("disabled");
		else
			$(".ownerdetails input[type='text']").attr("disabled","true	");
	});
	
	$("input[type='checkbox']").change(function() {
        if($(this).is(":checked")) {
            $(this).val(1);
            console.log(" is checked & value changed to "+$(this).val());
            console.log(this);
        }else{
        	$(this).val(0);
        	console.log(" is un-checked & value changed to "+$(this).val());
        	console.log(this);
        }
               
    });
	
	 $.ajax({
	       type: "POST",
	       url:"./GetRelationshipMap" ,
	       success: function(result)
	       {
	    	   console.log(result);
	    	   $("#relationshipid").html(result);
		   }
	     });

	$("#addMemberSubmit").click(function() {
		var frm = $('#addMemberForm');
	    $.ajax({
	           type: frm.attr('method'),
	           url: frm.attr('action'),
	           data: frm.serialize(), // serializes the form's elements.
	           success: function(data,txtStatus,jqXHR)
	           {
	        	   var newrow=
	        		"<tr><td>&nbsp;</td><td>"+data.Fname+"</td>"+
					"<td>"+data.Mname+"</td>"+
					"<td>"+data.Lname+"</td>"+
					"<td><a href=DeletePerson?personId="+data.PersonId+" class=\"btn btn btn-danger\">Delete</a></td></tr>";
				   $("#memberstbl").append(newrow);
				   $("#memberModal").modal('hide');
	           }
	         });
	    return false; // avoid to execute the actual submit of the form.
	});
});