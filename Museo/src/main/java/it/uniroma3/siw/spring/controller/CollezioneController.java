package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.spring.controller.validator.CollezioneValidator;
import it.uniroma3.siw.spring.model.Collezione;
import it.uniroma3.siw.spring.service.CollezioneService;
import it.uniroma3.siw.spring.service.OperaService;

@Controller
public class CollezioneController {

	@Autowired
	private CollezioneService collezioneService;

	@Autowired
	private CollezioneValidator collezioneValidator;

	@Autowired
	private OperaService operaService;

	@RequestMapping(value = "/collezioni", method = RequestMethod.GET)
	public String getCollezioni(Model model) {
		model.addAttribute("collezioni", this.collezioneService.tutti());
		return "collezioni.html";
	}

	@RequestMapping(value ="/collezione/{id}", method = RequestMethod.GET)
	public String getCollezione(@PathVariable("id") Long id, Model model) {
		Collezione collezione = this.collezioneService.collezionePerId(id);
		model.addAttribute("collezione", collezione);
		model.addAttribute("opere", this.operaService.operePerCollezione(collezione));
		return "collezione.html";
	}

	@RequestMapping(value = "/modificaCollezione", method = RequestMethod.GET)
	public String getModificaCollezione(Model model) {
		model.addAttribute("collezioni", this.collezioneService.tutti());
		return "modificaCollezione.html";
	}

	@RequestMapping(value ="/formCollezione/{id}", method = RequestMethod.GET)
	public String getCollezioneModificata(@PathVariable("id") Long id, Model model) {
		Collezione collezione = this.collezioneService.collezionePerId(id);
		model.addAttribute("collezione", collezione);
		return "collezioneForm.html";
	}

	@RequestMapping(value = "/formCollezione", method = RequestMethod.POST)
	public String collezioneModificata(@ModelAttribute("collezione") Collezione collezione, BindingResult bindingResult, Model model) {
		this.collezioneValidator.validate(collezione, bindingResult);
		if(!bindingResult.hasErrors()) {
			this.collezioneService.inserisci(collezione);
			model.addAttribute("collezioni", this.collezioneService.tutti());
			return "formCollezioneEffettuata.html";
		}
		return "collezioneForm";
	}

}
