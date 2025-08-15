package com.jaehyeon2.be.beans.model;

import java.util.Date;

public class BasicModel {

	private Date insertTime;
	private Date updateTime;
	
	public Date getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
