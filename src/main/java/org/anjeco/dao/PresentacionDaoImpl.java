package org.anjeco.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.anjeco.entity.Edicion;
import org.anjeco.entity.Presentacion;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class PresentacionDaoImpl implements PresentacionDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Presentacion find(int id) {

		return entityManager.find(Presentacion.class, id);

	}

	@Override
	public void create(Presentacion presentacion) {

		entityManager.merge(presentacion);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Presentacion> read() {

		String hql = "FROM Presentacion ORDER BY id";
		return (List<Presentacion>) entityManager.createQuery(hql).getResultList();

	}

	@Override
	public Presentacion update(Presentacion presentacion) {

		Presentacion pre = find(presentacion.getId());
		pre.setBanda(presentacion.getBanda());
		pre.setHora(presentacion.getHora());
		entityManager.flush();

		return pre;
	}

	@Override
	public void delete(int id) {

		entityManager.remove(find(id));

	}

	@Override
	public boolean exist(Date hora, Edicion edicion) {

		String hql = "FROM Presentacion WHERE hora= ? AND edicion= ?";
		int count = entityManager.createQuery(hql).setParameter(1, hora).setParameter(2, edicion.getId())
				.getResultList().size();
		return count > 0 ? true : false;

	}

}
