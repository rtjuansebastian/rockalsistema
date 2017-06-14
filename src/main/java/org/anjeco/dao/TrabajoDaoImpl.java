package org.anjeco.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.anjeco.entity.Trabajo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class TrabajoDaoImpl implements TrabajoDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Trabajo find(int id) {

		return entityManager.find(Trabajo.class, id);
	}

	@Override
	public void create(Trabajo trabajo) {

		entityManager.merge(trabajo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Trabajo> read() {

		String hql = "FROM Trabajo ORDER BY id";
		return (List<Trabajo>) entityManager.createQuery(hql).getResultList();

	}

	@Override
	public Trabajo update(Trabajo trabajo) {

		Trabajo tra = find(trabajo.getId());
		tra.setBanda(trabajo.getBanda());
		tra.setFecha(trabajo.getFecha());
		tra.setNombre(trabajo.getNombre());
		entityManager.flush();

		return tra;
	}

	@Override
	public void delete(int id) {

		entityManager.remove(find(id));

	}

	@Override
	public boolean exist(String nombre) {
		
		String hql="FROM Trabajo WHERE nombre= ? ";
		int count=entityManager.createQuery(hql).getResultList().size();
		return count > 0 ? true: false;
	}

}
