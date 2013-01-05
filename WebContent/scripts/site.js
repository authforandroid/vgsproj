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
});