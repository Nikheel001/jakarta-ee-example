package com.headshot.hsqldbsourcebatchtry.repo;

import com.headshot.hsqldbsourcebatchtry.entity.Customermonthlyspent;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

/**
 * 
 * @author nikheel.patel
 *
 */
@ApplicationScoped
@Transactional(value = TxType.REQUIRED)
public class CustomermonthlyspentRepo {

	@PersistenceContext(unitName = "hsqldbsourcebatchjpa")
	private EntityManager ref;

	public void accumulateCMS(Customermonthlyspent recordToAccumulate) {
		Customermonthlyspent cmsUpdated = ref.find(Customermonthlyspent.class, recordToAccumulate.getId());
		if (cmsUpdated == null) {
			ref.persist(recordToAccumulate);
		} else {
			cmsUpdated.setAmount(cmsUpdated.getAmount() + recordToAccumulate.getAmount());
			ref.merge(cmsUpdated);
		}
	}
}
