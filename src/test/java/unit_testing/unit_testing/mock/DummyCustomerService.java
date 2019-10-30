package unit_testing.unit_testing.mock;

public interface DummyCustomerService {
	
	public void addCustomer(String customerName);
	
	public void removeCustomer(String customerName);

	public void updateCustomer(String customerName);

	public String getCustomer(String customerName);
}
