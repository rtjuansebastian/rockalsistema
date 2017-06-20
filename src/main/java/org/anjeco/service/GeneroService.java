package org.anjeco.service;

import java.util.List;

import org.anjeco.entity.Genero;

public interface GeneroService {
	
	Genero find(int id);
	
	boolean create(Genero genero);
	
	List<Genero> read();
	
	Genero update(Genero genero);
		
	void delete(int id);
	
}
