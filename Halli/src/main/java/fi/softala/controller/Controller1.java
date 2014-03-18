package fi.softala.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping (value="/testaus")
public class Controller1 {
	
	@RequestMapping(value="uusi", method=RequestMethod.GET)
	public String getCreateForm() {
		return "testi2";
	}
<<<<<<< HEAD
	//Juhani iz da shit
	//Haloo! 
=======
	//Juhani iz da shit :D
>>>>>>> 6ca72b53525d66a81e7a7999e55545079fbbe491
}

