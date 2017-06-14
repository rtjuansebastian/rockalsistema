package org.anjeco.service;

import java.util.List;

import org.anjeco.entity.Banda;

public interface BandaService {
	
	Banda find(int id);
	
	boolean create(Banda banda);
	
	List<Banda> read();
	
	Banda update(Banda banda);
	
	void delete(int id);

}
