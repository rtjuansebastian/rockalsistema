package org.anjeco.service;

import java.util.List;

import org.anjeco.dao.EdicionDao;
import org.anjeco.entity.Edicion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EdicionServiceImpl implements EdicionService{
	
	@Autowired
	private EdicionDao edicionDao;

	@Override
	public Edicion find(int id) {
		
		return edicionDao.find(id);
		
	}

	@Override
	public boolean create(Edicion edicion) {
		
		if(edicionDao.exist(edicion.getFecha())){
			return false;
		}else{
			edicionDao.create(edicion);
			return true;
		}		
		
	}

	@Override
	public List<Edicion> read() {
		
		return edicionDao.read();
		
	}

	@Override
	public Edicion update(Edicion edicion) {
		
		return edicionDao.update(edicion);
		
	}

	@Override
	public void delete(int id) {
		
		edicionDao.delete(id);
		
	}	

}
