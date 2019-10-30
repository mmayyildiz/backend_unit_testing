package unit_testing.unit_testing.hamcrest;

import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

import static org.hamcrest.CoreMatchers.*;

public class HamcrestTest {

	@Test
	public void testTemelEslestirmeler() throws Exception{
		
		String text1 = "Meltem";
		String text2 = "Meltem2";
		
		Assert.assertEquals("Meltem", text1);
		
		assertThat(text1, is(equalTo("Meltem")));
		
		//assertThat(text1, is(nullValue()));
		
		assertThat(text1, containsString("tem"));
		
		assertThat(text1, anyOf(containsString("tem"),containsString("mel")));
	}
	
	@Test
	public void testListeler() throws Exception{
		
		List<String> sehirler = new ArrayList<String>(Arrays.asList("Istanbul", "Ankara", "Izmir"));
		
		assertThat(sehirler, hasItem("Istanbul"));
		
		assertThat(sehirler, hasItems("Istanbul","Izmir"));

		assertThat(sehirler, allOf(hasItems("Istanbul", "Izmir"), not(hasItem("Bursa"))));
		
		assertThat(sehirler, either(hasItems("Istanbul", "Izmir")).or(not(hasItem("Bursa"))));


	}
}
