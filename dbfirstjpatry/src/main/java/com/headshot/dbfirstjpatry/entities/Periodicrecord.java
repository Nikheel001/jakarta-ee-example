package com.headshot.dbfirstjpatry.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;


/**
 * The persistent class for the periodicrecord database table.
 * 
 */
@Entity
@Table(name="periodicrecord")
@NamedQuery(name="Periodicrecord.findAll", query="SELECT p FROM Periodicrecord p")
public class Periodicrecord implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int recordid;

	private float amount;

	@Column(length=100)
	private String description;

	private int duration;

	@Column(name="is_debit")
	private byte isDebit;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_modified")
	private Date lastModified;

	@Column(nullable=false, length=75)
	private String title;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="transacted_on")
	private Date transactedOn;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="categoryid")
	private Category category;

	//bi-directional many-to-one association to Transactionmode
	@ManyToOne
	@JoinColumn(name="trmodeid")
	private Transactionmode transactionmode;

	public Periodicrecord() {
	}

	public int getRecordid() {
		return this.recordid;
	}

	public void setRecordid(int recordid) {
		this.recordid = recordid;
	}

	public float getAmount() {
		return this.amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDuration() {
		return this.duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public byte getIsDebit() {
		return this.isDebit;
	}

	public void setIsDebit(byte isDebit) {
		this.isDebit = isDebit;
	}

	public Date getLastModified() {
		return this.lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getTransactedOn() {
		return this.transactedOn;
	}

	public void setTransactedOn(Date transactedOn) {
		this.transactedOn = transactedOn;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Transactionmode getTransactionmode() {
		return this.transactionmode;
	}

	public void setTransactionmode(Transactionmode transactionmode) {
		this.transactionmode = transactionmode;
	}

}