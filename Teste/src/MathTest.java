import static org.junit.Assert.*;

import org.junit.Test;

public class MathTest {

	@Test
	public void testPI() {
		double pi;
		pi = new Math().PI();			
		assertEquals(new Double(pi), new Double(java.lang.Math.PI));		
	}
	
	@Test
	public void testPI2() {
		double pi;
		pi = new Math().PI();			
		assertEquals(new Double(pi), new Double(java.lang.Math.PI));	
	}	

}
