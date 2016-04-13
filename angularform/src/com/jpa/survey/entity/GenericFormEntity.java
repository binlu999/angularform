package com.jpa.survey.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

//@MappedSuperclass
public abstract class GenericFormEntity extends GenericEntity {
	@Column(name = "INACTIVE_FLAG")
	private boolean inactiveFlag;
	
	@Column(name = "INACTIVE_DATE")
	private Date inactiveDate;
	
	@Column(name = "LAST_UPDT_ID")
	private String lastUPDTId;
	
	@Column(name = "LAST_UPDT_DATE")
	private Date lastUPDTDate;

	public boolean isInactiveFlag() {
		return inactiveFlag;
	}

	public void setInactiveFlag(boolean inactiveFlag) {
		this.inactiveFlag = inactiveFlag;
	}

	public Date getInactiveDate() {
		return inactiveDate;
	}

	public void setInactiveDate(Date inactiveDate) {
		this.inactiveDate = inactiveDate;
	}

	public String getLastUPDTId() {
		return lastUPDTId;
	}

	public void setLastUPDTId(String lastUPDTId) {
		this.lastUPDTId = lastUPDTId;
	}

	public Date getLastUPDTDate() {
		return lastUPDTDate;
	}

	public void setLastUPDTDate(Date lastUPDTDate) {
		this.lastUPDTDate = lastUPDTDate;
	}
	
	
}
