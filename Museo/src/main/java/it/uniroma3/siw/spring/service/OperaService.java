package it.uniroma3.siw.spring.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.model.Artista;
import it.uniroma3.siw.spring.model.Collezione;
import it.uniroma3.siw.spring.model.Opera;
import it.uniroma3.siw.spring.repository.OperaRepository;


@Service
public class OperaService {
	
	@Autowired
	private OperaRepository operaRepository;
	
	@Transactional
	public Opera inserisci(Opera opera) {
		return this.operaRepository.save(opera);
	}
	
	
	@Transactional
	public Opera operaPerId(Long id) {
		Optional<Opera> optional = operaRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		else return null;
	}
	
	@Transactional
	public List<Opera> operaDalTitolo(String titolo) {
		return (List<Opera>) operaRepository.findOperaByTitolo(titolo);
	}
	
	@Transactional
	public List<Opera> operaDaArtista(Artista artista) {
		return this.operaRepository.findByArtista(artista);
	}

	@Transactional
	public List<Opera> operePerCollezione(Collezione collezione) {
		return (List<Opera>) operaRepository.findByCollezione(collezione);
	}
	
	@Transactional
	public List<Opera> tutti(){
		return (List<Opera>) operaRepository.findAll();
	}
}
