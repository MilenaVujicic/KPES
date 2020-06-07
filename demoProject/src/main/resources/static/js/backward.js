function sendData() {
	
}

$(document).ready(function() {
	getTuzioci();
	getDokazi();
	getDela();
});

function getTuzioci() {
	$.ajax({
		url:"list/tuzioci",
		type: 'GET',
		success: function(tuzioci){
			for (let tuzilac of tuzioci) {
				prikaziTuzioca(tuzilac);
			}
		},
		error: function(){
			alert("ERROR");
		}
	});
}

function getDela() {
	$.ajax({
		url:"list/dela",
		type: 'GET',
		success: function(dela){
			for (let delo of dela) {
			    prikaziDelo(delo);
			}
		},
		error: function(){
			alert("ERROR");
		}
	});
}

function getDokazi() {
	$.ajax({
		url:"list/dokazi",
		type: 'GET',
		success: function(dokazi){
			for (let dokaz of dokazi) {
				prikaziDokaz(dokaz);
			}
		},
		error: function(){
			alert("ERROR");
		}
	});
}

function prikaziTuzioca(tuzilac) {
	let string = tuzilac.tip.replace('_', ' ');
	let tuzilacLabel = $('<label class=" custom-container" for="'+tuzilac.tip+'">' + string +
					'<input type="radio" name="recommend" id="'+tuzilac.tip+'">' + 
					'<span class="checkmark-radio"></span></label>');
	$('#tuzioci').append(tuzilacLabel);
}

function prikaziDelo(delo) {
	let deloLabel = $('<label class="container custom-container" for="'+delo.naziv+'">' + delo.naziv +
					  '<input type="checkbox" name="front" id="'+delo.naziv+'">' +
					  '<span class="checkmark"></span></label>');
	$('#dela').append(deloLabel);
}

function prikaziDokaz(dokaz) {
	let dokazLabel = $('<label class="container custom-container" for="'+ dokaz.opis +'">' + dokaz.opis +
					   '<input type="checkbox" name="front" id="'+ dokaz.opis +'" value="front">' +
					   '<span class="checkmark"></span></label>');
	$('#dokazi').append(dokazLabel);
}

function disable() {
	$('#dokazi').prop("disabled", true);
	$('#dela').prop("disabled", true);
}