function proveriDela() {
	$.ajax({
		url:"list/dela",
		type: 'GET',
		success: function(dela) {
			let url = "list/sendDela/dela";
			for (let delo of dela) {
				let checked = $('input[name="'+delo.naziv+'"]:checked').val();
				if(checked == 'on')
					url += "&" + delo.naziv;
			}
			
			$.ajax({
				url:url,
				type: 'GET',
				success: function() {
					alert("Success");
					window.location = './backward_result.html';
				},
				error: function() {
					alert("Error");
				} 
			});
		},
		error: function(){
			alert("ERROR");
		}
	});
}

function proveriDokaze() {
	$.ajax({
		url:"list/dokazi",
		type: 'GET',
		success: function(dokazi) {
			let url = "list/sendDokazi/dokazi";
			for (let dokaz of dokazi) {
				let checked = $('input[name="'+dokaz.opis+'"]:checked').val();
				if(checked == 'on')
					url += "&" + dokaz.opis;
			}
			
			$.ajax({
				url:url,
				type: 'GET',
				success: function() {
					alert("Success");
					window.location = './backward_result.html';
				},
				error: function() {
					alert("Error");
				} 
			});
		},
		error: function(){
			alert("ERROR");
		}
	});
}

function proveriTuzioca() {
	$.ajax({
		url:"list/tuzioci",
		type: 'GET',
		success: function(tuzioci) {
			let url = "list/sendTuzilac/tuzioci";
			for (let tuzilac of tuzioci) {
				let checked = $('input[name="'+tuzilac.tip+'"]:checked').val();
				if(checked == 'on')
					url += "&" + tuzilac.tip;
			}
			
			$.ajax({
				url:url,
				type: 'GET',
				success: function() {
					alert("Success");
					window.location = './backward_result.html';
				},
				error: function() {
					alert("Error");
				} 
			});
		},
		error: function(){
			alert("ERROR");
		}
	});
}

function sendTuzioci() {
	proveriTuzioca();
}

function sendDokazi() {
	proveriDokaze();
}

function sendDela() {
	proveriDela();
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
	let tuzilacLabel = $('<label class=" custom-container" for="'+tuzilac.tip+'">' + tuzilac.tip +
					'<input type="checkbox" name="'+tuzilac.tip+'" id="'+tuzilac.tip+'">' + 
					'<span class="checkmark"></span></label>');
	$('#tuzioci').append(tuzilacLabel);
}

function prikaziDelo(delo) {
	let deloLabel = $('<label class="container custom-container" for="'+delo.naziv+'">' + delo.naziv +
					  '<input type="checkbox" name="'+delo.naziv+'" id="'+delo.naziv+'">' +
					  '<span class="checkmark"></span></label>');
	$('#dela').append(deloLabel);
}

function prikaziDokaz(dokaz) {
	let dokazLabel = $('<label class="container custom-container" for="'+ dokaz.opis +'">' + dokaz.opis +
					   '<input type="checkbox" name="'+dokaz.opis+'" id="'+ dokaz.opis +'">' +
					   '<span class="checkmark"></span></label>');
	$('#dokazi').append(dokazLabel);
}

function disable() {
	$('#dokazi').prop("disabled", true);
	$('#dela').prop("disabled", true);
}