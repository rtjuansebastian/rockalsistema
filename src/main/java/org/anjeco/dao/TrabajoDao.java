package org.anjeco.dao;

import java.util.List;

import org.anjeco.entity.Trabajo;

public interface TrabajoDao {
	
	Trabajo find(int id);
	
	void create(Trabajo trabajo);
	
	List<Trabajo> read();
	
	Trabajo update(Trabajo trabajo);
	
	void delete(int id);
	
	boolean exist(String nombre);

}
