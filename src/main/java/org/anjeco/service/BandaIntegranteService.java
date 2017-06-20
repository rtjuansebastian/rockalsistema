package org.anjeco.service;

import java.util.List;

import org.anjeco.entity.BandaIntegrante;

public interface BandaIntegranteService {
	
	BandaIntegrante find(int id);
	
	boolean create(BandaIntegrante bandaIntegrante);
	
	List<BandaIntegrante> read();
	
	BandaIntegrante update(BandaIntegrante bandaIntegrante);
	
	void delete(int id);

}
