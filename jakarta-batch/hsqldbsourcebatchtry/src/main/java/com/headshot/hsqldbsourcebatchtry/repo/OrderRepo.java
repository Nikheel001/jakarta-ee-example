package com.headshot.hsqldbsourcebatchtry.repo;

import java.util.List;

import com.headshot.hsqldbsourcebatchtry.entity.Order;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

/**
 * 
 * @author nikheel.patel
 *
 */
@ApplicationScoped
public class OrderRepo {

	@PersistenceContext(unitName = "hsqldbsourcebatchjpa")
	private EntityManager ref;

	public List<Order> listNextNitems(int offset, int N) {
		TypedQuery<Order> listAll = ref.createQuery("SELECT o from Order o", Order.class).setFirstResult(offset)
				.setMaxResults(N);
		return listAll.getResultList();
	}
}
