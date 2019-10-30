package unit_testing.unit_testing.assertj;

import unit_testing.unit_testing.Musteri;


public class CustomerRepository {

	public void save(Customer customer) {
		System.out.println("Oracle DB kaydedildi");
	}
	
	public void sil(Integer musteriId) {
		System.out.println("Oracle DB musteri silindi");
	}
	
	public Musteri bul(Integer musteriId) {
		System.out.println("Oracle DB bul");
		return null;
	}
	
}
