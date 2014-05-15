$().ready(function() {


    // Variablet
    //var $kouluttaja_rivi = $('.kouluttaja');
    
	// Aikavalinta modaali ja nappuloiden toiminta ---------------------------------------------------------------
	
    var $ajankohta_input = $('#ajankohta_input');
    var $luokkatila_input = $('#luokkatila_input');
    var $ohjaaja_input = $('#ohjaaja_input');
    var $aikavalinta_nappula = $('#aikavalinta_nappula');
	var $aikalistaus = $('#aikalistaus');
    var $ajankohta_rivi = $('.ajankohta');
    var $valitseaika_nappula = $('#valitseaika_nappula');

    
	//Aikarivin valinta modaalissa
	$ajankohta_rivi.click(function() {
		if ($(this).hasClass("active")) {
			$(this).removeClass("active");
			$valitseaika_nappula.prop('disabled', true);				
		} else {
			$ajankohta_rivi.removeClass("active");
			$(this).addClass("active");
			$valitseaika_nappula.prop('disabled', false);			
		}
	});
	
	 // Valitun ajan lis�ys nappula aikavalinta modaalissa
    $valitseaika_nappula.click(function(e) {
        e.preventDefault();
    	console.log('Lis�t��n');
      
        var $valittu_aika = $aikalistaus.find('tr.active').find('td');
        if($valittu_aika[0]){       	
            $ajankohta_input.val($valittu_aika[0].innerHTML+' Klo: '+$valittu_aika[1].innerHTML+' - '+$valittu_aika[2].innerHTML);
            $luokkatila_input.val($valittu_aika[3].innerHTML);
            
        }
    });
    
    $aikavalinta_nappula.click(function(e){
        e.preventDefault();
        $ajankohta_input.val('');
        $luokkatila_input.val('');
    });
    
	// Kouluttajavalinta modaali ja nappuloiden toiminta ---------------------------------------------------------------
	
    var $kouluttaja1_input = $('#kouluttaja1_input');
    var $kouluttaja2_input = $('#kouluttaja2_input');
	var $kouluttajalistaus1 = $('#kouluttajalistaus1');
	var $kouluttajalistaus2 = $('#kouluttajalistaus2');
    var $kouluttaja_rivi = $('.kouluttaja');
    var $lisaakouluttaja1_nappula = $('#lisaakouluttaja1_nappula');
    var $lisaakouluttaja2_nappula = $('#lisaakouluttaja2_nappula');  
    var $kouluttaja1_nappula = $('#kouluttaja1_nappula');
    var $kouluttaja2_nappula = $('#kouluttaja2_nappula');
    var $kouluttajavalinta1 = $('#kouluttajavalinta1');
    var $kouluttajavalinta2 = $('#kouluttajavalinta2');
    
	//Kouluttajarivin valinta modaalissa
	$kouluttaja_rivi.click(function() {
		if ($(this).hasClass("active")) {
			$(this).removeClass("active");
			$lisaakouluttaja1_nappula.prop('disabled', true);
			$lisaakouluttaja2_nappula.prop('disabled', true);
		} else {
			$kouluttaja_rivi.removeClass("active");
			$(this).addClass("active");
			$lisaakouluttaja1_nappula.prop('disabled', false);
			$lisaakouluttaja2_nappula.prop('disabled', false);
		}
	});
	
	 // Valitun kouluttajan lis�ys nappula kouluttajavalinta modaalissa (input kohtainen)
    $lisaakouluttaja1_nappula.click(function(e) {
        e.preventDefault();
    	console.log('Lis�t��n');
      
        var $valittu_kouluttaja1 = $kouluttajalistaus1.find('tr.active').find('td');
        if($valittu_kouluttaja1[0]){ 
        		$kouluttaja1_input.val($valittu_kouluttaja1[0].innerHTML+' '+$valittu_kouluttaja1[1].innerHTML);
        }
    });
    
    
    $lisaakouluttaja2_nappula.click(function(e) {
        e.preventDefault();
    	console.log('Lis�t��n');
      
        var $valittu_kouluttaja2 = $kouluttajalistaus2.find('tr.active').find('td');
        if($valittu_kouluttaja2[0]){ 
        		$kouluttaja2_input.val($valittu_kouluttaja2[0].innerHTML+' '+$valittu_kouluttaja2[1].innerHTML);
        		$kouluttaja2_nappula.val('-');               	 		
        }
    });
    
    $kouluttaja1_nappula.click(function(e){
        e.preventDefault();
        if(!$kouluttaja1_input.val()){
        	$kouluttajavalinta1.modal('show');
        }else{
            $kouluttaja1_input.val('');         
        }
    });
    
	$kouluttaja1_input.change(function() {
	    if( $(this).val('')) {
			$kouluttaja1_nappula.val('+');
		}else{
			$kouluttaja1_nappula.val('-');			
		}
    });
    /*
    
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
*/
	/*
 // Kouluttajan lisäys nappula kouluttaja modaalissa
    $("#lisaakouluttaja_nappula").click(function(e) {
        e.preventDefault();
    	console.log('Lisätään');
      
        var valittu = $('#kouluttajalista').find('tr.active').find('td');
        if(valittu[0]){ 
           // $lisaakouluttaja_nappula.prop('disabled', false);        	
            $("#kouluttaja1").val($valittu[0].innerHTML+' '+$valittu[1].innerHTML);
        }
    });*/
  
	/*
    // Oletusarvot on-load
    $tallenna_nappula.prop("disabled",true); // 
    $aikavalinta_nappula.prop("disabled",true); // Aikarivi täytyy valita, muuten nappula ei käytössä
    $kouluttajavalinta_nappula.prop("disabled",true); // Kouluttajarivi täytyy valita, muuten nappula ei käytössä
    $lahtotaso.prop("selectedIndex", -1); // = Lähtotaso oletuksena tyhjä
    $lisaakouluttaja_nappula.prop("disabled",true); // Kouluttajan valinta modaalin lisäys nappula poissa käytöstä kunnes rivi valittu    
*/
  
    

	
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
	