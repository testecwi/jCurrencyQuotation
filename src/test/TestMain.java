package test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

import controller.CurrencyController;

public class TestMain {
	
	public static void main(String[] args) throws  Exception {
		try {  
		    
			String from = "";
			String to = "";
			String value = "";
			String date = "";
			
			 BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	        
			 System.out.print("Please enter Currency Cod. From : ");
			 from = reader.readLine();
	        
			 System.out.print("Please enter Currency Cod. To : ");
			 to = reader.readLine();
			 
			 System.out.print("Please enter Currency value: ");
			 value = reader.readLine();
			 
			 System.out.print("Please enter Currency Date (formatter: dd/MM/yyyy): ");
			 date = reader.readLine();
			
			Double doubleValue = null;
			try {
				 doubleValue =  new Double(value);
			} catch (Exception e) {
				throw new Exception("Invalid Currency Value !");
			}
		   
		    CurrencyController controller = new CurrencyController();
		    BigDecimal valueQuotation = controller.currencyQuotation(from, to,doubleValue, date);
		    System.out.println("Quotation Result: " + valueQuotation);

		} catch (IOException exception) {  
		    exception.printStackTrace(); 
		}  
	}

}
