package helper;

import static org.junit.Assert.*;
import static org.junit.Assert.*;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import wrapper.EmployeeBioData;
import wrapper.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;

import models.RestfulService;
/**
 * @author Arvind Sangwan, Raviraj Savaliya, Shaurya
 * @version 1.0
 */

public class SearchHelperTest {
	@Mock
	private SearchHelper searchHelper;

	@InjectMocks
	private EmployerInfoHelper employerInfoHelper;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	/**
     * This is a unit test method for the educationLevelMapper method of SearchHelper class
     * 
     */
	@Test
	public void educationalLevelMapperTest() {
		assertEquals("Law School Graduate", searchHelper.educationalLevelMapper(-1));
		assertEquals("College Graduate", searchHelper.educationalLevelMapper(10));
		assertEquals("Some College", searchHelper.educationalLevelMapper(40));
		assertEquals("High School", searchHelper.educationalLevelMapper(55));
		assertEquals("9th Grade", searchHelper.educationalLevelMapper(65));
		assertEquals("8th Grade", searchHelper.educationalLevelMapper(68));
		assertEquals("7th Grade", searchHelper.educationalLevelMapper(75));
		assertEquals("6th Grade", searchHelper.educationalLevelMapper(85));
		assertEquals("5th Grade", searchHelper.educationalLevelMapper(94));
		assertEquals("Early", searchHelper.educationalLevelMapper(110));
	}

	/**
     * This is a unit test method for the getSentences method of SearchHelper class
     * 
     */
	@Test
	public void getSentencesTest() {
		assertEquals(1.0, searchHelper.getSentences("Hi how are you."), 0.001);
	}

	/**
     * This is a unit test method for the getWords method of SearchHelper class
     * 
     */
	@Test
	public void getWordsTest() {
		assertEquals(4.0, searchHelper.getWords("Hi how are you"), 0.001);
	}

	/**
     * This is a unit test method for the getIndex method of SearchHelper class
     * 
     */
	@Test
	public void getIndexTest() {
		assertEquals(999.0, searchHelper.getFindex(""), 0.01);

	}

	/**
     * This is a unit test method for the getFkglIndex method of SearchHelper class
     * 
     */
	@Test
	public void getFKglIndex() {
		assertEquals(16.31, searchHelper.getFKglIndex("Hi how are you"), 0.001);
		assertEquals(999.0, searchHelper.getFKglIndex(""), 0.01);

	}

	/**
     * This is a unit test method for the getGlobalPreviewDesc method of SearchHelper class
     * 
     */
	@Test
	public void global_test() {
		List<Project> projectDataMap = new ArrayList<>();
		Project projectObj = new Project();
		projectObj.preview_description = "My preview desc";
		projectDataMap.add(projectObj);
		assertEquals("My preview desc", searchHelper.get_GlobalPreviewDesc(projectDataMap));
	}

	/**
     * This is a unit test method for the getlocalPreviewDesc method of SearchHelper class
     * 
     */
	
	@Test
	public void local_test() {
		List<Project> projectDataMap = new ArrayList<>();
		Project projectObj = new Project();
		projectObj.preview_description = "My preview desc";
		projectDataMap.add(projectObj);
		assertEquals("", searchHelper.getLocalPreviewDesc(projectDataMap, 10));
	}

	/**
     * This is a unit test method for the getter and setter for GlobalPreviewDesc method of SearchHelper class
     * 
     */
	@Test
	public void get___data() {
		StringBuilder globalPreviewDesc  = new StringBuilder();
		StringBuilder ab = new StringBuilder("Python");
		searchHelper.setGlobalPreviewDesc(ab);
		assertEquals("Python", searchHelper.getGlobalPreviewDesc().toString());
	}


}