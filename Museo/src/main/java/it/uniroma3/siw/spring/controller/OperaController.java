package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.spring.controller.validator.OperaValidator;
import it.uniroma3.siw.spring.model.Opera;
import it.uniroma3.siw.spring.service.OperaService;

@Controller
public class OperaController {
	
	@Autowired
	private OperaService operaService;
	
	@Autowired
	private OperaValidator operaValidator;
	
    @RequestMapping(value = "/opere", method = RequestMethod.GET)
	public String getOpere(Model model) {
		model.addAttribute("opere", this.operaService.tutti());
		return "opere.html";
	}
	
    @RequestMapping(value = "/opera/{id}", method = RequestMethod.GET)
    public String getOpera(@PathVariable("id") Long id, Model model) {
    	model.addAttribute("opera", this.operaService.operaPerId(id));
    	return "opera.html";
    }

	@RequestMapping(value = "/modificaOpera", method = RequestMethod.GET)
	public String getModificaOpera(Model model) {
		model.addAttribute("opere", this.operaService.tutti());
		return "modificaOpera.html";
	}

	@RequestMapping(value ="/formOpera/{id}", method = RequestMethod.GET)
	public String getOperaModificata(@PathVariable("id") Long id, Model model) {
		Opera opera = this.operaService.operaPerId(id);
		model.addAttribute("opera", opera);
		return "operaForm.html";
	}

	@RequestMapping(value = "/formOpera", method = RequestMethod.POST)
	public String operaModificata(@ModelAttribute("opera") Opera opera, BindingResult bindingResult, String titolo, Model model) {
		this.operaValidator.validate(opera, bindingResult);
		if(!bindingResult.hasErrors()) {
			this.operaService.inserisci(opera);
			model.addAttribute("opere", this.operaService.tutti());
			model.addAttribute("titolo", this.operaService.operaDalTitolo(titolo));
			return "formOperaEffettuata.html";
		}
		return "operaForm";
	}
    
}
