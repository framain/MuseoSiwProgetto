package it.uniroma3.siw.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.spring.model.Collezione;
import it.uniroma3.siw.spring.model.Curatore;

public interface CollezioneRepository extends CrudRepository<Collezione, Long>{
	
	public List<Collezione> findByNome(String nome);
	
	public List<Collezione> findByCuratore(Curatore curatore);

}
