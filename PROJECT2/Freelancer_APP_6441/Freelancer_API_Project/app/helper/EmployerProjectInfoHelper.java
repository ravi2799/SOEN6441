package helper;

import akka.actor.AbstractLoggingActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.RestfulServiceActor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.databind.JsonNode;

import play.libs.Json;
import play.libs.ws.WSClient;
import scala.compat.java8.FutureConverters;
import wrapper.*;

import javax.inject.Inject;

import static akka.pattern.Patterns.ask;


import akka.actor.AbstractLoggingActor;
import akka.actor.ActorInterruptedException;
import akka.actor.ActorRef;
import akka.actor.Props;

import play.libs.ws.*;
import java.io.InterruptedIOException;
import java.util.*;
import java.util.concurrent.CompletableFuture;

import static akka.pattern.Patterns.ask;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import javax.inject.Inject;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.core.type.TypeReference;

import java.util.concurrent.*;

import scala.compat.java8.FutureConverters;
import wrapper.*;


/***
 * @author Geetika Rathi
 * @version 1.0
 */
public class EmployerProjectInfoHelper extends AbstractLoggingActor {

    private final WSClient ws;
    private ObjectMapper mapper;

    @Inject
    EmployerProjectInfoHelper(WSClient ws) {
        this.ws = ws;
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
    /**
     * This is the EmployerProjectInfoHelperActor class which is child actor of EmployerProjectInfoHelper.
     */
    public static class EmployerProjectInfoHelperActor {
        final private String ownerid;
        public EmployerProjectInfoHelperActor(String ownerid) {
            this.ownerid = ownerid;
        }
    }
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(EmployerProjectInfoHelperActor.class,this::getEmployerProjectInfo)
                .build();
    }

    /**
     * Props is a configuration object using in creating an Actor;
     * it is immutable, so it is thread-safe and fully shareable.
     */
    public static Props props(WSClient ws) {
        return Props.create(EmployerProjectInfoHelper.class,ws);
    }

    /***
     * This fetches user project info from freelancer actor
     * @param c Its is an object of EmployerProjectInfoHelperActor actor
     */
    private void getEmployerProjectInfo(EmployerProjectInfoHelperActor c) {

        String ownerid = c.ownerid;
        final ActorRef senderRef = sender();
        final ActorRef freelancerActorRef = context().actorOf(HelperActorSupervisor.props(ws));

        ((CompletableFuture)FutureConverters.toJava(ask(freelancerActorRef,new RestfulServiceActor.ActorForEmployerProjectInfoPage(ownerid),5000))).thenApplyAsync( json -> {
			ProjectEmployeeInfo projectList = new ProjectEmployeeInfo();
			try {
				

				projectList = mapper.convertValue(json, ProjectEmployeeInfo.class);
			
			} catch (Exception ex) {
				System.out.println("Parsing json Failure !!!!!! 2    - Exception :" +
						ex);
			}
			return projectList;
		})
        .thenAccept(response -> senderRef.tell(response, self()) );
    }

}
