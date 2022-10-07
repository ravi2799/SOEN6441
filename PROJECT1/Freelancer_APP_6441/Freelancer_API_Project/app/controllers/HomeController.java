package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.*;
import wrapper.*;
import helper.*;

import java.util.stream.Collector;
import java.util.stream.Collectors;

import java.io.InterruptedIOException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import helper.StatisticsHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import play.mvc.Http.Session;
import javax.inject.*;
import helper.SearchHelper;
import play.libs.ws.*;
import scala.compat.java8.FutureConverters;

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
        private final StatisticsHelper statehelper;
        private final EmployerInfoHelper employerInfoHelper;
        private HttpExecutionContext httpExecutionContext;
        private HashMap<String, List<Project>> cache;
        private HashMap<String, List<Project>> projectDataMap;

        private String globalPreviewDesc = "";

        @Inject
        public HomeController(HttpExecutionContext httpExecutionContext,
                        SearchHelper projectSearcher, StatisticsHelper statehelper,
                        EmployerInfoHelper employerInfoHelper) {
                this.projectSearcher = projectSearcher;
                this.statehelper = statehelper;
                this.employerInfoHelper = employerInfoHelper;
                this.httpExecutionContext = httpExecutionContext;
                cache = new HashMap<String, List<Project>>();
                projectDataMap = new HashMap<String, List<Project>>();
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

                System.out.println("Session :  " + req.session().data() + "Mapping searched keyword"
                                + req.session().get(keyword + "-result")
                                + req.session().data().get(keyword + "-result"));

                CompletableFuture<String> completableFuture = new CompletableFuture<>();

                if (req.session().get(keyword + "-result").isPresent()) {
                        completableFuture.complete(req.session().get(keyword + "-result").get());
                        return completableFuture
                                        .thenApplyAsync(response -> ok(views.html.landingPage
                                                        .render(projectDataMap.get(keyword), req, keyword, cache,
                                                                        projectDataMap,
                                                                        globalPreviewDesc)));
                } else {
                        return projectSearcher.searchProject(keyword, projectDataMap)
                                        .thenApplyAsync(response -> {
                                                if (((List<Project>) response).size() > 0) {
                                                        cache.put(keyword, ((List<Project>) response));
                                                        return ok(views.html.landingPage
                                                                        .render((List<Project>) response, req, keyword,
                                                                                        cache, projectDataMap,
                                                                                        globalPreviewDesc))
                                                                        .addingToSession(req, keyword + "-result",
                                                                                        keyword);
                                                }
                                                return ok(views.html.landingPage.render((List<Project>) response, req,
                                                                keyword, cache, projectDataMap, globalPreviewDesc));
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
                System.out.println("Session :  " + req.session().data() + "Mapping searched keyword"
                                + req.session().get(skillsName + "-result")
                                + req.session().data().get(skillsName + "-result"));

                CompletableFuture<String> completableFuture = new CompletableFuture<>();
                return projectSearcher.searchProjectsBySkills(skillsName, skillsID, projectDataMap)
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
                                });
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

                CompletableFuture<EmployeeBioData> userInfoFuture = employerInfoHelper.getEmployerInfo(owner_id);
                CompletableFuture<ProjectEmployeeInfo> userProjectInfoFuture = employerInfoHelper
                                .getEmployerProjectInfo(owner_id);
                CompletableFuture<EmployerProfilePage> userProfilePageFuture = userInfoFuture
                                .thenCombine(userProjectInfoFuture, (userProfileInfo, userProjectInfo) -> {
                                        EmployerProfilePage employerProfilePage = new EmployerProfilePage();
                                        employerProfilePage.setEmployerProfileInfo(userProfileInfo);
                                        employerProfilePage.setEmployerProjectInfo(userProjectInfo);
                                        return employerProfilePage;
                                });
                return userProfilePageFuture.thenApplyAsync(userProfilePage -> ok(views.html.EmployerProfile
                                .render(userProfilePage.getEmployerProfileInfo(),
                                                userProfilePage.getEmployerProjectInfo())));

        }

        /**
         * @author Raviraj Savaliya
         *         This is the main method, renders the information of local word states
         * 
         * @param keyword local preview_description of single entry
         * @return The occurance of words and their counting
         */

        public CompletionStage<Result> renderStats(String keyword) throws InterruptedException, ExecutionException {
                List<Project> data = this.projectDataMap.get(keyword);
                String globalpreview_data = projectSearcher.get_GlobalPreviewDesc(data);
                return statehelper.showGlobalStates(globalpreview_data)
                                .thenApplyAsync(json -> ok(views.html.states.render(json)));
        }

        /**
         * @author Raviraj Savaliya
         *         This is the main method, renders the information of Global word
         *         states
         * 
         * @param keyword,projectid Global preview_description of single entry
         * @return The occurance of words and their counting
         */

        public CompletionStage<Result> renderlocalStats(String keyword, int projectid)
                        throws InterruptedException, ExecutionException {
                List<Project> pr = projectDataMap.get(keyword);
                String data = projectSearcher.getLocalPreviewDesc(pr, projectid);
                return statehelper.showLocalStates(data)
                                .thenApplyAsync(json -> ok(views.html.states.render(json)));

        }

}
