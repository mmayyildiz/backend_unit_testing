package unit_testing.unit_testing.assertj;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import junit.framework.Assert;
import unit_testing.unit_testing.assertj.custom.CustomerAssert;

public class CustomerAssertTest {

	private CustomerRepository customerRepository;
	private NotificationService notificationService;
	private CustomerService customerService;
	
	public static final String USERNAME = "meltem";
	public static final String EMAIL = "m@m.com";
	
	@Before
	public void setUp() throws Exception{
		customerService = new CustomerService();
		customerRepository = Mockito.mock(CustomerRepository.class);
	    notificationService = Mockito.mock(NotificationService.class);
	    
	    customerService.setCustomerRepository(customerRepository);
	    customerService.setNotificationService(notificationService);
	    
	}
	
	@Test
	public void testCustomAssertJUnit() throws Exception{

		Customer customer = customerService.handleNewCustomer(USERNAME, EMAIL);
		
		Mockito.verify(customerRepository).save(Mockito.any(Customer.class)); //customer);
		Mockito.verify(notificationService).sendWelcomeNotification(USERNAME, EMAIL);
		Assert.assertNotNull(customer.getGifts());
		Assert.assertEquals(2, customer.getGifts().size());
		Assert.assertEquals("welcome1",customer.getGifts().get(0).getName());
		Assert.assertEquals("welcome2",customer.getGifts().get(1).getName());

		
	}
	
	
	@Test 
	public void testCustomAssert() throws Exception{
	   Customer customer = customerService.handleNewCustomer(USERNAME, EMAIL);
	   assertThatCustomer(customer)
	                    .isSaved()
	                    .hasReceivedNotification()
	         	        .hasGifts(2)
	         	        .hasGiftWithName("welcome1")
	         	        .hasGiftWithName("welcome2");
	}
	
	private CustomerAssert assertThatCustomer(Customer customer) {
		return new CustomerAssert(customer, CustomerAssert.class, customerRepository, notificationService);
	}
}
