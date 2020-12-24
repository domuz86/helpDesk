package com.manko.helpdeskfinal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="intervencija")
public class Intervencija {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_intervencija")
	private int idIntervencija;

	@Column(name="naziv_intervencije")
	private String nazivIntervencije;

	@Column(name="ime_i_prezime")
	private String imeIprezime;

	@OneToOne
	@JoinColumn(name="id_detalji")
	private Detalji detalji;
	
	public Intervencija() {

	}

	public Intervencija(int idIntervencija, String nazivIntervencije, String imeIprezime) {
	
		this.idIntervencija = idIntervencija;
		this.nazivIntervencije = nazivIntervencije;
		this.imeIprezime = imeIprezime;
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

	public String getImeIprezime() {
		return imeIprezime;
	}

	public void setImeIprezime(String imeIprezime) {
		this.imeIprezime = imeIprezime;
	}

	public Detalji getDetalji() {
		return detalji;
	}

	public void setDetalji(Detalji detalji) {
		this.detalji = detalji;
	}

	
	
	
	
}
