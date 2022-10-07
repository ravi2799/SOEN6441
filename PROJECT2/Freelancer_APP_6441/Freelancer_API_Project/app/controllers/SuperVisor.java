package controllers;

import akka.actor.*;
import akka.japi.pf.DeciderBuilder;
import akka.japi.pf.ReceiveBuilder;
import akka.actor.ActorInterruptedException;
import java.io.InterruptedIOException;
import java.util.concurrent.*;
import scala.concurrent.duration.Duration;
import java.util.*;

import play.libs.ws.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;

import static akka.actor.SupervisorStrategy.*;
import java.util.concurrent.CompletableFuture;

import akka.actor.Props;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;
import helper.SearchHelperActor;
import helper.StatisticsHelper;
import helper.EmployerInfoHelperV2;
import helper.EmployerProjectInfoHelper;

/**
 * @author Arvind Sangwan, Geetika, Shaurya, Raviraj
 * @version 1.0
 */

public class SuperVisor extends AbstractLoggingActor {
    private final WSClient ws;
    
    /**
     * This is the Constructor method of SuperVisor class.
     * @param ws paramater of ws client
     * 
     */
    @Inject
    public SuperVisor(WSClient ws) {
        this.ws = ws;
    }
    
    /**
     * This is the create Receive method  for all defined actors.
     */
    
    @Override
    public Receive createReceive() {
        final ActorRef projectSearchChild = getContext().actorOf(SearchHelperActor.props(ws));
        final ActorRef employerProfileChild = getContext().actorOf(EmployerInfoHelperV2.props(ws));
        final ActorRef employerProjectChild = getContext().actorOf(EmployerProjectInfoHelper.props(ws));
        final ActorRef StateChild = getContext().actorOf(StatisticsHelper.props(ws));

        return receiveBuilder()
                .match(SearchHelperActor.projectSearchActorClass.class, any -> {
                    projectSearchChild.forward(any, getContext());
                })
                .match(SearchHelperActor.ProjectBySkillsActor.class, any -> {
                    projectSearchChild.forward(any, getContext());
                })
                .match(EmployerInfoHelperV2.EmployerProfileHelperActor.class, any -> {
                    employerProfileChild.forward(any, getContext());
                })
                .match(EmployerProjectInfoHelper.EmployerProjectInfoHelperActor.class, any -> {
                	employerProjectChild.forward(any, getContext());
                })
                .match(StatisticsHelper.StateSearchActorClass1.class, any -> {
                    StateChild.forward(any, getContext());
                })
                .match(StatisticsHelper.StateSearchActorClass2.class, any -> {
                    StateChild.forward(any, getContext());
                })
                .build();
    }

    /**
     * This method Applies the fault handling Directive (Resume, Restart, Stop) 
     * specified in the Decider to the child actor that failed, 
     * as opposed to AllForOneStrategy that applies it to all children.
     */
    public static final OneForOneStrategy STRATEGYForHandlingException = new OneForOneStrategy(
            10,
            Duration.create("10 seconds"),
            DeciderBuilder
                    .match(InterruptedIOException.class, ex -> escalate())
                    .match(ActorInterruptedException.class, ex -> escalate())
                    .match(InterruptedException.class, ex -> escalate())
                    .match(ExecutionException.class, ex -> escalate())
                    .match(NullPointerException.class, ex -> restart())
                    .match(CompletionException.class, ex -> escalate())
                    .build());

    @Override
    /**
     * Akka SupervisorStrategy is the policy to apply for crashing children.
     */
   
    public SupervisorStrategy supervisorStrategy() {
        return STRATEGYForHandlingException;
    }
    /**
     * Props is a configuration object using in creating an Actor;
     * it is immutable, so it is thread-safe and fully shareable.
     */
    
    public static Props props(WSClient ws) {
        return Props.create(SuperVisor.class, ws);
    }
}