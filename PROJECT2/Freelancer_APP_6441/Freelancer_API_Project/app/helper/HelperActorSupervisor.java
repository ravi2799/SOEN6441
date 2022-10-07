package helper;

import akka.actor.*;
import akka.japi.pf.DeciderBuilder;
import akka.japi.pf.ReceiveBuilder;
import models.RestfulServiceActor;
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

/**
 * @author Arvind Sangwan, Geetika, Shaurya, Raviraj
 * @version 1.0
 */

public class HelperActorSupervisor extends AbstractLoggingActor {
    private final WSClient ws;
    
    /**
     * This is the Constructor method of HelperActorSupervisor class.
     * @param ws paramater of ws client
     * 
     */ 
    @Inject
    public HelperActorSupervisor(WSClient ws) {
        this.ws = ws;
    }

    @Override
    
    /**
     * This is the create Receive method  for all defined actors.
     */
    
    public Receive createReceive() {
        final ActorRef child = context().actorOf(RestfulServiceActor.props(ws));
        return receiveBuilder()
                .match(RestfulServiceActor.SearchProjectsApi.class, any -> {
                    child.forward(any, getContext());
                })
                .match(RestfulServiceActor.ActorForEmployerProfilePage.class,any -> {
                    child.forward(any, getContext());
                })
                .match(RestfulServiceActor.ActorForEmployerProjectInfoPage.class,any -> {
                    child.forward(any, getContext());
                })
                .match(RestfulServiceActor.SkillsPageActor.class, any -> {
                    child.forward(any, getContext());
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

    // restart , resume, stop, escalate
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
        return Props.create(HelperActorSupervisor.class, ws);
    }
}
