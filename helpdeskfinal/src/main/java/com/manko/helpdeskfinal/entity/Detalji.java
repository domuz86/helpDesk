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
	private String opis;

	public Detalji() {
		
	}

	public Detalji(int id_detalji, String opis) {
		
		this.id_detalji = id_detalji;
		this.opis = opis;
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

	@Override
	public String toString() {
		return opis;
	}
	
	

}
