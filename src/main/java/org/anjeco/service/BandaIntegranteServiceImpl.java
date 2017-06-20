package org.anjeco.service;

import java.util.List;

import org.anjeco.dao.BandaIntegranteDao;
import org.anjeco.entity.BandaIntegrante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BandaIntegranteServiceImpl implements BandaIntegranteService {

	@Autowired
	private BandaIntegranteDao biDao;

	@Override
	public BandaIntegrante find(int id) {

		BandaIntegrante bandaIntegrante = biDao.find(id);
		return bandaIntegrante;

	}

	@Override
	public boolean create(BandaIntegrante bandaIntegrante) {
		
		if(biDao.exist(bandaIntegrante.getBanda().getId(),bandaIntegrante.getIntegrante().getId())){
			return false;
		}else{
			biDao.create(bandaIntegrante);
			return true;
		}
		
	}

	@Override
	public List<BandaIntegrante> read() {
		
		return biDao.read();
		
	}

	@Override
	public BandaIntegrante update(BandaIntegrante bandaIntegrante) {
		
		return biDao.update(bandaIntegrante);
		
	}

	@Override
	public void delete(int id) {
		
		biDao.delete(id);
		
	}

}
