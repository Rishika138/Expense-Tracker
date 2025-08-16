package com.exp_tracker.doa;

import java.util.List;
import com.exp_tracker.model.*;

public interface TransactionDao {
	
	//Adds a new transaction record to the database
	void addTransaction(Transaction transaction);
	
	//Fetches all transaction records from the database
	List<Transaction> getAllTransactions();
	
	//Updates an existing transaction in the database using the transaction's id
	void updatedTransaction (Transaction transaction);
	
	//Deletes a transaction from the database by its ID
	void deleteTransaction (int id);
	
}
