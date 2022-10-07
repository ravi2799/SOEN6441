package models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * @author  Raviraj Savaliya
 * @version 1.0
 */
public class RestfulServiceTest {
	@InjectMocks private  RestfulService restfulService;
	

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
	/**
	 * This method test the try_function of restful api that convert normal string into completable future
	 * @throws InterruptedException
	 * @throws ExecutionException
	 * @throws JsonProcessingException
	 * @throws InterruptedIOException
	 * @throws IOException
	 */
	@Test
	public void try_() throws InterruptedException, ExecutionException, JsonProcessingException,
	InterruptedIOException, IOException {
		String data = "Java";
		
		CompletableFuture<String> data_ = CompletableFuture.supplyAsync(( ) -> {
	        String data1 = data;
	        return data1;
	        });

		//when(restfulService.try_(any())).thenReturn(CompletableFuture.completedFuture(data));
		assertNotEquals(data_ , restfulService.try_("Java"));

		//verify(restfulService).try_("Java");
	}
}
