package unit_testing.unit_testing;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import junit.framework.Assert;

public class HesapMakinesiTest {
	
	@Test
	public void testTopla() {
		//on hazirlik // GIVEN
		HesapMakinesi hesapMakinesi = new HesapMakinesi();
		int sayi1 = 5;
		int sayi2 = 19;
		
		//methodu calistir // WHEN
		int toplam = hesapMakinesi.topla(sayi1, sayi2);
		
		//sonucu kontrol et // THEN
		Assert.assertEquals(24,toplam);
	}
	
	//amacımız her test methodunun içinde yalnız bir methodu test etmektir.
	@Test
	//@Ignore("Bu method daha sonra kullanilacak")
	public void testCikart() {
		
		HesapMakinesi hesapMakinesi = new HesapMakinesi();
		
		//ilk hatadan dolayı test birden durur son 2 test çalışmaz, bu sebeple her bir senoryoyu farklı 
		//bir test methodu içine eklemek gerek
		assertEquals(15, hesapMakinesi.cikart(15, 0));

	}
	
	@Test
	public void testSifirdanCikincaEksiOlur() throws Exception{
		
		HesapMakinesi hesapMakinesi = new HesapMakinesi();
		
		assertEquals(-15, hesapMakinesi.cikart(0,15));
		
	}
	
	@Test
	public void testSayidanAyniSayiCikincaSifirKalir() throws Exception{
		
		HesapMakinesi hesapMakinesi = new HesapMakinesi();
		
		assertEquals(0, hesapMakinesi.cikart(15,15));
		
	}
	

	
}
