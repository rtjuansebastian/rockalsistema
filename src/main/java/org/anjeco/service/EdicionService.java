package org.anjeco.service;

import java.util.List;

import org.anjeco.entity.Edicion;

public interface EdicionService {

	Edicion find(int id);
	
	boolean create(Edicion edicion);
	
	List<Edicion> read();
	
	Edicion update(Edicion edicion);
	
	void delete(int id);
	
}
