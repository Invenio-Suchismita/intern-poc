package com.training.poc;

public class lineitem {
	private String recordType;
    private int lineNumber;
    private String refDocNum;
    @Override
	public String toString() {
		return "lineitem [recordType=" + recordType + ", lineNumber=" + lineNumber + ", refDocNum=" + refDocNum
				+ ", city=" + city + ", amount=" + amount + "]";
	}
	public lineitem(String recordType, int lineNumber, String refDocNum, String city, double amount) {
		super();
		this.recordType = recordType;
		this.lineNumber = lineNumber;
		this.refDocNum = refDocNum;
		this.city = city;
		this.amount = amount;
	}
	private String city;
    private double amount;
	public String getRecordType() {
		return recordType;
	}
	public void setRecordType(String recordType) {
		this.recordType = recordType;
	}
	public int getLineNumber() {
		return lineNumber;
	}
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	public String getRefDocNum() {
		return refDocNum;
	}
	public void setRefDocNum(String refDocNum) {
		this.refDocNum = refDocNum;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

}
