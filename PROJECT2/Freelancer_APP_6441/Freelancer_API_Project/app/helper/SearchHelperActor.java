package helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import models.RestfulServiceActor;

import javax.inject.Inject;
import java.util.concurrent.CompletableFuture;
import wrapper.*;

import akka.actor.AbstractLoggingActor;
import akka.actor.*;
import play.libs.ws.*;
import akka.actor.ActorInterruptedException;
import akka.actor.ActorRef;
import akka.actor.Props;
import scala.compat.java8.FutureConverters;
import static akka.pattern.Patterns.ask;
import com.fasterxml.jackson.core.type.TypeReference;
import wrapper.ProjectResults;

/**
 * @author Arvind Sangwan, Geetika, Shaurya, Raviraj
 * @version 1.0
 */

public class SearchHelperActor extends AbstractLoggingActor {
    ObjectMapper mapper;
    private final WSClient ws;

    @Inject
    /**
     * This is the Constructor method of SearchHelperActor class.
     * @param ws paramater of ws client
     * 
     */
    public SearchHelperActor(WSClient ws) {
        this.ws = ws;
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * This is the projectSearchActorClass this is child actor of projectSearchActor.
     */
    public static class projectSearchActorClass {
        final private String keyWord;
        final private ProjectResults projectResults;
        
        /**
         * This is the ProjectBySkillsActor constructor.
         * @param keyWord ,projectResults this params has details of skill
         */

        public projectSearchActorClass(String keyWord, ProjectResults projectResults) {
            this.keyWord = keyWord;
            this.projectResults = projectResults;
        }
    }
    
    /**
     * This is the ProjectBySkillsActor this is child actor of Skill.
     */
    
    public static class ProjectBySkillsActor {
        final private String skillsName;
        final private String skillsID;
        final private ProjectResults projectResults;

        /**
         * This is the ProjectBySkillsActor constructor.
         * @param skillsName , skillsID ,projectResults this params has details of skill
         */
        
        public ProjectBySkillsActor(String skillsName, String skillsID, ProjectResults projectResults) {
            this.skillsName = skillsName;
            this.skillsID = skillsID;
            this.projectResults = projectResults;
        }
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(SearchHelperActor.projectSearchActorClass.class, this::searchProject)
                .match(ProjectBySkillsActor.class, this::searchProjectBySkills)
                .build();
    }

    /**
	 * This method fetches the projects for a given keyword
	 * using Actors. It calls the method written to call the API.
	 * 
	 * @param projectSearchActorClass static class containing keyword and 
	 * 			project results to search projects for that keyword.
	 */
    public void searchProject(projectSearchActorClass obj) {
        HashMap<String, List<Project>> projectDataMap = new HashMap<>();
        List<Project> repoInfoList = new ArrayList<Project>();

        final ActorRef senderRef = sender();
        final ActorRef gitHubActorRef = context().actorOf(HelperActorSupervisor.props(ws));

        ((CompletableFuture) FutureConverters.toJava(
                ask(gitHubActorRef, new RestfulServiceActor.SearchProjectsApi(obj.keyWord), 5000)))
                .thenApplyAsync(json -> {
                    ProjectInfoWrapper projectInfo = new ProjectInfoWrapper();
                    try {
                        projectInfo = mapper.convertValue(json, new TypeReference<ProjectInfoWrapper>() {
                        });

                        // projectInfo.time_submitted = new
                        // SimpleDateFormat(projectInfo.time_submitted);
                    } catch (Exception ex) {
                        System.out.println("Parsing json Failure !!!!!!   - Exception :" + ex);
                    }
                    if (obj.projectResults.getProjectsSize() < 100 && projectInfo.result != null)
                        obj.projectResults.setProjects(projectInfo.result.projects, obj.keyWord);
                    projectDataMap.put(obj.keyWord, obj.projectResults.getProjects());
                    return obj.projectResults.getProjects();
                }).thenAccept(response -> senderRef.tell((List<Project>) response, self()));

    }
    
    /**
	 * This method fetches the projects for a given skill written on the main page
	 * using Actors. It calls the method written to call the API for skills.
	 * 
	 * @param ProjectBySkillsActor static class containing skillsName, skillsID and 
	 * 			project results to search projects for that skill.
	 */
    public void searchProjectBySkills(ProjectBySkillsActor skillsObj) {
    	HashMap<String, List<Project>> projectDataMap = new HashMap<>();
        List<Project> repoInfoList = new ArrayList<Project>();

        final ActorRef senderRef = sender();
        final ActorRef skillsActorRef = context().actorOf(HelperActorSupervisor.props(ws));

        ((CompletableFuture) FutureConverters.toJava(
                ask(skillsActorRef, new RestfulServiceActor.SkillsPageActor(skillsObj.skillsID), 5000)))
                .thenApplyAsync(json -> {
                    ProjectInfoWrapper projectInfo = new ProjectInfoWrapper();
                    try {
                        projectInfo = mapper.convertValue(json, new TypeReference<ProjectInfoWrapper>() {
                        });

                        // projectInfo.time_submitted = new
                        // SimpleDateFormat(projectInfo.time_submitted);
                    } catch (Exception ex) {
                        System.out.println("Parsing json Failure !!!!!!   - Exception :" + ex);
                    }
                    if (skillsObj.projectResults.getProjectsSize() < 100 && projectInfo.result != null)
                    	skillsObj.projectResults.setProjects(projectInfo.result.projects, skillsObj.skillsName);
                    projectDataMap.put(skillsObj.skillsName, skillsObj.projectResults.getProjects());
                    return skillsObj.projectResults.getProjects();
                }).thenAccept(response -> senderRef.tell((List<Project>) response, self()));
    }

    public static Props props(WSClient ws) {
        return Props.create(SearchHelperActor.class, ws);
    }
}
