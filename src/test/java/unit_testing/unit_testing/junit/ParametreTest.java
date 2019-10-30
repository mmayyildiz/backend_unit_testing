package unit_testing.unit_testing.junit;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import unit_testing.unit_testing.HesapMakinesi;

@RunWith(Parameterized.class)
public class ParametreTest {
	
	private HesapMakinesi hesapMakinesi = new HesapMakinesi();
	
	@Parameterized.Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
			{10,2,20},
			{20,2,40},
			{5,2,10},
			{24,2,48},
			{6,2,12}});
	}
	
	
	private int eni;
	private int boyu;
	private int toplamMetreKare;
	
	public ParametreTest(int eni, int boyu, int toplamMetreKare) {
		this.eni = eni;
		this.boyu = boyu;
		this.toplamMetreKare = toplamMetreKare;
	}
	
	
	@Test
	public void testMetreKareHesapla() throws Exception {
		
	    assertEquals(toplamMetreKare, hesapMakinesi.metreKareHesapla(eni,boyu));
//		assertEquals(40, hesapMakinesi.metreKareHesapla(20,2));
//		assertEquals(10, hesapMakinesi.metreKareHesapla(5,2));
//		assertEquals(48, hesapMakinesi.metreKareHesapla(24,2));
//		assertEquals(12, hesapMakinesi.metreKareHesapla(6,2));
		
	}
	
	

}
