package com.manko.helpdeskfinal.reposotory;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import com.manko.helpdeskfinal.entity.Korisnik;

@Component
public class StringToKorisnik implements Converter<String, Korisnik> {

	@Autowired
	KorisnikRepo korisnikRepo;
	


	@Override
	public JavaType getInputType(TypeFactory arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JavaType getOutputType(TypeFactory arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Korisnik convert(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
