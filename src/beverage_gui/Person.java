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
		try {
		this.bill.put(beverage, amount);
		}catch(NullPointerException np){
			
		}
	}
	
	public Double getBill() {
		Beverages beverage = new Beverages();
		Double price=beverage.calculateBill(bill);
		return price;
	}
	
	
	
}
