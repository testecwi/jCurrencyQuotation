package controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import model.Currency;
import util.ReadFileCurrency;

public class CurrencyController {

	
	private List<Currency> currenciesList = null;
	
	
	public BigDecimal currencyQuotation(String from, String to, Number value, String quotation) throws Exception{
		
		quotation = this.validateQuotationData(quotation);
		this.currenciesList = ReadFileCurrency.loadByFile(this.getFileNameData(quotation));
		
		Currency currencyFrom = this.findCurrency(from);
		if(currencyFrom == null) throw new Exception("Error. Invalid currency From !") ;
		Currency currencyTo = this.findCurrency(to);
		if (currencyTo == null)  throw new Exception("Error. Invalid currency TO !");
		
		BigDecimal valueCoverter = new BigDecimal(value.toString());
		if (valueCoverter.doubleValue() <= 0d )  throw new Exception("Error. Invalid currency Value. (the value must be greater than 0) !");
		valueCoverter = valueCoverter.multiply(currencyFrom.getTaxaVenda());
		valueCoverter = valueCoverter.divide(currencyTo.getTaxaVenda(),2, RoundingMode.HALF_DOWN);
		
		return valueCoverter;
	}
	
	
	private String validateQuotationData(String quotationData) throws Exception {
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date datequotation = new Date();
		try {
			datequotation = df.parse(quotationData);
		} catch (Exception e) {
			 throw new Exception("Error. Invalid currency date (correct formatter: dd/MM/yyyy) !");
		}
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(datequotation);
        
		if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
        	calendar.add(Calendar.DATE, -2);
        	} else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
        	calendar.add(Calendar.DATE, -1);
        	}
		quotationData = df.format(calendar.getTime());
		 return quotationData;
	}



	private Currency findCurrency(String currencyCod){
		
		for (Currency currency : this.currenciesList) {
			if (currency.getMoeda().equalsIgnoreCase(currencyCod)) 	return currency;
		}
		return null;
	}


	private String getFileNameData(String quotationData) throws Exception {
		
		if (quotationData != null && !quotationData.equals("") && quotationData.length() == 10){
			String day = quotationData.substring(0, 2);
			String mounth = quotationData.substring(3, 5);
			String year = quotationData.substring(6, 10);
			return year+mounth+day;
		} 
		throw new Exception("Error. Invalid currency date (correct formatter: dd/MM/yyyy) !");
	}



	
	public List<Currency> getCurrenciesList() {
		return currenciesList;
	}




	public void setCurrenciesList(List<Currency> currenciesList) {
		this.currenciesList = currenciesList;
	} 
	
	
	
}
