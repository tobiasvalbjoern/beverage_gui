package beverage_gui;

import java.util.HashMap;

public class Beverages {
	private HashMap<String,Double> PriceBeverage;
	
	Beverages() {
		PriceBeverage=new HashMap<String,Double>();
		PriceBeverage.put("øl", 10.0);
		PriceBeverage.put("vin", 12.5);
		PriceBeverage.put("sodavand", 5.25);
		PriceBeverage.put("vodka", 10.0);
	}
	
	public Double calculateBill(HashMap<String,Integer> bill) {
		Double price=0.0;
		try {		
			for (String k : bill.keySet())
	        {   
	            Double priceBeverage=PriceBeverage.get(k);
	            Integer AmountBeverage=bill.get(k);
	            Double AmountBeverageDouble=(double)(AmountBeverage.intValue());
	            price+=priceBeverage*AmountBeverageDouble;
	            
	        } 
	         
	    } catch (NullPointerException np) { 
	    	
	    }
			
		return price;
	}
	
}
