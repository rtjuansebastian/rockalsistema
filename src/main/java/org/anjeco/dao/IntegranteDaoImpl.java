package org.anjeco.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.anjeco.entity.Integrante;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class IntegranteDaoImpl implements IntegranteDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Integrante find(int id) {

		return entityManager.find(Integrante.class, id);
	}

	@Override
	public void create(Integrante integrante) {

		entityManager.merge(integrante);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Integrante> read() {
		String hql = "FROM Integrante ORDER BY id";
		return (List<Integrante>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Integrante update(Integrante integrante) {

		Integrante inte = find(integrante.getId());
		inte.setNombre(integrante.getNombre());
		inte.setSexo(integrante.getSexo());
		inte.setFechaNacimiento(integrante.getFechaNacimiento());
		entityManager.flush();

		return inte;
	}

	@Override
	public void delete(int id) {
		entityManager.remove(find(id));

	}

	@Override
	public boolean exists(String nombre) {
		String hql = "FROM Integrante WHERE nombre= ? ";
		int count = entityManager.createQuery(hql).setParameter(1, nombre).getResultList().size();
		return count>0 ? true : false ;
	}

}
