package unit_testing.unit_testing.mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.internal.stubbing.answers.DoesNothing;

public class OnAsamaTest {
	
	@Test
	public void testWhen() throws Exception {
		
		DummyCustomerService service = mock(DummyCustomerService.class);
		when(service.getCustomer(anyString())).thenReturn("customerIstanbul");
		//ankara ile cagırılsa calışsmaz
		when(service.getCustomer(eq("istanbul"))).thenReturn("customerIstanbul");

		//hiç bir davranış belirtilmeyen mock nesneleri null döner
		String customer = service.getCustomer("istanbul");
		
	    assertThat(customer).isEqualTo("customerIstanbul");
	}
	
	@Test
	public void testWhen2() throws Exception {
		
		DummyCustomerService service = mock(DummyCustomerService.class);
		//ankara verilince exception atıyor
		when(service.getCustomer(eq("istanbul"))).thenThrow(new RuntimeException());
		
		String customer = service.getCustomer("istanbul");
		
	}

	@Test
	public void testWhen3() throws Exception {
		
		// void geri veren methodlar nasıl when kullanilir
		DummyCustomerService service = mock(DummyCustomerService.class);
		
		doNothing().when(service).addCustomer(anyString());
		doThrow(new RuntimeException()).when(service).addCustomer(anyString());
		
		doReturn("ankara").when(service).getCustomer("istanbul");
	}
}
