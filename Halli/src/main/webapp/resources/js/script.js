$(document).ready(function() {

	// Hae ikkunan korkeus
	var valikkojenkorkeus = 96;
	var nykyinenkorkeus = $(window).height();
	$('.details').css('height', nykyinenkorkeus - valikkojenkorkeus);

	// Ikkunan koon muuttuessa, suorita funktio
	$(window).resize(function() {

		// Hae uusi ikkunan korkeus
		var nykyinenkorkeus = $(window).height();
		$('.details').css('height', nykyinenkorkeus - valikkojenkorkeus);

	});
	// jQuery-validointi

	$("#ilmoittautuminen").validate({
	    invalidHandler: function(form, validator) {
	        var errors = validator.numberOfInvalids();
	        if (errors) {
	            $.colorbox.resize();
	        } else {
	        	$.colorbox.resize();
	        }
	    },
	    success: function(label) {
	    	$(label).remove();
	    	$.colorbox.resize();
	    },
		rules : {
			etunimi : {
				required : true,
				letterswithbasicpunc : true
			},
			sukunimi : {
				required : true,
				letterswithbasicpunc : true
			},
			opiskelijanro : {
				required : true,
				minlength : 7,
				maxlength : 8,
				pattern : "[a]*\\d{7}"
			},
		},
		wrapper: "div",		
		messages : {
			etunimi : {
				required : '',
				letterswithbasicpunc : 'Etunimessä saa olla vain kirjaimia'
			},
			sukunimi : {
				required : '',
				letterswithbasicpunc : 'Sukunimessä saa olla vain kirjaimia'

			},
			opiskelijanro : {
				required : '',
				minlength : '',
				maxlength : 'Anna opiskelijanumero oikeassa muodossa',
				pattern : "Anna opiskelijanumero oikeassa muodossa"
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
		$(".vahvistus").colorbox({
			inline : true,
			width : "50%",
		});

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
