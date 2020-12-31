package com.manko.helpdeskfinal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="konzumenti")
public class Konzumenti {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_konzumenti")
	private int idKonzumenti;
	
	@Column(name="ime_i_prezime")
	private String imeIprezime;

	public Konzumenti() {
	
	}

	
	
	public Konzumenti(int idKonzumenti, String imeIprezime) {
		
		this.idKonzumenti = idKonzumenti;
		this.imeIprezime = imeIprezime;
	}



	public int getIdKonzumenti() {
		return idKonzumenti;
	}

	public void setIdKonzumenti(int idKonzumenti) {
		this.idKonzumenti = idKonzumenti;
	}

	public String getImeIprezime() {
		return imeIprezime;
	}

	public void setImeIprezime(String imeIprezime) {
		this.imeIprezime = imeIprezime;
	}



	@Override
	public String toString() {
		return  imeIprezime;
	}

	
	
}
