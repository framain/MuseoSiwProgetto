package it.uniroma3.siw.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Opera {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String titolo;
	
	private String annoRealizzazione;
	
	@Column(length = 100000)
	private String descrizione;
	
	@ManyToOne
	private Collezione collezione;
	
	@ManyToOne
	private Artista artista;

	public Opera(String titolo, String annoRealizzazione, String descrizione, Collezione collezione, Artista artista) {
		this.titolo = titolo;
		this.annoRealizzazione = annoRealizzazione;
		this.descrizione = descrizione;
		this.collezione = collezione;
		this.artista = artista;
	}

	public Opera() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAnnoRealizzazione() {
		return annoRealizzazione;
	}

	public void setAnnoRealizzazione(String annoRealizzazione) {
		this.annoRealizzazione = annoRealizzazione;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Collezione getCollezione() {
		return collezione;
	}

	public void setCollezione(Collezione collezione) {
		this.collezione = collezione;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}
	
	
}
