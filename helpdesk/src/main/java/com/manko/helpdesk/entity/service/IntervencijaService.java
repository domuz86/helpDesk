package com.manko.helpdesk.entity.service;

import java.util.List;

import com.manko.helpdesk.entity.Intervencija;

public interface IntervencijaService {

	public List<Intervencija> findAll();
	
	public Intervencija findById(int theId);
	
	public void save(Intervencija intervencija);
	
	
	
	public void deleteById(int theId);
	
}
