package helper;

import javax.inject.Inject;
import models.RestfulService;
import play.mvc.*;

import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Arrays;
import java.util.List;
import wrapper.Project;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.DeserializationFeature;
import java.util.*;
import java.util.function.Function;
//import com.fasterxml.jackson.databind.JsonNode;
import java.util.concurrent.*;
import com.fasterxml.jackson.databind.*;


import helper.SearchHelper;
import wrapper.ProjectInfoWrapper;
import wrapper.ProjectResults;
import wrapper.Project;

/***
 * @author Raviraj Savaliya
 * @version 1.0
 */

public class StatisticsHelper{
    RestfulService rs;
    Project pr ;
    ProjectResults projectResults;
    private ObjectMapper mapper ;
    private HashMap <String , Long> countWord = new HashMap<>();
    private List<String> words = new ArrayList<String>();
            
    @Inject
    public StatisticsHelper (RestfulService rs, Project pr , ProjectResults projectResults){
        this.rs = rs;
        this.pr = pr;
        this.projectResults  = projectResults ;
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        
    }

    // public CompletableFuture<Map<String , Integer>> showStates(String keyWord) throws  InterruptedException, ExecutionException{
    //     return rs.searchedkeyword_stats(keyWord).thenApplyAsync(stats ->{
    //         Map<String , Integer> countWord = null;
    //        // ProjectInfoWrapper projectInfo = new ProjectInfoWrapper();
    //         List<String> words = new ArrayList<String>();
    //         if(stats != null){
    //             System.out.println(stats.get("result").get("projects"));
                
    //             for(JsonNode a :stats.get("result").get("projects")){
    //             //  for (JsonNode a : stats.get("result")){
    //               System.out.println(a.get("preview_description").asText());
    //               String data  = a.get("preview_description").asText(); 
    //                //String data = a.get("title").asText();
    //                words.addAll(Arrays.asList(data.split("[\\s@&?$+\\(||//)||,||\"||:||;]+")));

    //                // words.add(a.get("title").split(" ").asText());
    //                 System.out.println(words);
    //             }  
    //         }

    //         countWord = words.stream().parallel().map(String::toLowerCase)
	// 					.collect(Collectors.groupingBy(Function.identity(),
	// 					    Collectors.summingInt(e -> 1)))
	// 					.entrySet()
	// 					.stream()
	// 					.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
	// 					.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
	// 							(v1, v2) -> {throw new IllegalStateException();}, LinkedHashMap::new));
    //         System.out.println("couted words : " + countWord);

    //         return countWord;  
    //     });
    // }

    /**
     * This method return the list of Global word states
     * 
     * @param astring preview description in string formate
     * @return list of words and their counting
     */

    public CompletableFuture<Map<String , Integer>> showGlobalStates(String astring) throws  InterruptedException, ExecutionException{
        return rs.try_(astring).thenApplyAsync(keyWord ->{
        Map<String , Integer> countWord = null;

        List<String> words = new ArrayList<String>();
                                                                    
        words.addAll(Arrays.asList(keyWord.split("[\\s@&.-?$+\\(||//)||,||\"||:||;]+")));

        countWord = words.stream().parallel().map(String::toLowerCase)
						.collect(Collectors.groupingBy(Function.identity(),
						    Collectors.summingInt(e -> 1)))
						.entrySet()
						.stream()
						.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
						.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
								(v1, v2) -> {throw new IllegalStateException();}, LinkedHashMap::new));
           // System.out.println("couted words : " + countWord);
        return countWord;
    });
    }

    /**
     * This method return the list of Local word states
     * 
     * @param astring preview description in string format
     * @return list of words and their counting
     */

    public CompletableFuture<Map<String , Integer>> showLocalStates(String astring) throws  InterruptedException, ExecutionException{
        return rs.try_(astring).thenApplyAsync(keyWord ->{
        Map<String , Integer> countWord = null;

        List<String> words = new ArrayList<String>();

        words.addAll(Arrays.asList(keyWord.split("[\\s@&?$+\\(||//)||,||\"||:||;]+")));

        countWord = words.stream().parallel().map(String::toLowerCase)
						.collect(Collectors.groupingBy(Function.identity(),
						    Collectors.summingInt(e -> 1)))
						.entrySet()
						.stream()
						.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
						.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
								(v1, v2) -> {throw new IllegalStateException();}, LinkedHashMap::new));
           // System.out.println("couted words : " + countWord);
        return countWord;
    });
    }

}