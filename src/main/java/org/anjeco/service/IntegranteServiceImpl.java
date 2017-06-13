package org.anjeco.service;

import java.util.List;

import org.anjeco.dao.IntegranteDao;
import org.anjeco.entity.Integrante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IntegranteServiceImpl implements IntegranteService {
	
	@Autowired
	private IntegranteDao integranteDao;

	@Override
	public Integrante find(int id) {
		Integrante inte=integranteDao.find(id);
		return inte;
	}

	@Override
	public boolean create(Integrante integrante) {
		if(integranteDao.exists(integrante.getNombre())){
			return false;
		}else{
			integranteDao.create(integrante);
			return true;
		}
	}

	@Override
	public List<Integrante> read() {
		return integranteDao.read();
	}

	@Override
	public Integrante update(Integrante integrante) {
		return integranteDao.update(integrante);
	}

	@Override
	public void delete(int id) {
		integranteDao.delete(id);
		
	}

}
