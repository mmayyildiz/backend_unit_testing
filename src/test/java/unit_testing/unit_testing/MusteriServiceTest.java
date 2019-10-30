package unit_testing.unit_testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class MusteriServiceTest {
	
	private MusteriService musteriService;
	
    private MusteriRepositoryStub musteriRepository = new MusteriRepositoryStub();;
	
	private BilgilendirmeService bilgilendirmeService;
	
	@Before
	public void setUp() throws Exception{
	
		musteriService = new MusteriService();
		//musteriRepository = Mockito.mock(MusteriRepository.class);
		
		//afterdan sonra buna da gerek kalmadı o yuzden sınıf seviyesine çıkarırız
		//musteriRepository = new MusteriRepositoryStub();
		bilgilendirmeService = Mockito.mock(BilgilendirmeService.class);
		musteriService.setMusteriRepository(musteriRepository);
		musteriService.setBilgilendirmeService(bilgilendirmeService);
	}
	
	@After
	public void after(){
		musteriRepository.herseyiSil();
	}
	
	@Test
	public void testMusteriKaydet() {
		
		Musteri musteri = new Musteri(1234);
		
		musteriService.musteriKaydet(musteri);
		
		//testin db baglantısına gerek duymaması, izole çalışması gerekiyor mock ya da stub kullanılır
		//stub için ekstra sınıf eklemek gerek. mock daha çok tercih edilir. sahte nesne demek
		//verify kullanılarak herhangi bir nesnenin çagırılıp çagırılmadıgı kontrol edilir
		//yeniKayitMailGonder methodu çagırıldı mı müsteri aldı mı kontrol et
		//Mockito.verify(musteriRepository).kaydet(musteri);
//		assertTrue(musteriRepository.getMusteriListesi().containsValue(musteri));
	//	assertNotNull(musteriRepository.bul(musteri.getId()));
		
		assertEquals(musteri, musteriRepository.bul(musteri.getId()));
		Mockito.verify(bilgilendirmeService).yeniKayitMailGonder(musteri);
		
		 //afterdan sonra artık ihtiyac yok
		musteriRepository.sil(1234);
		
	}

	//test methodlarının çalışması sırası garanti değildir
	@Test
	public void testMusteriSil() {
		
		//testMusteriKaydet(); yanlıs
		
		// bunun çalışması için önce kaydetin çalışması gerektiğinden yanlış yaptık o yuzden şöyle yapalım
		//assertNotNull(musteriRepository.bul(1234));

		//kaydet methodunun dogru çalıştıgını varsaymamız gerkiyor, bu method baska bir methodda test ediliyor
		//yine de kaydet bundan önce calısırsa 2 kere kaydeder, ya da kaydette bir hata olursa silmeyi test edemez
		// bu yuzden stub sınıfının yapılandırmasını before a aldık, her methoda temiz başladı
		musteriService.musteriKaydet(new Musteri(1234));
		musteriService.musteriSil(1234);
		assertNull(musteriRepository.bul(1234));

		
		//Stub zahmetli. bizim test etmek istediğimiz işlem için gerekli olan sadece dış baglantıların dogru bir şekilde
		//çagırılıp çagırılmadıgıdır.
	}
	
	//Jenkins gibi bir build server kullanılarak tam otomatik bir şekilde testlerimiz çalıştırılabilir.
	
	
}
