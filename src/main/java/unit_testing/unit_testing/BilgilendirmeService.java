package unit_testing.unit_testing;

import exception.MailServerUnavailableException;

public class BilgilendirmeService {

	public void yeniKayitMailGonder(Musteri musteri) {
		
		System.out.println("Mail gönderildi");
		
	}
	
    public void haftalikMailGonder() {
    	 
    	     throw new MailServerUnavailableException("mail server hata veriyor");
    	  
    }
}
