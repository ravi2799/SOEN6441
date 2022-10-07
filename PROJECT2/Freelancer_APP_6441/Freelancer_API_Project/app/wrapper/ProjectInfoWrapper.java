package wrapper;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Arvind Sangwan, Raviraj Savaliya
 * @version 1.0
 */

public class ProjectInfoWrapper {
	public String request_id;
	public ProjectResults result;
	public String status;

	/**
	* This method getRequest_id
	*/
	public String getRequest_id() {
		return request_id;
	}
	

	/**
	 *
	* This method getRequest_id
	*  @param request_id
	*/
	public void setRequest_id(String request_id) {
		this.request_id = request_id;
	}


	/**
	 * 
	* This method get ProjectResults
	*/
	public ProjectResults getResult() {
		return result;
	}
	
	/**
	 *
	* This method setResult
	*  @param result
	*/

	public void setResult(ProjectResults result) {
		this.result = result;
	}
	
	/**
	* This method getStatus
	*/

	public String getStatus() {
		return status;
	}

	/**
	 *
	* This method setStatus
	*  @param status
	*/
	public void setStatus(String status) {
		this.status = status;
	}
}
