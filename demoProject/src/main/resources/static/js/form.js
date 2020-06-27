(function ($) {
    try {
        var selectSimple = $('.js-select-simple');
    
        selectSimple.each(function () {
            var that = $(this);
            var selectBox = that.find('select');
            var selectDropdown = that.find('.select-dropdown');
            selectBox.select2({
                dropdownParent: selectDropdown
            });
        });
    
    } catch (err) {
        console.log(err);
    }
    

})(jQuery);

function submit() {
    let naziv = $('#naziv').val();
    let min_kazna = $('#min_kazna').val();
    let max_kazna = $('#max_kazna').val();
    let clan = $('#clan').val();
    let stav = $('#stav').val();
    let tacka = $('#tacka').val(); 
    let zrtva = $('#zrtva').val();

    if (zrtva == "ZRTVA")
        zrtva = "";

    let subjOdnos = $('#subjOdnos').val();
    if (subjOdnos == "SUBJEKTIVAN ODNOS")
        subjOdnos = "";

    let stanje = $('#stanje').val();
    if (stanje == "STANJE")
        stanje = "";

    let mesto = $('#mesto').val();
    if (mesto == "MESTO")
        mesto = "";

    let radnja = $('#radnja').val();
    if (radnja == "RADNJA")
        radnja = "";

    let brZrtava = $('#brZrtava').val();
    if (brZrtava == "BROJ ŽRTAVA")
        brZrtava = "";
        
    let psihickoStanje = $('#psihicko_stanje').val();
    if (psihickoStanje == "")
        psihickoStanje = "nema podataka";

    let dokazi = $('#dokazi').val();
    if (dokazi == "")
        dokazi = "";

    $.ajax({
        url: 'delo/dodajNovo',
        type: 'POST',
		data: JSON.stringify({naziv, min_kazna, max_kazna, clan, stav, tacka, zrtva, subjOdnos, stanje, mesto, radnja, brZrtava, psihickoStanje, dokazi}),
		contentType: 'application/json',
		success: function(){
            alert('Success');
            window.location = "../index.html";
		},
		error: function(){
			alert('Something went wrong');
		}

    });

}

