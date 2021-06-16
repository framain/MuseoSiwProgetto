package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.spring.controller.validator.ArtistaValidator;
import it.uniroma3.siw.spring.model.Artista;
import it.uniroma3.siw.spring.service.ArtistaService;
import it.uniroma3.siw.spring.service.OperaService;

@Controller
public class ArtistaController {
	
	@Autowired
	private ArtistaService artistaService;
	
	@Autowired
	private ArtistaValidator artistaValidator;
	
	@Autowired
	private OperaService operaService;

    @RequestMapping(value ="/artista/{id}", method = RequestMethod.GET)
    public String getArtista(@PathVariable("id") Long id, Model model) {
    	Artista artista = this.artistaService.artistaPerId(id);
    	model.addAttribute("artista", artista);
    	model.addAttribute("opere", this.operaService.operaDaArtista(artista));
    	return "artista.html";
    }
    

    @RequestMapping(value = "/artisti", method = RequestMethod.GET)
    public String getArtisti(Model model) {
    		model.addAttribute("artisti", this.artistaService.tutti());
    		return "artisti.html";
    }
    
    @RequestMapping(value ="/formArtista/{id}", method = RequestMethod.GET)
	public String getArtistaModificato(@PathVariable("id") Long id, Model model) {
    	Artista artista = this.artistaService.artistaPerId(id);
    	model.addAttribute("artista", artista);
		return "artistaForm.html";
	}

	@RequestMapping(value = "/formArtista", method = RequestMethod.POST)
	public String artistaModificato(@ModelAttribute("artista") Artista artista, BindingResult bindingResult, Model model) {
		this.artistaValidator.validate(artista, bindingResult);
		if(!bindingResult.hasErrors()) {
			this.artistaService.inserisci(artista);
			model.addAttribute("artisti", this.artistaService.tutti());
			return "formArtistaEffettuata.html";
		}
		return "artistaForm";
	}
    
}