package com.exp_tracker.util;

//Standard Java I/O
import java.io.*;
import java.nio.charset.StandardCharsets;
//collection classes
import java.util.*;

//The model package used to store transaction data
import com.exp_tracker.model.Transaction;
//Main class from Jackson library used to convert Java objects to JSON and vice versa
import com.fasterxml.jackson.databind.ObjectMapper;
//Helps in reading generic types like List<Transaction> from JSON
import com.fasterxml.jackson.core.type.TypeReference;


//Declares a utility class JsonUtil
public class JsonUtil {
	
	
	//mapper is a static instance of ObjectMapper used for all JSON operations. 
	//Making it static and final avoids creating multiple instance
	private static final ObjectMapper mapper = new ObjectMapper().enable(com.fasterxml.jackson.databind.SerializationFeature.INDENT_OUTPUT);

	
	
	//Converts a list of Transaction objects into a JSON file

	public static boolean exportToJSON(List<Transaction> transactions, String filename) {
	    try {
	        File dir = new File("data");
	        if (!dir.exists()) {
	            boolean created = dir.mkdirs();
	            if (!created) {
	                System.out.println("\n==> ❌ Failed to create data directory.");
	                return false;
	            }
	        }

	        File file = new File(dir, filename); // Use data/ folder

	        // Write JSON with indentation
	        mapper.enable(com.fasterxml.jackson.databind.SerializationFeature.INDENT_OUTPUT);
	        mapper.writeValue(file, transactions);

	        System.out.println("Export to " + file.getAbsolutePath());
	        return true;
	    } catch (Exception e) {
	        System.out.println("\n==> ❌ Error during exportToJSON: " + e.getMessage());
	        e.printStackTrace();
	        return false;
	    }
	}

	
}
