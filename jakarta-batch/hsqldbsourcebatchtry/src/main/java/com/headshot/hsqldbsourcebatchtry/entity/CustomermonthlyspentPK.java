package com.headshot.hsqldbsourcebatchtry.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/**
 * 
 * @author nikheel.patel
 *
 */
@Embeddable
public class CustomermonthlyspentPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false)
	private long cid;

	@Column(unique=true, nullable=false)
	private LocalDateTime monthyear;

	public CustomermonthlyspentPK() {
	}
	public long getCid() {
		return this.cid;
	}
	public void setCid(long cid) {
		this.cid = cid;
	}
	public LocalDateTime getMonthyear() {
		return this.monthyear;
	}
	public void setMonthyear(LocalDateTime monthyear) {
		this.monthyear = monthyear;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CustomermonthlyspentPK)) {
			return false;
		}
		CustomermonthlyspentPK castOther = (CustomermonthlyspentPK)other;
		return 
			(this.cid == castOther.cid)
			&& this.monthyear.equals(castOther.monthyear);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.cid ^ (this.cid >>> 32)));
		hash = hash * prime + this.monthyear.hashCode();
		return hash;
	}
}