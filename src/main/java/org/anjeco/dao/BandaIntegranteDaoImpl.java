package org.anjeco.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.anjeco.entity.BandaIntegrante;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class BandaIntegranteDaoImpl implements BandaIntegranteDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public BandaIntegrante find(int id) {

		return entityManager.find(BandaIntegrante.class, id);
	}

	@Override
	public void create(BandaIntegrante bi) {

		entityManager.merge(bi);
		
	}

	@Override
	public List<BandaIntegrante> read() {

		String hql = "FROM BandaIntegrante ORDER BY id ";
		return (List<BandaIntegrante>) entityManager.createQuery(hql).getResultList();
		
	}

	@Override
	public BandaIntegrante update(BandaIntegrante bi) {
		
		BandaIntegrante bandaIntegrante = find(bi.getId());
		bandaIntegrante.setBanda(bi.getBanda());
		bandaIntegrante.setIntegrante(bi.getIntegrante());
		entityManager.flush();
		return bandaIntegrante;
		
	}

	@Override
	public void delete(int id) {
		
		entityManager.remove(find(id));

	}

	@Override
	public boolean exist(int banda, int integrante) {
		
		String hql="FROM BandaIntegrante WHERE banda= ? AND integrante=? ";
		int count = entityManager.createQuery(hql).setParameter(1, banda).setParameter(2, integrante).getResultList().size();
		return count > 0 ? true:false;
	}

}
