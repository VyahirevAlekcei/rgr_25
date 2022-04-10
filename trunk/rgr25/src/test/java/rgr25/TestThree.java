package rgr25;

import static org.junit.Assert.*;

import org.junit.Test;

import Calculator.Panel;


public class TestThree {
	Panel testingPanel1= new Panel();
	
	
	@Test
	public void test() {
		
		testingPanel1.setS(-1);
		testingPanel1.setP(-1);
		testingPanel1.setM(-1);
		assertNotNull(testingPanel1.getResult());
	
	}

}