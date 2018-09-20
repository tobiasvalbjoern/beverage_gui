package beverage_gui;

import java.util.*;

public class Person {
	private String name;
	private HashMap<String,Integer> bill;
	public Person(){
		name=new String();
		bill=new HashMap<String,Integer>();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void addToBill(String beverage, int amount) {
	
		this.bill.put(beverage, amount);
	}
	
	
	public Double getBill() {
		Beverages beverage = new Beverages();
		
		Double price=0.0;
			for (String k : bill.keySet())
		        {   
				//obs this can be null, if k is a name not existing in the list
				Double priceBeverage=beverage.getBeveragePrice(k);
				Integer AmountBeverage=bill.get(k);
				Double AmountBeverageDouble=(double)(AmountBeverage.intValue());
				price+=priceBeverage*AmountBeverageDouble;
		        } 
			return price;
	}
}

