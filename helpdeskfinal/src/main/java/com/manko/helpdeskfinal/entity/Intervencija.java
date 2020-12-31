package com.manko.helpdeskfinal.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "intervencija")
@Table
public class Intervencija {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_intervencija")
	private int idIntervencija;

	@Column(name = "naziv_intervencije")
	private String nazivIntervencije;

	

	@Column(name = "status")
	private String status;

	@Column(name = "datum")
	private String datum;
	

	@Column(name = "kancelarija")
	private int kancelarija;


	@OneToOne
	@JoinColumn(name = "id_korisnik")
	private Korisnik korisnik;

	@OneToOne
	@JoinColumn(name = "id_konzument")
	private Konzumenti konzumenti;

	@OneToOne
	@JoinColumn(name = "id_detalji")
	private Detalji detalji;
	
	

	public Intervencija() {

	}

	

	public Intervencija(int idIntervencija, String nazivIntervencije, String status, String datum, int kancelarija,
			Korisnik korisnik, Konzumenti konzumenti, Detalji detalji) {
		
		this.idIntervencija = idIntervencija;
		this.nazivIntervencije = nazivIntervencije;
		this.status = status;
		this.datum = datum;
		this.kancelarija = kancelarija;
		this.korisnik = korisnik;
		this.konzumenti = konzumenti;
		this.detalji = detalji;
	}



	public int getIdIntervencija() {
		return idIntervencija;
	}

	public void setIdIntervencija(int idIntervencija) {
		this.idIntervencija = idIntervencija;
	}

	public String getNazivIntervencije() {
		return nazivIntervencije;
	}

	public void setNazivIntervencije(String nazivIntervencije) {
		this.nazivIntervencije = nazivIntervencije;
	}

	public Detalji getDetalji() {
		return detalji;
	}

	public void setDetalji(Detalji detalji) {
		this.detalji = detalji;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public Konzumenti getKonzumenti() {
		return konzumenti;
	}

	public void setKonzumenti(Konzumenti konzumenti) {
		this.konzumenti = konzumenti;
	}



	public int getKancelarija() {
		return kancelarija;
	}



	public void setKancelarija(int kancelarija) {
		this.kancelarija = kancelarija;
	}

	
	

}
