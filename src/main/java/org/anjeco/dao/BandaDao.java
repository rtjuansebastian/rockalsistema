package org.anjeco.dao;

import java.util.List;

import org.anjeco.entity.Banda;

public interface BandaDao {

	Banda find(int id);
	
	void create(Banda banda);
	
	List<Banda> read();
	
	Banda update(Banda banda);
	
	void delete(int id);
	
	boolean exist(String nombre);
}
