$(document).ready(function() {

	//GET BROWSER WINDOW HEIGHT
	var valikkojenkorkeus = 96;
	var nykyinenkorkeus = $(window).height();
	//SET HEIGHT OF SIDEBAR AND CONTENT ELEMENTS
	$('.details').css('height', nykyinenkorkeus - valikkojenkorkeus);

	//ON RESIZE OF WINDOW
	$(window).resize(function() {

		//GET NEW HEIGHT
		var nykyinenkorkeus = $(window).height();	
		//RESIZE BOTH ELEMENTS TO NEW HEIGHT
		$('.details').css('height', nykyinenkorkeus - valikkojenkorkeus);

	});
	//kälviksen kommentti
	$(document).ready(function(){
        $("#ilmoittautuminen").validate({
        rules :{
            etunimi : {
                required : true
            },
            sukunimi : {
                required : true
            },
            opiskelijanro : {
                required : true
            },
        },
        messages :{
            etunimi : {
                required : 'Syötä etunimi'
            },
            sukunimi : {
                required : 'Syötä sukunimi'
            },
            opiskelijanro : {
                required : 'Syötä opiskelijanumero'
            },
        }
        });
    });
	
    $(".aihe").click(function(){
            $(".aihe").removeClass("active");
            $(this).addClass("active");
            var divId = $(this).attr("divId");
            $("#"+divId).show();
            $("#"+divId).siblings().hide();
            });
     
            $(".lisaa").click(function() { 
            var value = $(this).prop("value");
            var checkboxit = document.getElementsByName("box");
 
                        for (var i = 0; i < checkboxit.length; i++) {
                                if(checkboxit[i].value === value) {
                                        if(!checkboxit[i].checked) {
                                                checkboxit[i].checked = true;
                                                $(this).html("Poista valinta");
                            }else{
                            checkboxit[i].checked = false;
                                    $(this).html("Valitse koulutus");
                            }
                            }
                    }      
            if (tarkasta()) {
                     $(".vahvistus").removeAttr("disabled");
            } else {
                    $(".vahvistus").attr("disabled", "disabled");
            }      
    });
     
            var tarkasta = function() {
            var checkboxit = document.getElementsByName("box");
            var onkoValittu = false;
            for (var i = 0; i < checkboxit.length; i++) {
                    if (checkboxit[i].checked) {
                            onkoValittu = true;
                    }
            }
            return onkoValittu;
    };
     
    $(".vahvistus").click(function() {
    	$(".vahvistus").colorbox({inline:true, width:"45%", height:"70%"});
      
            var checkboxit = document.getElementsByName("box");
                    var aiheet = document.getElementsByName("aihe");
 
                for (var i = 0; i < checkboxit.length; i++) {
                        if (checkboxit[i].checked) {
                        var aihe = aiheet[i].value;
                                $("<p>").text(aihe).appendTo("#valitut");
                    }
            }
    });
    });  