package com.headshot.dbfirstjpatry.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;

/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@Table(name = "category")
@NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int categoryid;

	@Column(name = "group_categoryid")
	private int groupCategoryid;

	@Column(nullable = false, length = 20)
	private String name;

	// bi-directional many-to-one association to Periodicrecord
	@OneToMany(mappedBy = "category")
	private List<Periodicrecord> periodicrecords;

	// bi-directional many-to-one association to Record
	@OneToMany(mappedBy = "category")
	private List<Record> records;

	public Category() {
	}

	public int getCategoryid() {
		return this.categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public int getGroupCategoryid() {
		return this.groupCategoryid;
	}

	public void setGroupCategoryid(int groupCategoryid) {
		this.groupCategoryid = groupCategoryid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Periodicrecord> getPeriodicrecords() {
		return this.periodicrecords;
	}

	public void setPeriodicrecords(List<Periodicrecord> periodicrecords) {
		this.periodicrecords = periodicrecords;
	}

	public Periodicrecord addPeriodicrecord(Periodicrecord periodicrecord) {
		getPeriodicrecords().add(periodicrecord);
		periodicrecord.setCategory(this);

		return periodicrecord;
	}

	public Periodicrecord removePeriodicrecord(Periodicrecord periodicrecord) {
		getPeriodicrecords().remove(periodicrecord);
		periodicrecord.setCategory(null);

		return periodicrecord;
	}

	public List<Record> getRecords() {
		return this.records;
	}

	public void setRecords(List<Record> records) {
		this.records = records;
	}

	public Record addRecord(Record record) {
		getRecords().add(record);
		record.setCategory(this);

		return record;
	}

	public Record removeRecord(Record record) {
		getRecords().remove(record);
		record.setCategory(null);

		return record;
	}

}