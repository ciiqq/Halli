$(document).ready(function() {

	// GET BROWSER WINDOW HEIGHT
	var valikkojenkorkeus = 96;
	var nykyinenkorkeus = $(window).height();
	// SET HEIGHT OF SIDEBAR AND CONTENT ELEMENTS
	$('.details').css('height', nykyinenkorkeus - valikkojenkorkeus);

	// ON RESIZE OF WINDOW
	$(window).resize(function() {

		// GET NEW HEIGHT
		var nykyinenkorkeus = $(window).height();
		// RESIZE BOTH ELEMENTS TO NEW HEIGHT
		$('.details').css('height', nykyinenkorkeus - valikkojenkorkeus);

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
		// Jos yhtään checkboxia ei ole valittu, disabled attribuutti lisätään vahvistuspainikkeelle
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
			width : "45%",
			height : "70%"
		});

		var checkboxit = document.getElementsByName("box");
		var aiheet = document.getElementsByName("aihe");
		$("#valitut").empty(); // Tyhjennetään valitut id:llä oleva div

		for (var i = 0; i < checkboxit.length; i++) {
			if (checkboxit[i].checked) {
				var aihe = aiheet[i].value;
				$("<p>").text(aihe).appendTo("#valitut"); // Lisätään aihe valitut diviin
			}
		}
	});
});