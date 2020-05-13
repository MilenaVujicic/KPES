$(document).ready(function() {
	$('select').selectpicker();

	document.getElementById('btnSend').addEventListener('click', sendData, false);
});

function sendData(event){
	event.preventDefault();

	var starost1 = $('#sAge1').val();
	var starost2 = $('#sAge2').val();
	var subOdnos = $('#sSubOdnos').val();
	var stanje = $('#sStanje').val();
	var mesto = $('#sMesto').val();
	var radnja = $('#sRadnja').val();
	var broj = $('#sBroj').val();
	
	if(starost1 == null){
		starost1 = ['nema podataka'];
	}
	if(starost2 == null){
		starost2 = ['nema podataka'];
	}
	if(subOdnos == null){
		subOdnos = ['nema podataka'];
	}
	if(stanje == null){
		stanje = ['nema podataka'];
	}
	if(mesto == null){
		mesto = ['nema podataka'];
	}
	if(radnja == null){
		radnja = ['nema podataka'];
	}
	if(broj == null){
		broj = ['nema podataka'];
	}
	$.ajax({
		url:'data/sendData',
		type: 'POST',
		data: JSON.stringify({starost1: starost1, starost2 : starost2, subOdnos : subOdnos, stanje: stanje, mesto: mesto, radnja: radnja, broj: broj}),
		contentType: 'application/json',
		success: function(){
		},
		error: function(){
			alert('Something went wrong');
		}
	})
}