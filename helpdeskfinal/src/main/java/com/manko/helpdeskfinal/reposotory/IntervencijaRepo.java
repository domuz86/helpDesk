package com.manko.helpdeskfinal.reposotory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.manko.helpdeskfinal.entity.Intervencija;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

public interface IntervencijaRepo extends JpaRepository<Intervencija, Integer> {

	
	
	public List<Intervencija> findAllByOrderByIdIntervencijaDesc();
	
	
	@Query("SELECT u FROM intervencija u WHERE u.status = 'aktivna'")
	public List<Intervencija> findAllByStatus();
	
}
