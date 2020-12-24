package com.manko.helpdeskfinal.controler;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.manko.helpdeskfinal.entity.Detalji;
import com.manko.helpdeskfinal.entity.Intervencija;
import com.manko.helpdeskfinal.reposotory.DetaljiRepo;
import com.manko.helpdeskfinal.reposotory.IntervencijaRepo;

@Controller
public class HelpDeskController {

	@Autowired
	DetaljiRepo detaljiRepo;

	@Autowired
	IntervencijaRepo intervencijaRepo;

	@GetMapping("/intervencije")
	public String intervencije(Model model) {

		Intervencija intervencijaObj = new Intervencija();

		List<Intervencija> intervencije = intervencijaRepo.findAllByOrderByIdIntervencijaDesc();
		List<Detalji> sviDetalji = detaljiRepo.findAll();

		model.addAttribute("intervencije", intervencije);
		model.addAttribute("intervencijaObj", intervencijaObj);
		model.addAttribute("svidetalji", sviDetalji);
		return "intervencije";

	}

	@PostMapping("/intervencije")
	public String intervencijeSpasi(@RequestParam String nazivIntervencije, @RequestParam String imeIprezime,
			Model model) {

		Intervencija intervencija = new Intervencija();
		intervencija.setNazivIntervencije(nazivIntervencije);
		intervencija.setImeIprezime(imeIprezime);
		intervencijaRepo.save(intervencija);

		return "redirect:/intervencije";
	}

	@GetMapping("/detalji-form")
	public String detaljiForma(Model model, @RequestParam int intervencijeId, HttpSession session) {

		session.setAttribute("intervencijaId", intervencijeId);

		int intervencijaIdd = intervencijeId;
		Detalji detaljiObj = new Detalji();
		model.addAttribute("detaljiObj", detaljiObj);
		model.addAttribute("intervencijeId", intervencijaIdd);

		return "detalji-form";
	}

	@PostMapping("/detalji-form")
	public String detaljiSpasi(Model model, @RequestParam String opis, HttpSession session) {

		int intervencijaId = (int) session.getAttribute("intervencijaId");
		Intervencija intervencija = intervencijaRepo.findById(intervencijaId).get();

		Detalji detalji = new Detalji();
		detalji.setOpis(opis);

		intervencija.setDetalji(detalji);

		detaljiRepo.save(detalji);

		intervencijaRepo.save(intervencija);

		return "redirect:/intervencije";
	}
	
	@GetMapping("/hello")
	public String hello() {

		

		return "hello";
	}

}
