package models;

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
import play.api.http.HeaderNames.*;
import controllers.HomeController;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import javax.inject.Inject;

/**
 * @author Arvind Sangwan, Geetika, Shaurya, Raviraj
 * @version 1.0
 */
public class RestfulService {

    private final WSClient ws;

    @Inject
    public RestfulService(WSClient ws) {
        this.ws = ws;
    }


    /**
     * This method return the list of projects  on basis of searched keyword id
     * 
     * @param searchKeyWord searched keyword
     * @return list of projects on basis of searchKeyWord
     */

    public CompletableFuture<JsonNode> searchProjectKeyword(String searchKeyWord) {
        String url_for_request = "https://www.freelancer.com/api/projects/0.1/projects/active";
        CompletableFuture<JsonNode> data = ws.url(url_for_request)
                .addHeader("freelancer-oauth-v1", "i3CkNWAKpUmgx8pGKHnlXTRfz2QWBO")
                .addQueryParameter("limit", "10")
                .addQueryParameter("sort_field", "time_submitted")
                .addQueryParameter("job_details", "true")
                .addQueryParameter("query", String.valueOf(searchKeyWord))
                // .addQueryParameter("job_details", "true")
                .get().thenApplyAsync(WSResponse::asJson).toCompletableFuture();
        return data;
    }
    
    /**
     * This method returns the list of projects on the basis of skills
     * 
     * @param skillsID - Id of skill for list of projects
     * @return list of projects on basis of skillsID
     */
    public CompletableFuture<JsonNode> getProjectsBySkills  (String skillsID) {
    	String url_for_request = "https://wwww.freelancer.com/api/projects/0.1/projects/active";
    	CompletableFuture<JsonNode> data = ws.url(url_for_request)
                .addHeader("freelancer-oauth-v1", "i3CkNWAKpUmgx8pGKHnlXTRfz2QWBO")
    			.addQueryParameter("job_details", "true")
    			.addQueryParameter("limit", "10")
                .addQueryParameter("sort_field", "time_submitted")
                .addQueryParameter("jobs[]", skillsID)
                .get().thenApplyAsync(WSResponse::asJson).toCompletableFuture();
        return data;
    }
    
    /**
     * This method return the employer information  on basis of owner ID
     * 
     * @param ownerID Owner ID of the employer
     * @return employer information on the basis of owner ID
     */
    public  CompletableFuture<JsonNode> getEmployerInfo(String ownerID) {
	    String url_for_request = "https://www.freelancer.com/api/users/0.1/users/"+ownerID;
	        CompletableFuture<JsonNode> data = ws.url(url_for_request)
	                .addHeader("freelancer-oauth-v1", "i3CkNWAKpUmgx8pGKHnlXTRfz2QWBO")
	                .addQueryParameter("limit", "10")
	                .get().thenApplyAsync(WSResponse::asJson).toCompletableFuture();
	        return data;

	}
    /**
     * This method return the employer's 10 maximum projects  on basis of owner ID
     * 
     * @param ownerID Owner ID of the employer
     * @return employer projects on the basis of owner ID
     */
	public CompletableFuture<JsonNode> getEmployerProjectInfo(String ownerID) {

		String url = "https://www.freelancer.com/api/projects/0.1/projects";
		
		return ws.url(url)
				.addHeader("freelancer-oauth-v1", "i3CkNWAKpUmgx8pGKHnlXTRfz2QWBO")
				.addQueryParameter("owners[]", String.valueOf(ownerID))
				.addQueryParameter("sort_field", "time_updated")
				.addQueryParameter("limit", "10")
				.get()
				.thenApplyAsync(WSResponse::asJson)
				.toCompletableFuture();
	}
    
    /**
     * This method return the String in completable future form
     * @param keyWord preview description
     * @return String 
     */

    public CompletableFuture<String> try_(String keyWord){
        return CompletableFuture.supplyAsync(( ) -> {
        String data = keyWord;
        return data;
        });
    }

}
