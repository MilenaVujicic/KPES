$(document).ready(function() {
	$('select').selectpicker();

	document.getElementById('btnSend').addEventListener('click', sendData, false);
});

function sendData(event){
	event.preventDefault();

}