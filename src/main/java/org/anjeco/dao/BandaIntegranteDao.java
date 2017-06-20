package org.anjeco.dao;

import java.util.List;

import org.anjeco.entity.BandaIntegrante;

public interface BandaIntegranteDao {
	
	BandaIntegrante find(int id);
	
	void create(BandaIntegrante bi);
	
	List<BandaIntegrante> read();
	
	BandaIntegrante update(BandaIntegrante bi);
	
	void delete(int id);
	
	boolean exist(int banda, int integrante);

}
