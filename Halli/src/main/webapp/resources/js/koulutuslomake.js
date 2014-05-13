$().ready(function() {

	
	
    
    // Variablet
    var $kouluttaja_rivi = $('.kouluttaja');
    var $ajankohta_rivi = $('.ajankohta');
    var $tallenna_nappula = $('#tallenna_nappula');
    var $aikavalinta_nappula = $('#aikavalinta_nappula');    
    var $kouluttajavalinta_nappula = $('#kouluttajavalinta_nappula');
    var $lahtotaso = $('#lahtotaso_valinta');
    var $koulutuslomake = $('#koulutus_formi');
    var $kouluttaja1 = $('#kouluttaja1');
    var $kouluttaja2 = $('#kouluttaja2');
    var $kouluttaja1_nappula =('#kouluttaja1_nappula');
    var $kouluttaja2_nappula =('#kouluttaja2_nappula');
    var $lisaakouluttaja_nappula =('#lisaakouluttaja_nappula');
    var $kouluttajalista =('#kouluttajalista'); 

 // Kouluttajan lisäys nappula kouluttaja modaalissa
    $("#lisaakouluttaja_nappula").click(function(e) {
        e.preventDefault();
    	console.log('Lisätään');
      
        var valittu = $('#kouluttajalista').find('tr.active').find('td');
        if(valittu[0]){ 
           // $lisaakouluttaja_nappula.prop('disabled', false);        	
            $kouluttaja1.val($valittu[0].innerHTML+' '+$valittu[1].innerHTML);
        }
    });
  
	/*
    // Oletusarvot on-load
    $tallenna_nappula.prop("disabled",true); // 
    $aikavalinta_nappula.prop("disabled",true); // Aikarivi täytyy valita, muuten nappula ei käytössä
    $kouluttajavalinta_nappula.prop("disabled",true); // Kouluttajarivi täytyy valita, muuten nappula ei käytössä
    $lahtotaso.prop("selectedIndex", -1); // = Lähtotaso oletuksena tyhjä
    $lisaakouluttaja_nappula.prop("disabled",true); // Kouluttajan valinta modaalin lisäys nappula poissa käytöstä kunnes rivi valittu    
*/
  
    

	
    //Kouluttajarivin valinta modaalissa (rivin tyylin vaihto)
	$kouluttaja_rivi.click(function() {
		if ($(this).hasClass("active")) {
			$(this).removeClass("active");
		} else {
			$kouluttaja_rivi.removeClass("active");
			$(this).addClass("active");
		}
	});
	
	//Aikarivin valinta modaalissa --- ei toiminnassa!
	$ajankohta_rivi.click(function() {
		if ($(this).hasClass("active")) {
			$(this).removeClass("active");
		} else {
			$ajankohta_rivi.removeClass("active");
			$(this).addClass("active");
		}
	});

	
	/*
	// Koulutuslomake validointi
	$koulutuslomake.validate({
		rules: {
			aihe: {
				required: true,
				minlength: 2,
			},
		},
		messages: {
			aihe: {
				required: "Aihe on annettava",
				minlength: "Aihe on liian lyhyt!"
			}
		}
	});
	*/
	// Kouluttajanappien vaihto ja toiminnallisuus (mikäli kenttään lisätty kouluttaja "tyhjennys" tai tyhjänä modaalin avaaminen)
	/*$kouluttaja1.change(function() {
	    if( $(this).val().length > 0 ) {
			$kouluttaja1_nappula.val('-');
		}else{
			$kouluttaja1_nappula.val('+');			
		}
	});
	/*
    $kouluttaja1_nappula.val('-').on('click',function(){
        console.log('tyhjennetään');
        $kouluttaja1.val('');
    });
    */
	/*
	$kouluttaja2.change(function() {
	    if( $(this).val().length > 0 ) {
			$kouluttaja2_nappula.val('-');
		}else{
			$kouluttaja2_nappula.val('+');			
		}
	});
	/*
    $kouluttaja2_nappula.val('-').on('click',function(){
        console.log('tyhjennetään');
        $kouluttaja2.val('');
    });
	*/
	// Vapautetaan "Tallenna" nappula jos tiedot validoitu
    $('#koulutus_formi input').on('keyup blur', function () {
        if ($koulutuslomake.valid()) {
            $tallenna_nappula.prop('disabled', false);
        } else {
            $tallenna_nappula.prop('disabled', 'disabled');
        }
    });
  
    
    /*
	$lisaakouluttaja_nappula.change(function() {
		 if($valittu[0]){
            $lisaakouluttaja_nappula.prop('disabled', false);
		}else{
            $lisaakouluttaja_nappula.prop('disabled', 'disabled');
        }
	});
    */
 
});
	