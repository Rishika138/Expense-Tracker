package com.exp_tracker.service;
	

import com.exp_tracker.doa.*;
import com.exp_tracker.model.Transaction;
import com.exp_tracker.util.*;
	
import java.sql.Date;
import java.util.List;
import java.util.Scanner;
	
	
public class TransactionService {
		
		//This connects to your Data Access Object, which handles database operations
		private final TransactionDao dao = new TransactionDaoImpl();
		
		//A Scanner object used to get user input from the console
		private final Scanner sc = new Scanner(System.in);
		
		
		
		// ===== Utility: Message & Separator =====
	    private void printError(String message) {
	        System.out.println("\n==> ❌ " + message);
	        System.out.println("--------------------------------");
	        System.out.println("==> Try again.\n");
	    }
		
		
		// Reusable methods to get user input with prompt and validation
		private String promptNonEmpty() {
						
			String input;
			
			while(true) {
				System.out.print("Title: ");
				input = sc.nextLine().trim();
				if(!input.isEmpty()) {
					return input;
				}else {
					printError("Input cannot be empty.");
				}
			}
			
		}
		
		private double promptPositiveDouble() {
			
			while(true) {
				
				try{
					System.out.print("Amount: ");
					double val = Double.parseDouble(sc.nextLine().trim());
					if(val <= 0) throw new NumberFormatException();
					return val;
				}
				catch(NumberFormatException e) {
					
					printError("Please enter a valid positive number.");
					
				}
			}
		}
		
		private String promptType() {
			while(true) {
				System.out.print("Type (income/expense): ");
				String T_type = sc.nextLine().trim();
				if (T_type.equalsIgnoreCase("Income") || T_type.equalsIgnoreCase("Expense")) {
					return Character.toUpperCase(T_type.charAt(0)) + T_type.substring(1).toLowerCase();
				}else {
					printError("Type must be 'Income' or 'Expense'.");
				}
			}
		}
		
		
		private Date promptDate() {
			while(true) {
				try {
					System.out.print("Date (YYYY-MM-DD): ");
					return Date.valueOf(sc.nextLine().trim());
				}catch(IllegalArgumentException e) {
					printError("Invalid date format. Please use YYYY-MM-DD.");
				}
			}
		}
		
		
		
		
		
		
		public void displaySummary() {
	        List<Transaction> transactions = dao.getAllTransactions();
	        double totalIncome = 0;
	        double totalExpense = 0;

	        for (Transaction t : transactions) {
	            if (t.getT_type().equalsIgnoreCase("Income")) {
	                totalIncome += t.getT_amt();
	            } else if (t.getT_type().equalsIgnoreCase("Expense")) {
	                totalExpense += t.getT_amt();
	            }
	        }

	        double balance = totalIncome - totalExpense;
	        System.out.println("==========================================================================");
	        System.out.printf("Total Income: ₹%.2f | Total Expense: ₹%.2f | Balance: ₹%.2f%n",
	                totalIncome, totalExpense, balance);
	        System.out.println("==========================================================================\n");
	    }
	
		
		
		
		
		
		
		
		
		
		
		// ===== CRUD Methods =====
		//add
		public void addTransaction() {
			
			System.out.println("\n<-------------------------- Add a transaction: -------------------------->\n");
			
		    try {
		        String T_title = promptNonEmpty();
		        double T_amt = promptPositiveDouble();
		        String T_type = promptType();
		        Date T_date = promptDate();
		        
		        // Save to DB
		        Transaction t = new Transaction(0, T_title, T_amt, T_type, T_date);
		        dao.addTransaction(t);
		        

		    } catch (Exception e) {
		        System.out.println("==> ⚠️ Error while adding transaction: " + e.getMessage());
		        // Optionally log the full stack trace for debugging
		        e.printStackTrace();
		    }
		}

		
		
		
		
		//View
		public void viewTransactions() {
			
			System.out.println("\n<-------------------------- View Expense List: -------------------------->\n");
			
			//Fetches all transactions from the DB
			List<Transaction> list = dao.getAllTransactions();
			
			if (list.isEmpty()) {
				System.out.println("⚠️ No transactions found.");
			}else {
				//Prints each transaction to the console
				// Header
				System.out.printf("%-5s %-10s %10s %-10s %-15s%n", 
					    "ID", "Title", "Amount", "Type", "Date");

					System.out.println("----------------------------------------------------");

					for (Transaction tran : list) {
					    System.out.printf("%-5d %-10s %10.1f %-10s %-15s%n", 
					        tran.getT_id(),
					        tran.getT_title(),
					        tran.getT_amt(),
					        tran.getT_type(),
					        tran.getT_date().toString());
					}

					System.out.println("----------------------------------------------------");
					
			}
		}
		
		
		
		//update
		public void updateTransaction() {
			
			System.out.println("\n<-------------------------- Update a transaction: -------------------------->\n");
			
			//Asks user to enter the ID of the transaction to update
			System.out.print("Enter ID to update transaction: ");
			int T_id = Integer.parseInt(sc.nextLine());
			
			//Takes new values for all field			
			
			try {
				System.out.println("\nEnter details: ");
				
				String T_title = promptNonEmpty();
		        double T_amt = promptPositiveDouble();
		        String T_type = promptType();
		        Date T_date = promptDate();
				
				
		        //Sends the updated transaction to the DAO for updating in DB
		        dao.updatedTransaction(new Transaction(T_id, T_title, T_amt, T_type, T_date));
		        displaySummary();
		    
			} catch (Exception e) {
		        System.out.println("\n==> ⚠️ Error while adding transaction: " + e.getMessage());
		        // Optionally log the full stack trace for debugging
		        e.printStackTrace();
		    }
		}

	
		
		
		//delete
		public void deleteTransaction() {

			System.out.println("\n<-------------------------- Delete a transaction: -------------------------->\n");
					
			//Asks user to enter the ID to delete
			System.out.print("Enter ID to delete transaction: ");
			
			//Calls DAO method to delete it from the database\
			try {
	            int id = Integer.parseInt(sc.nextLine());
	            dao.deleteTransaction(id);
	            
	            displaySummary();
	            
	        } catch (NumberFormatException e) {
	            System.out.println("\n==> ❌ Invalid ID.");
	        }
				
		}
		
		
		
		
		
		//export to JSON
		public void exportToJSON() {
			
			//Gets all transactions from DB
		    List<Transaction> list = dao.getAllTransactions();
		    
		    if(list.isEmpty()) {
		    	System.out.println("\n==> ⚠️ No transactions to export.");
	            return;
		    }
		    
		  //Calls a method in JsonUtil to write that list into a file expense_data.json
		    boolean result = JsonUtil.exportToJSON(list, "expense_data.json");
	        if (result) {
	            System.out.println("\n==> ✅ Exported transactions to 'expense_data.json'.");
	        } else {
	            System.out.println("\n==> ❌ Failed to export data.");
	        }    
		    
		}
		
		
		
	}
