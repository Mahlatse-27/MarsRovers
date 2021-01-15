import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class movement_of_rover_Test {

	@Test
	void test1() {
		Program obj = new Program();
		
		String[] rover_pos = {"1", "2", "N" };
		String result = obj.movement_of_rover(5, 5, rover_pos , "LMLMLMLMM");
		
		assertEquals("1 3 N", result);
	}
	
	@Test()
	void test2() {
		Program obj = new Program();
		
		String[] rover_pos = {"3", "3", "E" };
		String result = obj.movement_of_rover(5, 5, rover_pos , "LMLMMMMMLMM");
		
		assertEquals("Rover Out Of Bounds", result);
	}
}
