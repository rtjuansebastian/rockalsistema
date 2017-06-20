package org.anjeco.service;

import java.util.List;

import org.anjeco.dao.GeneroDao;
import org.anjeco.entity.Genero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneroServiceImpl implements GeneroService {

	@Autowired
	private GeneroDao generoDao;

	@Override
	public Genero find(int id) {
		Genero gen = generoDao.find(id);
		return gen;
	}

	@Override
	public boolean create(Genero genero) {
		if (generoDao.exists(genero.getNombre())) {
			return false;
		} else {
			generoDao.create(genero);
			return true;
		}

	}

	@Override
	public List<Genero> read() {
		return generoDao.read();
	}

	@Override
	public Genero update(Genero genero) {
		return generoDao.update(genero);
	}

	@Override
	public void delete(int id) {
		generoDao.delete(id);

	}

}
