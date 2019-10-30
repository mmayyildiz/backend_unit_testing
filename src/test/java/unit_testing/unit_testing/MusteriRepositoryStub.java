package unit_testing.unit_testing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MusteriRepositoryStub extends MusteriRepository{
	
	//silmek için id ye ihtiyac olacagından map daha mantıklı
	private Map<Integer, Musteri> musteriListesi = new HashMap<Integer, Musteri>();
	
	@Override
	public void kaydet(Musteri musteri) {
		musteriListesi.put(musteri.getId(), musteri);
	}
	
	@Override
	public void sil(Integer musteriId) {
		musteriListesi.remove(musteriId);
	}
	
	@Override
	public Musteri bul(Integer musteriId) {
		return musteriListesi.get(musteriId);
	}

	public void herseyiSil() {
		musteriListesi.clear();		
	}

//	public Map<Integer, Musteri> getMusteriListesi() {
//		return musteriListesi;
//	}

	
	
}
