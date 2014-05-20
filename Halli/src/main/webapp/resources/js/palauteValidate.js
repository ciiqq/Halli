/**
 * 
 */
$(document).ready(function() {
	$("#palauteForm").validate({
		success: function(label) {
	    	$(label).remove();
	    },
		// Validointisäännöt
		rules : {
			palauteteksti : {
				required : true,
				minlength : 10,
				maxlength : 400
			},
			koulutus_id : {
				required : true
			},
			arvosana : {
				required : true
			}
		},
		// Virheviestit
		messages : {
			palauteteksti : "Kirjoita palautteesi",
			koulutus_id : "Valitse koulutus jolle haluat antaa palautetta",
			arvosana : "Valitse haluamasi numero arvosanaksi"
		}
	});
});