package helper;

import models.RestfulService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.inject.Inject;
import java.util.concurrent.CompletableFuture;
import java.util.ArrayList;
import java.util.List;
import wrapper.*;
import controllers.HomeController;
import java.util.*;
import java.util.concurrent.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.core.JsonProcessingException;

/***
 * @author Geetika Rathi
 * @version 1.0
 */
public class EmployerInfoHelper {
	ProjectResults projectResults;
	private final RestfulService restfulService;
	private ObjectMapper mapper;

	@Inject
	public EmployerInfoHelper(RestfulService restfulService, ProjectResults projectResults) {
		this.restfulService = restfulService;
		this.projectResults = projectResults;
		mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}
	/***
	 * This method fetches the call the freelancer service for employer information and converts the json to object
	 * @param ownerId Owner ID of the employer whose profile information to be fetched
	 * @return This returns the Completable future of employer profile info
	 */
	public CompletableFuture<EmployeeBioData> getEmployerInfo(String ownerId) {

		return restfulService.getEmployerInfo(ownerId).thenApplyAsync(json -> {
			EmployeeBioData userInfo = new EmployeeBioData();
		 try {

				userInfo = mapper.convertValue(json, EmployeeBioData.class);
			} catch (Exception ex) {
				System.out.println("Parsing json Failure !!!!!! 1   - Exception :" + ex);
			}
			return userInfo;
		});
	}
	/***
	 * This method fetches the call the freelancer service for projects information and converts the json to object
	 * @param ownerId Owner ID of the user whose projects information to be fetched
	 * @return This returns the Completable future of employer's project information
	 */
	public CompletableFuture<ProjectEmployeeInfo> getEmployerProjectInfo(String ownerId) {

		return restfulService.getEmployerProjectInfo(ownerId).thenApplyAsync(json -> {
			ProjectEmployeeInfo projectList = new ProjectEmployeeInfo();
			try {
				

				projectList = mapper.convertValue(json, ProjectEmployeeInfo.class);
			
			} catch (Exception ex) {
				System.out.println("Parsing json Failure !!!!!! 2    - Exception :" +
						ex);
			}
			return projectList;
		});
	}
}
