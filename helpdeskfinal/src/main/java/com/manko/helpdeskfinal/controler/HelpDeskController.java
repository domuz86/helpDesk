package com.manko.helpdeskfinal.controler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.manko.helpdeskfinal.entity.Detalji;
import com.manko.helpdeskfinal.entity.Intervencija;
import com.manko.helpdeskfinal.entity.Konzumenti;
import com.manko.helpdeskfinal.entity.Korisnik;
import com.manko.helpdeskfinal.reposotory.DetaljiRepo;
import com.manko.helpdeskfinal.reposotory.IntervencijaRepo;
import com.manko.helpdeskfinal.reposotory.KonzumentiRepo;
import com.manko.helpdeskfinal.reposotory.KorisnikRepo;
import com.manko.helpdeskfinal.reposotory.StringToKorisnik;

@Controller
public class HelpDeskController {

	@Autowired
	DetaljiRepo detaljiRepo;

	@Autowired
	IntervencijaRepo intervencijaRepo;

	@Autowired
	KorisnikRepo korisnikRepo;
	
	@Autowired
	KonzumentiRepo konzumentiRepo;

	@GetMapping("/intervencije")
	public String intervencije(Model model) {

		Detalji detalji = new Detalji();
		Intervencija intervencijaObj = new Intervencija();
		

		List<Konzumenti> konzumenti = konzumentiRepo.findAll();
		List<Korisnik> korisnik = korisnikRepo.findAll();
		List<Intervencija> intervencije = intervencijaRepo.findAllByStatus();
		List<Detalji> sviDetalji = detaljiRepo.findAll();
		
		
		

		model.addAttribute("detalji", detalji);
		model.addAttribute("intervencije", intervencije);
		model.addAttribute("intervencijaObj", intervencijaObj);
		model.addAttribute("svidetalji", sviDetalji);
		model.addAttribute("korisnikSvi", korisnik);
		model.addAttribute("konzumentiSvi", konzumenti);

		return "intervencije";

	}

	@Autowired
	StringToKorisnik stringToKorisnik;

	@PostMapping("/intervencije")
	public String intervencijeSpasi(@RequestParam String nazivIntervencije,
			@RequestParam String korisnik, @RequestParam String konzumenti, Model model) {

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();

		System.out.println("Id konzumenta je" + konzumenti);
		
		
		int idKorisnik = Integer.parseInt(korisnik);
		int idKonzument = Integer.parseInt(konzumenti);
		
		
		
		Korisnik korisnikDb = korisnikRepo.findById(idKorisnik).get();
		Konzumenti konzumentDb = konzumentiRepo.findById(idKonzument).get();

		
		
		Intervencija intervencija = new Intervencija();
		intervencija.setNazivIntervencije(nazivIntervencije);
		
		intervencija.setStatus("aktivna");
		intervencija.setKorisnik(korisnikDb);
		intervencija.setKonzumenti(konzumentDb);

		intervencija.setDatum(formatter.format(date));
		intervencijaRepo.save(intervencija);

		return "redirect:/intervencije";
	}

	@GetMapping("/detalji-form")
	public String detaljiForma(Model model, @RequestParam int intervencijeId) {

		int intervencijaIdd = intervencijeId;

		Detalji detaljiObj = new Detalji();

		System.out.println("detalj je " + detaljiObj.getOpis());

		model.addAttribute("detaljiObj", detaljiObj);

		model.addAttribute("intervencijeId", intervencijaIdd);

		return "detalji-form";
	}

	@PostMapping("/detalji-form")
	public String detaljiSpasi(Model model, @RequestParam String opis,@RequestParam String komentar, HttpSession session) {

		int intervencijaId = (int) session.getAttribute("intervencijaId");
		Intervencija intervencija = intervencijaRepo.findById(intervencijaId).get();

		
		
		
		Detalji detalji = new Detalji();
		detalji.setOpis(opis);
		detalji.setKomentar(komentar);
		
		

		intervencija.setDetalji(detalji);

		detaljiRepo.save(detalji);

		intervencijaRepo.save(intervencija);

		return "redirect:/intervencije";
	}

	@GetMapping("/hello")
	public String hello() {

		return "hello";
	}

	/*
	 * @GetMapping("/detalji/{id}") public String detalji(@PathVariable("id") int
	 * id, Model model) {
	 * 
	 * Intervencija inter = intervencijaRepo.findById(id).get();
	 * model.addAttribute("interdet", inter);
	 * 
	 * return "intervencije"; }
	 */

	@GetMapping("/beze")
	public String azuriraj(@RequestParam("intervencijeId") int id, Model model) {
		
		
		List<Korisnik> korisnik = korisnikRepo.findAll();
		List<Konzumenti> konzumenti = konzumentiRepo.findAll();
		
		
		Intervencija intervencijaObj = intervencijaRepo.findById(id).get();
	
		String imeIprezime=intervencijaObj.getKorisnik().getImeIprezime();

		model.addAttribute("korisnikSvi", korisnik);
		model.addAttribute("imeIprezime", imeIprezime);
		model.addAttribute("konzumentiSvi", konzumenti);

		
		
		model.addAttribute("intervencijaObj", intervencijaObj);
	
		return "intervencija-forma";
	}

	@GetMapping("/bezeDetalji")
	public String azurirajDetalji(@RequestParam("intervencijeId") int id, Model model, HttpSession session) {

		int intervencijeId = id;
		
		
		Intervencija intervencija = intervencijaRepo.findById(intervencijeId).get();

		session.setAttribute("intervencijaId", intervencijeId);

		Detalji detObj1;
		Detalji komentar;
		

		Intervencija intervencijaDB = intervencijaRepo.findById(id).get();
		komentar = intervencijaDB.getDetalji();
		
		if(komentar != null) {
			
			komentar.getKomentar();
			
		}
		else {
			komentar = new Detalji();
		}
		
		detObj1 = intervencijaDB.getDetalji();

		if (detObj1 != null) {

			detObj1.getOpis();
			

		} else {

			detObj1 = new Detalji();
			
		}
		
		
	
		model.addAttribute("komentar", komentar);
		model.addAttribute("detObj1", detObj1);
		session.setAttribute("detObj1", detObj1);
		model.addAttribute("intervencija", intervencija);

		return "detalji-form";
	}

	@PostMapping("/save")
	public String azurirajIntervenciju(@ModelAttribute("intervencijaObj") Intervencija intervencija, HttpSession session) {

		System.out.println(session.getAttribute("intervencijaId"));
		
		System.out.println("id Intervencije iz update" + intervencija.getIdIntervencija());
		
		
		Intervencija intervencijaObj = intervencija;
		
		
		
		System.out.println("datum" + intervencijaObj.getDatum());

		intervencijaRepo.save(intervencija);

		return "redirect:/intervencije";
	}

	@RequestMapping("/zatvori")
	public String zatvoriIntervenciju(@RequestParam("intervencijeId") int id) {

		Intervencija intervencijaObj = intervencijaRepo.findById(id).get();
		intervencijaObj.setStatus("zatvorena");
		intervencijaRepo.save(intervencijaObj);

		return "redirect:/intervencije";
	}

	@GetMapping("/novo")
	public String beze() {

		return "/novo";
	}
	
	
	@RequestMapping("/loginPage")
	public String login() {

		return "/login";
	}
}
