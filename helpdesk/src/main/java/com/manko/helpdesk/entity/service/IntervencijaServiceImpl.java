package com.manko.helpdesk.entity.service;

import java.util.List;

import com.manko.helpdesk.entity.Intervencija;
import com.manko.helpdesk.entity.repo.IntervencijaRepo;

public class IntervencijaServiceImpl implements IntervencijaService {

	
	
	private IntervencijaRepo intervencijaRepo;
	
	public IntervencijaServiceImpl(IntervencijaRepo intervencijaRepo) {
		
		intervencijaRepo = intervencijaRepo;
	}
	

	@Override
	public List<Intervencija> findAll() {
		
		return intervencijaRepo.findAll();
	}

	@Override
	public Intervencija findById(int theId) {
		
		return null;
	}

	@Override
	public void save(Intervencija intervencija) {
		intervencijaRepo.save(intervencija);
		
	}

	

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		
	}

}
