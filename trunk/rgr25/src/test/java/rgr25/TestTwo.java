package rgr25;

import static org.junit.Assert.*;

import org.junit.Test;

import Calculator.Panel;


public class TestTwo {
	Panel testingPanel2= new Panel();
	
	
	@Test
	public void test() {
		
		testingPanel2.setS(0);
		testingPanel2.setP(0);
		testingPanel2.setM(0);
		assertNull(testingPanel2.getDataAsString());
	
	}

}
