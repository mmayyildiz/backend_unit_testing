package unit_testing.unit_testing.junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class YasamDongusuTest {

	// methodlar ile alakalı değil, sadece sınıf için oldukları için static
	@BeforeClass
	public static void beforeCls() throws Exception {
		System.out.println("Her test sinifi icin - oncesi");
	}
	
	@AfterClass
	public static void afterCls() throws Exception {
		System.out.println("Her test sinifi icin - sonrasi");
	}
	
	@Before
	public void setUp() throws Exception {
		System.out.println("Method öncesi");
	}
	
	@After
	public void tearDown() throws Exception {
		System.out.println("Method sonrası");
	}
	
	@Test
	public void testHelloWorld1() throws Exception {
		System.out.println("Test Hello World 1");
	}
	
	@Test
	public void testHelloWorld2() throws Exception {
		System.out.println("Test Hello World 2");
	}
	

}
