package com.headshot.jakartajpatry.library;

import java.util.ArrayList;

import com.headshot.jakartajpatry.entities.MouseMove;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
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
		ArrayList<MouseMove> firstTenRecord = new ArrayList<MouseMove>();
		Query list10 = ref.createNativeQuery("SELECT * from MOUSEMOVE LIMIT 10 ", MouseMove.class);
		for(MouseMove m: (ArrayList<MouseMove>)list10.getResultList()) {
			System.out.println(m);
		}
	}
	
	public void listfirst10JakartaQueryLanguage() {
		ArrayList<MouseMove> firstTenRecord = new ArrayList<MouseMove>();
		Query list10 = ref.createQuery("SELECT m from MouseMove m", MouseMove.class).setMaxResults(10);
		for(MouseMove m: (ArrayList<MouseMove>)list10.getResultList()) {
			System.out.println(m);
		}
	}
	
	public void listfirst10JakartaQueryLanguage2() {
		ArrayList<MouseMove> firstTenRecord = new ArrayList<MouseMove>();
		Query list10 = ref.createQuery("SELECT m FROM MouseMove m WHERE INDEX(m) BETWEEN 0 AND 10", MouseMove.class).setMaxResults(10);
		for(MouseMove m: (ArrayList<MouseMove>)list10.getResultList()) {
			System.out.println(m);
		}
	}
	
	public void listfirst10JakartaCriteriaQueryBuilder() {
		ArrayList<MouseMove> firstTenRecord = new ArrayList<MouseMove>();
		CriteriaBuilder cb = ref.getCriteriaBuilder();
		CriteriaQuery<MouseMove> query = cb.createQuery(MouseMove.class);
		Root<MouseMove> col= query.from(MouseMove.class);
		query.select(col);
//		cb.array(col);
		Query list10 = ref.createQuery(query).setMaxResults(10);
		for(MouseMove m: (ArrayList<MouseMove>)list10.getResultList()) {
			System.out.println(m);
		}
	}
}
