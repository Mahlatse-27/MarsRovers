import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class rover_within_bounds_Test {

	@Test
	void test1() {
		Program obj = new Program();
		
		Boolean result = obj.rover_within_bounds(5, 5, 3, 3);
		
		assertEquals(false, result);
	}
	
	@Test()
	void test2() {
		Program obj = new Program();
		
		Boolean result = obj.rover_within_bounds(5, 5, 6, 3);
		
		assertEquals(true, result);
	}

}
