package beverage_gui.test;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import beverage_gui.Person;

public class TestBeverageGUI {
	
	private Person person;
	
	@Before
	public void setUp() throws Exception {
	person=new Person();	
	}

	@After
	public void tearDown() throws Exception {
	person=null;
	}

	@Test
	public void testName() {
		
		String testname="Tobias";
		person.setName(testname);
		String name=person.getName();
		assertEquals(name, testname);
	}
		
	@Test
	public void testBeverages() {
	    person.addToBill("øl",5);
	    Double price=person.getBill();
	    Double priceTest=50.0;
	    assertEquals(priceTest,price );
	}
	
	@Test
	public void testUpdateBeverages() {
	    person.addToBill("øl",5);
	    person.addToBill("øl",7);
	    Double price=person.getBill();
	    Double priceTest=70.0;
	    assertEquals(priceTest,price );
	}
	
	@Test
	public void testSeveralBeverages() {
	    person.addToBill("øl",5);
	    person.addToBill("vin",7);
	    person.addToBill("vodka", 1);
	    person.addToBill("sodavand",3);
	    Double price=person.getBill();
	    Double priceTest=10.0*5.0+7.0*12.5+1.0*10.0+3.0*5.25;
	    assertEquals(priceTest,price );
	}
	
	@Test
	public void testUpdateSeveralBeverages() {
		person.addToBill("øl",2);
		person.addToBill("øl",5);
		person.addToBill("vin",3);
		person.addToBill("vin",7);
		person.addToBill("vodka", 0);
		person.addToBill("vodka", 1);
		person.addToBill("sodavand",1);
		person.addToBill("sodavand",3);
	    Double price=person.getBill();
	    Double priceTest=10.0*5.0+7.0*12.5+1.0*10.0+3.0*5.25;
	    assertEquals(priceTest,price );
	}
}


