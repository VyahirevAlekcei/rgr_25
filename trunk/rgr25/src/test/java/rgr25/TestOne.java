package rgr25;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import Calculator.Panel;


public class TestOne {
	Panel testingPanel1= new Panel();
	
	
	@Test
	public void test() {
		
		testingPanel1.setS(2000000);
		testingPanel1.setP(12);
		testingPanel1.setM(15);
		assertTrue(testingPanel1.getResult() ==2.4E7 );
	
	}

}
