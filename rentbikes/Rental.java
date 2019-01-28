package com.intivefdv.backend;

interface Rental {
	public boolean checkInfo();
	public void calculateFee();
	public Double getFee();
	public Integer getQty();
}
