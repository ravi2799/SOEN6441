package helper;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import wrapper.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import models.RestfulService;

/**
 * @author Raviraj Savaliya
 * @version 1.0
 */

public class StatisticsHelperTest {
	@Mock
	private  RestfulService restfulService;
	
	@InjectMocks private StatisticsHelper help;
	
	@Before
	public void setup() throws Exception{
		MockitoAnnotations.initMocks(this);
	}
	
	/**
     * This is a unit test method for the showLocalStates method of StatisticsHelper class
     * 
     */
	@Test
	public void testlocalstats() throws InterruptedException, ExecutionException, JsonProcessingException,
	InterruptedIOException, IOException {
		String data ="I need java java developer";
//		HashMap<String, Integer> mockMap =  new HashMap<>() ;
//			mockMap.put("java",2);
//			mockMap.put("i", 1);
		
		when(restfulService.try_(any())).thenReturn(CompletableFuture.completedFuture(data));
		Map<String, Integer> issue = help.showLocalStates(data).get();
		assertEquals("2",issue.get("java").toString());
			
	}
	
	/**
     * This is a unit test method for the showGlobalStates method of StatisticsHelper class
     * 
     */
	@Test
	public void testGlobalstats() throws InterruptedException, ExecutionException, JsonProcessingException,
	InterruptedIOException, IOException {
		String data = "I am I A JAVA i HELLO , I am python developer";
		when(restfulService.try_(any())).thenReturn(CompletableFuture.completedFuture(data));
		Map<String, Integer> issue = help.showGlobalStates(data).get();
		assertEquals("4",issue.get("i").toString());
	}

}
