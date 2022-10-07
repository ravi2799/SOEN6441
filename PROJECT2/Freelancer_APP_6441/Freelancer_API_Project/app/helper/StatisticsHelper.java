package helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
//import com.fasterxml.jackson.databind.JsonNode;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.inject.Inject;

import akka.actor.AbstractActor.Receive;
import akka.actor.AbstractLoggingActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import helper.StatisticsHelper.StateSearchActorClass1;
import helper.StatisticsHelper.StateSearchActorClass2;
import play.libs.ws.WSClient;

/***
 * @author Raviraj Savaliya
 * @version 1.0
 */

public class StatisticsHelper extends AbstractLoggingActor {
    
    private final WSClient ws;
    //RestfulService rs;
    private HashMap <String , Long> countWord = new HashMap<>();
    private List<String> words = new ArrayList<String>();
            
    @Inject
    /**
     * This is the Constructor method of StatisticsHelper class.
     * @param ws paramater of ws client
     * 
     */
    public StatisticsHelper(WSClient ws) {
        this.ws = ws;
    }

    /**
     * This is the StateSearchActorClass1 this is child actor of StatistisHelper.
     */
    
    public static class StateSearchActorClass1{
        final private String astring;
        public StateSearchActorClass1(String astring){
            System.out.println("ASTRING +++++++++++ : " + astring);
            this.astring = astring;
            }
        }

    public static class StateSearchActorClass2{
        final private String astring;
        public StateSearchActorClass2(String astring){
            System.out.println("AbsSTRING +++++++++++ : " + astring);
            this.astring = astring;
            }
        }       

    @Override 
    public Receive createReceive() {
                return receiveBuilder()
                .match(StatisticsHelper.StateSearchActorClass1.class, this::showGlobalStates)
                .match(StatisticsHelper.StateSearchActorClass2.class, this::showLocalStates)
                .build();

    }


    /**
     * This method return the list of Global word states
     * @param r preview description in string format
     */

    public void showGlobalStates(StateSearchActorClass1 r) throws InterruptedException, ExecutionException 
    {

        final ActorRef senderRef = sender();
        //  ((CompletableFuture) FutureConverters.toJava(
        //          ask(senderRef1, new RestfulServiceActor.try_(r.astring),10000)))

                CompletableFuture.supplyAsync(( ) -> {
        String data = r.astring;
        return data;
        }).thenApplyAsync(keyWord ->{
        
        Map<String , Integer> countWord = null;
        List<String> words = new ArrayList<String>();
                                                                    
        words.addAll(Arrays.asList(keyWord.toString().split("[\\s@&.-?$+\\(||//)||,||\"||:||;]+")));

        countWord = words.stream().parallel().map(String::toLowerCase)
                        .collect(Collectors.groupingBy(Function.identity(),
                            Collectors.summingInt(e -> 1)))
                        .entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (v1, v2) -> {throw new IllegalStateException();}, LinkedHashMap::new));
            System.out.println("couted words : " + countWord);
        return countWord;
    }).thenAccept(response -> senderRef.tell(response, self()));
    }
    

    /**
     * This method return the list of Local word states
     * @param r preview description in string format
     */

    public void showLocalStates(StateSearchActorClass2 r) throws InterruptedException, ExecutionException {
        final ActorRef senderRef = sender();

        //make helper superviser inside helper function. 
       // final ActorRef senderRef1 = context().actorOf(HelperActorSupervisor.props(ws));
        //  ((CompletableFuture) FutureConverters.toJava(
        //   ask(senderRef1, new RestfulServiceActor.try_(r.astring),10000)))

        CompletableFuture.supplyAsync(( ) -> {
        String data = r.astring;
        return data;
        }).thenApplyAsync(keyWord ->{
        Map<String , Integer> countWord = null;
        List<String> words = new ArrayList<String>();
                                                                    
        words.addAll(Arrays.asList(keyWord.toString().split("[\\s@&.-?$+\\(||//)||,||\"||:||;]+")));

        countWord = words.stream().parallel().map(String::toLowerCase)
                        .collect(Collectors.groupingBy(Function.identity(),
                            Collectors.summingInt(e -> 1)))
                        .entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (v1, v2) -> {throw new IllegalStateException();}, LinkedHashMap::new));
            System.out.println("couted words : " + countWord);
        return countWord;
    }).thenAccept(response -> senderRef.tell(response, self()));
    }

    /**
     * Props is a configuration object using in creating an Actor;
     * it is immutable, so it is thread-safe and fully shareable.
     */

    public static Props props(WSClient ws) {
       // System.out.println(" ==================== Creating props for StateController ================");
        return Props.create(StatisticsHelper.class, ws);
    }

    
    
}