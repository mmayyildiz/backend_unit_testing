package unit_testing.unit_testing.assertj;

import org.junit.Test;

public class LombokTest {

	
	@Test
	public void testLombok() throws Exception{
		
		Gift gift = Gift.builder().name("Meltem").build();//new Gift("Meltem");
		System.out.println(gift.toString());
	}
}
