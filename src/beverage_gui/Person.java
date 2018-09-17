package beverage_gui;

import java.util.*;

public class Person {
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HashMap<String,Integer> getBeverages() {
		return beverages;
	}
	public void setBeverages(HashMap<String,Integer> beverages) {
		this.beverages = beverages;
	}
	private HashMap<String,Integer> beverages;
	
	
}
