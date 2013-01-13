/**
 * 
 */
$(document).ready(function(){
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