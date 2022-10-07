package controllers;

import static org.junit.Assert.*;

import org.junit.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;


import play.Application;
import play.inject.guice.GuiceApplicationBuilder;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Http;
import play.mvc.Result;
import play.test.Helpers;
import play.test.WithApplication;

import java.io.InterruptedIOException;
import java.util.*;
import com.fasterxml.jackson.databind.JsonNode;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.GET;
import static play.test.Helpers.route;

import java.util.Map;
import javax.inject.Inject;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import static play.mvc.Results.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

import com.fasterxml.jackson.core.JsonParseException;

import play.libs.ws.*;
import wrapper.*;
import org.hibernate.validator.constraints.ModCheck;
import org.junit.*;
import wrapper.*;

import java.util.HashMap;

import helper.*;
import models.RestfulService;

/**
 * @author Raviraj Savaliya, Arvind Sangwan, Geetika, Shaurya
 * @version 1.0
 */
public class HomeControllerTest {

    @Mock
    private HttpExecutionContext httpExecutionContext;

    @Mock
    private WSClient ws;

    @Mock
    private RestfulService restfulService;

    @Mock
    private SearchHelper searchHelper;

    @Mock
    private StatisticsHelper stHelper;

    @Mock
    private RestfulService rs;

    @Mock
    private EmployerInfoHelper empHelper;

    public static Application app;

    @InjectMocks
    private HomeController homeController;

    @Before
    public void setup() {
        app = Helpers.fakeApplication();
        Helpers.start(app);

    }

    /**
     * This is a unit test method for the route / 
     * 
     */
    @Test
    public void testIndex() {
        Http.RequestBuilder request = new Http.RequestBuilder().method(GET).uri("/");

        Result result = route(app, request);
        assertEquals(OK, result.status());
    }

    /**
     * This is a unit test method for the route /explore
     * 
     */
    @Test
    public void testexplore() {
        Http.RequestBuilder request = new Http.RequestBuilder().method(GET).uri("/explore");

        Result result = route(app, request);
        assertEquals(OK, result.status());
    }

    /**
     * This is a unit test method for the route /tutorial
     * 
     */
    @Test
    public void testtutorial() {
        Http.RequestBuilder request = new Http.RequestBuilder().method(GET).uri("/tutorial");

        Result result = route(app, request);

        assertEquals(OK, result.status());
    }

    /**
     * This is a unit test method for the route /SearchPage?keyword=java
     * 
     */
    @Test
    public void test_searchPage() {
        Http.RequestBuilder request = new Http.RequestBuilder().method(GET).uri("/SearchPage?keyword=java");

        Result result = route(app, request);

        assertEquals(OK, result.status());
    }

    /**
     * This is a unit test method for the route /SearchPage
     * 
     */
    @Test
    public void test_searchPage1() {
        Http.RequestBuilder request = new Http.RequestBuilder().method(GET).uri("/SearchPage");

        Result result = route(app, request);

        assertEquals(400, result.status());
    }

    /**
     * This is a unit test method for the route /clearSession
     * 
     */
    @Test
    public void test_clearSession() {

        Http.RequestBuilder request = new Http.RequestBuilder().method(GET).uri("/clearSession");

        Result result = route(app, request);

        assertEquals(303, result.status());
    }

    /**
     * This is a unit test method for the route /projectsBySkill
     * 
     */
    @Test
    public void test_projectBySkill() {

        Http.RequestBuilder request = new Http.RequestBuilder().method(GET).uri("/projectsBySkill");

        Result result = route(app, request);
        assertEquals(400, result.status());
    }
    
    /**
     * This is a unit test method for the route /projectsBySkill
     * 
     */
    @Test
    public void renderSkillByIDTest() {
        Http.RequestBuilder request = new Http.RequestBuilder().method(GET)
                .uri("/projectsBySkill?skillsName=Java&skillsID=7");

        Result result = route(app, request);
        assertEquals(200, result.status());
    }

    /**
     * This is a unit test method for the route /owner_id/:owner_id   
     * 
     */
    @Test
    public void test_owner_id() {

        Http.RequestBuilder request = new Http.RequestBuilder().method(GET).uri("/owner_id/123256");

        Result result = route(app, request);

        assertEquals(OK, result.status());
    }

    /**
     * This is a unit test method for the states view page 
     * 
     */
    @Test
    public void renderStatesTemplate() {
        HashMap<String, Integer> issueMap = new HashMap<>();
        assertEquals("text/html", views.html.states.render(issueMap).contentType());
    }

    /**
     * This is a unit test method for the main view page 
     * 
     */
    @Test
    public void renderMainTemplate() {
        assertEquals("text/html", views.html.main.render("", null).contentType());
    }

    /**
     * This is a unit test method for the commonSideBar view page 
     * 
     */
    @Test
    public void renderCommonTemplate() {
        HashMap<String, Integer> issueMap = new HashMap<>();
        assertEquals("text/html", views.html.commonSidebar.render().contentType());
    }

    /**
     * This is a unit test method for the index view page 
     * 
     */
    @Test
    public void renderIndexTemplate() {
        assertEquals("text/html", views.html.index.render().contentType());
    }

    /**
     * This is a unit test method for the welcome view page 
     * 
     */
    @Test
    public void renderWelcomeTemplate() {
        assertEquals("text/html", views.html.welcome.render("Arvind", "Sangwan").contentType());
    }

    
    /**
     * This is a unit test method for the skills view page 
     * 
     */
    @Test
    public void renderSkillTemplate() {
        List<Project> searchResult = new ArrayList<>();
        HashMap<String, List<Project>> mapData = new HashMap<>();

        List<Project> projectList = new ArrayList<>();
        mapData.put("Javascript", projectList);

        assertEquals("text/html",
                views.html.skills.render(searchResult, "Java", mapData, mapData, "java_data").contentType());
    }

    /**
     * This is a unit test method for the route /GlobalStatistics
     * 
     */
    @Test
    public void test_Globalstats() {
        Http.RequestBuilder request = new Http.RequestBuilder().method(GET)
                .uri("/GlobalStatistics/JAVA");
        Result result = route(app, request);
        assertEquals(200, result.status());
    }

    /**
     * This is a unit test method for the route /LocalStatistics
     * 
     */
    @Test
    public void test_Localstats() {

        Http.RequestBuilder request = new Http.RequestBuilder().method(GET)
                .uri("/LocalStatistics/java/33248729");

        Result result = route(app, request);
        assertEquals(200, result.status());
    }

}
