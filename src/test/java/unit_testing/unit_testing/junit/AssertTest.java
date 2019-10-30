package unit_testing.unit_testing.junit;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AssertTest {
	
	@Test
	public void testAssertions() throws Exception{
		
		Dummy d1 = new Dummy(5);
		Dummy d2 = new Dummy(5);
		//d1=d2; //dersek same olur
		//assertEquals(d1, d2);//object classının equals ile test eder
		//assertSame("d1 d2 ye eşit olması gerek", d1,d2); // equals methoduna bakmaz, aynı mı diye bakar
	
	   // assertNull(d1);
		//assertNotNull(d1);
		
		//assertTrue(d1 == null);
		//assertTrue(d1.equals(d2));
		
		String[] arr1 = new String[] {"1","2"};
		String[] arr2 = new String[] {"1","2"};
		
		assertEquals(d1,d2);
		
		assertArrayEquals(arr1,arr2);
				
	}

	private static class Dummy{
		
		private int id;
		
		Dummy(int id){
			this.id = id;
		}

		public int getId() {
			return id;
		}
		
		@Override
		public boolean equals(Object obj) {
			return this.id == ((Dummy) obj).getId();
		}
	
	}
}
