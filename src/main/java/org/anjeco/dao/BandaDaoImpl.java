package org.anjeco.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.anjeco.entity.Banda;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class BandaDaoImpl implements BandaDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Banda find(int id) {

		return entityManager.find(Banda.class, id);

	}

	@Override
	public void create(Banda banda) {

		entityManager.merge(banda);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Banda> read() {

		String hql = "FROM Banda ORDER BY id";
		return (List<Banda>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Banda update(Banda banda) {

		Banda ban = find(banda.getId());
		ban.setNombre(banda.getNombre());
		ban.setResena(banda.getResena());
		ban.setIntegrantes(banda.getIntegrantes());
		ban.setTrabajos(banda.getTrabajos());
		entityManager.flush();

		return ban;
	}

	@Override
	public void delete(int id) {

		entityManager.remove(find(id));

	}

	@Override
	public boolean exist(String nombre) {
		
		String hql="FROM Banda WHERE nombre= ? ";
		int count=entityManager.createQuery(hql).setParameter(1, nombre).getResultList().size();
		
		return count > 0 ? true: false;
	}

}
