$(document).ready(function() {

	// Hae ikkunan korkeus
	var valikkojenkorkeus = 96;
	var nykyinenkorkeus = $(window).height();
	$('.tiedot').css('height', nykyinenkorkeus - valikkojenkorkeus);

	// Ikkunan koon muuttuessa, suorita funktio
	$(window).resize(function() {

		// Hae uusi ikkunan korkeus
		var nykyinenkorkeus = $(window).height();
		$('.tiedot').css('height', nykyinenkorkeus - valikkojenkorkeus);
		$('.lista').css('height', nykyinenkorkeus - valikkojenkorkeus);

	});
	// jQuery-validointi
	$.validator.addMethod("nimiValidointi", function(value, element) {
		value = $.trim(value);
		for (var i = 0; i < value.length; i++) {
			if (value[i] == "-") {
				if (i == 0 || i == value.length - 1) {
					return false;
				} else if (value[i+1] == '-') {
					return false;
				}
			} else if (!(/[a-öA-Ö]/.test(value[i]))){
				return false;
			}
		}
		return true;
	}, "Nimessä saa olla vain kirjaimia ja väliviiva kahden nimen välissä");
	
	$.validator.addMethod("opiskelijanumeroValidointi", function(value, element) {
		value = $.trim(value);
		if(value.length != 7 && value.length != 8){
			return false;
		}
		if(value.length == 7){
			for (var i = 0; i < value.length; i++) {
				if (!(/[0-9]/.test(value[i]))){
					return false;
				}
			}
		} else{
			if(value[0]!="a" && value[0]!="A"){
				return false;
			}
				
			for (var i = 1; i < value.length; i++) {
				if (!(/[0-9]/.test(value[i]))){
					return false;
				}
			}
		}
		return true;
	}, "Anna opiskelijanumero oikeassa muodossa");
	
	$("#ilmoittautuminen").validate({
	    invalidHandler: function(form, validator) {},
	    success: function(label) {
	    	$(label).remove();
	    },
		rules : {
			etunimi : {
				required : true,
				nimiValidointi : true
			},
			sukunimi : {
				required : true,
				nimiValidointi : true
			},
			opiskelijanro : {
				required : true,
				opiskelijanumeroValidointi : true
			},
		},
		wrapper: "div",		
		messages : {
			etunimi : {
				required : '',
				nimiValidointi : 'Etunimessä saa olla vain kirjaimia ja väliviiva kahden nimen välissä'
			},
			sukunimi : {
				required : '',
				nimiValidointi : 'Sukunimessä saa olla vain kirjaimia ja väliviiva kahden nimen välissä'

			},
			opiskelijanro : {
				required : '',
				opiskelijanumeroValidointi : 'Anna opiskelijanumero oikeassa muodossa'
			},
		}	
	});

	// Tarkastaa formin jokaisella näppäimen painalluksessa ja kun hiiri
	// siirretään pois input kentästä
	$("#ilmoittautuminen input").bind("keydown keyup mouseleave", function() {
		var validi = $("#ilmoittautuminen").valid();
		if (validi) {
			$("#ilmoittaudu").prop("disabled", false);
		} else {
			$("#ilmoittaudu").prop("disabled", true);
		}
	});

	$(".aihe").click(function() {
		$(".aihe").removeClass("active");
		$(this).addClass("active");
		var divId = $(this).attr("divId");
		$("#" + divId).show();
		$("#" + divId).siblings().hide();
	});

	// Koulutuksen valintapainikkeen toiminta:
	$(".lisaa").click(function() {
		var value = $(this).prop("value"); // Haetaan valintapainiketta vastaava koulutus id
		var checkboxit = document.getElementsByName("box");

		for (var i = 0; i < checkboxit.length; i++) {
			// Jos checkboxin koulutus id vastaa valintapainikkeen koulutus id:tä
			if (checkboxit[i].value === value) {
				if (!checkboxit[i].checked) {
					checkboxit[i].checked = true; // Muuttaa checkboxin valituksi
					$(this).html("Poista valinta"); // Muuta valintapainikkeen teksti
				} else {
					checkboxit[i].checked = false;
					$(this).html("Valitse koulutus");
				}
			}
		}
		// Jos yksikin checkbox on valittu, palautetaan true,
		// jolloin disabled attribuutti poistetaan vahvistuspainikkeelta
		if (tarkasta()) {
			$(".vahvistus").removeAttr("disabled");
		// Jos yhtään checkboxia ei ole valittu, disabled attribuutti
		// lisätään vahvistuspainikkeelle
		} else {
			$(".vahvistus").attr("disabled", "disabled");
		}
	});

	var tarkasta = function() {
		var checkboxit = document.getElementsByName("box");
		var onkoValittu = false;
		for (var i = 0; i < checkboxit.length; i++) {
			// Jos yksikin checkbox on valittu, palautetaan true
			if (checkboxit[i].checked) {
				onkoValittu = true;
			}
		}
		return onkoValittu;
	};

	$(".vahvistus").click(function() {
		var checkboxit = document.getElementsByName("box");
		var aiheet = document.getElementsByName("aihe");
		var valitutidt = new Array();
		$("#valitut").empty(); // Tyhjennetään valitut id:llä oleva div

		for (var i = 0; i < checkboxit.length; i++) {
			if (checkboxit[i].checked) {
				var aihe = aiheet[i].value;
				var id = checkboxit[i].value;
				$("<li>").text(aihe).appendTo("#valitut"); // Lisätään aihe valitut diviin
				valitutidt[i] = checkboxit[i].value;
			}
		}
		
		/*hups olipas pöhkö koodi ;) */
		var oikeatvaluet = new Array();
		var k = 0;
		var muuttuja;
		for (var i = 0; i < valitutidt.length; i++){
			if (valitutidt[i] !== undefined){
				muuttuja = valitutidt[i];
				oikeatvaluet[k] = muuttuja;
				k++;
			}
		}
		
		
		str = oikeatvaluet.join();
		
		//$("#valitutkoulutukset").val(str);
		document.getElementById("valitutkoulutukset").value = str;
	});
});
