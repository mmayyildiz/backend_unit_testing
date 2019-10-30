package unit_testing.unit_testing.mock;

import org.junit.Test;
import static org.mockito.Mockito.*;

public class SpyTest {
	
	@Test
	public void testSpy() throws Exception{
		// gercek nesnenin casuslugunu yapıyori spy her zaman gerçek nesneyi cagırır
		DummyCustomerServiceImpl service = spy(new DummyCustomerServiceImpl());
		
		//ama mock davranısı verebiliriz
		doNothing().when(service).addCustomer(eq("istanbul"));
		doThrow(new IllegalArgumentException()).when(service).removeCustomer(anyString());
		
		doNothing().when(service).removeCustomer("istanbul1");
		doNothing().when(service).removeCustomer("istanbul2");
		//istanbul3 için gerçek nesneyi kullan
		doCallRealMethod().when(service).removeCustomer("istanbul3"); // bunu yorum yapsak ta 

		//default olarak spy nesnesi gerçek nesneyi çagırı
		service.removeCustomer("istanbul1");
		service.removeCustomer("istanbul2");
		service.removeCustomer("istanbul3"); // bunu ekrana yazdırır 

		//service.addCustomer("istanbul"); // hiç bir şey yapmaz
		//service.addCustomer("ankara"); // ekrana yazdırır
		//service.removeCustomer("*****");//exception atar
	}

}
