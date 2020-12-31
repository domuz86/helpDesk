package com.manko.helpdeskfinal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="detalji")
public class Detalji {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_detalji")
	private int id_detalji;

	@Column(name = "opis")
	String opis;
	
	@Column(name = "komentar")
	String komentar;
	

	public Detalji() {
		
	}

	
	public Detalji(String opis, String komentar) {
		
		this.opis = opis;
		this.komentar = komentar;
	}


	public int getId_detalji() {
		return id_detalji;
	}

	public void setId_detalji(int id_detalji) {
		this.id_detalji = id_detalji;
	}




	public String getOpis() {
		return opis;
	}




	public void setOpis(String opis) {
		this.opis = opis;
	}




	public String getKomentar() {
		return komentar;
	}




	public void setKomentar(String komentar) {
		this.komentar = komentar;
	}

	
	
	

}
