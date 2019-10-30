package unit_testing.unit_testing.assertj;

import org.assertj.core.api.Condition;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CustomerTest {
	List<String> turkSehirlerListesi = new ArrayList<String>(Arrays.asList("Istanbul", "Izmir", "Ankara"));
	List<String> yabanciSehirlerListesi = new ArrayList<String>(Arrays.asList("Amsterdam", "Paris", "Londra"));
	
	@Test
	public void testString() throws Exception{
		
		String text1 = "Istanbul";
		
	    assertThat(text1)
	             .describedAs("bu bir hata")
	             .isEqualTo("Istanbul")
	             .startsWith("Ist")
	             .endsWith("bul")
	             .contains("tan")
	             .isNotEmpty()
	             .isNotNull()
	             .doesNotContain("Meltem")
	             .containsOnlyOnce("tand");
        
		
	}

	
	@Test
	public void testDuzListeler() throws Exception{
		
		List<String> sehirler = new ArrayList<String>(Arrays.asList("Istanbul", "Izmir", "Ankara"));

		assertThat(sehirler)
		      .describedAs("bu br hata")
		      .contains("Ankara")
		      .doesNotContain("Bursa")
		      .containsExactly("Istanbul", "Izmir", "Ankara")
		      .doesNotHaveDuplicates();
		
		List<String> sehirler2 = new ArrayList<String>(Arrays.asList("Istanbul", "Izmir", "Ankara"));

		assertThat(sehirler2)
		        .have(turkSehirleri());
		
		List<String> sehirler3 = new ArrayList<String>(Arrays.asList("Amsterdam", "Paris", "Londra"));

		assertThat(sehirler3)
		        .have(yabanciSehirler());
		
		List<String> sehirler4 = new ArrayList<String>(Arrays.asList("Amsterdam","Istanbul", "Paris", "Izmir","Londra"));

		assertThat(sehirler4)
		      .haveExactly(2, turkSehirleri())
		      .haveExactly(3, yabanciSehirler());
	}
	
	private Condition<? super String> turkSehirleri(){
		return new Condition<String>(){
			@Override
			public boolean matches(String s) {
				return turkSehirlerListesi.contains(s);
			}
		};
	}
	
	private Condition<? super String> yabanciSehirler(){
		return new Condition<String>(){
			@Override
			public boolean matches(String s) {
				return yabanciSehirlerListesi.contains(s);
			}
		};
	}
	
}
