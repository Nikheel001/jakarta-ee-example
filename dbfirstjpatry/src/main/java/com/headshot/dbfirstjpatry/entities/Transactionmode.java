package com.headshot.dbfirstjpatry.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the transactionmode database table.
 * 
 */
@Entity
@Table(name="transactionmode")
@NamedQuery(name="Transactionmode.findAll", query="SELECT t FROM Transactionmode t")
public class Transactionmode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private byte trmodeid;

	@Column(nullable=false, length=20)
	private String name;

	//bi-directional many-to-one association to Periodicrecord
	@OneToMany(mappedBy="transactionmode")
	private List<Periodicrecord> periodicrecords;

	//bi-directional many-to-one association to Record
	@OneToMany(mappedBy="transactionmode")
	private List<Record> records;

	public Transactionmode() {
	}

	public byte getTrmodeid() {
		return this.trmodeid;
	}

	public void setTrmodeid(byte trmodeid) {
		this.trmodeid = trmodeid;
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
		periodicrecord.setTransactionmode(this);

		return periodicrecord;
	}

	public Periodicrecord removePeriodicrecord(Periodicrecord periodicrecord) {
		getPeriodicrecords().remove(periodicrecord);
		periodicrecord.setTransactionmode(null);

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
		record.setTransactionmode(this);

		return record;
	}

	public Record removeRecord(Record record) {
		getRecords().remove(record);
		record.setTransactionmode(null);

		return record;
	}

}