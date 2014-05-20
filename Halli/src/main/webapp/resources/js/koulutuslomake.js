$().ready(function() {
    
	// Javascript Kooditus koulutuslomakkeelle
	// Ilkka K
	// Muokattu: 18.5.2014
	
    // Oletusarvot on-load
    var $tallenna_nappula = $('#tallenna_nappula');	
    $tallenna_nappula.prop("disabled",true); // Estet��n tyhj�n lomakkeen tallennus oletuksena
    
	// Aikavalinta modaali ja nappuloiden toiminta ---------------------------------------------------------------
	
	// Variablet
    var $ajankohta_input = $('#ajankohta_input');
    var $luokkatila_input = $('#luokkatila_input');
    var $ohjaaja_input = $('#ohjaaja_input');
    var $aikavalinta_nappula = $('#aikavalinta_nappula');
	var $aikalistaus = $('#aikalistaus');
    var $ajankohta_rivi = $('.ajankohta');
    var $aikavalinta = $('#aikavalinta');
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
           // $ohjaaja_input.val($valittu_aika[4].innerHTML); Ei k�yt�ss�, koska ohjaajaa ei ole yhdistetty aikaslottiin!
            $aikavalinta_nappula.attr('value', 'Poista');
            
        }
    });
    
    // Aikainputtien tyhjennus, mik�li aika on haettu lomakkeelle ja halutaan valita uusi aika
    $aikavalinta_nappula.click(function(e){
        e.preventDefault();   	    		
    	if($(this).attr('value') == 'Poista'){ 
            $ajankohta_input.val('');
            $luokkatila_input.val('');
            //$ohjaaja_input.val(''); Ei k�yt�ss�, koska ohjaajaa ei ole yhdistetty aikaslottiin!
            $(this).attr('value', 'Valitse');         
    	}else
        	$aikavalinta.modal('show');   
    });
    
	// Kouluttajavalinta modaali ja nappuloiden toiminta ---------------------------------------------------------------
	
    // Variablet
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
        		$kouluttaja1_nappula.attr('value', '-');
        }
    });
    
    
    $lisaakouluttaja2_nappula.click(function(e) {
        e.preventDefault();
    	console.log('Lis�t��n');
      
        var $valittu_kouluttaja2 = $kouluttajalistaus2.find('tr.active').find('td');
        if($valittu_kouluttaja2[0]){ 
        		$kouluttaja2_input.val($valittu_kouluttaja2[0].innerHTML+' '+$valittu_kouluttaja2[1].innerHTML);
        		$kouluttaja2_nappula.attr('value', '-');            	 		
        }
    });
    
    $kouluttaja1_nappula.click(function(e){
        e.preventDefault();
    	if($(this).attr('value') == '-'){
            $kouluttaja1_input.val(''); 
            $(this).attr('value', '+');  
        }else
        	$kouluttajavalinta1.modal('show');       
    });

    $kouluttaja2_nappula.click(function(e){
        e.preventDefault();
    	if($(this).attr('value') == '-'){
            $kouluttaja2_input.val(''); 
            $(this).attr('value', '+');  
        }else
        	$kouluttajavalinta2.modal('show');       
    });
    
    // Koulutuslomake validointi ennen tietojen viemist� kantaan
    // HUOM!! Tarkastettava sallitut pituus yms. arvot kannasta!
    var $koulutusformi = $('#koulutus_formi'); 
    
    $koulutusformi.validate({
        rules: {
            aihe: {
                minlength: 2,
                maxlength: 50,  
                required: true,
            },
            opiskelijanro: {
                minlength: 7,
                maxlength: 8,
                
                required: true,
            },
            kuvaus: {
                minlength: 3,
                required: false,
            },
            koulutusmenetelmat: {
                minlength: 3,
                maxlength: 15,
                required: false,
            },
            lahtotaso: {
                required: false,
            },
            avainsanat: {
                required: false,
            }
        },
		messages: {
			aihe: {
				required: "Aihe on pakollinen tieto!",
				minlength: "Aihe on liian lyhyt!",
			},
			kuvaus: {
				minlength: "Kuvaus on liian lyhyt",
			},
		},   
        highlight: function(element) {
            $(element).closest('.form-group').addClass('has-error');
        },
        unhighlight: function(element) {
            $(element).closest('.form-group').removeClass('has-error');
        },
        errorElement: 'span',
        errorClass: 'help-block',
        errorPlacement: function(error, element) {
            if(element.parent('.input-group').length) {
                error.insertAfter(element.parent());
            } else {
                error.insertAfter(element);
            }
        }
    });

    
	// Vapautetaan "Tallenna" nappula jos tiedot validoitu
    $koulutusformi.on('keyup blur', function () {
        if ($koulutusformi.valid()) {
            $tallenna_nappula.prop('disabled', false);
        } else {
            $tallenna_nappula.prop('disabled', 'disabled');
        }
    });
    
    $tallenna_nappula.click(function(){
    });
    
});

	