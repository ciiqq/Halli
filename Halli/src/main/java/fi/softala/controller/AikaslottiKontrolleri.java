package fi.softala.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.helpers.DateTimeDateFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.softala.DAO.AikatauluslottiDAO;
import fi.softala.bean.Aikatauluslotti;
import fi.softala.bean.Kouluttaja;

@Controller
@RequestMapping (value="/")
public class AikaslottiKontrolleri {
	
	@Inject
	private AikatauluslottiDAO dao;
	
	public AikatauluslottiDAO getDao() {
		return dao;
	}

	public void setDao(AikatauluslottiDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping(value="opettaja/aikataulut", method=RequestMethod.GET)
	public String aikatauluslottiLista() {
		return "aikataulut";
		
	}
	
	public String getformat(String input)
	{
		int c;
		String result,substring;
		
		result="";
		for(c=0;c<input.length();c++) {
			substring=input.substring(c,c+1);
			if(substring.equals("0") ||
			   substring.equals("1") ||
			   substring.equals("2") ||
			   substring.equals("3") ||
			   substring.equals("4") ||
			   substring.equals("5") ||
			   substring.equals("6") ||
			   substring.equals("7") ||
			   substring.equals("8") ||
			   substring.equals("9")) {
				result=result+"9";
			} else {
				result=result+"9";			
			}
		}
		return(result);
	}

	private String pvmmuutos(String pvms)
	{
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd.MM.yy");
		Date tempd = new Date();
		try {
			tempd = sdf1.parse(pvms);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	    String temps2=sdf2.format(tempd);
	    return(temps2);
	}

	private String aikamuutos(String aikas)
	{
		SimpleDateFormat sdf1 = new SimpleDateFormat("hh.mm");
		Date tempd = new Date();
		try {
			tempd = sdf1.parse(aikas);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	    SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm:ss");
	    String temps2=sdf2.format(tempd);
	    return(temps2);
	}

	@RequestMapping(value="opettaja/aikataulut/lisaa", method=RequestMethod.POST)
	public String lisaaSlotti(HttpServletRequest request, Model model) {

		Aikatauluslotti a = new Aikatauluslotti();

		a.setPvm(pvmmuutos(request.getParameter("paivamaara")));
		
		a.setAlkukello(aikamuutos(request.getParameter("alkuaika")));
		
		a.setLoppukello(aikamuutos(request.getParameter("loppuaika")));

		a.setKoulutustila(request.getParameter("tila"));
		
		dao.talleta(a);
		
		return "aikataulut";
		
	}

}
