package TDD;

import org.junit.*;
import static org.junit.Assert.*;

public class TestFunction {
	@Test
	public void checkIfEmpty() {
		assertEquals("0",AddFunction.add(""));
	}
	
	@Test
	public void singleNumber() {
		assertEquals("1",AddFunction.add("1"));
	}
	
	@Test 
	public void sumOfTwoNumbers() {
		assertEquals("3.3",AddFunction.add("1.1,2.2"));
	}
}
