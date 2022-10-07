package wrapper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import helper.SearchHelper;

/**
 * @author Arvind Sangwan ,Raviraj Savaliya
 * @version 1.0
 */
public class Project {
	public int id;
	public int owner_id;
	public String title;
	public String time_submitted;
	@JsonProperty("type")
	public String project_type;
	public ArrayList<Skill> jobs;
	public String preview_description;
	public String educationalStatus;
	public double fIndex;
	public double fkglIndex;
	public String seo_url;

	 /**
     * This method gets the getFIndex
     */
	public double getFIndex() {
		return this.fIndex;
	}
	
	 /**
	 *@param fIndex
     * This method sets the getFIndex
     */
	
	public void setFIndex(Integer fIndex) {
		this.fIndex = fIndex;
	}
	/**
    * This method gets the getEducationalStatus
    */
	public String getEducationalStatus() {
		return this.educationalStatus;
	}

	 /**
     * This method sets the educationalstatus on basis of preview_description
     * 
     * @param preview_description searched keyword
     */
	public void setEducationalStatus(String preview_description) {
		int fIndex = (int)SearchHelper.getFindex(preview_description);
		this.educationalStatus = SearchHelper.educationalLevelMapper(fIndex);
	}

	SearchHelper projectSearcher;
	/**
	* This method gets the id
	*/
	public int getId() {
		return id;
	}
	/**
	*@param id 
	* This method set the id
	*/
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	* This method get Owner_id
	*/
	
	public int getOwner_id() {
		return owner_id;
	}
	
	/**
	*@param owner_id 
	* This method get Owner_id
	*/
	
	public void setOwner_id(int owner_id) {
		this.owner_id = owner_id;
	}

	/**
	* This method get Title
	*/
	
	public String getTitle() {
		return title;
	}

	/**
	*@param title 
	* This method set title
	*/
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	* This method get time
	*/
	public String getTime_submitted() {
		return time_submitted;
	}

	/**
	 * @param time_submitted
	* This method set time
	*/
	public void setTime_submitted(String time_submitted) {
		this.time_submitted = time_submitted;
	}

	/**
	* This method get time
	*/
	
	public String getProject_type() {
		return project_type;
	}

	/**
	* This method set Project_type
	* @param project_type
	*/
	
	
	public void setProject_type(String project_type) {
		this.project_type = project_type;
	}

	/**
	* This method get skill		
	*/
	
	public ArrayList<Skill> getSkills() {
		return jobs;
	}

	/**
	* This method set skill
	* @param jobs
	*/
	

	
	public void setSkills(ArrayList<Skill> jobs) {
		this.jobs = jobs;
	}

	/**
	* This method get Preview_description		
	*/
	public String getPreview_description() {
		return preview_description;
	}

	/**
	* This method set preview description
	* @param preview_description
	*/

	public void setPreview_description(String preview_description) {
		this.preview_description = preview_description;
	}
	
	/**
	* This method getFkglIndex
	*/
	
	public double getFkglIndex() {
		return fkglIndex;
	}

	/**
	*@param  fkglIndex
	* This method setFkglIndex
	*/
	
	
	public void setFkglIndex(double fkglIndex) {
		this.fkglIndex = fkglIndex;
	}

	/**
	* This method getSeo_url
	*/
	
	public String getSeo_url() {
		return seo_url;
	}
	
	/**
	* This method setSeo_url
	* @param seo_url 
	*/

	public void setSeo_url(String seo_url) {
		this.seo_url = seo_url;
	}

}
