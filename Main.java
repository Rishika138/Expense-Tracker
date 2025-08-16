package com.exp_tracker;

import com.exp_tracker.service.TransactionService;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		TransactionService service = new TransactionService();
		
		int choice;
		
		do {
            System.out.println("\n<---------------- Expense Tracker Menu: ---------------->\n");
            
            service.displaySummary();
            
            System.out.println("1. Add Transaction");
            System.out.println("2. View Transactions");
            System.out.println("3. Update Transaction");
            System.out.println("4. Delete Transaction");
            System.out.println("5. Export to JSON");
            System.out.println("6. Exit");
            
            System.out.print("\n==> Choose: ");
            choice = sc.nextInt();	
            
            switch (choice) {
	            case 1 -> service.addTransaction();
	            case 2 -> service.viewTransactions();
	            case 3 -> service.updateTransaction();
	            case 4 -> service.deleteTransaction();
	            case 5 -> service.exportToJSON();
	            case 6 -> System.out.println("\n==> Exiting...");
	            default -> System.out.println("\n==> Invalid choice");
	        }

		}
		while(choice != 7);
        
	}

}
