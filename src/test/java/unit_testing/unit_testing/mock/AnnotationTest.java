package unit_testing.unit_testing.mock;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import unit_testing.unit_testing.assertj.CustomerRepository;
import unit_testing.unit_testing.assertj.CustomerService;
import unit_testing.unit_testing.assertj.NotificationService;

@RunWith(MockitoJUnitRunner.class)
public class AnnotationTest {
	
	//@Mock
	//private DummyCustomerService dummyCustomerService;
	@Spy
	private DummyCustomerServiceImpl dummyCustomerService;
	
	@InjectMocks
	private CustomerService customerService; // setup methoduna ihtiyac kalmadı
	
	@Mock
	private CustomerRepository customerRepository;
	
	@Mock
	private NotificationService notificationService;
	
//Mock gelince gerek kalmadı
//    @Before
//    public void setUp() throws Exception{
//    	   dummyCustomerService = Mockito.mock(DummyCustomerService.class);
//    }
//	
	
//   @Before
//    public void setUp() throws Exception{
//  	    customerService = new CustomerService();
//  	    customerService.setCustomerRepository(customerRepository);
//  	    customerService.setNotificationService(notificationService);
//    }
	
	@Test
	public void testAnnotation() throws Exception {
		//dummyCustomerService.addCustomer("istanbul");
		customerService.handleNewCustomer("name", "email");
	}

}
