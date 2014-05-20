/**
 * 
 */
$("#opiskelijanumeroForm").validate({
	success: function(label) {
    	$(label).remove();
    },
	// Validointisäännöt
	rules : {
		palauteopiskelijanumero : {
			required : true,
			minlength : 7,
			opiskelijanumeroValidointi: true
		}
	},
	// Virheviestit
	messages : {
		palauteopiskelijanumero : "Kirjoita opiskelijanumerosi"
	}
});