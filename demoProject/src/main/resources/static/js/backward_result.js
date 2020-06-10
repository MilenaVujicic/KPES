$(document).ready(function() {
	let response = localStorage.getItem("backward_response");
	console.log(response);
	let words = response.split('&');
	for (let word of words) {
		let wr = word.split(':');
		let h2 = $('<h3 class="mt-5">'+wr[0]+':</h3>');
		let p = $('<p class="lead">'+wr[1]+'</p>');
		$('#div').append(h2).append(p);
	}
});