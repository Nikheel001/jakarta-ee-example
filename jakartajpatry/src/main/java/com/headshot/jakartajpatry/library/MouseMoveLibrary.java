package com.headshot.jakartajpatry.library;

import com.headshot.jakartajpatry.entities.MouseMove;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

/**
 * 
 * @author headshot
 *
 */
public class MouseMoveLibrary {

	private EntityManager ref;

	public MouseMoveLibrary(EntityManager ref) {
		this.ref = ref;
	}

	public void listfirst10Native() {
		Query list10 = ref.createNativeQuery("SELECT * from MOUSEMOVE LIMIT 10 ", MouseMove.class);
		for (MouseMove m : (Iterable<MouseMove>) list10.getResultList()) {
			System.out.println(m);
		}
	}

	public void listfirst10JakartaQueryLanguage() {
		TypedQuery<MouseMove> list10 = ref.createQuery("SELECT m from MouseMove m", MouseMove.class).setMaxResults(10);
		for (MouseMove m : list10.getResultList()) {
			System.out.println(m);
		}
	}

	public void listfirst10JakartaCriteriaQueryBuilder() {
		CriteriaBuilder cb = ref.getCriteriaBuilder();
		CriteriaQuery<MouseMove> query = cb.createQuery(MouseMove.class);
		Root<MouseMove> col = query.from(MouseMove.class);
		query.select(col);
		TypedQuery<MouseMove> list10 = ref.createQuery(query).setMaxResults(10);
		for (MouseMove m : list10.getResultList()) {
			System.out.println(m);
		}
	}
}
