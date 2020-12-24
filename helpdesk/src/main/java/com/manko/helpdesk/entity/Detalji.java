package com.manko.helpdesk.entity;

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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_detalji")
	private int id;
	
	@Column(name="opis_kvara")
	private String opisKvara;
	
	@Column(name="napomena")
	private String napomena;

	public Detalji() {
		
	}

	public Detalji(int id, String opisKvara, String napomena) {
	
		this.id = id;
		this.opisKvara = opisKvara;
		this.napomena = napomena;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOpisKvara() {
		return opisKvara;
	}

	public void setOpisKvara(String opisKvara) {
		this.opisKvara = opisKvara;
	}

	public String getNapomena() {
		return napomena;
	}

	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}
	
	

}
