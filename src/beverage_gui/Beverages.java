package beverage_gui;

import java.util.HashMap;
import java.util.Set;

public class Beverages {
	private HashMap<String,Double> PriceBeverage;
	
	public Beverages() {
		PriceBeverage=new HashMap<String,Double>();
		PriceBeverage.put("øl", 10.0);
		PriceBeverage.put("vin", 12.5);
		PriceBeverage.put("sodavand", 5.25);
		PriceBeverage.put("vodka", 10.0);
	}
	
	public Double getBeveragePrice(String beverage) {
		Double price = 0.0;
		price=PriceBeverage.get(beverage);
		return price;
	}   

	public void changeBeveragePrice(String beverage, int amount) {
		PriceBeverage.put(beverage, (double)amount);
	}
	
	public void addBeverage(String beverage, double amount) {
		PriceBeverage.put(beverage, amount);
		
	}

	public Set<String> getBeverageKeys() {
		return PriceBeverage.keySet();
	}

	public void removeBeverage(String beverage) {
		PriceBeverage.remove(beverage);
	}
	
}


