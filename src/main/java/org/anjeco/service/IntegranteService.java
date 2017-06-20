package org.anjeco.service;

import java.util.List;

import org.anjeco.entity.Integrante;

public interface IntegranteService {
	
	Integrante find(int id);
	
	boolean create(Integrante integrante);
	
	List<Integrante> read();
	
	Integrante update(Integrante integrante);
	
	void delete(int id);

}
