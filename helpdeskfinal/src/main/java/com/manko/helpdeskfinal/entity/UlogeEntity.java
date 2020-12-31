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

@Entity(name = "uloge")
@Table
public class UlogeEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_uloge")
	private int id_uloge;
	
	@Column(name = "naziv_uloge")
	private String naziv_uloge;

	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name = "korisnici_uloge", joinColumns = @JoinColumn(name = "id_uloge"), inverseJoinColumns = @JoinColumn(name = "id_korisnik"))
	private Collection<Korisnik> korisnici;
	
	
	public UlogeEntity() {
		
	}
	
	
	public UlogeEntity(String naziv_uloge) {
		super();
		this.naziv_uloge = naziv_uloge;
	}



	public String getNaziv_uloge() {
		return naziv_uloge;
	}

	public void setNaziv_uloge(String naziv_uloge) {
		this.naziv_uloge = naziv_uloge;
	}
	
	
	
	
}
