package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.spring.controller.validator.CuratoreValidator;
import it.uniroma3.siw.spring.model.Curatore;
import it.uniroma3.siw.spring.service.CollezioneService;
import it.uniroma3.siw.spring.service.CuratoreService;

@Controller
public class CuratoreController {
	
	@Autowired
	private CuratoreService curatoreService;
	
	@Autowired
	private CuratoreValidator curatoreValidator;
	
	@Autowired
	private CollezioneService collezioneService;

    @RequestMapping(value ="/curatore/{id}", method = RequestMethod.GET)
    public String getCuratore(@PathVariable("id") Long id, Model model) {
    	Curatore curatore = this.curatoreService.curatorePerId(id);
    	System.out.println(curatore.getNome());
    	model.addAttribute("curatore", curatore);
    	model.addAttribute("collezioni", this.collezioneService.collezionePerCuratore(curatore));
    	return "curatore.html";
    }
    
    @RequestMapping(value ="/formCuratore/{id}", method = RequestMethod.GET)
	public String getCuratoreModificato(@PathVariable("id") Long id, Model model) {
    	Curatore curatore = this.curatoreService.curatorePerId(id);
    	model.addAttribute("curatore", curatore);

		return "curatoreForm.html";
	}

	@RequestMapping(value = "/formCuratore", method = RequestMethod.POST)
	public String curatoreModificato(@ModelAttribute("curatore") Curatore curatore, BindingResult bindingResult, Model model) {
		this.curatoreValidator.validate(curatore, bindingResult);
		if(!bindingResult.hasErrors()) {
			this.curatoreService.inserisci(curatore);
			model.addAttribute("curatori", this.curatoreService.tuttiICuratori());
			return "formCuratoreEffettuata.html";
		}
		return "curatoreForm";
	}
	
}
