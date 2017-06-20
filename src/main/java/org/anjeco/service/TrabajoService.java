package org.anjeco.service;

import java.util.List;

import org.anjeco.entity.Trabajo;

public interface TrabajoService {
	
	Trabajo find(int id);
	
	boolean create(Trabajo trabajo);
	
	List<Trabajo> read();
	
	Trabajo update(Trabajo trabajo);
	
	void delete(int id);
	
}
