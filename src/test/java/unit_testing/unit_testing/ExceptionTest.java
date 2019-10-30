package unit_testing.unit_testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import exception.MailServerUnavailableException;

public class ExceptionTest {
	
	private BilgilendirmeService bilgilendirmeService = new BilgilendirmeService();
	
	@Test
	public void testTryCatchException() {
		
		try {
			bilgilendirmeService.haftalikMailGonder();
		}catch(Exception ex) {
			 assertTrue(ex instanceof MailServerUnavailableException);
			 assertEquals("mail server hata veriyor", ex.getMessage());
		}
		
	}
	
	// dezavantajı hata mesajının ne oldugunu kontrol etme olanagımız yok 
	@Test(expected = MailServerUnavailableException.class)
	public void testExpectedException() throws Exception{
		bilgilendirmeService.haftalikMailGonder();
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testRuleException() throws Exception{
		thrown.expect(MailServerUnavailableException.class);
		thrown.expectMessage("mail server hata veriyor");
		
		bilgilendirmeService.haftalikMailGonder();
	}
	
	@Test
	public void testCatchExceptionFramework() throws Exception{
		//???
	 //	catchException(bilgilendirmeService).haftalikMailGonder();
     // assertTrue(caughtException() instanceof MailServerUnavailableException);
    //	assertEquals("mail server hata veriyor", caughtException().getMessage());
	}
	
}
