package com.training.poc;

public class header {
	private String recordType;
    @Override
	public String toString() {
		return "header [recordType=" + recordType + ", totalLines=" + totalLines + ", totalAmt=" + totalAmt
				+ ", minAmt=" + minAmt + ", currentDate=" + currentDate + "]";
	}
	public header(String recordType, int totalLines, double totalAmt, int minAmt, String currentDate) {
		super();
		this.recordType = recordType;
		this.totalLines = totalLines;
		this.totalAmt = totalAmt;
		this.minAmt = minAmt;
		this.currentDate = currentDate;
	}
	private int totalLines;
    private double totalAmt;
    private int minAmt;
    private String currentDate;
	public String getRecordType() {
		return recordType;
	}
	public void setRecordType(String recordType) {
		this.recordType = recordType;
	}
	public int getTotalLines() {
		return totalLines;
	}
	public void setTotalLines(int totalLines) {
		this.totalLines = totalLines;
	}
	public double getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(double totalAmt) {
		this.totalAmt = totalAmt;
	}
	public int getMinAmt() {
		return minAmt;
	}
	public void setMinAmt(int minAmt) {
		this.minAmt = minAmt;
	}
	public String getCurrentDate() {
		return currentDate;
	}
	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}

}
