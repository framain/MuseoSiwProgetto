package it.uniroma3.siw.spring.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Curatore {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String matricola;
	
	private String nome;
	
	private String cognome;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataDiNascita;
	
	private String luogoDiNascita;
	
	private String email;
	
	private String telefono;
	
	@OneToMany(mappedBy = "curatore")
	private List<Collezione> collezioni;

	public Curatore(String matricola, String nome, String cognome, LocalDate dataDiNascita, String luogoDiNascita, String email, String telefono) {
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.luogoDiNascita = luogoDiNascita;
		this.email = email;
		this.telefono = telefono;
		this.collezioni = new ArrayList<Collezione>();
	}

	public Curatore() {
		this.collezioni = new ArrayList<Collezione>();
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
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

	public String getLuogoDiNascita() {
		return luogoDiNascita;
	}

	public void setLuogoDiNascita(String luogoDiNascita) {
		this.luogoDiNascita = luogoDiNascita;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Collezione> getCollezioni() {
		return collezioni;
	}

	public void setCollezioni(List<Collezione> collezioni) {
		this.collezioni = collezioni;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
