package com.exp_tracker.doa;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.*;
import java.util.*;

import com.exp_tracker.db.DBConnection;
import com.exp_tracker.model.Transaction;


public class TransactionDaoImpl implements TransactionDao {

	
	private static final int T_id = 0;



	//add
	public void addTransaction(Transaction tx) {
		
		//SQL query to insert a transaction record with 4 parameters
		String sql = "insert into transactions(T_title, T_amt, T_type, T_date) values (?, ?, ?, ?)";
		
		
		//Establish a DB connection and create a PreparedStatement
		try(Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql)){
			
			//Assign values from the Transaction object to the ? placeholders
			ps.setString(1, tx.getT_title());
			ps.setDouble(2, tx.getT_amt());
			ps.setString(3, tx.getT_type());
			ps.setDate(4, tx.getT_date());
			
			//inserts the record
			ps.executeUpdate();
			System.out.println("\n==> ✅ Transaction added successfully!\n");
			
		}
		//Any SQL exceptions are caught and printed
		catch(SQLException e) {
			 e.printStackTrace();
		}
	}
	
	
	
	
	//view
	public List<Transaction> getAllTransactions() {
		
		//Prepare to store all transactions in a List
		List<Transaction> list = new ArrayList<>();
		
		//SQL query fetches all records
		String sql = "select * from transactions";
		
		
		//Establish connection, create a Statement, execute the query
		try(Connection con = DBConnection.getConnection();
			Statement stmt = con.createStatement();
				
			//ResultSet holds the returned records
			ResultSet rs = stmt.executeQuery(sql)){
			
			while(rs.next()) {
				
				//Loop through ResultSet and map each row to a Transaction object
				Transaction tx = new Transaction();
				
				tx.setT_id(rs.getInt("T_id"));
                tx.setT_title(rs.getString("T_title"));
                tx.setT_amt(rs.getDouble("T_amt"));
                tx.setT_type(rs.getString("T_type"));
                tx.setT_date(rs.getDate("T_date"));
				
				//Add it to the list
				list.add(tx);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		//return the list at the end
		return list;
	}
	
	

	//update
	public void updatedTransaction(Transaction tx) {
		
		//SQL query updates the transaction based on its id
		String sql = "update transactions set T_title=?, T_amt=?, T_type=?, T_date=? where T_id=?";
		
		//Connection and PreparedStatement are created
		try(Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql)){
			
			//Set all updated values from the Transaction object, including the id for the WHERE clause
			ps.setString(1, tx.getT_title());
			ps.setDouble(2, tx.getT_amt());
			ps.setString(3, tx.getT_type());
			ps.setDate(4, tx.getT_date());
			ps.setInt(5, tx.getT_id());
			
			//Execute the update
			ps.executeUpdate();
			System.out.println("\n==> ✅ Transaction updated successfully.\n");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	

	//delete
	public void deleteTransaction(int id) {
		
		//SQL command to delete a transaction by id
		String sql = "delete from transactions where T_id=?";
		
		//Connection and PreparedStatement are created
		try(Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql)){
			
			//Set the id in the query
			ps.setInt(1, id);
			
			//run executeUpdate() to delete the record
			ps.executeUpdate();
			System.out.println("\n==> ✅ Transaction deleted successfully.\n");
		}
		catch(SQLException e) {
			e.printStackTrace();	
		}
	}
	
	

}
