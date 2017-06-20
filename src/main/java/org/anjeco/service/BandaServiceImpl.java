package org.anjeco.service;

import java.util.List;

import org.anjeco.dao.BandaDao;
import org.anjeco.entity.Banda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BandaServiceImpl implements BandaService{
	
	@Autowired
	private BandaDao bandaDao;

	@Override
	public Banda find(int id) {
		Banda banda=bandaDao.find(id);
		return banda;
	}

	@Override
	public boolean create(Banda banda) {
		
		if(bandaDao.exist(banda.getNombre())){
			return false;
		}else{
			bandaDao.create(banda);
			return true;
		}
		
	}

	@Override
	public List<Banda> read() {

		return bandaDao.read();

	}

	@Override
	public Banda update(Banda banda) {
		
		return bandaDao.update(banda);
		
	}

	@Override
	public void delete(int id) {
		
		bandaDao.delete(id);
		
	}

}
