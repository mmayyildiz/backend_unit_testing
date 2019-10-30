package unit_testing.unit_testing;

public class MusteriService {

	private MusteriRepository musteriRepository;
	
	private BilgilendirmeService bilgilendirmeService;
	
	public void musteriKaydet(Musteri musteri) {
		musteriRepository.kaydet(musteri);
		bilgilendirmeService.yeniKayitMailGonder(musteri);
		
	}

	public void setMusteriRepository(MusteriRepository musteriRepository) {
		this.musteriRepository = musteriRepository;
	}

	public void setBilgilendirmeService(BilgilendirmeService bilgilendirmeService) {
		this.bilgilendirmeService = bilgilendirmeService;
	}
	
	public void musteriSil(Integer musteriId) {
		musteriRepository.sil(musteriId);
	}
	
}
