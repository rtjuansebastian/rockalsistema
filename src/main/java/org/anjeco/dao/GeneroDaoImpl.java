package org.anjeco.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.anjeco.entity.Genero;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class GeneroDaoImpl implements GeneroDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Genero find(int id) {

		return entityManager.find(Genero.class, id);

	}

	@Override
	public void create(Genero genero) {
		
		entityManager.merge(genero);		
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Genero> read() {
		String hql = "FROM Genero ORDER BY id";
		return (List<Genero>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Genero update(Genero genero) {
		
		Genero gen=find(genero.getId());
		gen.setNombre(genero.getNombre());
		entityManager.flush();
		
		return gen;
		
	}

	@Override
	public void delete(int id) {
		entityManager.remove(find(id));

	}

	@Override
	public boolean exists(String nombre) {
		String hql = "FROM Genero WHERE nombre = ? ";
		int count = entityManager.createQuery(hql).setParameter(1, nombre)
		              .getResultList().size();
		return count > 0 ? true : false;		
	}	

}
