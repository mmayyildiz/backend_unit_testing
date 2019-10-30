package unit_testing.unit_testing.mock;

import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito.*;

import static org.mockito.Mockito.*;

public class BehaviourTest {

	@Test
	public void testBehavior() throws Exception{
		
		DummyCustomerService customerService = mock(DummyCustomerService.class);
		
		customerService.addCustomer("istanbul");
		customerService.addCustomer("ankara");
		
		// servisin istanbul parametresi ile cagırılıp cagırılmadını dogrulatıyoruz
		verify(customerService).addCustomer("istanbul");
		verify(customerService).addCustomer("ankara");
		
		

	}
	
	@Test
	public void testKacKereCagirildi() throws Exception {
		DummyCustomerService customerService = mock(DummyCustomerService.class);

		customerService.addCustomer("istanbul");
		customerService.addCustomer("istanbul");
		customerService.addCustomer("ankara");
		customerService.addCustomer("istanbul");
		
		// kac kere cagırıldıgını dogruluyoruz
		verify(customerService, times(3)).addCustomer("istanbul");
		verify(customerService, times(1)).addCustomer("ankara"); // times default 1
		
		// hiç bir şekilde çagırılmadıgını dogrulatalım, parametre farketmeksizin
		verify(customerService, never()).removeCustomer(anyString());
		
		verify(customerService, never()).removeCustomer("izmir");

		//en az 2 defa cagirildi
		verify(customerService, atLeast(2)).addCustomer("istanbul");
 
	}
	
	@Test
	public void testSirasiniKontrolEt() throws Exception{
		//verildiği sırada cagirilsin
        DummyCustomerService customerService = mock(DummyCustomerService.class);
		
		customerService.addCustomer("istanbul");
		customerService.addCustomer("ankara");
		customerService.updateCustomer("izmir");
		
		InOrder inOrder = inOrder(customerService); // istediğimiz kadar mock nesnesi verebiliriz
		
		inOrder.verify(customerService).addCustomer("istanbul");  //1
		inOrder.verify(customerService).addCustomer("ankara");    //2
		inOrder.verify(customerService).updateCustomer("izmir");  //3

	}
	
	@Test
	public void testBaskaKontrolYok() throws Exception{
		
		DummyCustomerService customerService = mock(DummyCustomerService.class);
		DummyCustomerService customerService2 = mock(DummyCustomerService.class);

		customerService.addCustomer("istanbul");
		customerService.removeCustomer("ankara");
		//customerService.addCustomer("izmir"); // test hata alır
		customerService2.addCustomer("izmir");
		
		verify(customerService).addCustomer("istanbul");
		verify(customerService).removeCustomer("ankara");
		
		verifyNoMoreInteractions(customerService); // baska cagirilma olmasın, sadece verdiklerim

		verifyZeroInteractions(customerService2); //  bu mock nesnesi hiç cagirilmasın

	}
}
