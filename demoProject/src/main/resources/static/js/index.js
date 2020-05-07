$(document).ready(()=>{
	$.ajax({
		url:"rest/test",
		type: 'GET',
		success: function(){
			alert("SUCCESS");
		},
		error: function(){
			alert("ERROR");
		}
	});
})