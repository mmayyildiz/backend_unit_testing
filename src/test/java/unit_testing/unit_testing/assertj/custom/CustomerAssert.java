package unit_testing.unit_testing.assertj.custom;
import unit_testing.unit_testing.assertj.Customer;
import unit_testing.unit_testing.assertj.CustomerAssertTest;
import unit_testing.unit_testing.assertj.CustomerRepository;
import unit_testing.unit_testing.assertj.NotificationService;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.AbstractAssert;
import org.mockito.Mockito;

public class CustomerAssert extends AbstractAssert<CustomerAssert, Customer>{

	private CustomerRepository customerRepository;
    private NotificationService notificationService;
    
	public CustomerAssert(Customer actual, Class<?> selfType, CustomerRepository customerRepository, NotificationService notificationService) {
		super(actual, selfType);
		this.customerRepository = customerRepository;
		this.notificationService = notificationService;
		isNotNull();
	}

	//return olarak kendisini vermeli ki akış olarak çalışsın
	public CustomerAssert hasGifts(int sizeOfGifts) {
		// actual en başta verdiğimiz customer nesnesidir.
		assertThat(actual.getGifts())
		        .isNotEmpty()
		        .hasSize(sizeOfGifts);
		
		return this;
	}
	
	
	public CustomerAssert hasGiftWithName(String giftName) {
			
			assertThat(actual.getGifts())
			        .isNotEmpty()
			        .extracting("name")
			        .contains(giftName);
			
			return this;
	}

	public CustomerAssert isSaved() {
		Mockito.verify(customerRepository).save(Mockito.any(Customer.class));
		return this;
	}
	
	public CustomerAssert hasReceivedNotification() {
		Mockito.verify(notificationService).sendWelcomeNotification(CustomerAssertTest.USERNAME, CustomerAssertTest.EMAIL);
		return this;
	}
}
