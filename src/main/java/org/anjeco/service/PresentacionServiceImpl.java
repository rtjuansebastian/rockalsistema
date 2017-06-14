package org.anjeco.service;

import java.util.List;

import org.anjeco.dao.PresentacionDao;
import org.anjeco.entity.Presentacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PresentacionServiceImpl implements PresentacionService {

	@Autowired
	private PresentacionDao presentacionDao;

	@Override
	public Presentacion find(int id) {

		Presentacion presentacion = presentacionDao.find(id);
		return presentacion;

	}

	@Override
	public boolean create(Presentacion presentacion) {
		
		if(presentacionDao.exist(presentacion.getHora(), presentacion.getEdicion())){
			return false;
		}else{
			presentacionDao.create(presentacion);
			return true;
		}
	}

	@Override
	public List<Presentacion> read() {
		
		return presentacionDao.read();
		
	}

	@Override
	public Presentacion update(Presentacion presentacion) {
		
		return presentacionDao.update(presentacion);
		
	}

	@Override
	public void delete(int id) {

		presentacionDao.delete(id);
		
	}

}
