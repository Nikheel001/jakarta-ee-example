package com.headshot.hsqldbsourcebatchtry.entity;

import java.io.Serializable;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

/**
 * 
 * @author nikheel.patel
 *
 */
@Entity
@Table(name="CUSTOMERMONTHLYSPENT")
@NamedQuery(name="Customermonthlyspent.findAll", query="SELECT c FROM Customermonthlyspent c")
public class Customermonthlyspent implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CustomermonthlyspentPK id;

	private double amount;

	public Customermonthlyspent() {
	}

	public CustomermonthlyspentPK getId() {
		return this.id;
	}

	public void setId(CustomermonthlyspentPK id) {
		this.id = id;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}