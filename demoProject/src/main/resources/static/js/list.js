$(document).ready(function() {
	let odgovor = localStorage.getItem("response");
	let words = odgovor.split('&');
	document.getElementById("sudija").innerHTML = words[0];
	document.getElementById("delo").innerHTML = words[2];
	document.getElementById("kazna").innerHTML = words[3];
	document.getElementById("dokazi").innerHTML = words[1];
});