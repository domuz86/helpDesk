package com.manko.helpdeskfinal.controler;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.manko.helpdeskfinal.entity.Korisnik;
import com.manko.helpdeskfinal.entity.UlogeEntity;
import com.manko.helpdeskfinal.reposotory.KorisnikRepo;
import com.manko.helpdeskfinal.reposotory.UlogeRepo;

@Controller
public class HelpDeskRegController {

	@Autowired
	UlogeRepo ulogeRepo;
	
	@Autowired
	KorisnikRepo korisnikRepo;
	@Autowired
	 BCryptPasswordEncoder bcryptPasswordEncoder;
	
	
	@RequestMapping("/registracija")
	public String login(Model model) {

		Korisnik korisnik = new Korisnik();
		model.addAttribute("korisnik", korisnik);
		
		return "/registracija";
	}
	
	
	@RequestMapping("/spasiKorisnika")
	public String spasiKorisnika(@ModelAttribute("korisnik") Korisnik korisnik) {

		UlogeEntity uloga = ulogeRepo.findById(2).get();
		korisnik.setUloge(Arrays.asList(uloga));
		String lozinka = korisnik.getLozinka();
		korisnik.setLozinka(bcryptPasswordEncoder.encode(lozinka));
		korisnikRepo.save(korisnik);
		
		return "redirect:/loginPage";
	}
	
	
	@RequestMapping("/nova")
	public String nova(Model model) {

		
		
		return "/nova";
	}
	
}
