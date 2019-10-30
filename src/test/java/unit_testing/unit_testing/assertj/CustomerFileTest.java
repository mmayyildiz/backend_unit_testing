package unit_testing.unit_testing.assertj;

import java.io.File;

import org.junit.Test;

import exception.MailServerUnavailableException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.contentOf;

public class CustomerFileTest {

	@Test
	public void testFiles() throws Exception{
		
		//dosya nerede ?????
		File file = new File("test.txt");
		
		assertThat(file)
			.exists()
			.canRead()
			.canWrite()
			.hasExtension(".txt")
			.hasName("test.txt");
		
		assertThat(contentOf(file))
		        .startsWith("Lorem");
	}
	
	@Test
	public void testException() throws Exception{
		
		Exception exception = new MailServerUnavailableException("this is a test");
		
		assertThat(exception)
		        .hasMessage("this is a test")
		        .isInstanceOf(MailServerUnavailableException.class)
		        .hasMessageContaining("is a");
		
		
		
	}
}
