package beverage_gui;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;

public class TestBeverageGUI {
	
	Person person=new Person();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testName() {
		
		String testname="Tobias";
		person.setName(testname);
		String name=person.getName();
		assertEquals(name, testname);
		//testBeverage();
	}
	
	@Test
	public void testBeverages() {
		HashMap<String,Integer> beverage = new HashMap<String,Integer>(); 
	    beverage.put("Øl", 5);
	  
	    person.setBeverages(beverage);
	    HashMap<String,Integer> beverageTest=person.getBeverages();
	    //HashMap<String,Integer> fail=new HashMap<String,Integer>();
	    //fail.put("fejl", 0);
	    assertEquals(beverage, beverageTest);
	}
	
}

