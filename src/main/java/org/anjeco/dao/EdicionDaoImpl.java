package org.anjeco.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.anjeco.entity.Edicion;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class EdicionDaoImpl implements EdicionDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Edicion find(int id) {

		return entityManager.find(Edicion.class, id);

	}

	@Override
	public void create(Edicion edicion) {

		entityManager.merge(edicion);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Edicion> read() {

		String hql = "FROM Edicion ORDER BY id ";
		return (List<Edicion>) entityManager.createQuery(hql).getResultList();

	}

	@Override
	public Edicion update(Edicion edicion) {

		Edicion edi = find(edicion.getId());
		edi.setFecha(edicion.getFecha());
		edi.setLugar(edicion.getLugar());
		edi.setObjetivo(edicion.getObjetivo());
		edi.setPresentaciones(edicion.getPresentaciones());
		entityManager.flush();

		return edi;

	}

	@Override
	public void delete(int id) {

		entityManager.remove(find(id));

	}

	@Override
	public boolean exist(Date fecha) {

		String hql = "FROM Edicion WHERE fecha= ? ";
		int count = entityManager.createQuery(hql).getResultList().size();
		return count > 0 ? true : false;

	}

}
