package com.manko.helpdeskfinal.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity(name="korisnik")
@Table
public class Korisnik {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_korisnik")
	private int idKorisnik;
	
	@Column(name="korisnicko_ime")
	private String korisnickoIme;
	
	@Column(name="lozinka")
	private String lozinka;
	
	@Column(name="ime_i_prezime")
	private String imeIprezime;
	

	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name = "korisnici_uloge", joinColumns = @JoinColumn(name = "id_korisnik"), inverseJoinColumns = @JoinColumn(name = "id_uloge"))
	private Collection<UlogeEntity> uloge;

	public Korisnik() {
		
	}

	
	
	
	public Korisnik(int idKorisnik, String korisnickoIme, String lozinka, String imeIprezime) {
	
		this.idKorisnik=idKorisnik;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.imeIprezime = imeIprezime;
	}




	public int getIdKorisnik() {
		return idKorisnik;
	}

	public void setIdKorisnik(int idKorisnik) {
		this.idKorisnik = idKorisnik;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public String getImeIprezime() {
		return imeIprezime;
	}

	public void setImeIprezime(String imeIprezime) {
		this.imeIprezime = imeIprezime;
	}


	@Override
	public String toString() {
		return imeIprezime;
	}




	public Collection<UlogeEntity> getUloge() {
		return uloge;
	}




	public void setUloge(Collection<UlogeEntity> uloge) {
		this.uloge = uloge;
	}
	
	
	
	
}
