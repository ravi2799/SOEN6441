package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import play.libs.concurrent.HttpExecutionContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import play.mvc.*;
import views.html.landingPage;
import wrapper.*;
import helper.*;

import java.util.stream.Collector;
import java.util.stream.Collectors;

import java.io.InterruptedIOException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import play.mvc.Http.Session;
import javax.inject.*;

import play.libs.ws.*;
import scala.compat.java8.FutureConverters;
import akka.actor.*;
import static akka.pattern.Patterns.ask;
import akka.stream.javadsl.*;
import java.time.Duration;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */

/**
 * @author Arvind Sangwan, Geetika, Shaurya, Raviraj
 * @version 1.0
 */
public class HomeController extends Controller {
        private final SearchHelper projectSearcher;

        private final EmployerInfoHelper employerInfoHelper;
        private HttpExecutionContext httpExecutionContext;
        private HashMap<String, List<Project>> cache;
        ProjectResults projectResults;
        private HashMap<String, List<Project>> projectDataMap;
        final ActorRef supperActor;
        public static WSClient ws;

        private String globalPreviewDesc = "";

        @Inject
        public HomeController(HttpExecutionContext httpExecutionContext,
                        SearchHelper projectSearcher, WSClient ws,
                        EmployerInfoHelper employerInfoHelper, ActorSystem system,
                        ProjectResults projectResults) {
                this.projectSearcher = projectSearcher;
                this.projectResults = projectResults;
                this.ws = ws;
                this.employerInfoHelper = employerInfoHelper;
                this.httpExecutionContext = httpExecutionContext;
                cache = new HashMap<String, List<Project>>();
                projectDataMap = new HashMap<String, List<Project>>();
                this.supperActor = system.actorOf(SuperVisor.props(ws));
        }

        /**
         * This is the method to clear the session.
         * 
         * @param req
         * @return it will redirect to the landing page
         */

        public Result index(Http.Request req) {

                this.projectSearcher.setGlobalPreviewDesc(new StringBuilder());
                globalPreviewDesc = "";
                projectDataMap = new HashMap<>();
                List<Project> response = new ArrayList<>();
                return ok(views.html.landingPage.render(response, req, "", cache, projectDataMap, globalPreviewDesc));
        }

        /***
         * This function initiate socket connection to freelancer api
         * 
         * @param keyWord topic name that is to be searched
         * @return
         */
        public WebSocket socket(String keyWord) {
                return WebSocket.Text.accept(
                                request -> {
                                        // Log events to the console
                                        Sink<String, ?> in = Sink.foreach(System.out::println);
                                        ObjectMapper o = new ObjectMapper();
                                        // Send a single 'Hello!' message and then leave the socket open
                                        Source<String, ?> out = null;
                                        out = Source.tick(
                                                        Duration.ofSeconds(10),
                                                        Duration.ofSeconds(10),
                                                        FutureConverters.toJava(ask(supperActor,
                                                                        new SearchHelperActor.projectSearchActorClass(
                                                                                        keyWord, projectResults),
                                                                        5000))
                                                                        .thenApplyAsync(response -> {
                                                                                if (((List<Project>) response)
                                                                                                .size() > 0) {
                                                                                        response = projectSearcher
                                                                                                        .transformDuplicaceResults(
                                                                                                                        (List<Project>) response,
                                                                                                                        keyWord,
                                                                                                                        cache);
                                                                                        List<Project> projectsData = new ArrayList<>();
                                                                                        ((List<Project>) response)
                                                                                                        .stream()
                                                                                                        .forEach(project -> {
                                                                                                                projectsData.add(
                                                                                                                                project);
                                                                                                        });

                                                                                }
                                                                                return (List<Project>) response;
                                                                        })
                                                                        .thenApply(res -> {
                                                                                try {
                                                                                        return o.writeValueAsString(
                                                                                                        res);
                                                                                } catch (JsonProcessingException e) {
                                                                                        e.printStackTrace();
                                                                                }
                                                                                return "";
                                                                        }).toCompletableFuture())
                                                        .map(CompletableFuture::get);
                                        // ).toCompletableFuture().get();
                                        return Flow.fromSinkAndSource(in, out);
                                });
        }

        /**
         * This is the Prebuild method.
         */
        public Result explore() {
                return ok(views.html.explore.render());
        }

        /**
         * This is the Prebuild method .
         */
        public Result tutorial() {
                return ok(views.html.tutorial.render());
        }

        /**
         * This is the method to clear the session.
         * 
         * @param request
         * @return it will clear the session and redirect to search page
         */
        public Result clearSession(Http.Request request) {
                // cache.clear();
                return redirect("/SearchPage?keyword=\"absdsds\"").withNewSession();
        }

        /**
         * This is the main method, renders the information regarding projects, along
         * with searched keyword, skills present in a project and owner id
         * 
         * @param req,keyword project description to be searched.
         * @return The list of projects containing information regarding searhed keyword
         */
        public CompletionStage<Result> searchProjectsPage(Http.Request req, String keyword)
                        throws InterruptedException, ExecutionException, JsonProcessingException {

                CompletableFuture<String> completableFuture = new CompletableFuture<>();

                if (req.session().get(keyword + "-result").isPresent()) {
                        completableFuture.complete(req.session().get(keyword + "-result").get());
                        return completableFuture
                                        .thenApplyAsync(response -> ok(views.html.landingPage
                                                        .render(projectDataMap.get(keyword), req, keyword, cache,
                                                                        projectDataMap,
                                                                        globalPreviewDesc)));
                } else {
                        return FutureConverters
                                        .toJava(ask(supperActor,
                                                        new SearchHelperActor.projectSearchActorClass(keyword,
                                                                        projectResults),
                                                        5000))
                                        .thenApplyAsync(response -> {
                                                if (((List<Project>) response).size() > 0) {
                                                        cache.put(keyword, ((List<Project>) response));

                                                        return ok(views.html.landingPage.render(
                                                                        (List<Project>) response, req, keyword, cache,
                                                                        projectDataMap,
                                                                        globalPreviewDesc))
                                                                        .addingToSession(req, keyword + "-result",
                                                                                        keyword);
                                                }
                                                return ok(landingPage
                                                                .render((List<Project>) response, req, keyword,
                                                                                cache, projectDataMap,
                                                                                globalPreviewDesc));
                                        }).toCompletableFuture();
                }
        }

        /**
         * This is the method to display 10 latest projects that contain a particular
         * skill.
         * Projects are displayed in the same fashion as they are displayed on the main
         * page.
         * 
         * @param req,skillsName,skillsID skills which are to be searched to return
         *                                matching
         *                                projects
         * @return The list of projects containing information regarding skills
         */

        public CompletionStage<Result> searchBySkills(Http.Request req, String skillsName, String skillsID)
                        throws InterruptedException, ExecutionException, JsonProcessingException {

                CompletableFuture<String> completableFuture = new CompletableFuture<>();
                return FutureConverters
                                .toJava(ask(supperActor,
                                                new SearchHelperActor.ProjectBySkillsActor(skillsName, skillsID,
                                                                projectResults),
                                                5000))
                                .thenApplyAsync(response -> {
                                        if (((List<Project>) response).size() > 0) {
                                                cache.put(skillsName, ((List<Project>) response));
                                                return ok(views.html.skills
                                                                .render((List<Project>) response,
                                                                                skillsName, cache,
                                                                                projectDataMap,
                                                                                globalPreviewDesc));
                                        }
                                        return ok(views.html.skills.render((List<Project>) response,
                                                        skillsName, cache, projectDataMap, globalPreviewDesc));
                                }).toCompletableFuture();
        }

        /**
         * This method renders the information regarding employer's profile and their
         * projects
         * 
         * @author Geetika Rathi
         * @param owner_id Owner ID of the employer whose information to be
         *                 fetched
         * @return employer information along with their projects
         */
        public CompletionStage<Result> ownerInfoPage(String owner_id) {
                CompletionStage<Object> userInfoFuture = FutureConverters.toJava(
                                ask(supperActor, new EmployerInfoHelperV2.EmployerProfileHelperActor(owner_id), 5000));
                CompletionStage<Object> userProjectInfoFuture = FutureConverters.toJava(ask(supperActor,
                                new EmployerProjectInfoHelper.EmployerProjectInfoHelperActor(owner_id), 5000));
                CompletionStage<EmployerProfilePage> userProfilePageFuture = userInfoFuture.thenCombine(
                                userProjectInfoFuture,
                                (userProfileInfo, userProjectInfo) -> {
                                        EmployerProfilePage employerProfilePage = new EmployerProfilePage();
                                        employerProfilePage.setEmployerProfileInfo((EmployeeBioData) userProfileInfo);
                                        employerProfilePage
                                                        .setEmployerProjectInfo((ProjectEmployeeInfo) userProjectInfo);
                                        return employerProfilePage;
                                });
                return userProfilePageFuture.thenApplyAsync(userProfilePage -> ok(views.html.EmployerProfile
                                .render(userProfilePage.getEmployerProfileInfo(),
                                                userProfilePage.getEmployerProjectInfo())));
        }

        /**
         * @author Raviraj Savaliya
         *         This is the main method, renders the information of Global word
         *         states.
         * @param keyword Global preview_description of single entry.
         * @return The occurance of words and their counting.
         */

        public CompletionStage<Result> renderStats(String keyword) throws InterruptedException, ExecutionException {
                List<Project> data = this.cache.get(keyword);
                String globalpreview_data = projectSearcher.get_GlobalPreviewDesc(data);
                return FutureConverters
                                .toJava(ask(supperActor,
                                                new StatisticsHelper.StateSearchActorClass1(globalpreview_data), 5000))
                                .thenApplyAsync(response -> ok(
                                                views.html.states.render((Map<String, Integer>) response)));
        }

        /**
         * @author Raviraj Savaliya
         *         This is the main method, renders the information of Local word
         *         states.
         * @param keyword,projectid keyword and project id.
         * @return The occurance of words and their counting.
         */

        public CompletionStage<Result> renderlocalStats(String keyword, int projectid)
                        throws InterruptedException, ExecutionException {
                List<Project> pr = cache.get(keyword);
                String data = projectSearcher.getLocalPreviewDesc(pr, projectid);
                return FutureConverters
                                .toJava(ask(supperActor, new StatisticsHelper.StateSearchActorClass2(data), 5000))
                                .thenApplyAsync(response -> ok(
                                                views.html.states.render((Map<String, Integer>) response)));
        }

}
