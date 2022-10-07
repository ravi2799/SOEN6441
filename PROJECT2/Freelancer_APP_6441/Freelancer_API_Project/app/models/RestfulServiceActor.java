package models;

import akka.actor.AbstractLoggingActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import play.libs.ws.*;
import play.mvc.Http;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.stream.Collectors;
import com.fasterxml.jackson.databind.JsonNode;
import play.api.http.HeaderNames.*;
import controllers.HomeController;

import java.util.*;

public class RestfulServiceActor extends AbstractLoggingActor {

    private final WSClient ws;

    @Inject
    public RestfulServiceActor(WSClient ws) {

        this.ws = ws;
    }

    public static class SearchProjectsApi {
        private String searchedKeyword;

        public SearchProjectsApi(String searchedKeyword) {
            this.searchedKeyword = searchedKeyword;
        }
    }

    public static class ActorForEmployerProfilePage {
        private final String ownerID;

        public ActorForEmployerProfilePage(String ownerID) {
            this.ownerID = ownerID;
        }
    }

    public static class ActorForEmployerProjectInfoPage {
        private final String ownerID;

        public ActorForEmployerProjectInfoPage(String ownerID) {
            this.ownerID = ownerID;
        }
    }

    public static class SkillsPageActor {
        private String skillsID;

        public SkillsPageActor(String skillsID) {
            this.skillsID = skillsID;
        }
    }

    public static Props props(WSClient ws) {
        return Props.create(RestfulServiceActor.class, ws);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(SearchProjectsApi.class, this::searchProjects)
                .match(ActorForEmployerProfilePage.class, this::getEmployerProfileInfo)
                .match(ActorForEmployerProjectInfoPage.class, this::getEmployerProjectInfo)
                .match(SkillsPageActor.class, this::apiCallForSkills)
                .build();
    }

    /**
     * This method fetches the result conatining project related to searched keyword.
     *
     * @param searchClassObj Wrapper contaning keyword to be searched for.
     * @return Json object wrap in completable future.
     */
    public void searchProjects(SearchProjectsApi searchClassObj) {

        String url_for_request = "https://www.freelancer.com/api/projects/0.1/projects/active";

        final ActorRef senderRef = sender();

        ws.url(url_for_request)
                .addHeader("freelancer-oauth-v1", "i3CkNWAKpUmgx8pGKHnlXTRfz2QWBO")
                .addQueryParameter("limit", "10")
                .addQueryParameter("sort_field", "time_submitted")
                .addQueryParameter("job_details", "true")
                .addQueryParameter("query", String.valueOf(searchClassObj.searchedKeyword))
                // .addQueryParameter("job_details", "true")
                .get().thenApplyAsync(WSResponse::asJson)
                .thenAccept(response -> senderRef.tell((JsonNode) response, self()));
    }

    /**
     * This method fetches the employer profile information
     *
     * @param actorForEmployerProfilePage contaning owner_id to show profile
     *                                    information of a owner.
     * @return Json object wrap in completable future.
     */

    public void getEmployerProfileInfo(ActorForEmployerProfilePage actorForEmployerProfilePage) {
        String url_for_request = "https://www.freelancer.com/api/users/0.1/users/"
                + actorForEmployerProfilePage.ownerID;
        final ActorRef senderRef = sender();
        ws.url(url_for_request).addHeader("freelancer-oauth-v1", "i3CkNWAKpUmgx8pGKHnlXTRfz2QWBO")
                .addQueryParameter("limit", "10")
                .get()
                .thenApplyAsync(WSResponse::asJson)
                .thenAccept(response -> senderRef.tell((JsonNode) response, self()));
    }

    /**
     * This method fetches the employer information related to a project
     * 
     * @param actorForEmployerProjectInfoPage static class containing information of
     *                                        skills data.
     */

    public void getEmployerProjectInfo(ActorForEmployerProjectInfoPage actorForEmployerProjectInfoPage) {
        String url = "https://www.freelancer.com/api/projects/0.1/projects";
        final ActorRef senderRef = sender();
        ws.url(url).addHeader("freelancer-oauth-v1", "i3CkNWAKpUmgx8pGKHnlXTRfz2QWBO")
                .addQueryParameter("owners[]", String.valueOf(actorForEmployerProjectInfoPage.ownerID))
                .addQueryParameter("sort_field", "time_updated")
                .addQueryParameter("limit", "10")
                .get()
                .thenApplyAsync(WSResponse::asJson)
                .thenAccept(response -> senderRef.tell((JsonNode) response, self()));
    }

    /**
     * This method fetches all the projects related to skills actor.
     * 
     * @param skillsPageActor static class containing information of skills data.
     */

    public void apiCallForSkills(SkillsPageActor skillsPageActor) {

        String apiURL = "https://wwww.freelancer.com/api/projects/0.1/projects/active";

        final ActorRef senderRef = sender();

        ws.url(apiURL)
                .addHeader("freelancer-oauth-v1", "i3CkNWAKpUmgx8pGKHnlXTRfz2QWBO")
                .addQueryParameter("job_details", "true")
                .addQueryParameter("limit", "10")
                .addQueryParameter("sort_field", "time_submitted")
                .addQueryParameter("jobs[]", String.valueOf(skillsPageActor.skillsID))
                .get().thenApplyAsync(WSResponse::asJson)
                .thenAccept(response -> senderRef.tell((JsonNode) response, self()));

    }

}
