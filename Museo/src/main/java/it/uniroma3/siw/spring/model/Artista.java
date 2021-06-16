package it.uniroma3.siw.spring.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Artista {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nome;
	
	private String cognome;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataDiNascita;
	
	private String postoDiNascita;
	
	private String nazionalita;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataDiMorte;
	
	private String postoDiMorte;

	@Column(length = 100000)
	private String biografia;
	
	@OneToMany(mappedBy = "artista")
	private List<Opera> opera;
	
	
	
	public Artista(String nome, String cognome, LocalDate dataDiNascita, String postoDiNascita, String nazionalita, LocalDate dataDiMorte, String postoDiMorte, String biografia) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.postoDiNascita = postoDiNascita;
		this.nazionalita = nazionalita;
		this.dataDiMorte = dataDiMorte;
		this.postoDiMorte = postoDiMorte;
		this.biografia = biografia;
		this.opera = new ArrayList<>();
	}

	public Artista() {
		this.opera = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public LocalDate getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(LocalDate dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public String getPostoDiNascita() {
		return postoDiNascita;
	}

	public void setPostoDiNascita(String postoDiNascita) {
		this.postoDiNascita = postoDiNascita;
	}

	public String getNazionalita() {
		return nazionalita;
	}

	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}

	public LocalDate getDataDiMorte() {
		return dataDiMorte;
	}

	public void setDataDiMorte(LocalDate dataDiMorte) {
		this.dataDiMorte = dataDiMorte;
	}

	public String getPostoDiMorte() {
		return postoDiMorte;
	}

	public void setPostoDiMorte(String postoDiMorte) {
		this.postoDiMorte = postoDiMorte;
	}
	
	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public List<Opera> getOpera() {
		return opera;
	}

	public void setOpera(List<Opera> opera) {
		this.opera = opera;
	}
	
	
	

}
