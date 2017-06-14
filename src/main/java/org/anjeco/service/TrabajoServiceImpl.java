package org.anjeco.service;

import java.util.List;

import org.anjeco.dao.TrabajoDao;
import org.anjeco.entity.Trabajo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrabajoServiceImpl implements TrabajoService {

	@Autowired
	private TrabajoDao trabajoDao;

	@Override
	public Trabajo find(int id) {

		Trabajo trabajo = trabajoDao.find(id);
		return trabajo;

	}

	@Override
	public boolean create(Trabajo trabajo) {

		if (trabajoDao.exist(trabajo.getNombre())) {
			return false;
		} else {
			trabajoDao.create(trabajo);
			return true;
		}

	}

	@Override
	public List<Trabajo> read() {

		return trabajoDao.read();

	}

	@Override
	public Trabajo update(Trabajo trabajo) {

		return trabajoDao.update(trabajo);

	}

	@Override
	public void delete(int id) {

		trabajoDao.delete(id);

	}

}
