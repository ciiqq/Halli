//jQueryn suorittaminen
$(document).ready(function() {

	// Hae ikkunan korkeus
	var valikkojenkorkeus = 96;
	var nykyinenkorkeus = $(window).height();
	//korkeus lasketaan valikkojen korkeus (96 pikseliä) huomioon ottaen
	$('.tiedot').css('height', nykyinenkorkeus - valikkojenkorkeus);

	// Ikkunan koon muuttuessa, suorita funktio
	$(window).resize(function() {

		// Hae uusi ikkunan korkeus
		var nykyinenkorkeus = $(window).height();
		$('.tiedot').css('height', nykyinenkorkeus - valikkojenkorkeus);
		$('.lista').css('height', nykyinenkorkeus - valikkojenkorkeus);

	});
	// jQuery-validointi ilmoittautumiskenttään
	$.validator.addMethod("nimiValidointi", function(value, element) {
		//nimen validointi: vain suomalaisia kirjaimia ja viivoja, viiva vain jos
		//kirjaimien välissä
		value = $.trim(value);
		for (var i = 0; i < value.length; i++) {
			if (value[i] == "-") {
				//jos viiva on ensimmäisenä tai viimeisenä, virhetilanne
				if (i == 0 || i == value.length - 1) {
					return false;
				} else if (value[i+1] == '-') {
					return false;
				}
			//hyväksytään vain suomalaisia kirjaimia
			} else if (!(/[a-öA-Ö]/.test(value[i]))){
				return false;
			}
		}
		return true;
	}, "Nimessä saa olla vain kirjaimia ja väliviiva kahden nimen välissä");
	
	//opiskelijanumeron validointi: 7 tai 8 merkkiä, 7-merkkisessä vain numeroita,
	//8-merkkisessä ensimmäisen täytyy olla a tai A ja muiden numeroita
	$.validator.addMethod("opiskelijanumeroValidointi", function(value, element) {
		value = $.trim(value);
		//merkkijonon pituus 7 tai 8
		if(value.length != 7 && value.length != 8){
			return false;
		}
		//jos pituus 7, vain numerot sallittu
		if(value.length == 7){
			for (var i = 0; i < value.length; i++) {
				if (!(/[0-9]/.test(value[i]))){
					return false;
				}
			}
		} else{
			//jos pituus 8, ensimmäinen merkki a tai A
			if(value[0]!="a" && value[0]!="A"){
				return false;
			}
				
			//jos pituus 8, muut kuin ensimmäinen numeroita
			for (var i = 1; i < value.length; i++) {
				if (!(/[0-9]/.test(value[i]))){
					return false;
				}
			}
		}
		return true;
	}, "Anna opiskelijanumero oikeassa muodossa");
	
	//onnistumisen vaatimukset: kentät täytyy olla täytettynä ja 
	//validointi-metodien täytyy palauttaa true
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
		//virheviestit
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

	//kun klikataan vasemman puoleisesta valikosta koulutuksen nimeä,
	//koulutuksen tarkemmat tiedot muuttuvat näkyviksi oikealle puolelle
	$(".aihe").click(function() {
		$(".aihe").removeClass("active");
		$(this).addClass("active");
		var divId = $(this).data("kohde");
		$("#" + divId).show(); //näytetään valitun koulutuksen tiedot
		$("#" + divId).siblings().hide(); //piilotetaan muut kuin valitun koulutuksen tiedot
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
		// Jos yksikin checkbox on valittu, palautetaan true tarkasta()-funktiosta,
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

	//viedään valittujen koulutusten id:t taulukkoon ja näytetään valittujen
	//koulutusten nimet modaali-ikkunassa
	$(".vahvistus").click(function() {
		var checkboxit = document.getElementsByName("box");
		var aiheet = document.getElementsByName("aihe");
		var valitutidt = new Array();
		$("#valitut").empty(); // Tyhjennetään valitut id:llä oleva div

		for (var i = 0; i < checkboxit.length; i++) {
			if (checkboxit[i].checked) {
				var aihe = aiheet[i].value;
				var id = checkboxit[i].value;
				$("<li>").text(aihe).appendTo("#valitut"); // Lisätään aihe valitut -diviin
				valitutidt[i] = checkboxit[i].value;
			}
		}
		
		//Valitut ID:t taulukkoon
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
