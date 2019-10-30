package unit_testing.unit_testing.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import unit_testing.unit_testing.HesapMakinesi;

@RunWith(JUnitParamsRunner.class)
public class AssertKolayTest {

	private HesapMakinesi hesapMakinesi = new HesapMakinesi();
	
	@Test
	@Parameters({"10,2,20","20,3,60"})
	public void testMetreKareHesaplama(int eni, int boyu, int toplamMetreKare) throws Exception{
		assertEquals(toplamMetreKare, hesapMakinesi.metreKareHesapla(eni, boyu));
	}
}
