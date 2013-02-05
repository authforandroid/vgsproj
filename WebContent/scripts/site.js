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
	
		
		
		
		$("#sameadd").click(function(){
			if($(this).is(":checked")){
			$("#perline1").val($("#line1").val());
			$("#perline2").val($("#line2").val());
			$("#perarea").val($("#area").val());
			$("#percity").val($("#city").val());
			$("#perstate").val($("#state").val());
			$("#perpincode").val($("#pincode").val());
			$("#percontact").val($("#contact").val());
			}
		});
		
		$("#saveaddress").click(function(){
			var line1=$("#line1").val();
			var line2=$("#line2").val();
			var area=$("#area").val();
			var city=$("#city").val();
			var state=$("#state").val();
			var pincode=$("#pincode").val();
			var contact=$("#contact").val();
			
			
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
			
			var perline1=$("#perline1").val();
			var perline2=$("#perline2").val();
			var perarea=$("#perarea").val();
			var percity=$("#percity").val();
			var perstate=$("#perstate").val();
			var percontact=$("#percontact").val();
			var perpincode=$("#perpincode").val();
			
			if($("#sameadd").is(":checked")){
				}
			else{
				if(perline1==""){
					message=message+"Line1 should not be blank (Permanent Address) \n";
				}
				if(perarea==""){
					message=message+"Area should not be blank (Permanent Address) \n";
				}
				if(percity==""){
					message=message+"City should not be blank (Permanent Address) \n";
				}
				if(perstate==""){
					message=message+"State should not be blank(Permanent Address) \n";
				}
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
		
		var fname= $("#addMemberForm #fname").val();
		var mname= $("#addMemberForm #mname").val();
		var lname= $("#addMemberForm #lname").val();
		var dd= $("#addMemberForm #dd").val();
		var mm= $("#addMemberForm #mm").val();
		var yyyy= $("#addMemberForm #yyyy").val();
				
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
				$.ajax({
			           type: frm.attr('method'),
			           url: frm.attr('action'),
			           data: frm.serialize(), // serializes the form's elements.
			           success: function(data,txtStatus,jqXHR)
			           {
						   $("#memberModal").modal('hide');
						   window.location.reload(true);
			           }
			         });
				
			}else{
				alert("Please Check the following Errors \n\n"+message);
				return false;
			}
	   // return false; // avoid to execute the actual submit of the form.
	});
	
	$(".btn.delete").click(function(){
		var id=$(this).attr("id");
		var status=confirm("you are about to delete a member in family. If you delete it once you cant get it back. Are You sure about this ?" );
		if(status){
			$.ajax({ 
				   type: "POST",
			       url:"./DeleteMember" ,
		           data: {
		        	   memberId:id
		           },
		           success: function(data,txtStatus,jqXHR)
		           {
					alert("Successfully deleted  member "+data.Fname+" "+data.Lname);
					window.location.reload(true);
		           }
		         });
		}else{
			window.location.reload(true);
		}		
	});
});