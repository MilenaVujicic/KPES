$(document).ready(function() {
	$('select').selectpicker();

	document.getElementById('btnSend').addEventListener('click', sendData, false);
});

function sendData(event){
	event.preventDefault();

	var subOdnos = $('#sSubOdnos').val();
	
	$.ajax({
		url:'data/sendData',
		type: 'POST',
		data: JSON.stringify({subOdnos : subOdnos}),
		contentType: 'application/json',
		success: function(){
		},
		error: function(){
			alert('Something went wrong');
		}
	})
}