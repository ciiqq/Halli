$(document).ready(function() {
  
  
	$(".kouluttaja").click(function() {
		if ($(this).hasClass("active")) {
			$(this).removeClass("active");
		} else {
			$(".kouluttaja").removeClass("active");
			$(this).addClass("active");
		}
	});

	
});