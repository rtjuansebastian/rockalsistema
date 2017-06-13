package org.anjeco.dao;

import java.util.List;

import org.anjeco.entity.Integrante;

public interface IntegranteDao {
	Integrante find(int id);

	void create(Integrante integrante);

	List<Integrante> read();

	Integrante update(Integrante integrante);

	void delete(int id);

	boolean exists(String nombre);

}
