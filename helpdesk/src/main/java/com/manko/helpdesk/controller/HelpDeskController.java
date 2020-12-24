package com.manko.helpdesk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.manko.helpdesk.entity.Intervencija;
import com.manko.helpdesk.entity.service.IntervencijaService;


@Controller
@RequestMapping("/help")
public class HelpDeskController {

IntervencijaService intervencijaService;
	
	
	@GetMapping("/intervencije")
	public String intervencije() {
		
		return "intervencije";
	}

	@GetMapping("/forma-helpdesk")
	public String formaHelpdesk(Model model) {
		
		Intervencija intervencija = new Intervencija();
		model.addAttribute("intervencija" , intervencija);
		return "forma-helpdesk";
	}

	@PostMapping("/spasi")
	public String spasi(@ModelAttribute("intervencija") Intervencija intervencija) {
		
		System.out.println("u kontroleru");
		System.out.println("Spaseno"+intervencija.getNazivIntervencije() );
		
		
		intervencijaService.save(intervencija);
		
		
		
		return "forma-helpdesk";
	}
	
}
