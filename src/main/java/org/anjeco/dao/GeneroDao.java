package org.anjeco.dao;

import java.util.List;

import org.anjeco.entity.Genero;

public interface GeneroDao {
	
	Genero find(int id);
	
	void create(Genero genero);
	
	List <Genero> read();
	
	Genero update(Genero genero);
	
	void delete(int id);
	
	boolean exists(String nombre);

}
