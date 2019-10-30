package unit_testing.unit_testing.assertj;

import exception.MailServerUnavailableException;
import unit_testing.unit_testing.Musteri;

public class NotificationService {
	
    public void sendWelcomeNotification(String customerName, String email) {
		
		System.out.println("Mail gönderildi");
		
	}
	
    public void haftalikMailGonder() {
    	 
    	     throw new MailServerUnavailableException("mail server hata veriyor");
    	  
    }

}
