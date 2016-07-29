package util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Currency;

public class ReadFileCurrency {
	
	public static String FILE_DIR = "C://";
	public static String EXTENSION_FILE = ".csv";
	
	public static List<Currency> loadByFile(String fileName){
		
		Scanner scanner = null;
		List<Currency> list = new ArrayList<>();
		try {
			File file = new File(FILE_DIR + fileName + EXTENSION_FILE);
			if (file.exists()){
				scanner = new Scanner(file);
				scanner.useDelimiter(";|\\n");
				while (scanner.hasNext()) {
					Currency currency = new Currency();
					currency.setDataCurrency(scanner.next());
					currency.setCodMoeda(scanner.next());
					currency.setTipo(scanner.next());
					currency.setMoeda(scanner.next());
					currency.setTaxaCompra(scanner.nextBigDecimal());
					currency.setTaxaVenda(scanner.nextBigDecimal());
					scanner.next();
					scanner.next();
					list.add(currency);
				}	
			} else{
				throw new Exception("Error. " + file.getAbsolutePath() + " File not found. (quotation file date is not available)");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
		
		return list;
	}
}


