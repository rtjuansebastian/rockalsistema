package org.anjeco.service;

import java.util.List;

import org.anjeco.entity.Presentacion;

public interface PresentacionService {
	
	Presentacion find(int id);
	
	boolean create(Presentacion presentacion);
	
	List<Presentacion> read();
	
	Presentacion update(Presentacion presentacion);
	
	void delete(int id);	
	
}
