package com.manko.helpdesk.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "intervencija")
public class Intervencija {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_intervencija")
	private int id;

	@Column(name = "naziv_ntervencije")
	private String nazivIntervencije;

	private String imeIprezime;
	
	private Detalji detalji;

	
	public Intervencija() {
		
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNazivIntervencije() {
		return nazivIntervencije;
	}

	public void setNazivIntervencije(String nazivIntervencije) {
		this.nazivIntervencije = nazivIntervencije;
	}



	
	
	
}
