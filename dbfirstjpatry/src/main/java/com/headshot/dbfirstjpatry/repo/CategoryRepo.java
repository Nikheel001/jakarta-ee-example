package com.headshot.dbfirstjpatry.repo;

import java.util.List;

import com.headshot.dbfirstjpatry.entities.Category;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

/**
 * 
 * @author nikheel.patel
 *
 */
public class CategoryRepo {

	private EntityManager ref;

	public CategoryRepo(EntityManager ref_base) {
		ref = ref_base;
	}

	public List<Category> listAll() {
		TypedQuery<Category> listAll = ref.createQuery("SELECT m from Category m", Category.class);
		return listAll.getResultList();
	}

}
