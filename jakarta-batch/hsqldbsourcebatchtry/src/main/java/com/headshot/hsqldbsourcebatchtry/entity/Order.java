package com.headshot.hsqldbsourcebatchtry.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;


/**
 * The persistent class for the ORDERS database table.
 * 
 */
@Entity
@Table(name="ORDERS")
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private long oid;

	private double amount;

	@Column(nullable=false)
	private long cid;

	private LocalDateTime createdon;

	private LocalDateTime updatedon;

	public Order() {
	}

	public long getOid() {
		return this.oid;
	}

	public void setOid(long oid) {
		this.oid = oid;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public long getCid() {
		return this.cid;
	}

	public void setCid(long cid) {
		this.cid = cid;
	}

	public LocalDateTime getCreatedon() {
		return this.createdon;
	}

	public void setCreatedon(LocalDateTime createdon) {
		this.createdon = createdon;
	}

	public LocalDateTime getUpdatedon() {
		return this.updatedon;
	}

	public void setUpdatedon(LocalDateTime updatedon) {
		this.updatedon = updatedon;
	}
}