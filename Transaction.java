package com.exp_tracker.model;

import java.sql.Date;

public class Transaction {
	
	private int T_id;
	private String T_title;
	private Double T_amt;
	private String T_type;
	private Date T_date;
	
	// Default Constructor
	public Transaction() {
	}
	
	// Constructor with all fields
	public Transaction(int t_id, String t_title, Double t_amt, String t_type, Date t_date) {
		super();
		T_id = t_id;
		T_title = t_title;
		T_amt = t_amt;
		T_type = t_type;
		T_date = t_date;
	}

	// Getters and Setters
	public int getT_id() {
		return T_id;
	}

	public void setT_id(int t_id) {
		T_id = t_id;
	}

	public String getT_title() {
		return T_title;
	}

	public void setT_title(String t_title) {
		T_title = t_title;
	}

	public Double getT_amt() {
		return T_amt;
	}

	public void setT_amt(Double t_amt) {
		T_amt = t_amt;
	}

	public String getT_type() {
		return T_type;
	}

	public void setT_type(String t_type) {
		T_type = t_type;
	}

	public Date getT_date() {
		return T_date;
	}

	public void setT_date(Date t_date) {
		T_date = t_date;
	}
	
	// toString() for printing
//	@Override
//	public String toString() {
//		
//		return "Transaction{" + 
//			   "id=" + T_id + 
//			   ", title=" + T_title + 
//			   ", amount=" + T_amt +
//			   ", type=" + T_type +
//			   ", date=" + T_date + "}" ;
//	}	
	
}
