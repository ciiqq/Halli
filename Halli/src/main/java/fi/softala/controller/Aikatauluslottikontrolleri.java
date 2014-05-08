package fi.softala.controller;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import fi.softala.bean.Aikatauluslotti;
import fi.softala.DAO.AikatauluslottiDAO;

import javax.inject.Inject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping (value="/aikatauluslotti")
public class Aikatauluslottikontrolleri {
	@Inject
	AikatauluslottiDAO dao;

	@RequestMapping(value="lisaa", method=RequestMethod.GET)
	public String aikatauluslottiLisaa(Model model, HttpServletRequest request) { /* JariK 20140319 */
		Date today = new Date();
		List<Aikatauluslotti> aikatauluslotit = dao.haeKaikki();
		request.getSession().setAttribute("paivays",today);
 		model.addAttribute("aikatauluslotit", aikatauluslotit);
		return "aikataulut";
	}
	@RequestMapping(value="vaihdakuukausi", method=RequestMethod.GET)
	public String vaihdakuukausi(Model model, HttpServletRequest request) { /* JariK 20140319 */
		Date today = new Date();
		Date paivays;
//		int vvvvkk;
		String toiminto;
		int vuosi = 0;
		int kuukausi = 0;
		int paiva = 0;
		String paivas;
		String kuukausiteksti = "";
		String[] kuukausiennimet;
		kuukausiennimet = new String[12];
		kuukausiennimet[0]="Tammikuu";
		kuukausiennimet[1]="Helmikuu";
		kuukausiennimet[2]="Maaliskuu";
		kuukausiennimet[3]="Huhtikuu";
		kuukausiennimet[4]="Toukokuu";
		kuukausiennimet[5]="Kesäkuu";
		kuukausiennimet[6]="Heinäkuu";
		kuukausiennimet[7]="Elokuu";
		kuukausiennimet[8]="Syyskuu";
		kuukausiennimet[9]="Lokakuu";
		kuukausiennimet[10]="Marraskuu";
		kuukausiennimet[11]="Joulukuu";
		paivays = (Date) request.getSession().getAttribute("paivays");
		if(paivays==null)
			paivays=today;
			
		paivas = request.getParameter("paiva");
		
		if(paivas==null)
			paiva = paivays.getDate();
		else
			paiva=Integer.parseInt(paivas);
		
		kuukausi = paivays.getMonth();
		vuosi = paivays.getYear();
		
		toiminto=request.getParameter("vaihda");
		if (toiminto!=null) {
			if (toiminto.equals("edellinen")) {
				kuukausi--;
				if(kuukausi<0){
					vuosi--;
					kuukausi = 11;
				}
			} else if (toiminto.equals("seuraava")) {
				kuukausi++;
				if(kuukausi>11){
					vuosi++;
					kuukausi = 0;
				}
			}
		}
		paivays.setMonth(kuukausi);
		paivays.setYear(vuosi);
		paiva = 1;
		paivays.setDate(paiva);
		request.getSession().setAttribute("paivays",paivays);

		kuukausiteksti = kuukausiennimet[kuukausi]+" "+(vuosi+1900);		
		model.addAttribute("kuukausiteksti", kuukausiteksti);
		
		return "aikatauluslottilisaa";
	}	
		
	@RequestMapping(value="lista2", method=RequestMethod.GET)
	public String aikatauluslottiLista(Model model) { /* JariK 20140319 */
		List<Aikatauluslotti> aikatauluslotit = dao.haeKaikki();
 		model.addAttribute("aikatauluslotit", aikatauluslotit);
		return "aikatauluslottilista";
	}
	@RequestMapping(value="kalenteri", method=RequestMethod.GET)
	public String kalenteri(Model model) { /* JariK 20140319 */
		return "kalenteri";
	}
}

