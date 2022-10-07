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
public class EmployerInfoHelperV2 extends AbstractLoggingActor {

    private final WSClient ws;
    private ObjectMapper mapper;

    @Inject
    EmployerInfoHelperV2(WSClient ws) {
        this.ws = ws;
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
    /**
     * This is the EmployerProfileHelperActor class which is child actor of EmployerInfoHelperV2.
     */
    public static class EmployerProfileHelperActor {
        final private String ownerid;
        public EmployerProfileHelperActor(String ownerid) {
            this.ownerid = ownerid;
        }
    }
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(EmployerProfileHelperActor.class,this::getEmployerProfileInfo)
                .build();
    }

    /**
     * Props is a configuration object using in creating an Actor;
     * it is immutable, so it is thread-safe and fully shareable.
     */
    public static Props props(WSClient ws) {
        return Props.create(EmployerInfoHelperV2.class,ws);
    }

    /***
     * This fetches user profile info from freelancer actor
     * @param c Its is an object of EmployerProfileHelperActor actor
     */
    private void getEmployerProfileInfo(EmployerProfileHelperActor c) {

        String ownerid = c.ownerid;
        final ActorRef senderRef = sender();
        final ActorRef freelancerActorRef = context().actorOf(HelperActorSupervisor.props(ws));

        ((CompletableFuture)FutureConverters.toJava(ask(freelancerActorRef,new RestfulServiceActor.ActorForEmployerProfilePage(ownerid),5000))).thenApplyAsync( json -> mapper.convertValue(json, new TypeReference<EmployeeBioData>() {})
        ).thenAccept(response -> senderRef.tell(response, self()) );
    }

}
